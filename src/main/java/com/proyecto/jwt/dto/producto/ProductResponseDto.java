package com.proyecto.jwt.dto.producto;

import java.util.UUID;

public record ProductResponseDto(
        UUID id,
        String nombre,
        Double precio,
        Integer strock
) { }