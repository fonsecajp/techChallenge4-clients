package br.com.fiap.techChallenge4Clients.usecases.client.dto;


import br.com.fiap.techChallenge4Clients.entities.Address;

public interface IClientRegistrationData {
    String name();
    String identification();
    String email();
    String phone();
    Address address();
}
