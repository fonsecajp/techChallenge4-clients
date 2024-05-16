package br.com.fiap.techChallenge4Clients.infraestructure.client.gateway;

import br.com.fiap.techChallenge4Clients.entities.client.gateway.ClientGateway;
import br.com.fiap.techChallenge4Clients.entities.client.model.Client;
import br.com.fiap.techChallenge4Clients.infraestructure.config.db.repository.ClientRepository;
import br.com.fiap.techChallenge4Clients.infraestructure.config.db.schema.ClientSchema;

import java.util.Optional;

public class ClientDatabaseGateway implements ClientGateway {

    private final ClientRepository clientRepository;

    public ClientDatabaseGateway(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client create(Client client) {
        return clientRepository.save(new ClientSchema(client)).toClient();
    }

    @Override
    public Client update(Client client) {
        return clientRepository.save(new ClientSchema(client)).toClient();
    }

    @Override
    public Client updateByIdetification(Client client) {
        return clientRepository.save(new ClientSchema(client)).toClient();}

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Optional<Client> findByIdentification(String id) {
        return clientRepository.findByIdentification(id).map(ClientSchema::toClient);
    }

    @Override
    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id).map(ClientSchema::toClient);
    }
}
