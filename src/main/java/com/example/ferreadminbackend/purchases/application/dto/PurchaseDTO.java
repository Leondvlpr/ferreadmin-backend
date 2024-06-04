package com.example.ferreadminbackend.purchases.application.dto;

import java.util.List;

// import com.example.ferreadminbackend.insumo.domain.entity.Proveedor;

import lombok.Data;

@Data
public class PurchaseDTO {
    private List<PurchaseResourceDTO> resources;
    private String purchaseDescription;
    private String customerName;
}
