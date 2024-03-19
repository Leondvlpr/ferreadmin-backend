package com.example.ferreadminbackend.insumo.application.dto;

public class InsumoDTO {
    private Integer idInsumo;

    private String accion;

    private Long cantidadDisponible;

    private Long cantidadMinima;

    private Long precioUnitario;

    private String descripcion;

    private String nombre;

    private String proveedor;

    public Integer getIdInsumo() {
        return this.idInsumo;
    }

    public void setIdInsumo(Integer idInsumo) {
        this.idInsumo = idInsumo;
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

    public Long getPrecioUnitario() {
        return this.precioUnitario;
    }

    public void setPrecioUnitario(Long precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProveedor() {
        return this.proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getAccion() {
        return this.accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
    
}
