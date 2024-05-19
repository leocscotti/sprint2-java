package br.com.fiap.visionaryai.visionaryai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.visionaryai.visionaryai.dtos.ClienteDTO;
import br.com.fiap.visionaryai.visionaryai.models.Cliente;
import br.com.fiap.visionaryai.visionaryai.services.ClienteService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<Page<ClienteDTO>> findAll(@PageableDefault Pageable pageable) {
        Page<ClienteDTO> clientesDTO = clienteService.findAll(pageable);
        return ResponseEntity.ok(clientesDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable Long id) {
        ClienteDTO clienteDTO = clienteService.findById(id);
        return ResponseEntity.ok(clienteDTO);
    }

    @PostMapping
    public ResponseEntity<Cliente> save(@Valid @RequestBody Cliente cliente) {
        Cliente clienteSalvo = clienteService.save(cliente);
        return new ResponseEntity<>(clienteSalvo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
        Cliente clienteSalvo = clienteService.update(id, cliente);
        return new ResponseEntity<>(clienteSalvo, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
