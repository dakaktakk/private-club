package com.example.privateclub.service;

import com.example.privateclub.domain.dto.response.qrcode.QRCodeResponse;

import java.util.List;
import java.util.UUID;

public interface QRCodeService {

    QRCodeResponse entryQRCode(UUID codeId);

    QRCodeResponse createQRCode(Long participantId);

    QRCodeResponse getQRCodeById(Long id);

    List<QRCodeResponse> getAllQRCode();

    void deleteQRCode(Long id);
}
