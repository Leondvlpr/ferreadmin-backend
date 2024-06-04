package com.example.ferreadminbackend.resource.domain.entity;

import com.example.ferreadminbackend.purchases.domain.entity.PurchaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "resource")
public class ResourceEntity {

    @Id
    @Column(name = "id_resource")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idResource;

    private String resourceName;
    private String resourceDescription;

    private Long unitResourcePrice;

    @ManyToOne
    @JoinColumn(name = "id_supplier")
    private SupplierEntity supplier;

    @JsonIgnore
    @OneToMany(mappedBy = "resources")
    private List<PurchaseEntity> purchases;

    @Column(name = "amount_available")
    private Long amountAvailable; 

    @Column(name = "min_amount")
    private Long minAmount;
}
