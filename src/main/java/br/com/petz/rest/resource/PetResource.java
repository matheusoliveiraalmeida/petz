package br.com.petz.rest.resource;

import br.com.petz.rest.request.PetRequest;
import br.com.petz.rest.response.PetResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PetResource {

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista de Pets"),
            @ApiResponse(code = 404, message = "Pet não encontrado"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    @ApiOperation(value = "Retorna uma lista de Pets")
    ResponseEntity<List<PetResponse>> listAll();

    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Pet salvo com sucesso"),
            @ApiResponse(code = 500, message = "Problemas na hora de salvar")
    })
    @ApiOperation(value = "Salva um Pet")
    ResponseEntity<?> save(PetRequest request);

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Mostra o Pet atualizado"),
            @ApiResponse(code = 404, message = "Pet não encontrado"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    @ApiOperation(value = "Atualiza as informações do Pet")
    ResponseEntity<PetResponse> update(PetRequest request);

    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Não retorna nada"),
            @ApiResponse(code = 404, message = "Pet não encontrado"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    @ApiOperation(value = "Deleta um Pet")
    ResponseEntity<Void> delete(Integer id);

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o Pet"),
            @ApiResponse(code = 500, message = "Pet não encontrado"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    @ApiOperation(value = "Busca um Pet através do seu ID")
    ResponseEntity<PetResponse> searchById(Integer id);

}
