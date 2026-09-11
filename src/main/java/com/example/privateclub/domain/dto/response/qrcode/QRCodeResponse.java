package com.example.privateclub.domain.dto.response.qrcode;

import java.util.UUID;

public record QRCodeResponse(
        Long id,
        UUID QRId,
        String lastName,
        String firstName,
        String middleName
) {
}
