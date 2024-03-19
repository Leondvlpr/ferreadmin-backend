package com.example.ferreadminbackend.insumo.application.service;

import java.util.List;
import java.util.Optional;

import com.example.ferreadminbackend.insumo.domain.entity.Insumo;

public interface InsumoService {

    List<Insumo> obtenerInsumos();

    Optional<Insumo> obtenerInsumo(Integer idInsumo);

    Insumo guardarInsumo(Insumo insumo);
}
