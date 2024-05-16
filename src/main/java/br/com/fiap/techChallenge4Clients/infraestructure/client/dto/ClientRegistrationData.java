package br.com.fiap.techChallenge4Clients.infraestructure.client.dto;


import br.com.fiap.techChallenge4Clients.entities.Address;
import br.com.fiap.techChallenge4Clients.usecases.client.dto.IClientRegistrationData;

public record ClientRegistrationData(
        String name,
        String identification,
        String email,
        String phone,
        Address address
) implements IClientRegistrationData {
}
