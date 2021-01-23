package br.com.petz.rest.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Getter
public class PetResponse {

    @ApiModelProperty(value = "Id do Pet")
    private Integer id;

    @ApiModelProperty(value = "Nome do Pet")
    private String nome;

    @ApiModelProperty(value = "Raça do Pet")
    private String raca;

    @ApiModelProperty(value = "Dono do Pet")
    private ClienteResponse cliente;

    public PetResponse(
            Integer id,
            String nome,
            String raca,
            ClienteResponse cliente
    ) {
        this.id = id;
        this.nome = nome;
        this.raca = raca;
        this.cliente = cliente;
    }

}
