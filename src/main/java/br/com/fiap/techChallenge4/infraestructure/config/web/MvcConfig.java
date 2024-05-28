package br.com.fiap.techChallenge4.infraestructure.config.web;

import br.com.fiap.techChallenge4.entities.client.gateway.ClientGateway;
import br.com.fiap.techChallenge4.infraestructure.address.service.AddressService;
import br.com.fiap.techChallenge4.infraestructure.client.gateway.ClientDatabaseGateway;
import br.com.fiap.techChallenge4.infraestructure.config.db.repository.ClientRepository;
import br.com.fiap.techChallenge4.usecases.address.FindAddressByPostalCodeUseCase;
import br.com.fiap.techChallenge4.usecases.client.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MvcConfig {

    @Bean
    public CreateClientUseCase createClientUseCase(ClientRepository clientRepository) {
        ClientGateway clientGateway = new ClientDatabaseGateway(clientRepository);
        FindAddressByPostalCodeUseCase findAddressByPostalCodeUseCase = new FindAddressByPostalCodeUseCase(new AddressService());
        return new CreateClientUseCase(clientGateway, findAddressByPostalCodeUseCase);
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
    public FindAddressByPostalCodeUseCase findAddressByPostalCodeUseCase(AddressService addressService){
        return new FindAddressByPostalCodeUseCase(addressService);
    }

    @Bean
    public UpdateClientUseCase updateClientUseCase(ClientRepository clientRepository) {
        ClientGateway clientGateway = new ClientDatabaseGateway(clientRepository);
        FindAddressByPostalCodeUseCase findAddressByPostalCodeUseCase = new FindAddressByPostalCodeUseCase(new AddressService());
        return new UpdateClientUseCase(clientGateway, findAddressByPostalCodeUseCase);
    }
}
