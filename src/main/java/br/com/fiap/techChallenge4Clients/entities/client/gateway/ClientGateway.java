package br.com.fiap.techChallenge4Clients.entities.client.gateway;

import br.com.fiap.techChallenge4Clients.entities.client.model.Client;

import java.util.Optional;

public interface ClientGateway {
    Client create(Client client);
    Client update(Client client);
    Client updateByIdetification(Client client);
    void delete(Long id);
    Optional<Client> findByIdentification(String id);
    Optional<Client> findById(Long id);
}
