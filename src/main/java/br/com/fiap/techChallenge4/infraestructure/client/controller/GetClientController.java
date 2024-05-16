package br.com.fiap.techChallenge4.infraestructure.client.controller;


import br.com.fiap.techChallenge4.entities.client.exception.ClientNotFoundException;
import br.com.fiap.techChallenge4.infraestructure.client.dto.ClientPublicData;
import br.com.fiap.techChallenge4.usecases.client.GetClientUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetClientController {
    private final GetClientUseCase getClientUseCase;


    public GetClientController(GetClientUseCase getClientUseCase) {
        this.getClientUseCase = getClientUseCase;
    }

    @GetMapping("/clients/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientPublicData getClientByName(@PathVariable Long id) throws ClientNotFoundException {
        return new ClientPublicData(getClientUseCase.execute(id));
    }
}
