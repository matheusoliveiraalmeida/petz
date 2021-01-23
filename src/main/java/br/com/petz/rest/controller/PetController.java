package br.com.petz.rest.controller;

import br.com.petz.rest.request.PetRequest;
import br.com.petz.rest.resource.PetResource;
import br.com.petz.rest.response.PetResponse;
import br.com.petz.service.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController implements PetResource {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<PetResponse>> listAll(){
        return ResponseEntity.ok(petService.listAll());
    }

    @PostMapping
    @Override
    public ResponseEntity<?> save(@RequestBody PetRequest request) {
        petService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    @Override
    public ResponseEntity<PetResponse> update(@RequestBody PetRequest request){
        return ResponseEntity.ok(petService.update(request));
    }

    @DeleteMapping("{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        petService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    @Override
    public ResponseEntity<PetResponse> searchById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(petService.searchById(id));
    }

}
