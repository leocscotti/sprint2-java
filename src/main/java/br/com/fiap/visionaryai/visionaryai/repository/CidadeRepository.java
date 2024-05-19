package br.com.fiap.visionaryai.visionaryai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.visionaryai.visionaryai.models.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade ,Long> {
    
}
