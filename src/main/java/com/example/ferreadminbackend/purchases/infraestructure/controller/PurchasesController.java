package com.example.ferreadminbackend.purchases.infraestructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ferreadminbackend.purchases.application.dto.PurchaseDTO;
import com.example.ferreadminbackend.purchases.application.service.PurchaseServiceImpl;
import com.example.ferreadminbackend.purchases.domain.entity.PurchaseEntity;
import com.example.ferreadminbackend.resource.application.dto.ResponseDTO;

@RestController
@RequestMapping("/purchases")
public class PurchasesController {

    @Autowired
    private PurchaseServiceImpl purchaseServiceImpl;

    @GetMapping()
    public ResponseEntity<List<PurchaseEntity>> getPurchases() {
        List<PurchaseEntity> purchases = purchaseServiceImpl.getPurchases();

        return new ResponseEntity<>(purchases, HttpStatus.OK);
    }

    @PostMapping("savePurchase")
    public ResponseEntity<ResponseDTO> savePurchase(@RequestBody PurchaseDTO compra) {
        try {
            ResponseDTO purchaseSaved = purchaseServiceImpl.saveCustomPurchase(compra);
            return ResponseEntity.ok(purchaseSaved);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(500, "Ha ocurrido un error interno gurdando la compra", null));
        }
    }
}
