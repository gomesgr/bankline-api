package com.gomesgr.santander.banklineapi.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Movimentacao {
    private Integer id;
    private LocalDateTime data;
    private String descricao;
    private Double valor;
    private MovimentacaoTipo tipo;
}
