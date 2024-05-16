package br.com.fiap.techChallenge4Clients.usecases.client;


import br.com.fiap.techChallenge4Clients.entities.client.exception.ClientNotFoundException;
import br.com.fiap.techChallenge4Clients.entities.client.gateway.ClientGateway;
import br.com.fiap.techChallenge4Clients.entities.client.model.Client;

public class DeleteClientUseCase {
    private final ClientGateway clientGateway;

    public DeleteClientUseCase(ClientGateway clientGateway) {
        this.clientGateway = clientGateway;
    }


    public void execute(final Long id) throws ClientNotFoundException {
        Client client = clientGateway.findById(id)
                .orElseThrow(ClientNotFoundException::new);
        clientGateway.delete(client.getId());
    }
}
