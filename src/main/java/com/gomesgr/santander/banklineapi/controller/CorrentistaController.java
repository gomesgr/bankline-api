package com.gomesgr.santander.banklineapi.controller;

import com.gomesgr.santander.banklineapi.dto.CorrentistaDTO;
import com.gomesgr.santander.banklineapi.model.Correntista;
import com.gomesgr.santander.banklineapi.repository.CorrentistaRepo;
import com.gomesgr.santander.banklineapi.service.CorrentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/correntista")
public class CorrentistaController {
    @Autowired
    private CorrentistaRepo repo;

    @Autowired
    private CorrentistaService service;

    @GetMapping
    public List<Correntista> findAll() {
        return repo.findAll();
    }

    @PostMapping
    public void save(@RequestBody CorrentistaDTO correntista) {
        service.save(correntista);
    }
}
