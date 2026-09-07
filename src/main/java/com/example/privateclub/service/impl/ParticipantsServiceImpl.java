package com.example.privateclub.service.impl;

import com.example.privateclub.domain.dto.request.participant.ParticipantRequest;
import com.example.privateclub.domain.dto.response.participant.ParticipantResponse;
import com.example.privateclub.domain.entity.Participant;
import com.example.privateclub.domain.mapper.ParticipantMapper;
import com.example.privateclub.repository.ParticipantsRepository;
import com.example.privateclub.service.ParticipantsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ParticipantsServiceImpl implements ParticipantsService {

    private final ParticipantsRepository participantsRepository;
    private final ParticipantMapper participantMapper;

    public ParticipantsServiceImpl(ParticipantsRepository participantsRepository,
                                   ParticipantMapper participantMapper) {
        this.participantsRepository = participantsRepository;
        this.participantMapper = participantMapper;
    }

    @Override
    public ParticipantResponse createParticipant(ParticipantRequest participantRequest) {

        Participant participant = participantMapper.toEntity(participantRequest);
        Participant saveParticipant = participantsRepository.save(participant);

        return participantMapper.toDto(saveParticipant);
    }

    @Override
    @Transactional(readOnly = true)
    public ParticipantResponse getParticipantById(Long id) {

        Participant participant = participantsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Участник не найден по id: " + id));

        return participantMapper.toDto(participant);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ParticipantResponse> getAllParticipants() {
        return participantsRepository.findAll()
                .stream()
                .map(participantMapper::toDto)
                .toList();
    }

    @Override
    public ParticipantResponse updateParticipant(Long id, ParticipantRequest participantRequest) {

        Participant participant = participantsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Участник не найден по id: " + id));

        participant.setLastName(participantRequest.lastName());
        participant.setFirstName(participantRequest.firstName());
        participant.setMiddleName(participantRequest.middleName());

        Participant updateParticipant = participantsRepository.save(participant);

        return participantMapper.toDto(updateParticipant);
    }

    @Override
    public void deleteParticipant(Long id) {

        if (!participantsRepository.existsById(id)) {
            throw new RuntimeException("Участник не найден по id: " + id);
        }

        participantsRepository.deleteById(id);
    }
}
