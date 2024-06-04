package com.example.ferreadminbackend.purchases.domain.entity;

import java.util.List;

import com.example.ferreadminbackend.resource.domain.entity.ResourceEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "purchases")
public class PurchaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_purchase")
    private Long idPurchase;

    @Column(name = "purchase_date")
    private String purchaseDate;

    @Column(name = "purchase_description")
    private String purchaseDescription;

    @Column(name = "customer_name")
    private String customerName;

    @ManyToMany()
    @JoinTable(
        name = "purchase_detail",
        joinColumns = @JoinColumn(name = "id_purchase"),
        inverseJoinColumns = @JoinColumn(name = "id_resource")
    )
    private List<ResourceEntity> resources;

    @Column(name = "total_purchase")
    private Long totalPurchase;
}
