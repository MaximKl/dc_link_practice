package com.DCLink.task.dto.defaultDTO;

public record ProductDTO(
        long productCode,
        String productName,
        String productDescription,
        String type,
        String brand,
        float price,
        float cost,
        boolean isProductAvailable

) {
}
