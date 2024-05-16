package br.com.fiap.techChallenge4.infraestructure.config.db.repository;

import br.com.fiap.techChallenge4.entities.client.model.Client;
import br.com.fiap.techChallenge4.infraestructure.config.db.schema.ClientSchema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientSchema, Long> {
    Optional<ClientSchema> findByIdentification(String identification);
}
