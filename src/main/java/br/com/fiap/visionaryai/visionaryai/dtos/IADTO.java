package br.com.fiap.visionaryai.visionaryai.dtos;

import lombok.Data;

@Data
public class IADTO {
    private Long id;
    private String tipo;
    private String descricao;
    private String acuracia;
    private String status;
}