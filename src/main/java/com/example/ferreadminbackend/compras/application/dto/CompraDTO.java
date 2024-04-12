package com.example.ferreadminbackend.compras.application.dto;

import java.util.List;

// import com.example.ferreadminbackend.insumo.domain.entity.Proveedor;

import lombok.Data;

@Data
public class CompraDTO {
    private List<InsumoCompraDTO> insumos;
    private String descripcionCompra;
}
