package com.example.privateclub.service.impl;

import com.example.privateclub.domain.dto.response.qrcode.QRCodeResponse;
import com.example.privateclub.domain.entity.Participant;
import com.example.privateclub.domain.entity.QRCode;
import com.example.privateclub.domain.mapper.QRCodesMapper;
import com.example.privateclub.repository.ParticipantsRepository;
import com.example.privateclub.repository.QRCodesRepository;
import com.example.privateclub.service.QRCodeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class QRCodeServiceImpl implements QRCodeService {

    private final QRCodesRepository qrCodesRepository;
    private final ParticipantsRepository participantsRepository;
    private final QRCodesMapper qrCodesMapper;

    public QRCodeServiceImpl(QRCodesRepository qrCodesRepository, ParticipantsRepository participantsRepository, QRCodesMapper qrCodesMapper) {
        this.qrCodesRepository = qrCodesRepository;
        this.participantsRepository = participantsRepository;
        this.qrCodesMapper = qrCodesMapper;
    }

    @Override
    @Transactional
    public QRCodeResponse entryQRCode(UUID codeId) {
        QRCode qrCode = qrCodesRepository.findByCode(codeId)
                .orElseThrow(() -> new RuntimeException("QR-code не найден: " + codeId));

        var participantId = qrCode.getParticipant();

        qrCodesRepository.findByParticipantAndActiveTrue(participantId)
                .ifPresent(oldCode -> oldCode.setActive(false));

        QRCode newQRCode = new QRCode(UUID.randomUUID());
        newQRCode.setCode(UUID.randomUUID());
        newQRCode.setActive(true);
        newQRCode.setParticipant(participantId);
        qrCodesRepository.save(newQRCode);

        return qrCodesMapper.toDto(newQRCode);
    }


    @Override
    @Transactional
    public QRCodeResponse createQRCode(Long participantId) {
        Participant participant = participantsRepository.findById(participantId)
                .orElseThrow(() -> new EntityNotFoundException("Участник не найден: " + participantId));

        Optional<QRCode> existingActive = qrCodesRepository.findByParticipantIdAndActiveTrue(participantId);

        if (existingActive.isPresent()) {
            return qrCodesMapper.toDto(existingActive.get());
        }

        QRCode newQRCode = new QRCode(UUID.randomUUID());
        newQRCode.setActive(true);
        newQRCode.setParticipant(participant);
        qrCodesRepository.save(newQRCode);

        return qrCodesMapper.toDto(newQRCode);
    }

    @Override
    @Transactional(readOnly = true)
    public QRCodeResponse getQRCodeById(Long id) {
        QRCode qrCode = qrCodesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("QR-code не найден: " + id));

        return qrCodesMapper.toDto(qrCode);
    }

    @Override
    @Transactional(readOnly = true)
    public List<QRCodeResponse> getAllQRCode() {
        return qrCodesRepository.findAll()
                .stream()
                .map(qrCodesMapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public void deleteQRCode(Long id) {
        QRCode qrCode = qrCodesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("QR-код не найден: " + id));
        qrCodesRepository.delete(qrCode);
    }
}
