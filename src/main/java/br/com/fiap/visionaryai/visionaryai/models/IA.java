package br.com.fiap.visionaryai.visionaryai.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "tb_IA")
@Data
public class IA {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @NotBlank(message = "Informe o tipo da IA")
	@Column(name = "tp_ia")
	private String tipo;
	
    @NotBlank(message = "Descreva a IA")
	@Column(name = "ds_ia")
	private String descricao;
	
    @Size(min=3, message= "A acurácia deve ser em %")
	@Column(name = "acuracia")
	private String acuracia;
	
    @NotBlank(message = "Informe a situação da IA")
	@Column(name = "st_ia")
	private String status;

	public IA (Long id, String tipo, String descricao, String acuracia, String status) {
		this.id = id;
		this.tipo = tipo;
		this.descricao = descricao;
		this.acuracia = acuracia;
		this.status = status;
	}
}
