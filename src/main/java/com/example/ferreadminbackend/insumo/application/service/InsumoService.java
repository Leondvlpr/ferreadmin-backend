package com.example.ferreadminbackend.insumo.application.service;

import java.util.List;
// import java.util.Optional;
import java.util.Optional;

import com.example.ferreadminbackend.insumo.application.dto.InsumoDTO;
import com.example.ferreadminbackend.insumo.application.dto.ResponseDTO;
import com.example.ferreadminbackend.insumo.domain.entity.Insumo;

public interface InsumoService {

    List<Insumo> obtenerInsumos();

    List<Insumo> obtenerInsumosPorIds(List<Integer> ids);

    Optional<Insumo> obtenerInsumoPorId(Integer idInsumo);

    ResponseDTO guardarInsumo(InsumoDTO insumo);

    ResponseDTO guardarInsumos(List<InsumoDTO> insumos);
}
