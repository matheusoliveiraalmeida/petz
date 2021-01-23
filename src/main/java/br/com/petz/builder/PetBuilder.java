package br.com.petz.builder;

import br.com.petz.model.Cliente;
import br.com.petz.model.Pet;

import java.util.function.Consumer;

public class PetBuilder {

    public Integer id;
    public String nome;
    public String raca;
    public Cliente cliente;

    public PetBuilder with(Consumer<PetBuilder> builder) {
        builder.accept(this);
        return this;
    }

    public Pet build() {
        return new Pet(id, nome, raca, cliente);
    }

}
