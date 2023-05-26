package com.example.demo.controllers;

import com.example.demo.mapper.ProductMapper;
import com.example.demo.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://127.0.0.1:5173", "http://localhost:5173", "${react.address}"})
@RequestMapping("/api/products") //Base URL
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping
    public ResponseEntity getAllProducts() {
        return ResponseEntity.ok(productMapper.productsToProductDtos(productService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getProductById(@PathVariable int id) {
        return ResponseEntity.ok(productMapper.productToProductDto(productService.findById(id)));
    }
}
