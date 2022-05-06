package com.gomesgr.santander.banklineapi.controller;

import com.gomesgr.santander.banklineapi.dto.MovimentacaoDTO;
import com.gomesgr.santander.banklineapi.model.Movimentacao;
import com.gomesgr.santander.banklineapi.repository.MovimentacaoRepo;
import com.gomesgr.santander.banklineapi.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {
    @Autowired
    private MovimentacaoRepo repo;

    @Autowired
    private MovimentacaoService service;

    @GetMapping
    public List<Movimentacao> findAll() {
        return repo.findAll();
    }

    @GetMapping("/{contaId}")
    public List<Movimentacao> findAll(@PathVariable("contaId") Integer contaId) {
        return repo.findByContaId(contaId);
    }

    @PostMapping
    public void save(@RequestBody MovimentacaoDTO movimentacao) {
        service.save(movimentacao);
    }
}
