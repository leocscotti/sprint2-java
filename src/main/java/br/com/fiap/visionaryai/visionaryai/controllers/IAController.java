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

import br.com.fiap.visionaryai.visionaryai.dtos.IADTO;
import br.com.fiap.visionaryai.visionaryai.models.IA;
import br.com.fiap.visionaryai.visionaryai.services.IAService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/ias")
public class IAController {
    private final IAService iaService;

    @Autowired
    public IAController(IAService iaService) {
        this.iaService = iaService;
    }

    @GetMapping
    public ResponseEntity<Page<IADTO>> findAll(@PageableDefault Pageable pageable) {
        Page<IADTO> iasDTO = iaService.findAll(pageable);
        return ResponseEntity.ok(iasDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IADTO> findById(@PathVariable Long id) {
        IADTO iaDTO = iaService.findById(id);
        return ResponseEntity.ok(iaDTO);
    }

    @PostMapping
    public ResponseEntity<IA> save(@Valid @RequestBody IA ia) {
        IA iaSalvo = iaService.save(ia);
        return new ResponseEntity<>(iaSalvo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IA> update(@PathVariable Long id, @Valid @RequestBody IA ia) {
        IA iaSalvo = iaService.update(id, ia);
        return new ResponseEntity<>(iaSalvo, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        iaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
