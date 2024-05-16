package br.com.fiap.techChallenge4.infraestructure.config.db.schema;


import br.com.fiap.techChallenge4.entities.Address;
import br.com.fiap.techChallenge4.entities.client.model.Client;
import br.com.fiap.techChallenge4.infraestructure.validation.ValidCPFOrCNPJ;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Client")
@Getter
@Setter
public class ClientSchema extends AbstractEntitySchema<Long> {

    @NotNull
    @NotEmpty
    private String name;


    @NotNull
    @Column(unique = true)
    @ValidCPFOrCNPJ
    private String identification;

    @NotNull
    private Address address;

    @NotEmpty
    @NotNull
    private String email;

    @NotEmpty
    @NotNull
    private String phone;

    public ClientSchema() {
        super();
    }
    public ClientSchema(Client client) {
        this.setId(client.getId());
        this.name = client.getName();
        this.identification = client.getIdentification();
        this.address = client.getAddress();
        this.email = client.getEmail();
        this.phone = client.getPhone();
    }
    public Client toClient(){
        Client client = new Client(this.name, this.identification, this.email, this.phone, this.address);
        client.setId(this.getId());
        return client;
    }
}
