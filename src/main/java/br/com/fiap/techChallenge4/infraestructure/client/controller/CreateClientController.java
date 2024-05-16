package br.com.fiap.techChallenge4.infraestructure.client.controller;


import br.com.fiap.techChallenge4.infraestructure.client.dto.ClientPublicData;
import br.com.fiap.techChallenge4.infraestructure.client.dto.ClientRegistrationData;
import br.com.fiap.techChallenge4.usecases.client.CreateClientUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CreateClientController {
    private final CreateClientUseCase createClientUseCase;

    public CreateClientController(CreateClientUseCase createClientUseCase) {
        this.createClientUseCase = createClientUseCase;
    }

    @PostMapping("/clients")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientPublicData createClient(@Valid @RequestBody ClientRegistrationData clientData) {
        return new ClientPublicData(createClientUseCase.execute(clientData));
    }
}
