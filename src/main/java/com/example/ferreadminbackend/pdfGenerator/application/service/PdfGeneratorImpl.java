package com.example.ferreadminbackend.pdfGenerator.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import com.example.ferreadminbackend.pdfGenerator.application.dto.PdfDTO;
import com.example.ferreadminbackend.purchases.application.service.PurchaseServiceImpl;
import com.example.ferreadminbackend.purchases.domain.entity.PurchaseEntity;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.io.source.ByteArrayOutputStream;

@Service
public class PdfGeneratorImpl implements PdfGeneratorService {

        @Autowired
        private PurchaseServiceImpl purchaseServiceImpl;

        public ClassLoaderTemplateResolver getTemplateResolver() {

                ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();

                templateResolver.setPrefix("templates/");
                templateResolver.setSuffix(".html");
                templateResolver.setTemplateMode(TemplateMode.HTML);
                templateResolver.setCharacterEncoding("UTF-8");
                templateResolver.setOrder(0);

                return templateResolver;
        }

        public String getTemplateReport(PdfDTO purchaseBody){

                SpringTemplateEngine templateEngine = new SpringTemplateEngine();

                PurchaseEntity purchase = purchaseServiceImpl.getPurchase(purchaseBody.getIdPurchase())
                                .orElseThrow(() -> new IllegalArgumentException("La compra no existe"));

                Context context = new Context();

                context.setVariable("purchase", purchase);

                templateEngine.setTemplateResolver(this.getTemplateResolver());

                String plantillaReporte = templateEngine.process("PlantillaReporte", context);

                return plantillaReporte;
        }

        public ResponseEntity<byte[]> convertHtmlToPdf(PdfDTO purchaseBody) {

                ByteArrayOutputStream target = new ByteArrayOutputStream();
                ConverterProperties converterProperties = new ConverterProperties();
                converterProperties.setBaseUri("http://localhost:8092");

                HtmlConverter.convertToPdf(this.getTemplateReport(purchaseBody), target, converterProperties);

                byte[] bytes = target.toByteArray();
                String fileName = "ordenCompra.pdf";

                HttpHeaders header = new HttpHeaders();
                header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);
                header.add("Cache-Control", "no-cache, no-store, must-revalidate");
                header.add("Pragma", "no-cache");
                header.add("Expires", "0");

                return ResponseEntity.ok()
                                .headers(header)
                                .contentType(MediaType.APPLICATION_PDF)
                                .body(bytes);
        }
}
