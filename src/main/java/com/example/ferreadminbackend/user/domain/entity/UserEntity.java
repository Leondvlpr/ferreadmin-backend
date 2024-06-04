package com.example.ferreadminbackend.user.domain.entity;

import java.util.List;

import com.example.ferreadminbackend.sale.domain.entity.SaleEntity;

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
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identification_number")
    private Long identificationNumber;

    private String username;
    private String email;
    private String password;
    @ManyToOne
    @JoinColumn(name = "user_role")
    private RoleEntity userRole;

    @OneToMany(mappedBy = "idSale")
    List<SaleEntity> userSales;
}
