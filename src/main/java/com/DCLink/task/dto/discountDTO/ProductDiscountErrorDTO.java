package com.DCLink.task.dto.discountDTO;

import java.sql.Timestamp;

public record ProductDiscountErrorDTO(

        String reason,
        long productCode,
        long clientCode,
        Timestamp timestamp
) {
}
