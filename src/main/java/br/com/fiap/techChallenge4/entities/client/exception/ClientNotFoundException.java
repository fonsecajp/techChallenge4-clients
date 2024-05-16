package br.com.fiap.techChallenge4.entities.client.exception;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException() {
        super("Client not found");
    }
}
