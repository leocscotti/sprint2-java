package br.com.fiap.visionaryai.visionaryai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.visionaryai.visionaryai.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
