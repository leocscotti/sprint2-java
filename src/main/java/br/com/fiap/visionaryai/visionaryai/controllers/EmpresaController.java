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

import br.com.fiap.visionaryai.visionaryai.dtos.EmpresaDTO;
import br.com.fiap.visionaryai.visionaryai.models.Empresa;
import br.com.fiap.visionaryai.visionaryai.services.EmpresaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {
    private final EmpresaService empresaService;

    @Autowired
    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping
    public ResponseEntity<Page<EmpresaDTO>> findAll(@PageableDefault Pageable pageable) {
        Page<EmpresaDTO> empresasDTO = empresaService.findAll(pageable);
        return ResponseEntity.ok(empresasDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaDTO> findById(@PathVariable Long id) {
        EmpresaDTO empresaDTO = empresaService.findById(id);
        return ResponseEntity.ok(empresaDTO);
    }

    @PostMapping
    public ResponseEntity<Empresa> save(@Valid @RequestBody Empresa empresa) {
        Empresa empresaSalvo = empresaService.save(empresa);
        return new ResponseEntity<>(empresaSalvo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> update(@PathVariable Long id, @Valid @RequestBody Empresa empresa) {
        Empresa empresaSalvo = empresaService.update(id, empresa);
        return new ResponseEntity<>(empresaSalvo, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        empresaService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
