package com.example.ferreadminbackend.insumo.infraestructure.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ferreadminbackend.insumo.application.dto.InsumoDTO;
import com.example.ferreadminbackend.insumo.application.dto.ResponseDTO;
import com.example.ferreadminbackend.insumo.application.service.InsumoServiceImpl;
import com.example.ferreadminbackend.insumo.domain.entity.Insumo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/insumos")
public class InsumoController {

    @Autowired
    private InsumoServiceImpl insumoServiceImpl;

    @GetMapping()
    public ResponseEntity<List<Insumo>> obtenerInsumos() {
        List<Insumo> insumos = insumoServiceImpl.obtenerInsumos();
        return new ResponseEntity<>(insumos, HttpStatus.OK);
    }

    // @PostMapping()
    // public ResponseEntity<Optional<Insumo>> obtenerInsumo(@RequestBody String
    // requestBody) {

    // Gson gson = new Gson();

    // InsumoDTO insumoDTO = gson.fromJson(requestBody, InsumoDTO.class);

    // Optional<Insumo> insumo =
    // insumoServiceImpl.obtenerInsumo(insumoDTO.getIdInsumo());

    // if (insumo.isPresent()) {
    // return new ResponseEntity<>(insumo, HttpStatus.OK);
    // } else {
    // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // }

    // }

    @PostMapping("guardarInsumo")
    public ResponseEntity<ResponseDTO> guardarInsumo(@RequestBody InsumoDTO insumo) {

        try {
            ResponseDTO insumoGuardado = insumoServiceImpl.guardarInsumo(insumo);
            System.out.println(insumoGuardado);
            return ResponseEntity.ok(insumoGuardado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDTO(404, e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(500, "Ha ocurrido un error interno"));
        }

    }

}
