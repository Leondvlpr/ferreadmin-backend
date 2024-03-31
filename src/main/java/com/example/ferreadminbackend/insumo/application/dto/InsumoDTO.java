package com.example.ferreadminbackend.insumo.application.dto;

import lombok.Data;

@Data
public class InsumoDTO {
    private String nombre;
    private String descripcion;
    private Long precioUnitario;
    private Long idProveedor;
    private Long cantidadMinima;
    private Long cantidadDisponible;

}
