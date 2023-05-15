package com.DCLink.task.mapper.defaultMapper;

import com.DCLink.task.dto.defaultDTO.ClientDTO;
import com.DCLink.task.model.Client;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.function.Function;

@Service
public class ClientMapper implements Function<Client, ClientDTO> {

    @Override
    public ClientDTO apply(Client client) {
        return new ClientDTO(
                client.getId(),
                client.getBusinessName(),
                MessageFormat.format("{0} {1} {2}",
                        client.getSurname(),
                        client.getName(),
                        client.getPatronymicName()),
                (int) client.getBaseDiscount(),
                client.isCooperating()
        );
    }
}
