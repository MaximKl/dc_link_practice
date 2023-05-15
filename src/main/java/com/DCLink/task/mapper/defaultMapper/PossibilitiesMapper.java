package com.DCLink.task.mapper.defaultMapper;

import com.DCLink.task.dto.defaultDTO.ClientPossibilitiesDTO;
import com.DCLink.task.model.ClientPossibilities;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.function.Function;

@Service
public class PossibilitiesMapper implements Function<ClientPossibilities, ClientPossibilitiesDTO> {
    @Override
    public ClientPossibilitiesDTO apply(ClientPossibilities possibilities) {
        return new ClientPossibilitiesDTO(
                possibilities.getClient().getId(),
                MessageFormat.format("{0} {1} {2}",
                        possibilities.getClient().getSurname(),
                        possibilities.getClient().getName(),
                        possibilities.getClient().getPatronymicName()),
                possibilities.getClient().getBusinessName(),
                possibilities.getBrand() == null ?
                        MessageFormat.format("{0}", possibilities.getType().getName())
                        :
                        MessageFormat.format("{0} {1}", possibilities.getType().getName(), possibilities.getBrand().getName()),
                (int) possibilities.getDiscountPercent(),
                possibilities.getDiscountMoney(),
                possibilities.isAvailable()
        );
    }
}
