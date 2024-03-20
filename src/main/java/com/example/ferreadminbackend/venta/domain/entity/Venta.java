package com.example.ferreadminbackend.venta.domain.entity;

import java.util.List;

import com.example.ferreadminbackend.cliente.domain.entity.Cliente;
import com.example.ferreadminbackend.insumo.domain.entity.Insumo;

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

    @Column(name = "metodo_pago")
    private String metodoPago;

}
