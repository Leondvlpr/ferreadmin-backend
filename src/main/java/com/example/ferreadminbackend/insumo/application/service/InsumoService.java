package com.example.ferreadminbackend.insumo.application.service;

import java.util.List;
// import java.util.Optional;

import com.example.ferreadminbackend.insumo.application.dto.InsumoDTO;
import com.example.ferreadminbackend.insumo.application.dto.ResponseDTO;
import com.example.ferreadminbackend.insumo.domain.entity.Insumo;

public interface InsumoService {

    List<Insumo> obtenerInsumos();

    // Optional<Insumo> obtenerInsumo(Integer idInsumo);

    ResponseDTO guardarInsumo(InsumoDTO insumo);
}
