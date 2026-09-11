package com.example.privateclub.domain.mapper;

import com.example.privateclub.domain.dto.request.participant.ParticipantRequest;
import com.example.privateclub.domain.dto.response.participant.ParticipantResponse;
import com.example.privateclub.domain.entity.Participant;
import org.springframework.stereotype.Component;

@Component
public class ParticipantMapper {

    public ParticipantResponse toDto(Participant participant) {
        return new ParticipantResponse(
                participant.getId(),
                participant.getLastName(),
                participant.getFirstName(),
                participant.getMiddleName()
        );
    }

    public Participant toEntity(ParticipantRequest participantRequest) {
        Participant participant = new Participant();
        participant.setLastName(participantRequest.lastName());
        participant.setFirstName(participantRequest.firstName());
        participant.setMiddleName(participantRequest.middleName());
        return participant;
    }
}
