package com.example.ferreadminbackend.sale.domain.entity;

import java.util.List;

import com.example.ferreadminbackend.customer.domain.entity.CustomerEntity;
import com.example.ferreadminbackend.resource.domain.entity.ResourceEntity;
import com.example.ferreadminbackend.user.domain.entity.UserEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "sales")
public class SaleEntity {

    @Id
    @Column(name = "id_sale")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSale;

    @Column(name = "sale_date")
    private String fechaVenta;

    @ManyToOne
    private CustomerEntity idCustomer;

    @OneToMany(mappedBy = "idResource")
    private List<ResourceEntity> resources;

    @Column(name = "sale_amount")
    private Long saleAmount;

    @Column(name = "total_sale")
    private Long totalSale;

    @Column(name = "payment_method")
    private String paymentMethod;

    @ManyToOne
    private UserEntity userIdentification;
}
