package com.example.ferreadminbackend.usuario.domain.entity;

import java.util.List;

import com.example.ferreadminbackend.venta.domain.entity.Venta;

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
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cedula_empleado")
    private Long idCedula;

    private String username;
    private String correo;
    private String password;
    @ManyToOne
    @JoinColumn(name = "rol_usuario")
    private Rol rolUsuario;

    @OneToMany(mappedBy = "idVenta")
    List<Venta> ventasUsuario;
}
