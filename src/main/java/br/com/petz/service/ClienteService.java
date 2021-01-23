package br.com.petz.service;

import br.com.petz.rest.request.ClienteRequest;
import br.com.petz.rest.response.ClienteResponse;

import java.util.List;

public interface ClienteService {

    List<ClienteResponse> listAll();

    void save(ClienteRequest request);

    ClienteResponse update(ClienteRequest request);

    void delete(Integer id);

    ClienteResponse searchById(Integer id);

}
