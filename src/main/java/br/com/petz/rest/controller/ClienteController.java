package br.com.petz.rest.controller;

import br.com.petz.rest.request.ClienteRequest;
import br.com.petz.rest.resource.ClienteResource;
import br.com.petz.rest.response.ClienteResponse;
import br.com.petz.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController implements ClienteResource {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<ClienteResponse>> listAll(){
        return ResponseEntity.ok(clienteService.listAll());
    }

    @PostMapping
    @Override
    public ResponseEntity<?> save(@RequestBody ClienteRequest request) {
        clienteService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    @Override
    public ResponseEntity<ClienteResponse> update(@RequestBody ClienteRequest request){
        return ResponseEntity.ok(clienteService.update(request));
    }

    @DeleteMapping("{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    @Override
    public ResponseEntity<ClienteResponse> searchById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(clienteService.searchById(id));
    }

}