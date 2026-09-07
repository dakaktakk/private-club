package com.example.privateclub.domain.dto.request.participant;

import jakarta.validation.constraints.NotBlank;

public record ParticipantRequest(
        @NotBlank(message = "Фамилия пользователя не должно быть пустым")
        String lastName,
        @NotBlank(message = "Имя пользователя не должно быть пустым")
        String firstName,
        String middleName
) {
}
