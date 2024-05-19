package br.com.fiap.visionaryai.visionaryai.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.fiap.visionaryai.visionaryai.dtos.EmpresaDTO;
import br.com.fiap.visionaryai.visionaryai.models.Empresa;
import br.com.fiap.visionaryai.visionaryai.repository.EmpresaRepository;

@Service
public class EmpresaService {
    private final EmpresaRepository empresaRepository;

    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public Page<EmpresaDTO> findAll(Pageable pageable) {
        pageable = PageRequest.of(0, 5, Sort.by("nome").ascending());
        return empresaRepository.findAll(pageable).map(this::toDTO);
    }

    public EmpresaDTO findById(Long id) {
        Optional<Empresa> empresa = empresaRepository.findById(id);
        return empresa.map(this::toDTO).orElse(null);
    }

    public Empresa save(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public Empresa update(Long id, Empresa empresa) {
        Optional<Empresa> empresaOptional = empresaRepository.findById(id);
        if (empresaOptional.isPresent()) {
            Empresa empresaUpdate = empresaOptional.get();
            empresaUpdate.setCnpj(empresa.getCnpj());
            empresaUpdate.setEmail(empresa.getEmail());
            empresaUpdate.setNome(empresa.getNome());
            empresaUpdate.setSituacao(empresa.getSituacao());
            empresa = empresaRepository.save(empresaUpdate);
            return empresa;
        }
        return null;
    }

    public void delete(Long id) {
        Optional<Empresa> empresaOptional = empresaRepository.findById(id);
        empresaOptional.ifPresent(empresaRepository::delete);
    }

    private EmpresaDTO toDTO(Empresa empresa) {
        EmpresaDTO empresaDTO = new EmpresaDTO();
        empresaDTO.setId(empresa.getId());
        empresaDTO.setCnpj(empresa.getCnpj());
        empresaDTO.setEmail(empresa.getEmail());
        empresaDTO.setNome(empresa.getNome());
        empresaDTO.setSituacao(empresa.getSituacao());
        return empresaDTO;
    }
}