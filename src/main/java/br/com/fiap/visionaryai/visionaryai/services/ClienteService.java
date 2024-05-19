package br.com.fiap.visionaryai.visionaryai.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.fiap.visionaryai.visionaryai.dtos.ClienteDTO;
import br.com.fiap.visionaryai.visionaryai.models.Cliente;
import br.com.fiap.visionaryai.visionaryai.repository.ClienteRepository;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Page<ClienteDTO> findAll(Pageable pageable) {
        pageable = PageRequest.of(0, 5, Sort.by("nome").ascending());
        return clienteRepository.findAll(pageable).map(this::toDTO);
    }

    public ClienteDTO findById(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.map(this::toDTO).orElse(null);
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente update(Long id, Cliente cliente) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isPresent()) {
            Cliente clienteUpdate = clienteOptional.get();
            clienteUpdate.setNome(cliente.getNome());
            cliente = clienteRepository.save(clienteUpdate);
            return cliente;
        }
        return null;
    }

    public void delete(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        clienteOptional.ifPresent(clienteRepository::delete);
    }

    private ClienteDTO toDTO(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(cliente.getId());
        clienteDTO.setNome(cliente.getNome());
        return clienteDTO;
    }
}