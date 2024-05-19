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
@Table(name = "tb_anuncio")
@Data
public class Anuncio {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @NotBlank(message = "a descrição do anúncio é obrigatório")
	@Column(name = "ds_anuncio")
	private String descricao;

    @NotBlank(message = "a categoria do anúncio é obrigatório")
	@Column(name = "categ_anuncio")
	private String categoria;
	
    @NotBlank(message = "Informe a data de início do anúncio")
	@Column(name = "dt_inicio")
	private LocalDateTime dataInicio;
	
	@Column(name = "dt_fim")
	private LocalDateTime dataFim;

	public Anuncio (Long id, String descricao, String categoria, LocalDateTime dataInicio, LocalDateTime dataFim) {
		this.id = id;
		this.descricao = descricao;
		this.categoria = categoria;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

}
