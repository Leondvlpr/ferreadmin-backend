package com.example.ferreadminbackend.user.application.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.ferreadminbackend.user.domain.entity.UserEntity;
import com.example.ferreadminbackend.user.domain.repository.UserRepository;

@Service
public class UserSecurityService implements UserDetailsService {
    private final UserRepository userRepository;

    public UserSecurityService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity usuarioEntity = this.userRepository.findByUsername(userName)
        .orElseThrow(() -> new UsernameNotFoundException("User " + userName + " not found."));

        return User.builder()
        .username(usuarioEntity.getUsername())
        .password(usuarioEntity.getPassword())
        .build();
    }

}
