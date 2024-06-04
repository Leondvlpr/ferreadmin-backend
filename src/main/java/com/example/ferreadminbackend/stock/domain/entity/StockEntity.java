package com.example.ferreadminbackend.stock.domain.entity;

import com.example.ferreadminbackend.resource.domain.entity.ResourceEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "stock")
public class StockEntity {
    
    @Id
    @Column(name = "id_stock")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idStock;

    @OneToOne
    @JoinColumn(name = "id_resource")
    private ResourceEntity idStockResource;

    private Long availableAmount;

}
