package com.example.ferreadminbackend.customer.domain.entity;

import java.util.List;

import com.example.ferreadminbackend.sale.domain.entity.SaleEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "customers")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private Long idCustomer;

    @OneToMany(mappedBy = "idCustomer")
    private List<SaleEntity> customerSales;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_surnames")
    private String customerSurnames;

}
