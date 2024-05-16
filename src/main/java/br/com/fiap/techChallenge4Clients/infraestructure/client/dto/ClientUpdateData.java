package br.com.fiap.techChallenge4Clients.infraestructure.client.dto;


import br.com.fiap.techChallenge4Clients.entities.Address;
import br.com.fiap.techChallenge4Clients.usecases.client.dto.IClientUpdateData;

import java.util.Optional;

public record ClientUpdateData(
        Optional<String> email,
        Optional<String> phone,
        Optional<Address> address
) implements IClientUpdateData {
}
