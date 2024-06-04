package com.example.ferreadminbackend.resource.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ferreadminbackend.resource.domain.entity.SupplierEntity;
import com.example.ferreadminbackend.resource.domain.repository.SupplierRepository;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public Optional<SupplierEntity> getSupplierById(Long idSupplier) {
        return supplierRepository.findById(idSupplier);
    }

    @Override
    public List<SupplierEntity> getSuppliers() {
        return supplierRepository.findAll();
    }
}
