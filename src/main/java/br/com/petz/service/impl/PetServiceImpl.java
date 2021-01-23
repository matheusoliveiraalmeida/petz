package br.com.petz.service.impl;

import br.com.petz.builder.ClienteResponseBuilder;
import br.com.petz.builder.PetBuilder;
import br.com.petz.builder.PetResponseBuilder;
import br.com.petz.exception.ClienteNaoEncontradoException;
import br.com.petz.exception.PetNaoEncontradoException;
import br.com.petz.model.Cliente;
import br.com.petz.model.Pet;
import br.com.petz.repository.ClienteRepository;
import br.com.petz.repository.PetRepository;
import br.com.petz.rest.request.PetRequest;
import br.com.petz.rest.response.ClienteResponse;
import br.com.petz.rest.response.PetResponse;
import br.com.petz.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;
    private final ClienteRepository clienteRepository;

    @Autowired
    public PetServiceImpl(
            PetRepository petRepository,
            ClienteRepository clienteRepository
    ) {
        this.petRepository = petRepository;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<PetResponse> listAll() {

        List<Pet> pets = petRepository.findAll();

        List<PetResponse> petsResponse = new ArrayList<>(pets.size());
        pets.forEach(pet -> petsResponse.add(get(pet)));
        return petsResponse;
    }

    @Override
    public void save(PetRequest request) {
        petRepository.save(create(request));
    }

    @Override
    public PetResponse update(PetRequest request) {
        return get(petRepository.save(create(request)));
    }

    @Override
    public void delete(Integer id) {
        Optional<Pet> pet = petRepository.findById(id);

        if (pet.isEmpty()) {
            throw new PetNaoEncontradoException("Pet não encontrado.");
        }

        petRepository.deleteById(id);
    }

    @Override
    public PetResponse searchById(Integer id) {
        Optional<Pet> pet = petRepository.findById(id);

        if (pet.isEmpty()) {
            throw new PetNaoEncontradoException("Pet não encontrado.");
        }

        return get(petRepository.getOne(id));
    }

    private PetResponse get(Pet pet) {
        return new PetResponseBuilder()
                .with($pet -> {
                    $pet.id = pet.getId();
                    $pet.nome = pet.getNome();
                    $pet.raca = pet.getRaca();
                    $pet.cliente = getCliente(pet.getCliente());
                }).build();
    }

    private ClienteResponse getCliente(Cliente cliente) {
        return new ClienteResponseBuilder()
                .with($cliente -> {
                    $cliente.id = cliente.getId();
                    $cliente.nome = cliente.getNome();
                    $cliente.celular = cliente.getCelular();
                    $cliente.cpf = cliente.getCpf();
                    $cliente.endereco = cliente.getEndereco();
                }).build();
    }

    private Pet create(PetRequest request) {
        return new PetBuilder()
                .with($pet -> {
                    $pet.id = request.getId();
                    $pet.nome = request.getNome();
                    $pet.raca = request.getRaca();
                    $pet.cliente = getCliente(request.getClienteId());
                }).build();
    }

    private Cliente getCliente(Integer clienteId) {
        Optional<Cliente> cliente = clienteRepository.findById(clienteId);

        if (cliente.isEmpty()) {
            throw new ClienteNaoEncontradoException("Cliente não encontrado.");
        }

        return cliente.get();
    }

}
