package br.com.petz.service.impl;

import br.com.petz.builder.ClienteBuilder;
import br.com.petz.builder.ClienteResponseBuilder;
import br.com.petz.builder.PetResponseBuilder;
import br.com.petz.exception.ClienteNaoEncontradoException;
import br.com.petz.exception.PetNaoEncontradoException;
import br.com.petz.model.Cliente;
import br.com.petz.model.Pet;
import br.com.petz.repository.ClienteRepository;
import br.com.petz.repository.PetRepository;
import br.com.petz.rest.request.ClienteRequest;
import br.com.petz.rest.response.ClienteResponse;
import br.com.petz.rest.response.PetResponse;
import br.com.petz.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.util.CollectionUtils.isEmpty;

@Component
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final PetRepository petRepository;

    @Autowired
    public ClienteServiceImpl(
            ClienteRepository clienteRepository,
            PetRepository petRepository
    ) {
        this.clienteRepository = clienteRepository;
        this.petRepository = petRepository;
    }

    @Override
    public List<ClienteResponse> listAll() {
        List<Cliente> clientes = clienteRepository.findAll();

        List<ClienteResponse> clientesResponses = new ArrayList<>(clientes.size());
        clientes.forEach(cliente -> clientesResponses.add(getCliente(cliente)));
        return clientesResponses;
    }

    @Override
    public void save(ClienteRequest request) {
        clienteRepository.save(create(request));
    }

    @Override
    public ClienteResponse update(ClienteRequest request) {
        Optional<Cliente> cliente = clienteRepository.findById(request.getId());
        if (cliente.isEmpty()) {
            throw new ClienteNaoEncontradoException("Cliente não encontrado.");
        }

        Cliente clienteUpdated = create(request);
        return getCliente(clienteRepository.save(clienteUpdated));
    }

    @Override
    public void delete(Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);

        if (cliente.isEmpty()) {
            throw new ClienteNaoEncontradoException("Cliente não encontrado.");
        }

        clienteRepository.deleteById(id);
    }

    @Override
    public ClienteResponse searchById(Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);

        if (cliente.isEmpty()) {
            throw new ClienteNaoEncontradoException("Cliente não encontrado.");
        }

        return getCliente(clienteRepository.getOne(id));
    }

    private ClienteResponse getCliente(Cliente cliente) {
        return new ClienteResponseBuilder()
                .with($cliente -> {
                    $cliente.id = cliente.getId();
                    $cliente.nome = cliente.getNome();
                    $cliente.celular = cliente.getCelular();
                    $cliente.cpf = cliente.getCpf();
                    $cliente.endereco = cliente.getEndereco();
                    $cliente.pets = getPet(cliente.getPets());
                }).build();
    }

    private List<PetResponse> getPet(List<Pet> pets) {
        List<PetResponse> petsResponses = new ArrayList<>();
        pets.forEach(pet -> petsResponses.add(new PetResponseBuilder()
                .with($pet -> {
                    $pet.id = pet.getId();
                    $pet.nome = pet.getNome();
                    $pet.raca = pet.getRaca();
                }).build()
        ));
        return petsResponses;
    }

    private Cliente create(ClienteRequest request) {
        return new ClienteBuilder()
                .with($cliente -> {
                    $cliente.id = request.getId();
                    $cliente.nome = request.getNome();
                    $cliente.celular = request.getCelular();
                    $cliente.cpf = request.getCpf();
                    $cliente.endereco = request.getEndereco();
                    $cliente.pets = getPets(request.getPetsIds());
                }).build();
    }

    private List<Pet> getPets(List<Integer> petsIds) {
        List<Pet> pets = new ArrayList<>();
        if (!isEmpty(petsIds)) {
            petsIds.forEach(petId -> {
                Optional<Pet> pet = petRepository.findById(petId);
                if (pet.isEmpty()) {
                    throw new PetNaoEncontradoException("Pet não encontrado.");
                }
                pets.add(pet.get());
            });
        }
        return pets;
    }

}
