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

    public Long getIdCedula() {
        return this.idCedula;
    }

    public void setIdCedula(Long idCedula) {
        this.idCedula = idCedula;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Venta> getVentasUsuario() {
        return this.ventasUsuario;
    }

    public void setVentasUsuario(List<Venta> ventasUsuario) {
        this.ventasUsuario = ventasUsuario;
    }

    public Rol getRolUsuario() {
        return this.rolUsuario;
    }

    public void setRolUsuario(Rol rolUsuario) {
        this.rolUsuario = rolUsuario;
    }
}
