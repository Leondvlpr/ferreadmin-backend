package com.example.ferreadminbackend.insumo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ferreadminbackend.insumo.domain.entity.Insumo;

@Repository
public interface InsumoRepository extends JpaRepository<Insumo, Integer> {

    
}
