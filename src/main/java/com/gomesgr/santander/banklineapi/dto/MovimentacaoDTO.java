package com.gomesgr.santander.banklineapi.dto;

import com.gomesgr.santander.banklineapi.model.MovimentacaoTipo;
import lombok.Data;

@Data
public class MovimentacaoDTO {
    private String descricao;
    private Double valor;
    private Integer contaId;
    private MovimentacaoTipo tipo;
}
