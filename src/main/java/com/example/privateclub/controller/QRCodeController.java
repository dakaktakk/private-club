package com.example.privateclub.controller;

import com.example.privateclub.domain.dto.response.qrcode.QRCodeResponse;
import com.example.privateclub.service.QRCodeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/qr-codes")
public class QRCodeController {

    private final QRCodeService qrCodeService;

    public QRCodeController(QRCodeService qrCodeService) {
        this.qrCodeService = qrCodeService;
    }

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
    public ResponseEntity<List<QRCodeResponse>> getAllQRCode() {
        List<QRCodeResponse> responses = qrCodeService.getAllQRCode();
        return ResponseEntity.ok(responses);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQRCode(@PathVariable Long id) {
        qrCodeService.deleteQRCode(id);
        return ResponseEntity.noContent().build();
    }
}
