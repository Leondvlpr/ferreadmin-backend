package com.example.ferreadminbackend.insumo.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "insumo")
public class Insumo {

    @Id
    @Column(name = "id_insumo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInsumo;

    @NotNull(message = "El campo nombre es requerido")
    private String nombre;
    private String descripcion;

    private Long precioUnitario;

    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private Proveedor proveedor;

    @Column(name = "cantidad_disponible")
    private Long cantidadDisponible;

    @Column(name = "cantidad_minima")
    private Long cantidadMinima;

    public Integer getIdInsumo() {
        return this.idInsumo;
    }

    public void setIdInsumo(Integer idInsumo) {
        this.idInsumo = idInsumo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getPrecioUnitario() {
        return this.precioUnitario;
    }

    public void setPrecioUnitario(Long precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Long getCantidadDisponible() {
        return this.cantidadDisponible;
    }

    public void setCantidadDisponible(Long cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public Long getCantidadMinima() {
        return this.cantidadMinima;
    }

    public void setCantidadMinima(Long cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    public Proveedor getProveedor() {
        return this.proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}
