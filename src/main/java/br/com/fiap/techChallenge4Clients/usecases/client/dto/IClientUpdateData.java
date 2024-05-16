package br.com.fiap.techChallenge4Clients.usecases.client.dto;



import br.com.fiap.techChallenge4Clients.entities.Address;

import java.util.Optional;

public interface IClientUpdateData {
    Optional<String> email();
    Optional<String> phone();
    Optional<Address> address();
}
