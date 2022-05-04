package com.gomesgr.santander.banklineapi.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class Conta {
    @Column(name = "numero")
    private Long numero;

    @Column(name = "saldo")
    private Double saldo;
}
