package com.example.privateclub.service;

import com.example.privateclub.domain.dto.request.participant.ParticipantRequest;
import com.example.privateclub.domain.dto.response.participant.ParticipantResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ParticipantsService {

    ParticipantResponse createParticipant(ParticipantRequest participantRequest);

    ParticipantResponse getParticipantById(Long id);

    Page<ParticipantResponse> getAllParticipants(Pageable pageable);

    ParticipantResponse updateParticipant(Long id, ParticipantRequest participantRequest);

    void deleteParticipant(Long id);
}
