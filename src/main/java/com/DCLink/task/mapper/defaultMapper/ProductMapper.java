package com.DCLink.task.mapper.defaultMapper;

import com.DCLink.task.dto.defaultDTO.ProductDTO;
import com.DCLink.task.model.Product;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ProductMapper implements Function<Product, ProductDTO> {
    @Override
    public ProductDTO apply(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getProductName(),
                product.getProductDescription(),
                product.getType().getName(),
                product.getBrand().getName(),
                product.getPrice(),
                product.getCost(),
                product.isProductIsAvailable()
        );
    }
}
