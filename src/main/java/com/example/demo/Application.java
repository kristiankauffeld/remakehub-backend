package com.example.demo;

import com.example.demo.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    private final ProductRepository productRepository;

    public Application(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
