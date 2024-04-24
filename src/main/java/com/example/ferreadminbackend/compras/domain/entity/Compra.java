package com.example.ferreadminbackend.compras.domain.entity;

import java.util.List;

import com.example.ferreadminbackend.insumo.domain.entity.Insumo;

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
@Table(name = "compra")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Long idCompra;

    @Column(name = "fecha_compra")
    private String fechaCompra;

    @Column(name = "descripcion_compra")
    private String descripcionCompra;

    @Column(name = "nombre_cliente")
    private String nombreCliente;

    @ManyToMany()
    @JoinTable(
        name = "detalle_compra",
        joinColumns = @JoinColumn(name = "id_compra"),
        inverseJoinColumns = @JoinColumn(name = "id_insumo")
    )
    private List<Insumo> insumos;

    @Column(name = "total_compra")
    private Long totalCompra;
}
