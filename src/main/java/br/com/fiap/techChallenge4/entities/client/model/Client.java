package br.com.fiap.techChallenge4.entities.client.model;


import br.com.fiap.techChallenge4.entities.AbstractEntity;
import br.com.fiap.techChallenge4.entities.Address;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Client extends AbstractEntity<Long> {

    private String name;
    private String identification;
    private String email;
    private String phone;
    private Address address;

    public Client(String name, String identification, String email, String phone, Address address) {
        this.name = name;
        this.identification = identification;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
    public Client(){


    }
}
