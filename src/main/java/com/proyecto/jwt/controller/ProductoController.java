package com.proyecto.jwt.controller;

import com.proyecto.jwt.dto.producto.ProductResponseDto;
import com.proyecto.jwt.dto.producto.ProductoRequestDto;
import com.proyecto.jwt.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponseDto crear(@Valid @RequestBody ProductoRequestDto dto) {
        return productoService.crear(dto);
    }

    @GetMapping
    public List<ProductResponseDto> listar(@RequestParam(required = false) String nombre) {
        return productoService.listar(nombre);
    }

    @GetMapping("/{id}")
    public ProductResponseDto buscarPorId(@PathVariable UUID id) {
        return productoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ProductResponseDto actualizar(@PathVariable UUID id, @Valid @RequestBody ProductoRequestDto dto) {
        return productoService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable UUID id) {
        productoService.eliminar(id);
    }
}