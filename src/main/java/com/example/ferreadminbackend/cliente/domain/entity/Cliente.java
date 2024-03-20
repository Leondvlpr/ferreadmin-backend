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

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;

    @OneToMany(mappedBy = "idVenta")
    private List<Venta> ventasCliente;

    @Column(name = "nombre_cliente")
    private String nombreCliente;

    @Column(name = "apellidos_cliente")
    private String apellidosCliente;

    public Long getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return this.nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidosCliente() {
        return this.apellidosCliente;
    }

    public void setApellidosCliente(String apellidosCliente) {
        this.apellidosCliente = apellidosCliente;
    }

    public List<Venta> getVentasCliente() {
        return this.ventasCliente;
    }

    public void setVentasCliente(List<Venta> ventasCliente) {
        this.ventasCliente = ventasCliente;
    }

}
