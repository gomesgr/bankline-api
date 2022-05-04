package com.gomesgr.santander.banklineapi.repository;

import com.gomesgr.santander.banklineapi.model.Correntista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorrentistaRepo extends JpaRepository<Correntista, Integer> {
}
