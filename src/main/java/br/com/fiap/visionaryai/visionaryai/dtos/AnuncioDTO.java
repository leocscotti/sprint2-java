package br.com.fiap.visionaryai.visionaryai.dtos;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AnuncioDTO {
    private Long id;
    private String descricao;
    private String categoria;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
}