package br.com.fiap.techChallenge4.usecases.client;


import br.com.fiap.techChallenge4.entities.address.Address;
import br.com.fiap.techChallenge4.entities.client.exception.ClientNotFoundException;
import br.com.fiap.techChallenge4.entities.client.gateway.ClientGateway;
import br.com.fiap.techChallenge4.entities.client.model.Client;
import br.com.fiap.techChallenge4.infraestructure.client.dto.ClientUpdateData;
import br.com.fiap.techChallenge4.usecases.address.FindAddressByPostalCodeUseCase;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class UpdateClientUseCase {
    private final ClientGateway clientGateway;
    private final FindAddressByPostalCodeUseCase findAddressByPostalCodeUseCase;

    public UpdateClientUseCase(ClientGateway clientGateway, FindAddressByPostalCodeUseCase findAddressByPostalCodeUseCase) {
        this.clientGateway = clientGateway;
        this.findAddressByPostalCodeUseCase = findAddressByPostalCodeUseCase;
    }

    public Client execute(Long id, ClientUpdateData updateData) throws ClientNotFoundException {
        Client client = clientGateway.findById(id).orElseThrow(ClientNotFoundException::new);
        updatePropertyIfPresent(client::setEmail, updateData::email);
        updatePropertyIfPresent(client::setPhone, updateData::phone);
        updateAddressIfPostalCodePresent(updateData, client);

        return this.clientGateway.update(client);
    }

    public Client execute(String id, ClientUpdateData updateData) throws ClientNotFoundException {
        Client client = clientGateway.findByIdentification(id).orElseThrow(ClientNotFoundException::new);
        updatePropertyIfPresent(client::setEmail, updateData::email);
        updatePropertyIfPresent(client::setPhone, updateData::phone);
        updateAddressIfPostalCodePresent(updateData, client);

        return this.clientGateway.updateByIdetification(client);
    }

    private void updatePropertyIfPresent(Consumer<String> setter, Supplier<Optional<String>> valueSupplier) {
        valueSupplier.get().ifPresent(setter);
    }

    private void updateAddressIfPostalCodePresent(ClientUpdateData clientUpdateData, Client client) {
        clientUpdateData.postalCode().ifPresent(postalCode -> {
            Address address = findAddressByPostalCodeUseCase.execute(postalCode);
            address.setNumber(clientUpdateData.number().orElse(client.getAddress().getNumber()));
            address.setComplement(clientUpdateData.complement().orElse(client.getAddress().getComplement()));
            client.setAddress(address);
        });
    }
}
