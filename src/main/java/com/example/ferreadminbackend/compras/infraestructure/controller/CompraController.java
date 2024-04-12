package com.example.ferreadminbackend.compras.infraestructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ferreadminbackend.compras.application.dto.CompraDTO;
import com.example.ferreadminbackend.compras.application.service.CompraServiceImpl;
import com.example.ferreadminbackend.compras.domain.entity.Compra;
import com.example.ferreadminbackend.insumo.application.dto.ResponseDTO;

@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    private CompraServiceImpl compraServiceImpl;

    @GetMapping()
    public ResponseEntity<List<Compra>> obtenerCompras() {
        List<Compra> compras = compraServiceImpl.obtenerCompras();

        return new ResponseEntity<>(compras, HttpStatus.OK);
    }

    @PostMapping("guardarCompra")
    public ResponseEntity<ResponseDTO> guardarCompra(@RequestBody CompraDTO compra) {
        try {
            ResponseDTO compraGuardada = compraServiceImpl.guardarCompraPersonalizada(compra);
            return ResponseEntity.ok(compraGuardada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(500, "Ha ocurrido un error interno gurdando la compra"));
        }
    }
}
