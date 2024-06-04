package com.example.ferreadminbackend.auth.infraestructure.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ferreadminbackend.auth.application.dto.LoginDTO;
import com.example.ferreadminbackend.auth.infraestructure.config.JwtUtil;
import com.example.ferreadminbackend.user.domain.entity.UserEntity;
import com.example.ferreadminbackend.user.domain.repository.UserRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private UserRepository usuarioRepository;

    // @Autowired
    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserRepository usuarioRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDto) {
        UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());
        Authentication authentication = this.authenticationManager.authenticate(login);

        Optional <UserEntity> optionalUsuario = usuarioRepository.findByUsername(loginDto.getUsername());

       if (optionalUsuario.isPresent()) {
            UserEntity usuario = optionalUsuario.get();
            String jwt = this.jwtUtil.create(usuario.getUsername());

            Map<String, Object> userData = new HashMap<>();
            userData.put("username", usuario.getUsername());
            userData.put("correo", usuario.getEmail());

            Map<String, Object> data = new HashMap<>();
            data.put("usuario", userData);
            data.put("token", jwt);

            return ResponseEntity.ok().body(Map.of("code", HttpStatus.OK.value(), "data", data));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
