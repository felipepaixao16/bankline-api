package com.dio.bank.bankline.api.service;

import com.dio.bank.bankline.api.dto.NovaMovimentacao;
import com.dio.bank.bankline.api.model.Conta;
import com.dio.bank.bankline.api.model.Correntista;
import com.dio.bank.bankline.api.model.Movimentacao;
import com.dio.bank.bankline.api.model.MovimentacaoTipo;
import com.dio.bank.bankline.api.repository.CorrentistaRepository;
import com.dio.bank.bankline.api.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MovimentacaoService {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Autowired
    private CorrentistaRepository correntistaRepository;

    public void salvar(NovaMovimentacao novaMovimentacao) {
        Movimentacao movimentacao = new Movimentacao();

        Double valor = novaMovimentacao.getValor();
        if(novaMovimentacao.getTipo() == MovimentacaoTipo.DESPESA)
            valor = valor * -1;

        movimentacao.setDataHora(LocalDateTime.now());
        movimentacao.setDescricao(novaMovimentacao.getDescricao());
        movimentacao.setIdConta(novaMovimentacao.getIdConta());
        movimentacao.setTipo(novaMovimentacao.getTipo());
        movimentacao.setValor(valor);

        Correntista correntista = correntistaRepository.findById(novaMovimentacao.getIdConta()).orElse(null);
        if(correntista != null) {
            correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
            correntistaRepository.save(correntista);
        }

        movimentacaoRepository.save(movimentacao);
    }
}
