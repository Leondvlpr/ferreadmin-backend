package com.example.ferreadminbackend.generadorPdf.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import com.example.ferreadminbackend.compras.application.service.CompraServiceImpl;
import com.example.ferreadminbackend.compras.domain.entity.Compra;
import com.example.ferreadminbackend.generadorPdf.application.dto.ParametrosPdf;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.io.source.ByteArrayOutputStream;

@Service
public class GeneradorPdfImpl implements GeneradorPdf {

        @Autowired
        private CompraServiceImpl compraServiceImpl;

        public ResponseEntity<byte[]> convertirHtmlAPdf(ParametrosPdf bodyCompra) {

                SpringTemplateEngine templateEngine = new SpringTemplateEngine();
                ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
            
                Compra compra = compraServiceImpl.obtenerCompra(bodyCompra.getIdCompra())
                                .orElseThrow(() -> new IllegalArgumentException("La compra no existe"));
            
                Context context = new Context();
            
                context.setVariable("compra", compra);
            
                templateResolver.setPrefix("templates/");
                templateResolver.setSuffix(".html");
                templateResolver.setTemplateMode(TemplateMode.HTML);
                templateResolver.setCharacterEncoding("UTF-8");
                templateResolver.setOrder(0);
            
                templateEngine.setTemplateResolver(templateResolver);
            
                String plantillaReporte = templateEngine.process("PlantillaReporte", context);
            
                ByteArrayOutputStream target = new ByteArrayOutputStream();
                ConverterProperties converterProperties = new ConverterProperties();
                converterProperties.setBaseUri("http://localhost:8092");
            
                HtmlConverter.convertToPdf(plantillaReporte, target, converterProperties);
            
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
