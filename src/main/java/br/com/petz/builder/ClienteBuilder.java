package br.com.petz.builder;

import br.com.petz.model.Cliente;
import br.com.petz.model.Pet;

import java.util.List;
import java.util.function.Consumer;

public class ClienteBuilder {

    public Integer id;
    public String nome;
    public String celular;
    public String endereco;
    public String cpf;
    public List<Pet> pets;

    public ClienteBuilder with(Consumer<ClienteBuilder> builder) {
        builder.accept(this);
        return this;
    }

    public Cliente build() {
        return new Cliente(id, nome, celular, endereco, cpf, pets);
    }

}
