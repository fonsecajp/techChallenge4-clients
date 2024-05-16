package br.com.fiap.techChallenge4.entities;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Address {

    private String street;
    private String postalCode;
    private String city;
    private String country;

    public Address(String street, String postalCode, String city, String country) {
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    public Address() {
    }
}
