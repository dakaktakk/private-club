package com.example.privateclub.domain.dto.response.participant;

import jakarta.validation.constraints.NotBlank;

public record ParticipantResponse(
        Long id,
        String lastName,
        String firstName,
        String middleName
) {
}
