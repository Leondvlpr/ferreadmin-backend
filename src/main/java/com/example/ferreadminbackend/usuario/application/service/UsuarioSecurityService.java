package com.example.ferreadminbackend.usuario.application.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.ferreadminbackend.usuario.domain.entity.Usuario;
import com.example.ferreadminbackend.usuario.domain.repository.UsuarioRepository;

@Service
public class UsuarioSecurityService implements UserDetailsService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioSecurityService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Usuario usuarioEntity = this.usuarioRepository.findByUsername(userName)
        .orElseThrow(() -> new UsernameNotFoundException("User " + userName + " not found."));

        return User.builder()
        .username(usuarioEntity.getUsername())
        .password(usuarioEntity.getPassword())
        .build();
    }

}
