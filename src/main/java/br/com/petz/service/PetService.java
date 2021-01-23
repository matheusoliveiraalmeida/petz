package br.com.petz.service;

import br.com.petz.rest.request.PetRequest;
import br.com.petz.rest.response.PetResponse;

import java.util.List;

public interface PetService {

    List<PetResponse> listAll();

    void save(PetRequest request);

    PetResponse update(PetRequest request);

    void delete(Integer id);

    PetResponse searchById(Integer id);

}
