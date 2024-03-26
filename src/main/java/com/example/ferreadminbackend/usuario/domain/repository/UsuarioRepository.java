package com.example.ferreadminbackend.usuario.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ferreadminbackend.usuario.domain.entity.Usuario;

import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}
