package br.com.fiap.techChallenge4Clients.infraestructure.config.web;

import br.com.fiap.techChallenge4Clients.entities.client.gateway.ClientGateway;
import br.com.fiap.techChallenge4Clients.infraestructure.client.gateway.ClientDatabaseGateway;
import br.com.fiap.techChallenge4Clients.infraestructure.config.db.repository.ClientRepository;
import br.com.fiap.techChallenge4Clients.usecases.client.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MvcConfig {

    @Bean
    public CreateClientUseCase createClientUseCase(ClientRepository clientRepository) {
        ClientGateway clientGateway = new ClientDatabaseGateway(clientRepository);
        return new CreateClientUseCase(clientGateway);
    }

    @Bean
    public DeleteClientUseCase deleteClientUseCase(ClientRepository clientRepository) {
        ClientGateway clientGateway = new ClientDatabaseGateway(clientRepository);
        return new DeleteClientUseCase(clientGateway);
    }

    @Bean
    public GetClientUseCase getClientUseCase(ClientRepository clientRepository) {
        ClientGateway clientGateway = new ClientDatabaseGateway(clientRepository);
        return new GetClientUseCase(clientGateway);
    }

    @Bean
    public GetClientByIdentificationUseCase getClientByIdentificationUseCase(ClientRepository clientRepository) {
        ClientGateway clientGateway = new ClientDatabaseGateway(clientRepository);
        return new GetClientByIdentificationUseCase(clientGateway);
    }


    @Bean
    public UpdateClientUseCase updateClientUseCase(ClientRepository clientRepository) {
        ClientGateway clientGateway = new ClientDatabaseGateway(clientRepository);
        return new UpdateClientUseCase(clientGateway);
    }
}
