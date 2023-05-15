package com.DCLink.task.dto.discountDTO;
public record PossibilityDTO(
        String productType,
        float percentDiscount,
        float moneyDiscount,
        boolean isAvailable
        ) {
}
