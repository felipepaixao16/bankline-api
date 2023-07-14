package com.dio.bank.bankline.api.repository;

import com.dio.bank.bankline.api.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

// O repository serve para determinar alguém para fazer uma interação com a minha entidade
// Então esse repository foi criado para salvar as Movimentações
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {
}
