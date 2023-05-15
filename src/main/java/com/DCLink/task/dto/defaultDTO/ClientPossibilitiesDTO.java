package com.DCLink.task.dto.defaultDTO;

public record ClientPossibilitiesDTO(
        long clientCode,
        String clientPIB,
        String businessName,
        String productType,
        int percent_discount,
        float money_discount,
        boolean isAvailablePossibility

) {
}
