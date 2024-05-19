package br.com.fiap.visionaryai.visionaryai.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "tb_pais")
@Data
public class Regiao {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @NotBlank(message = "o nome da região é obrigatória")
	@Column(name = "nm_regiao")
	private String nome;

	public Regiao (Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}
}
