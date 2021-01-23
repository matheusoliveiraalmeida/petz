package br.com.petz.builder;

import br.com.petz.rest.response.ClienteResponse;
import br.com.petz.rest.response.PetResponse;

import java.util.function.Consumer;

public class PetResponseBuilder {

    public Integer id;
    public String nome;
    public String raca;
    public ClienteResponse cliente;

    public PetResponseBuilder with(Consumer<PetResponseBuilder> builder) {
        builder.accept(this);
        return this;
    }

    public PetResponse build() {
        return new PetResponse(id, nome, raca, cliente);
    }

}
