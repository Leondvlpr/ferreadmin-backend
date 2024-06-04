package com.example.ferreadminbackend.pdfGenerator.application.service;

import org.springframework.http.ResponseEntity;

import com.example.ferreadminbackend.pdfGenerator.application.dto.PdfDTO;

public interface PdfGeneratorService {
    public ResponseEntity<byte[]> convertHtmlToPdf(PdfDTO purchaseBody);
}
