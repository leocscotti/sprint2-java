package br.com.fiap.visionaryai.visionaryai.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "tb_empresa")
@Data
public class Empresa {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @Size(min= 14, message="O CNPJ é inválido")
	@Column(name = "cnpj")
	private String cnpj;
	
    @Email(message= "email inválido")
	@Column(name = "ds_email")
	private String email;

	@NotBlank(message = "O nome da empresa é obrigatório")
	@Column(name = "nm_empresa")
	private String nome;
	
    @NotBlank(message = "a situação da empresa é obrigatória")
	@Column(name = "st_empresa")
	private String situacao;

	public Empresa (Long id, String cnpj, String email, String nome, String situacao){
		this.id= id;
		this.cnpj = cnpj;
		this.email = email;
		this.nome = nome;
		this.situacao = situacao;
	}
}
