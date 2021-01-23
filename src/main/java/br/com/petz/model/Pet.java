package br.com.petz.model;

import lombok.Getter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "pets")
@Getter
public class Pet {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column
    private String nome;

    @Column
    private String raca;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Pet() {}

    public Pet(
            Integer id,
            String nome,
            String raca,
            Cliente cliente
    ) {
        this.id = id;
        this.nome = nome;
        this.raca = raca;
        this.cliente = cliente;
    }

}
