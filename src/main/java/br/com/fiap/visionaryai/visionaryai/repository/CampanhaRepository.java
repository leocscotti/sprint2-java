package br.com.fiap.visionaryai.visionaryai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.visionaryai.visionaryai.models.Campanha;

public interface CampanhaRepository extends JpaRepository<Campanha ,Long> {
    
}