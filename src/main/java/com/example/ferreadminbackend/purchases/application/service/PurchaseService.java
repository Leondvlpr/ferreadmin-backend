package com.example.ferreadminbackend.purchases.application.service;

import java.util.List;
import java.util.Optional;

import com.example.ferreadminbackend.purchases.application.dto.PurchaseDTO;
import com.example.ferreadminbackend.purchases.domain.entity.PurchaseEntity;
import com.example.ferreadminbackend.resource.application.dto.ResponseDTO;

public interface PurchaseService {
    public List<PurchaseEntity> getPurchases();

    public Optional<PurchaseEntity> getPurchase(Long idPurchase);

    public ResponseDTO saveCustomPurchase(PurchaseDTO purchase);

    public ResponseDTO getPurchaseOrder();
}
