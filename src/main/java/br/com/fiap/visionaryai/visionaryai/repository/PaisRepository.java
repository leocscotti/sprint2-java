package br.com.fiap.visionaryai.visionaryai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.visionaryai.visionaryai.models.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long> {
    
}
