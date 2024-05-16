package br.com.fiap.techChallenge4Clients.infraestructure.client.dto;


import br.com.fiap.techChallenge4Clients.entities.Address;
import br.com.fiap.techChallenge4Clients.entities.client.model.Client;
import br.com.fiap.techChallenge4Clients.usecases.client.dto.IClientPublicData;

public record ClientPublicData(
        Long id,
        String name,
        String identification,
        String email,
        String phone,
        Address address
) implements IClientPublicData {
    public ClientPublicData (Client client){
        this(
                client.getId(),
                client.getName(),
                client.getIdentification(),
                client.getEmail(),
                client.getPhone(),
                client.getAddress());
    }
}
