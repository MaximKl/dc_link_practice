package com.DCLink.task.dto.defaultDTO;

public record ClientDTO(
        long clientCode,

        String businessName,
        String PIB,
        int basicDiscountPercent,
        boolean isCooperating

) {
}
