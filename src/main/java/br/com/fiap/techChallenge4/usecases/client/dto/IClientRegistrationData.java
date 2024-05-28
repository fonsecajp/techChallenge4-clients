package br.com.fiap.techChallenge4.usecases.client.dto;


public interface IClientRegistrationData {
    String name();
    String identification();
    String email();
    String phone();
    String postalCode();
    Integer number();
    String complement();
}
