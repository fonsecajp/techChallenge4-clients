package br.com.fiap.techChallenge4Clients.infraestructure.client.controller;


import br.com.fiap.techChallenge4Clients.entities.client.exception.ClientNotFoundException;
import br.com.fiap.techChallenge4Clients.infraestructure.client.dto.ClientPublicData;
import br.com.fiap.techChallenge4Clients.usecases.client.GetClientByIdentificationUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GetClientByIdentificationController {
    private final GetClientByIdentificationUseCase getClientByIdentificationUseCase;

    public GetClientByIdentificationController(GetClientByIdentificationUseCase getClientByIdentificationUseCase) {
        this.getClientByIdentificationUseCase = getClientByIdentificationUseCase;
    }


    @GetMapping("/clients/identification/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientPublicData getClientByName(@PathVariable String id) throws ClientNotFoundException {
        return new ClientPublicData(getClientByIdentificationUseCase.execute(id));
    }
}
