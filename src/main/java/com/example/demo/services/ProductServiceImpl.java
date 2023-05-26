package com.example.demo.services;

import com.example.demo.exceptions.ProductNotFoundException;
import com.example.demo.models.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public Collection<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product add(Product entity) {
        return null;
    }

    @Override
    public Product update(Product entity) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void delete(Product entity) {

    }
}
