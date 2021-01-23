package br.com.petz.rest.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetRequest {

    @ApiModelProperty(value = "Id do Pet")
    private Integer id;

    @ApiModelProperty(value = "Nome do Pet")
    private String nome;

    @ApiModelProperty(value = "Raça do Pet")
    private String raca;

    @ApiModelProperty(value = "Id do cliente")
    private Integer clienteId;

}
