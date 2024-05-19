package br.com.fiap.visionaryai.visionaryai.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.fiap.visionaryai.visionaryai.dtos.IADTO;
import br.com.fiap.visionaryai.visionaryai.models.IA;
import br.com.fiap.visionaryai.visionaryai.repository.IARepository;

@Service
public class IAService {
    private final IARepository iaRepository;

    @Autowired
    public IAService(IARepository iaRepository) {
        this.iaRepository = iaRepository;
    }

    public Page<IADTO> findAll(Pageable pageable) {
        pageable = PageRequest.of(0, 5, Sort.by("tipo").ascending());
        return iaRepository.findAll(pageable).map(this::toDTO);
    }

    public IADTO findById(Long id) {
        Optional<IA> ia = iaRepository.findById(id);
        return ia.map(this::toDTO).orElse(null);
    }

    public IA save(IA ia) {
        return iaRepository.save(ia);
    }

    public IA update(Long id, IA ia) {
        Optional<IA> iaOptional = iaRepository.findById(id);
        if (iaOptional.isPresent()) {
            IA iaUpdate = iaOptional.get();
            iaUpdate.setTipo(ia.getTipo());
            iaUpdate.setDescricao(ia.getDescricao());
            iaUpdate.setAcuracia(ia.getAcuracia());
            iaUpdate.setStatus(ia.getStatus());
            ia = iaRepository.save(iaUpdate);
            return ia;
        }
        return null;
    }

    public void delete(Long id) {
        Optional<IA> iaOptional = iaRepository.findById(id);
        iaOptional.ifPresent(iaRepository::delete);
    }

    private IADTO toDTO(IA ia) {
        IADTO iaDTO = new IADTO();
        iaDTO.setId(ia.getId());
        iaDTO.setTipo(ia.getTipo());
        iaDTO.setDescricao(ia.getDescricao());
        iaDTO.setAcuracia(ia.getAcuracia());
        iaDTO.setStatus(ia.getStatus());
        return iaDTO;
    }
}