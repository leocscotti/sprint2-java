package br.com.fiap.visionaryai.visionaryai.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "tb_campanha")
@Data

public class Campanha {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @NotBlank(message = "a situação da campanha é obrigatória")
	@Column(name = "st_campanha")
	private String status;
	
    @NotBlank(message = "Informe a data de início da campanha")
	@Column(name = "dt_inicio")
	private LocalDateTime dataInicio;
	
	@Column(name = "dt_fim")
	private LocalDateTime dataFim;
	
    @NotBlank(message = "a descrição da campanha é obrigatória")
	@Column(name = "ds_campanha")
	private String descricao;

	public Campanha (Long id, String status, LocalDateTime dataInicio, LocalDateTime dataFim, String descricao) {
		this.id = id;
		this.status = status;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.descricao = descricao;
	}
}
