package br.com.fiap.visionaryai.visionaryai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.visionaryai.visionaryai.models.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
