package com.example.demo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ProductDTO {
    private int id;
    private String name;
    private String description;
    private String price;
    private double amount;
    private String imageUrl;
    private String imageAlt;

}
