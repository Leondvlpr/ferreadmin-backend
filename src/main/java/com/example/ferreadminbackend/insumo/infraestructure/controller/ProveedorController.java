package com.example.ferreadminbackend.insumo.infraestructure.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ferreadminbackend.insumo.application.dto.ProveedorDTO;
import com.example.ferreadminbackend.insumo.application.dto.ResponseDTO;
import com.example.ferreadminbackend.insumo.application.service.DomainProveedorService;
import com.example.ferreadminbackend.insumo.domain.entity.Proveedor;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {

    @Autowired
    private DomainProveedorService domainProveedorService;

    @GetMapping
    public ResponseEntity<List<Proveedor>> consultarProveedores() {
        List<Proveedor> proveedores = domainProveedorService.obtenerProveedores();
        return new ResponseEntity<>(proveedores, HttpStatus.OK);
    }

    @PostMapping("consultarProveedor")
    public ResponseDTO consultarProveedor(@RequestBody Map<String, Long> requestBody) {
        Long idProveedor = requestBody.get("idProveedor");
        try {
            Proveedor proveedor = domainProveedorService.obtenerProveedor(idProveedor)
                    .orElseThrow(() -> new IllegalArgumentException("El proveedor no existe"));

            ProveedorDTO proveedorDTO = new ProveedorDTO();

            proveedorDTO.setIdProveedor(proveedor.getIdProveedor());
            proveedorDTO.setNombreProveedor(proveedor.getNombreProveedor());

            return new ResponseDTO(200, "Proveedor encontrado", proveedorDTO);
        } catch (Exception e) {
            return new ResponseDTO(404, "Proveedor no encontrado");
        }
    }

}
