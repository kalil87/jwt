package com.proyecto.jwt.controller;

import com.proyecto.jwt.dto.usuario.request.LoginRequestDTO;
import com.proyecto.jwt.dto.usuario.request.RegistroRequestDTO;
import com.proyecto.jwt.dto.usuario.response.RegistroResponseDTO;
import com.proyecto.jwt.dto.usuario.response.TokenResponseDTO;
import com.proyecto.jwt.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/registro")
    @ResponseStatus(HttpStatus.CREATED)
    public RegistroResponseDTO registrar(@Valid @RequestBody RegistroRequestDTO dto) {
        return authenticationService.registrar(dto);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public TokenResponseDTO autenticar(@Valid @RequestBody LoginRequestDTO dto) {
        return authenticationService.login(dto);
    }
}