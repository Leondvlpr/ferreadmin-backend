package com.example.ferreadminbackend.resource.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ferreadminbackend.resource.domain.entity.SupplierEntity;

public interface SupplierRepository extends JpaRepository<SupplierEntity, Long> {

    
}
