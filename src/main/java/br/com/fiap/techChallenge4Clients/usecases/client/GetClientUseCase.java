package br.com.fiap.techChallenge4Clients.usecases.client;


import br.com.fiap.techChallenge4Clients.entities.client.exception.ClientNotFoundException;
import br.com.fiap.techChallenge4Clients.entities.client.gateway.ClientGateway;
import br.com.fiap.techChallenge4Clients.entities.client.model.Client;

public class GetClientUseCase {
    private final ClientGateway clientGateway;

    public GetClientUseCase(ClientGateway clientGateway) {
        this.clientGateway = clientGateway;
    }

    public Client execute(Long id) throws ClientNotFoundException {
        return this.clientGateway
                .findById(id)
                .orElseThrow(ClientNotFoundException::new);
    }
}
