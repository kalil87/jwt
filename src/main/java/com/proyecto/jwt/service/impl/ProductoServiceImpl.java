package com.proyecto.jwt.service.impl;

import com.proyecto.jwt.dto.producto.ProductResponseDto;
import com.proyecto.jwt.dto.producto.ProductoRequestDto;
import com.proyecto.jwt.entity.Producto;
import com.proyecto.jwt.exception.RecursoNoEncontradoException;
import com.proyecto.jwt.mapper.ProductoMapper;
import com.proyecto.jwt.repository.ProductoRepository;
import com.proyecto.jwt.service.ProductoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductoServiceImpl implements ProductoService {
    private ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository repo) {
        productoRepository = repo;
    }

    @Override
    public ProductResponseDto crear(ProductoRequestDto dto) {
        Producto producto = ProductoMapper.toEntity(dto);
        Producto guardado = productoRepository.save(producto);
        return ProductoMapper.toResponseDto(guardado);
    }

    @Override
    public List<ProductResponseDto> listar(String nombre) {
        if (nombre == null) {
            return productoRepository.findAll()
                    .stream()
                    .map(ProductoMapper::toResponseDto)
                    .toList();
        } else {
            return buscarPorNombre(nombre);
        }
    }

    @Override
    public ProductResponseDto buscarPorId(UUID id) {
        return productoRepository.findById(id)
                .map(ProductoMapper::toResponseDto)
                .orElseThrow(()-> new RecursoNoEncontradoException("No se encontro el id " + id));
    }

    @Override
    public ProductResponseDto actualizar(UUID id, ProductoRequestDto dto) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(()-> new RecursoNoEncontradoException("No se encontro el id " + id));

        ProductoMapper.updateEntity(producto, dto);
        Producto guardado = productoRepository.save(producto);
        return ProductoMapper.toResponseDto(guardado);
    }

    @Override
    public void eliminar(UUID id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(()-> new RecursoNoEncontradoException("No se encontro el id " + id));
        productoRepository.delete(producto);
    }

    @Override
    public List<ProductResponseDto> buscarPorNombre(String nombre) {
        return productoRepository.findByNombreContainingIgnoreCase(nombre)
                .stream()
                .map(ProductoMapper::toResponseDto)
                .toList();
    }
}