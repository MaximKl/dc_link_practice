package com.DCLink.task.mapper.discountMapper;

import com.DCLink.task.dto.discountDTO.AllClientPossibilitiesDTO;
import com.DCLink.task.model.Client;
import com.DCLink.task.model.ClientPossibilities;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AllClientPossibilitiesMapper {

    private final PossibilityMapper possibilityMapper;

    public AllClientPossibilitiesDTO apply(Client client, List<ClientPossibilities> clientPossibilities) {
        return new AllClientPossibilitiesDTO(
                client.getId(),
                MessageFormat.format("{0} {1} {2}",
                        client.getSurname(),
                        client.getName(),
                        client.getPatronymicName()),
                client.getBusinessName(),
                clientPossibilities.isEmpty() ?
                        new ArrayList<>() :
                        clientPossibilities.stream().map(possibilityMapper).toList(),
                Timestamp.valueOf(LocalDateTime.now())
        );
    }
}
