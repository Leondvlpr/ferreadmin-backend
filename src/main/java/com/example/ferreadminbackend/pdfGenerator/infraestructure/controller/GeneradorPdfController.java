package com.example.ferreadminbackend.pdfGenerator.infraestructure.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ferreadminbackend.pdfGenerator.application.dto.PdfDTO;
import com.example.ferreadminbackend.pdfGenerator.application.service.PdfGeneratorImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/generatePdf")
public class GeneradorPdfController {

    @Autowired
    private PdfGeneratorImpl generadorPdfImpl;

    @PostMapping("")
    public ResponseEntity<byte[]> generatePdf(@RequestBody PdfDTO purchaseBody) {

        ResponseEntity<byte[]> pdfFile = generadorPdfImpl.convertHtmlToPdf(purchaseBody);

        return pdfFile;
    }

}
