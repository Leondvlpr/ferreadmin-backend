package com.example.ferreadminbackend.insumo.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ferreadminbackend.insumo.domain.entity.Proveedor;
import com.example.ferreadminbackend.insumo.domain.repository.ProveedorRepository;

@Service
public class DomainProveedorService implements ProveedorService {
    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public Optional<Proveedor> obtenerProveedor(Long idProveedor) {
        return proveedorRepository.findById(idProveedor);
    }

    @Override
    public List<Proveedor> obtenerProveedores() {
        return proveedorRepository.findAll();
    }
}
