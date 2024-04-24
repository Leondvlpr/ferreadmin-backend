package com.example.ferreadminbackend.generadorPdf.infraestructure.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ferreadminbackend.generadorPdf.application.dto.ParametrosPdf;
import com.example.ferreadminbackend.generadorPdf.application.service.GeneradorPdfImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/generarPdf")
public class GeneradorPdfController {

    @Autowired
    private GeneradorPdfImpl generadorPdfImpl;

    @PostMapping("")
    public ResponseEntity<byte[]> generarPdf(@RequestBody ParametrosPdf bodyCompra) {

        ResponseEntity<byte[]> pdfFile = generadorPdfImpl.convertirHtmlAPdf(bodyCompra);

        return pdfFile;
    }

}
