package com.proyecto.jwt.mapper;

import com.proyecto.jwt.dto.producto.ProductResponseDto;
import com.proyecto.jwt.dto.producto.ProductoRequestDto;
import com.proyecto.jwt.entity.Producto;

public class ProductoMapper {

    private ProductoMapper() {}

    public static Producto toEntity(ProductoRequestDto dto) {
        Producto producto = new Producto();
        producto.setNombre(dto.nombre());
        producto.setPrecio(dto.precio());
        producto.setStock(dto.stock());
        return producto;
    }

    public static ProductResponseDto toResponseDto(Producto producto) {
        return new ProductResponseDto(
                producto.getId(),
                producto.getNombre(),
                producto.getPrecio(),
                producto.getStock()
        );
    }

    public static void updateEntity(Producto producto, ProductoRequestDto dto) {
        producto.setNombre(dto.nombre());
        producto.setPrecio(dto.precio());
        producto.setStock(dto.stock());
    }
}