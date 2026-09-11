package com.example.privateclub.domain.dto.request.qrcode;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record QRCodesRequest(
        @NotBlank(message = "QRCode не должен быть пустым")
        UUID code,
        Long participantId
) {
}
