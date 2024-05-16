package br.com.fiap.techChallenge4.usecases.client;


import br.com.fiap.techChallenge4.entities.Address;
import br.com.fiap.techChallenge4.entities.client.exception.ClientNotFoundException;
import br.com.fiap.techChallenge4.entities.client.gateway.ClientGateway;
import br.com.fiap.techChallenge4.entities.client.model.Client;
import br.com.fiap.techChallenge4.infraestructure.client.dto.ClientUpdateData;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class UpdateClientUseCase {
    private final ClientGateway clientGateway;

    public UpdateClientUseCase(ClientGateway clientGateway) {
        this.clientGateway = clientGateway;
    }

    public Client execute(Long id, ClientUpdateData updateData) throws ClientNotFoundException {
        Client client = clientGateway.findById(id).orElseThrow(ClientNotFoundException::new);
        updatePropertyIfPresent(client::setEmail, updateData::email);
        updatePropertyIfPresent(client::setPhone, updateData::phone);
        updateAddressIfPresent(client::setAddress, updateData::address);

        return this.clientGateway.update(client);
    }

    public Client execute(String id, ClientUpdateData updateData) throws ClientNotFoundException {
        Client client = clientGateway.findByIdentification(id).orElseThrow(ClientNotFoundException::new);
        updatePropertyIfPresent(client::setEmail, updateData::email);
        updatePropertyIfPresent(client::setPhone, updateData::phone);
        updateAddressIfPresent(client::setAddress, updateData::address);

        return this.clientGateway.updateByIdetification(client);
    }

    private void updatePropertyIfPresent(Consumer<String> setter, Supplier<Optional<String>> valueSupplier) {
        valueSupplier.get().ifPresent(setter);
    }

    private void updateAddressIfPresent(Consumer<Address> setter, Supplier<Optional<Address>> valueSupplier) {
        valueSupplier.get().ifPresent(setter);
    }
}
