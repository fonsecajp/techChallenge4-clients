package br.com.fiap.techChallenge4Clients.usecases.client;


import br.com.fiap.techChallenge4Clients.entities.client.gateway.ClientGateway;
import br.com.fiap.techChallenge4Clients.entities.client.model.Client;
import br.com.fiap.techChallenge4Clients.usecases.client.dto.IClientRegistrationData;

public class CreateClientUseCase {

    private final ClientGateway clientGateway;

    public CreateClientUseCase(ClientGateway clientGateway) {
        this.clientGateway = clientGateway;
    }

    public Client execute(IClientRegistrationData registrationData){
        Client client =
                new Client(registrationData.name(),registrationData.identification(), registrationData.email(), registrationData.phone(),registrationData.address());
        return clientGateway.create(client);
    }
}
