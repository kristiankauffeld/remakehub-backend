package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition="TEXT", nullable = false)
    private String description;

    @Column(name = "price_id", nullable = false)
    private String price;

    @Column(name = "amount", nullable = false)
    private double amount;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "image_alt", nullable = false)
    private String imageAlt;

}
