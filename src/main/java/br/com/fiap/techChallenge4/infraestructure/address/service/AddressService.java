package br.com.fiap.techChallenge4.infraestructure.address.service;

import br.com.fiap.techChallenge4.entities.address.Address;
import br.com.fiap.techChallenge4.infraestructure.address.dto.AddressDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class AddressService {
    private final RestTemplate restTemplate = new RestTemplate();
    private static final String VIACEP_URL = "https://viacep.com.br/ws/{postalCode}/json/";

    public Address findAddressByPostalCode(String postalCode) {
        String url = UriComponentsBuilder.fromUriString(VIACEP_URL)
                .buildAndExpand(postalCode)
                .toUriString();
        AddressDTO response = restTemplate.getForObject(url, AddressDTO.class);
        return mapToAddress(response);
    }

    private Address mapToAddress(AddressDTO dto) {
        Address address = new Address();
        address.setPostalCode(dto.getCep());
        address.setStreet(dto.getLogradouro());
        address.setComplement(dto.getComplemento());
        address.setNeighborhood(dto.getBairro());
        address.setCity(dto.getLocalidade());
        address.setState(dto.getUf());
        return address;
    }
}
