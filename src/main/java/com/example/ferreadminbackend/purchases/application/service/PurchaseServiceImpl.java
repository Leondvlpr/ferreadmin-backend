package com.example.ferreadminbackend.purchases.application.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ferreadminbackend.purchases.application.dto.PurchaseDTO;
import com.example.ferreadminbackend.purchases.application.dto.PurchaseResourceDTO;
import com.example.ferreadminbackend.purchases.domain.entity.PurchaseEntity;
import com.example.ferreadminbackend.purchases.domain.repository.PurchaseRepository;
import com.example.ferreadminbackend.resource.application.dto.ResponseDTO;
import com.example.ferreadminbackend.resource.application.service.ResourceServiceImpl;
import com.example.ferreadminbackend.resource.domain.entity.ResourceEntity;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private ResourceServiceImpl resourceServiceImpl;

    @Override
    public List<PurchaseEntity> getPurchases() {
        return purchaseRepository.findAll();
    }

    @Override
    public Optional<PurchaseEntity> getPurchase(Long idPurchase) {
        return purchaseRepository.findById(idPurchase);
    }

    public List<ResourceEntity> getResourcesByPurchase(PurchaseDTO purchase) {
        return purchase
                .getResources()
                .stream()
                .map(resource -> {

                    return this.getResourceAmount(resource);
                }).collect(Collectors.toList());
    }

    public ResourceEntity getResourceAmount(PurchaseResourceDTO resource) {
        ResourceEntity resourceEntity = resourceServiceImpl.getResourceById(resource.getIdResource())
                .orElseThrow(() -> new IllegalArgumentException("El insumo no existe"));

        Long resourceAmount = resourceEntity.getAmountAvailable() + resource.getAmount();

        // REASIGNAR CANTIDAD DEL INSUMO
        resourceEntity.setAmountAvailable(resourceAmount);

        return resourceEntity;
    }

    public Long getTotalPurchase(List<ResourceEntity> purchaseResources) {
        return purchaseResources
                .stream()
                .mapToLong(ResourceEntity::getUnitResourcePrice).sum();
    }

    @Override
    public ResponseDTO saveCustomPurchase(PurchaseDTO purchase) {
        try {
            List<ResourceEntity> purchaseResources = this.getResourcesByPurchase(purchase);
            Long totalPurchase = this.getTotalPurchase(purchaseResources);

            PurchaseEntity purchaseEntity = new PurchaseEntity();
            purchaseEntity.setPurchaseDate(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            purchaseEntity.setResources(purchaseResources);
            purchaseEntity.setPurchaseDescription(purchase.getPurchaseDescription());
            purchaseEntity.setTotalPurchase(totalPurchase);
            purchaseEntity.setCustomerName(purchase.getCustomerName());
            purchaseRepository.save(purchaseEntity);

            return new ResponseDTO(200, "La compra se guardó correctamente", null);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseDTO(500, "Error interno al intentar guardar la compra", null);
        }
    }

    @Override
    public ResponseDTO getPurchaseOrder() {

        return new ResponseDTO(200, "La orden de compra se generó correctamente", null);
    }
}
