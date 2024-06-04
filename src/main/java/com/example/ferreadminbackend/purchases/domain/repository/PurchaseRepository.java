package com.example.ferreadminbackend.purchases.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ferreadminbackend.purchases.domain.entity.PurchaseEntity;

public interface PurchaseRepository extends JpaRepository<PurchaseEntity, Long> {
}
