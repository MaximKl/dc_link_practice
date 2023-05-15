package com.DCLink.task.mapper.discountMapper;

import com.DCLink.task.dto.discountDTO.PossibilityDTO;
import com.DCLink.task.model.ClientPossibilities;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.function.Function;

@Service
public class PossibilityMapper implements Function<ClientPossibilities, PossibilityDTO> {

    @Override
    public PossibilityDTO apply(ClientPossibilities possibilities) {
        return new PossibilityDTO(
                possibilities.getBrand() == null ?
                        MessageFormat.format("{0}", possibilities.getType().getName())
                        :
                        MessageFormat.format("{0} {1}", possibilities.getType().getName(), possibilities.getBrand().getName()),
                possibilities.getDiscountPercent(),
                possibilities.getDiscountMoney(),
                possibilities.isAvailable());

    }
}
