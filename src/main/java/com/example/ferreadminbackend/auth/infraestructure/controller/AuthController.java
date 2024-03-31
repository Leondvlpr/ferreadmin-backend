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
import com.example.ferreadminbackend.usuario.domain.entity.Usuario;
import com.example.ferreadminbackend.usuario.domain.repository.UsuarioRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private UsuarioRepository usuarioRepository;

    // @Autowired
    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UsuarioRepository usuarioRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDto) {
        UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());
        Authentication authentication = this.authenticationManager.authenticate(login);

        Optional <Usuario> optionalUsuario = usuarioRepository.findByUsername(loginDto.getUsername());

       if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            String jwt = this.jwtUtil.create(usuario.getUsername());

            Map<String, Object> userData = new HashMap<>();
            userData.put("username", usuario.getUsername());
            userData.put("correo", usuario.getCorreo());

            Map<String, Object> data = new HashMap<>();
            data.put("usuario", userData);
            data.put("token", jwt);

            return ResponseEntity.ok().body(Map.of("code", HttpStatus.OK.value(), "data", data));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
