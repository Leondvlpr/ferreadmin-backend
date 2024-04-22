package com.example.ferreadminbackend.generadorPdf.application.service;

import java.io.FileOutputStream;

import org.springframework.stereotype.Service;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.pdf.PdfWriter;

@Service
public class GeneradorPdfImpl implements GeneradorPdf {
    
    public String convertirHtmlAPdf(String Html) {

        String hello = "hello";

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {
            
            PdfWriter pdfWriter = new PdfWriter(byteArrayOutputStream);

            DefaultFontProvider defaultFontProvider = new DefaultFontProvider(false, true, false);

            ConverterProperties converterProperties = new ConverterProperties();

            converterProperties.setFontProvider(defaultFontProvider);

            HtmlConverter.convertToPdf(Html, pdfWriter, converterProperties);

            FileOutputStream fout = new FileOutputStream("/Users/ellsu/Downloads/ordenCompra.pdf");

            byteArrayOutputStream.writeTo(fout);
            byteArrayOutputStream.close();

            byteArrayOutputStream.flush();
            fout.close();

            return null;

        } catch (Exception e) {
            // TODO: handle exception
        }

        return hello;
    }
}
