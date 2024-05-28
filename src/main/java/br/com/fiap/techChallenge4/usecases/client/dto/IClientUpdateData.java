package br.com.fiap.techChallenge4.usecases.client.dto;



import java.util.Optional;

public interface IClientUpdateData {
    Optional<String> email();
    Optional<String> phone();
    Optional<String> postalCode();
    Optional<Integer> number();
    Optional<String> complement();
}
