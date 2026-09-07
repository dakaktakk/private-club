package com.example.privateclub.domain.dto.response.participant;

public record ParticipantResponse(
        Long id,
        String lastName,
        String firstName,
        String middleName
) {
}
