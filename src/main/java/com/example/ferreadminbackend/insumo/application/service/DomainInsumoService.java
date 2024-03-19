package com.example.ferreadminbackend.insumo.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ferreadminbackend.insumo.domain.entity.Insumo;
import com.example.ferreadminbackend.insumo.domain.repository.InsumoRepository;

@Service
public class DomainInsumoService implements InsumoService {

    @Autowired
    private InsumoRepository insumoRepository;

    @Override
    public List<Insumo> obtenerInsumos() {
        return insumoRepository.findAll();
    }

    @Override
    public Optional<Insumo> obtenerInsumo(Integer idInsumo) {
        return insumoRepository.findById(idInsumo);
    }

    @Override
    public Insumo guardarInsumo(Insumo insumo) {
        return insumoRepository.save(insumo);
    }

}
