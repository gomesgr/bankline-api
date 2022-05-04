package com.gomesgr.santander.banklineapi.service;

import com.gomesgr.santander.banklineapi.dto.MovimentacaoDTO;
import com.gomesgr.santander.banklineapi.model.Correntista;
import com.gomesgr.santander.banklineapi.model.Movimentacao;
import com.gomesgr.santander.banklineapi.model.MovimentacaoTipo;
import com.gomesgr.santander.banklineapi.repository.CorrentistaRepo;
import com.gomesgr.santander.banklineapi.repository.MovimentacaoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MovimentacaoService {

    @Autowired
    private MovimentacaoRepo repo;

    @Autowired
    private CorrentistaRepo correntistaRepo;

    public void save(MovimentacaoDTO movimentacaoDTO) {
        Movimentacao mov = new Movimentacao();

        Double valor = movimentacaoDTO.getTipo() == MovimentacaoTipo.RECEITA ?
                movimentacaoDTO.getValor() : movimentacaoDTO.getValor() * -1;

        mov.setDataHora(LocalDateTime.now());
        mov.setDescricao(movimentacaoDTO.getDescricao());
        mov.setContaId(movimentacaoDTO.getContaId());
        mov.setTipo(movimentacaoDTO.getTipo());
        mov.setValor(valor);

        Correntista correntista = correntistaRepo
                .findById(movimentacaoDTO.getContaId())
                .orElse(null);

        if (correntista != null) {
            correntista.getConta()
                    .setSaldo(correntista.getConta().getSaldo() + valor);
            correntistaRepo.save(correntista);
        }

        repo.save(mov);

    }
}
