package com.example.privateclub.service;

import com.example.privateclub.domain.dto.response.qrcode.QRCodeResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface QRCodeService {

    QRCodeResponse entryQRCode(UUID codeId);

    QRCodeResponse createQRCode(Long participantId);

    QRCodeResponse getQRCodeById(Long id);

    Page<QRCodeResponse> getAllQRCode(Pageable pageable);

    void deleteQRCode(Long id);
}
