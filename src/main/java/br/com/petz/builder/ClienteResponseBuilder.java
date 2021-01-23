package br.com.petz.builder;

import br.com.petz.rest.response.ClienteResponse;
import br.com.petz.rest.response.PetResponse;

import java.util.List;
import java.util.function.Consumer;

public class ClienteResponseBuilder {

    public Integer id;
    public String nome;
    public String celular;
    public String endereco;
    public String cpf;
    public List<PetResponse> pets;

    public ClienteResponseBuilder with(Consumer<ClienteResponseBuilder> builder) {
        builder.accept(this);
        return this;
    }

    public ClienteResponse build() {
        return new ClienteResponse(id, nome, celular, endereco, cpf, pets);
    }

}
