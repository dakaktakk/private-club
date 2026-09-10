package com.example.privateclub.controller;

import com.example.privateclub.domain.dto.response.qrcode.QRCodeResponse;
import com.example.privateclub.service.QRCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static org.springframework.data.domain.Sort.Direction.ASC;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/qr-codes")
public class QRCodeController {

    private final QRCodeService qrCodeService;

    @PostMapping("/entry")
    public ResponseEntity<QRCodeResponse> entryQRCode(@RequestParam UUID codeId) {
        QRCodeResponse response = qrCodeService.entryQRCode(codeId);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<QRCodeResponse> createQRCode(@RequestParam Long participantId) {
        QRCodeResponse response = qrCodeService.createQRCode(participantId);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QRCodeResponse> getQRCodeById(@PathVariable Long id) {
        QRCodeResponse response = qrCodeService.getQRCodeById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<QRCodeResponse>> getAllQRCode(
            @PageableDefault(sort = "id", direction = ASC)
            Pageable pageable) {

        Page<QRCodeResponse> responses = qrCodeService.getAllQRCode(pageable);
        return ResponseEntity.ok(responses);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQRCode(@PathVariable Long id) {
        qrCodeService.deleteQRCode(id);
        return ResponseEntity.noContent().build();
    }
}
