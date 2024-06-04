package com.example.ferreadminbackend.resource.infraestructure.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ferreadminbackend.resource.application.dto.ResponseDTO;
import com.example.ferreadminbackend.resource.application.dto.SupplierDTO;
import com.example.ferreadminbackend.resource.application.service.SupplierServiceImpl;
import com.example.ferreadminbackend.resource.domain.entity.SupplierEntity;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private SupplierServiceImpl supplierServiceImpl;

    @GetMapping
    public ResponseEntity<List<SupplierEntity>> consultarProveedores() {
        List<SupplierEntity> proveedores = supplierServiceImpl.getSuppliers();
        return new ResponseEntity<>(proveedores, HttpStatus.OK);
    }

    @PostMapping("getSupplier")
    public ResponseDTO getSupplier(@RequestBody Map<String, Long> requestBody) {
        Long idSupplier = requestBody.get("idSupplier");
        try {
            SupplierEntity supplier = supplierServiceImpl.getSupplierById(idSupplier)
                    .orElseThrow(() -> new IllegalArgumentException("El proveedor no existe"));

            SupplierDTO supplierDTO = new SupplierDTO();

            supplierDTO.setIdSupplier(supplier.getIdSupplier());
            supplierDTO.setSupplierName(supplier.getSupplierName());

            return new ResponseDTO(200, "Proveedor encontrado", supplierDTO);
        } catch (Exception e) {
            return new ResponseDTO(404, "Proveedor no encontrado", null);
        }
    }

}
