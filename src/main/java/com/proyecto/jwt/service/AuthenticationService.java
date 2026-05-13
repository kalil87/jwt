package com.proyecto.jwt.service;

import com.proyecto.jwt.dto.usuario.request.LoginRequestDTO;
import com.proyecto.jwt.dto.usuario.request.RegistroRequestDTO;
import com.proyecto.jwt.dto.usuario.response.RegistroResponseDTO;
import com.proyecto.jwt.dto.usuario.response.TokenResponseDTO;

public interface AuthenticationService {

    RegistroResponseDTO registrar(RegistroRequestDTO dto);

    TokenResponseDTO login(LoginRequestDTO dto);
}