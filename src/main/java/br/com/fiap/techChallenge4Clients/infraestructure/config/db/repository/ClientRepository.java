package br.com.fiap.techChallenge4Clients.infraestructure.config.db.repository;

import br.com.fiap.techChallenge4Clients.infraestructure.config.db.schema.ClientSchema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientSchema, Long> {
    Optional<ClientSchema> findByIdentification(String identification);
}
