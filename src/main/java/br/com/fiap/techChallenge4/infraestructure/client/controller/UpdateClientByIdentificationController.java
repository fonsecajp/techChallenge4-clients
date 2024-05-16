package br.com.fiap.techChallenge4.infraestructure.client.controller;


import br.com.fiap.techChallenge4.entities.client.exception.ClientNotFoundException;
import br.com.fiap.techChallenge4.infraestructure.client.dto.ClientPublicData;
import br.com.fiap.techChallenge4.infraestructure.client.dto.ClientUpdateData;
import br.com.fiap.techChallenge4.usecases.client.UpdateClientUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UpdateClientByIdentificationController {
    private final UpdateClientUseCase updateClientUseCase;

    public UpdateClientByIdentificationController(UpdateClientUseCase updateClientUseCase) {
        this.updateClientUseCase = updateClientUseCase;
    }


    @PutMapping("/clients/identification/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientPublicData updateClient(@PathVariable String id, @Valid @RequestBody ClientUpdateData updateData) throws ClientNotFoundException {
        return new ClientPublicData(updateClientUseCase.execute(id,updateData));
    }
}
