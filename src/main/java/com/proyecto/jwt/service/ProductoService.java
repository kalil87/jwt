package com.proyecto.jwt.service;

import com.proyecto.jwt.dto.producto.ProductResponseDto;
import com.proyecto.jwt.dto.producto.ProductoRequestDto;

import java.util.List;
import java.util.UUID;

public interface ProductoService {

    ProductResponseDto crear(ProductoRequestDto dto);

    List<ProductResponseDto> listar(String nombre);

    ProductResponseDto buscarPorId(UUID id);

    ProductResponseDto actualizar(UUID id, ProductoRequestDto dto);

    void eliminar(UUID id);

    List<ProductResponseDto> buscarPorNombre(String nombre);
}