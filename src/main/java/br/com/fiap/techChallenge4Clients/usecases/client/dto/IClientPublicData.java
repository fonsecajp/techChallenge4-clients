package br.com.fiap.techChallenge4Clients.usecases.client.dto;


import br.com.fiap.techChallenge4Clients.entities.Address;

public interface IClientPublicData {

    String name();
    String identification();
    String email();
    String phone();
    Address address();

}
