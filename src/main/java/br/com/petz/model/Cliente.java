package br.com.petz.model;


import lombok.Getter;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REMOVE;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "clientes")
@Getter
public class Cliente {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column
    private String nome;

    @Column
    private String celular;

    @Column
    private String endereco;

    @Column
    private String cpf;

    @OneToMany(mappedBy = "cliente", cascade = { PERSIST, REMOVE }, fetch = LAZY)
    private List<Pet> pets;

    public Cliente() {}

    public Cliente(
            Integer id,
            String nome,
            String celular,
            String endereco,
            String cpf,
            List<Pet> pets
    ) {
        this.id = id;
        this.nome = nome;
        this.celular = celular;
        this.endereco = endereco;
        this.cpf = cpf;
        this.pets = pets;
    }

}
