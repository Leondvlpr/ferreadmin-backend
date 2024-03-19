package com.example.ferreadminbackend.stock.domain.entity;

import com.example.ferreadminbackend.insumo.domain.entity.Insumo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "stock")
public class Stock {
    
    @Id
    @Column(name = "id_stock")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idStock;

    @OneToOne
    @JoinColumn(name = "id_insumo")
    private Insumo idInsumoStock;

    private Long cantidadDisponible;

    public Integer getIdStock() {
        return this.idStock;
    }

    public void setIdStock(Integer idStock) {
        this.idStock = idStock;
    }

    public Insumo getIdInsumoStock() {
        return this.idInsumoStock;
    }

    public void setIdInsumoStock(Insumo idInsumoStock) {
        this.idInsumoStock = idInsumoStock;
    }

    public Long getCantidadDisponible() {
        return this.cantidadDisponible;
    }

    public void setCantidadDisponible(Long cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

}
