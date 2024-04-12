package com.example.ferreadminbackend.compras.application.service;

import java.util.List;
import java.util.Optional;

import com.example.ferreadminbackend.compras.application.dto.CompraDTO;
import com.example.ferreadminbackend.compras.domain.entity.Compra;
import com.example.ferreadminbackend.insumo.application.dto.ResponseDTO;

public interface CompraService {
    public List<Compra> obtenerCompras();

    public Optional<Compra> obtenerCompra(Long idCompra);

    public ResponseDTO guardarCompraPersonalizada(CompraDTO compra);

    public ResponseDTO generarOrdenCompra();
}
