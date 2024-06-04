package com.example.ferreadminbackend.resource.application.service;

import java.util.List;
import java.util.Optional;

import com.example.ferreadminbackend.resource.domain.entity.SupplierEntity;

public interface SupplierService {

    Optional<SupplierEntity> getSupplierById(Long idSupplier);

     public List<SupplierEntity> getSuppliers();
}
