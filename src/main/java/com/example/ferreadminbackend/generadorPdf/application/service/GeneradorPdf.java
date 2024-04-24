package com.example.ferreadminbackend.generadorPdf.application.service;

import org.springframework.http.ResponseEntity;

import com.example.ferreadminbackend.generadorPdf.application.dto.ParametrosPdf;

public interface GeneradorPdf {
    public ResponseEntity<byte[]> convertirHtmlAPdf(ParametrosPdf bodyCompra);
}
