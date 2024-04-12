package com.example.ferreadminbackend.compras.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ferreadminbackend.compras.domain.entity.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long> {
}
