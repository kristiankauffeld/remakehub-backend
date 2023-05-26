package com.example.demo.mapper;

import com.example.demo.dto.ProductDTO;
import com.example.demo.models.Product;
import org.mapstruct.Mapper;
import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO productToProductDto(Product product);
    List<ProductDTO> productsToProductDtos(Collection<Product> products);
    //public abstract Collection<ProductDTO> productsToProductDtos(Collection<Product> products);
}
