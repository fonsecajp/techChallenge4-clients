package br.com.fiap.techChallenge4.usecases.client;


import br.com.fiap.techChallenge4.entities.address.Address;
import br.com.fiap.techChallenge4.entities.client.gateway.ClientGateway;
import br.com.fiap.techChallenge4.entities.client.model.Client;
import br.com.fiap.techChallenge4.usecases.address.FindAddressByPostalCodeUseCase;
import br.com.fiap.techChallenge4.usecases.client.dto.IClientRegistrationData;

public class CreateClientUseCase {

    private final ClientGateway clientGateway;
    private final FindAddressByPostalCodeUseCase findAddressByPostalCodeUseCase;

    public CreateClientUseCase(ClientGateway clientGateway, FindAddressByPostalCodeUseCase findAddressByPostalCodeUseCase) {
        this.clientGateway = clientGateway;
        this.findAddressByPostalCodeUseCase = findAddressByPostalCodeUseCase;
    }

    public Client execute(IClientRegistrationData registrationData){
        Address address = findAddressByPostalCodeUseCase.execute(registrationData.postalCode());
        address.setNumber(registrationData.number());
        address.setComplement(registrationData.complement());

        Client client =
                new Client(registrationData.name(),registrationData.identification(), registrationData.email(), registrationData.phone(), address);
        return clientGateway.create(client);
    }
}
