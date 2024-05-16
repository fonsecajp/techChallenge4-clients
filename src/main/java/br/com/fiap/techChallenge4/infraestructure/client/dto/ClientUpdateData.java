package br.com.fiap.techChallenge4.infraestructure.client.dto;


import br.com.fiap.techChallenge4.entities.Address;
import br.com.fiap.techChallenge4.usecases.client.dto.IClientUpdateData;

import java.util.Optional;

public record ClientUpdateData(
        Optional<String> email,
        Optional<String> phone,
        Optional<Address> address
) implements IClientUpdateData {
}
