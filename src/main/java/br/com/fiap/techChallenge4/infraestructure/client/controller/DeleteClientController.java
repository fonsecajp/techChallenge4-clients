package br.com.fiap.techChallenge4.infraestructure.client.controller;

import br.com.fiap.techChallenge4.usecases.client.DeleteClientUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
public class DeleteClientController {
    private final DeleteClientUseCase deleteClientUseCase;

    public DeleteClientController(DeleteClientUseCase deleteClientUseCase) {
        this.deleteClientUseCase = deleteClientUseCase;
    }

    @DeleteMapping("/clients/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClient(@PathVariable Long id) {
        deleteClientUseCase.execute(id);
    }
}
