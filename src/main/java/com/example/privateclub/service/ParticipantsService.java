package com.example.privateclub.service;

import com.example.privateclub.domain.dto.request.participant.ParticipantRequest;
import com.example.privateclub.domain.dto.response.participant.ParticipantResponse;

import java.util.List;

public interface ParticipantsService {

    ParticipantResponse createParticipant(ParticipantRequest participantRequest);

    ParticipantResponse getParticipantById(Long id);

    List<ParticipantResponse> getAllParticipants();

    ParticipantResponse updateParticipant(Long id, ParticipantRequest participantRequest);

    void deleteParticipant(Long id);
}
