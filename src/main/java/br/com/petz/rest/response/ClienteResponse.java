package br.com.petz.rest.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class ClienteResponse {

    @ApiModelProperty(value = "Id do cliente")
    private Integer id;

    @ApiModelProperty(value = "Nome do cliente")
    private String nome;

    @ApiModelProperty(value = "Celular do cliente")
    private String celular;

    @ApiModelProperty(value = "Endereço do cliente")
    private String endereco;

    @ApiModelProperty(value = "Identificação do cliente")
    private String cpf;

    @ApiModelProperty(value = "Pets do cliente")
    private List<PetResponse> pets;

    public ClienteResponse(
            Integer id,
            String nome,
            String celular,
            String endereco,
            String cpf,
            List<PetResponse> pets
    ) {
        this.id = id;
        this.nome = nome;
        this.celular = celular;
        this.endereco = endereco;
        this.cpf = cpf;
        this.pets = pets;
    }

}
