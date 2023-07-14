package com.dio.bank.bankline.api.repository;

import com.dio.bank.bankline.api.model.Correntista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorrentistaRepository extends JpaRepository<Correntista, Integer> {
}
