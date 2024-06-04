package com.example.ferreadminbackend.resource.application.dto;

import lombok.Data;

@Data
public class ResourceDTO {
    private String name;
    private String description;
    private Long unitPrice;
    private Long idSupplier;
    private Long minAmount;
    private Long availableAmount;

}
