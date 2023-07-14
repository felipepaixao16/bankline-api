package com.dio.bank.bankline.api.controller;

import com.dio.bank.bankline.api.dto.NovaMovimentacao;
import com.dio.bank.bankline.api.dto.NovoCorrentista;
import com.dio.bank.bankline.api.model.Correntista;
import com.dio.bank.bankline.api.model.Movimentacao;
import com.dio.bank.bankline.api.repository.CorrentistaRepository;
import com.dio.bank.bankline.api.repository.MovimentacaoRepository;
import com.dio.bank.bankline.api.service.CorrentistaService;
import com.dio.bank.bankline.api.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Autowired
    private MovimentacaoService movimentacaoService;

    @GetMapping
    public List<Movimentacao> pegarTodos() {
        return movimentacaoRepository.findAll();
    }

    @PostMapping
    public void salvar(@RequestBody NovaMovimentacao novaMovimentacao) {
        movimentacaoService.salvar(novaMovimentacao);
    }
}
