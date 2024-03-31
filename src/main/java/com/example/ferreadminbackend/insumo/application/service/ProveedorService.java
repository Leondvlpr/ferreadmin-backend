package com.example.ferreadminbackend.insumo.application.service;

import java.util.List;
import java.util.Optional;

import com.example.ferreadminbackend.insumo.domain.entity.Proveedor;

public interface ProveedorService {

    Optional<Proveedor> obtenerProveedor(Long idProveedor);

     public List<Proveedor> obtenerProveedores();
}
