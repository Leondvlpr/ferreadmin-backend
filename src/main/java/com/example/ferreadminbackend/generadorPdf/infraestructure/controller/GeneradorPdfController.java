package com.example.ferreadminbackend.generadorPdf.infraestructure.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import com.example.ferreadminbackend.compras.application.service.CompraServiceImpl;
import com.example.ferreadminbackend.compras.domain.entity.Compra;
import com.example.ferreadminbackend.generadorPdf.application.service.GeneradorPdfImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/generarPdf")
public class GeneradorPdfController {

    @Autowired
    private SpringTemplateEngine springTemplateEngine;

    @Autowired
    private CompraServiceImpl compraServiceImpl;

    @Autowired
    private GeneradorPdfImpl generadorPdfImpl;

    @PostMapping("")
    public String generarPdf(@RequestBody Map<String, Long> bodyCompra) {

        Long idCompra = bodyCompra.get("idCompra");

        Compra compra = compraServiceImpl.obtenerCompra(idCompra)
                .orElseThrow(() -> new IllegalArgumentException("La compra no existe"));

        // System.out.println(compra + "probando info de la compra");
        String finalHtml = null;

        Context context = new Context();

        Map<String, Object> dataContext = new HashMap<>();

        dataContext.put("compra", compra);

        context.setVariables(dataContext);

        finalHtml = springTemplateEngine.process("PlantillaReporte", context);

        generadorPdfImpl.convertirHtmlAPdf(finalHtml);

        return "Success";
    }

}
