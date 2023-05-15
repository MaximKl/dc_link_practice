package com.DCLink.task.dto.discountDTO;

import java.sql.Timestamp;
import java.util.List;

public record AllClientPossibilitiesDTO(
        long clientCode,
        String PIB,
        String businessName,
        List<PossibilityDTO> possibilities,
        Timestamp timestamp
) {
}
