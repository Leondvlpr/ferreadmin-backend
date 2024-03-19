package com.example.ferreadminbackend.insumo.infraestructure.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ferreadminbackend.insumo.application.dto.InsumoDTO;
import com.example.ferreadminbackend.insumo.application.service.DomainInsumoService;
import com.example.ferreadminbackend.insumo.domain.entity.Insumo;
import com.google.gson.Gson;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@Validated
@RequestMapping("/insumos")
public class InsumoController {

    @Autowired
    private DomainInsumoService domainInsumoService;

    @GetMapping()
    public ResponseEntity<List<Insumo>> obtenerInsumos() {
        List<Insumo> insumos = domainInsumoService.obtenerInsumos();
        return new ResponseEntity<>(insumos, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Optional<Insumo>> obtenerInsumo(@RequestBody String requestBody) {

        Gson gson = new Gson();

        InsumoDTO insumoDTO = gson.fromJson(requestBody, InsumoDTO.class);

        Optional<Insumo> insumo = domainInsumoService.obtenerInsumo(insumoDTO.getIdInsumo());

        if (insumo.isPresent()) {
            return new ResponseEntity<>(insumo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("guardarInsumo")
    public ResponseEntity<Insumo> guardarInsumo(@Valid @RequestBody String requestBody) {

        Gson gson = new Gson();

        Insumo insumo = gson.fromJson(requestBody, Insumo.class);

        Insumo insumoGuardado = domainInsumoService.guardarInsumo(insumo);

        if (insumoGuardado != null) {
            return new ResponseEntity<>(insumo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
