package com.example.ferreadminbackend.resource.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDTO {
    private Integer code;
    private String msj;
    private SupplierDTO supplier;
    private String otherInformation;

    public ResponseDTO(Integer code, String msj, SupplierDTO supplier) {
        this.code = code;
        this.msj = msj;
        this.supplier = supplier;
    }
}
