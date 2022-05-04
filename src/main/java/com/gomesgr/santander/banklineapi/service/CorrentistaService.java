package com.gomesgr.santander.banklineapi.service;

import com.gomesgr.santander.banklineapi.dto.CorrentistaDTO;
import com.gomesgr.santander.banklineapi.model.Conta;
import com.gomesgr.santander.banklineapi.model.Correntista;
import com.gomesgr.santander.banklineapi.repository.CorrentistaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CorrentistaService {
    @Autowired
    private CorrentistaRepo repo;

    public void save(CorrentistaDTO correntistaDTO) {
        Correntista correntista = new Correntista();
        correntista.setCpf(correntistaDTO.getCpf());
        correntista.setNome(correntistaDTO.getNome());

        Conta conta = new Conta();
        conta.setSaldo(0.0);
        conta.setNumero(new Date().getTime());

        correntista.setConta(conta);

        repo.save(correntista);
    }
}
