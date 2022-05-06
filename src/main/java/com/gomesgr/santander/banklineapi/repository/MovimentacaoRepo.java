package com.gomesgr.santander.banklineapi.repository;

import com.gomesgr.santander.banklineapi.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovimentacaoRepo extends JpaRepository<Movimentacao, Integer> {

    public List<Movimentacao> findByContaId (Integer contaId);
}
