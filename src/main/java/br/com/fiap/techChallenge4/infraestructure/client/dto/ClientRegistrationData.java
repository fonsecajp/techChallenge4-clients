package br.com.fiap.techChallenge4.infraestructure.client.dto;


import br.com.fiap.techChallenge4.entities.Address;
import br.com.fiap.techChallenge4.usecases.client.dto.IClientRegistrationData;

public record ClientRegistrationData(
        String name,
        String identification,
        String email,
        String phone,
        Address address
) implements IClientRegistrationData {
}
