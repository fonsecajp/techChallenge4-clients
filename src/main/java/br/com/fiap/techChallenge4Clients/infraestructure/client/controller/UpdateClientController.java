package br.com.fiap.techChallenge4Clients.infraestructure.client.controller;


import br.com.fiap.techChallenge4Clients.entities.client.exception.ClientNotFoundException;
import br.com.fiap.techChallenge4Clients.infraestructure.client.dto.ClientPublicData;
import br.com.fiap.techChallenge4Clients.infraestructure.client.dto.ClientUpdateData;
import br.com.fiap.techChallenge4Clients.usecases.client.UpdateClientUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UpdateClientController {
    private final UpdateClientUseCase updateClientUseCase;

    public UpdateClientController(UpdateClientUseCase updateClientUseCase) {
        this.updateClientUseCase = updateClientUseCase;
    }


    @PutMapping("/clients/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientPublicData updateClient(@PathVariable Long id, @Valid @RequestBody ClientUpdateData updateData) throws ClientNotFoundException {
        return new ClientPublicData(updateClientUseCase.execute(id,updateData));
    }
}
