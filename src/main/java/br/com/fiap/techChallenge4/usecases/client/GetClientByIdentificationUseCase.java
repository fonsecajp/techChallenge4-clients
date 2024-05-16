package br.com.fiap.techChallenge4.usecases.client;


import br.com.fiap.techChallenge4.entities.client.exception.ClientNotFoundException;
import br.com.fiap.techChallenge4.entities.client.gateway.ClientGateway;
import br.com.fiap.techChallenge4.entities.client.model.Client;

public class GetClientByIdentificationUseCase {
    private final ClientGateway clientGateway;

    public GetClientByIdentificationUseCase(ClientGateway clientGateway) {
        this.clientGateway = clientGateway;
    }

    public Client execute(String id) throws ClientNotFoundException {
        return this.clientGateway
                .findByIdentification(id)
                .orElseThrow(ClientNotFoundException::new);
    }
}
