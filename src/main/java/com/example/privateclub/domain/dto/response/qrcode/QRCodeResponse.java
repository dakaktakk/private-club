package com.example.privateclub.domain.dto.response.qrcode;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record QRCodeResponse(
        Long id,
        UUID QRId,
        String lastName,
        String firstName,
        String middleName
) {
}
