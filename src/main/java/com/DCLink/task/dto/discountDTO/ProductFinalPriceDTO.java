package com.DCLink.task.dto.discountDTO;

import java.sql.Timestamp;

public record ProductFinalPriceDTO(
        String PIB,
        String businessName,
        String productName,
        float finalPrice,
        float fullPrice,
        float minPrice,
        String type,
        String discounts,
        long productCode,
        long clientCode,
        Timestamp timestamp

) {
}
