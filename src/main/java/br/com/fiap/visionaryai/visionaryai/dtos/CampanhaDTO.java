package br.com.fiap.visionaryai.visionaryai.dtos;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CampanhaDTO {
    private Long id;
    private String status;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private String descricao;
}