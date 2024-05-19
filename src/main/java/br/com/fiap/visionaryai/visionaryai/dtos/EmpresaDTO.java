package br.com.fiap.visionaryai.visionaryai.dtos;

import lombok.Data;

@Data
public class EmpresaDTO {
    private Long id;
    private String cnpj;
    private String email;
    private String nome;
    private String situacao;
}
