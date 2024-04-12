package com.example.ferreadminbackend.insumo.domain.entity;

import com.example.ferreadminbackend.compras.domain.entity.Compra;
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
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
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

    @JsonIgnore
    @OneToMany(mappedBy = "insumos")
    private List<Compra> compras;

    @Column(name = "cantidad_disponible")
    private Long cantidadDisponible;

    @Column(name = "cantidad_minima")
    private Long cantidadMinima;
}
