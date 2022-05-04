package com.gomesgr.santander.banklineapi.model;

import lombok.Data;

@Data
public class Correntista {
    private Integer id;
    private String nome;
    private String cpf;
    private Conta conta;
}
