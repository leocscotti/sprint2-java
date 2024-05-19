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
@Table(name = "tb_cliente")
@Data
public class Cliente {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @NotBlank(message = "O nome é obrigatório")
	@Column(name = "nm_cliente")
	private String nome;

	public Cliente(Long id, String nome) {
        this.id = id;
        this.nome = nome;
	}
}
