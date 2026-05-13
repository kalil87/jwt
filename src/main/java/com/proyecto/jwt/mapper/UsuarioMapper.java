package com.proyecto.jwt.mapper;

import com.proyecto.jwt.dto.usuario.request.RegistroRequestDTO;
import com.proyecto.jwt.entity.Role;
import com.proyecto.jwt.entity.Usuario;

public class UsuarioMapper {

    private UsuarioMapper() {}

    public static Usuario toEntity(RegistroRequestDTO dto, String password) {
        Usuario usuario = new Usuario();

        usuario.setUsername(dto.username());
        usuario.setPassword(password);
        usuario.setRol(Role.USER);

        return usuario;
    }
}