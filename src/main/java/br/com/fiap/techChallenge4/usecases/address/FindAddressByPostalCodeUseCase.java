package br.com.fiap.techChallenge4.usecases.address;

import br.com.fiap.techChallenge4.entities.address.Address;
import br.com.fiap.techChallenge4.infraestructure.address.service.AddressService;

public class FindAddressByPostalCodeUseCase {
    private final AddressService addressService;

    public FindAddressByPostalCodeUseCase(AddressService addressService) {
        this.addressService = addressService;
    }

    public Address execute(String postalCode) {
        return addressService.findAddressByPostalCode(postalCode);
    }
}
