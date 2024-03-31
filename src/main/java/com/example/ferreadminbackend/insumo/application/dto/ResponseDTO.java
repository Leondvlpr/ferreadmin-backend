package com.example.ferreadminbackend.insumo.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDTO {
    private Integer code;
    private String msj;
    private ProveedorDTO proveedor;

    public ResponseDTO(Integer code, String msj) {
        this.code = code;
        this.msj = msj;
        this.proveedor = null;
    }
}
