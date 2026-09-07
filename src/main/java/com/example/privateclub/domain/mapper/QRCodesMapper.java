package com.example.privateclub.domain.mapper;

import com.example.privateclub.domain.dto.response.qrcode.QRCodeResponse;
import com.example.privateclub.domain.entity.Participant;
import com.example.privateclub.domain.entity.QRCode;
import org.springframework.stereotype.Component;

@Component
public class QRCodesMapper {

    public QRCodeResponse toDto(QRCode qrCode) {
        Participant participant = qrCode.getParticipant();
        return new QRCodeResponse(
                qrCode.getId(),
                qrCode.getCode(),
                participant.getLastName(),
                participant.getFirstName(),
                participant.getMiddleName()
        );
    }
}
