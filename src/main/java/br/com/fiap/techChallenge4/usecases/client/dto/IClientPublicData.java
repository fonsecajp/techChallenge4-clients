package br.com.fiap.techChallenge4.usecases.client.dto;


import br.com.fiap.techChallenge4.entities.Address;

public interface IClientPublicData {

    String name();
    String identification();
    String email();
    String phone();
    Address address();

}
