package com.example.ferreadminbackend.venta.domain.entity;

import java.util.List;

import com.example.ferreadminbackend.cliente.domain.entity.Cliente;
import com.example.ferreadminbackend.insumo.domain.entity.Insumo;
import com.example.ferreadminbackend.usuario.domain.entity.Usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "venta")
public class Venta {

    @Id
    @Column(name = "id_venta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenta;

    @Column(name = "fecha_venta")
    private String fechaVenta;

    @ManyToOne
    private Cliente idCliente;

    @OneToMany(mappedBy = "idInsumo")
    private List<Insumo> listaInsumos;

    @Column(name = "cantidad_venta")
    private Long cantidadVendida;

    @Column(name = "total_venta")
    private Long totalVenta;

    @Column(name = "metodo_pago")
    private String metodoPago;

    @ManyToOne
    private Usuario cedulaUsuario;

    public Long getIdVenta() {
        return this.idVenta;
    }

    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }

    public String getFechaVenta() {
        return this.fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Cliente getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public List<Insumo> getListaInsumos() {
        return this.listaInsumos;
    }

    public void setListaInsumos(List<Insumo> listaInsumos) {
        this.listaInsumos = listaInsumos;
    }

    public Long getCantidadVendida() {
        return this.cantidadVendida;
    }

    public void setCantidadVendida(Long cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public Long getTotalVenta() {
        return this.totalVenta;
    }

    public void setTotalVenta(Long totalVenta) {
        this.totalVenta = totalVenta;
    }

    public String getMetodoPago() {
        return this.metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Usuario getCedulaUsuario() {
        return this.cedulaUsuario;
    }

    public void setCedulaUsuario(Usuario cedulaUsuario) {
        this.cedulaUsuario = cedulaUsuario;
    }
}
