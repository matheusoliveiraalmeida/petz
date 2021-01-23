package br.com.petz.rest.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ClienteRequest {

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

    @ApiModelProperty(value = "Id dos Pets")
    private List<Integer> petsIds;

}
