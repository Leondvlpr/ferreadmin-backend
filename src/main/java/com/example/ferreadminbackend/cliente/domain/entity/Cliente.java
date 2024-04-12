package com.example.ferreadminbackend.cliente.domain.entity;

import java.util.List;

import com.example.ferreadminbackend.venta.domain.entity.Venta;

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
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;

    @OneToMany(mappedBy = "idCliente")
    private List<Venta> ventasCliente;

    @Column(name = "nombre_cliente")
    private String nombreCliente;

    @Column(name = "apellidos_cliente")
    private String apellidosCliente;

}
