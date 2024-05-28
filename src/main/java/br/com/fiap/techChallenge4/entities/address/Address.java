package br.com.fiap.techChallenge4.entities.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Address {
    private String street;

    private Integer number;

    private String complement;

    private String neighborhood;

    private String postalCode;

    private String city;

    private String state;

    public Address(String street, Integer number, String complement, String neighborhood, String postalCode, String city, String state) {
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.postalCode = postalCode;
        this.city = city;
        this.state = state;
    }

    public Address() {
    }
}
