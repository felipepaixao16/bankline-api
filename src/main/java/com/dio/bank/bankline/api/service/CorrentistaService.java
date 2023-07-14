package com.dio.bank.bankline.api.service;

import com.dio.bank.bankline.api.dto.NovoCorrentista;
import com.dio.bank.bankline.api.model.Conta;
import com.dio.bank.bankline.api.model.Correntista;
import com.dio.bank.bankline.api.repository.CorrentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CorrentistaService {

    @Autowired
    private CorrentistaRepository correntistaRepository;

    public void salvar(NovoCorrentista novoCorrentista) {
        Correntista correntista = new Correntista();
        correntista.setCpf(novoCorrentista.getCpf());
        correntista.setNome(novoCorrentista.getNome());

        Conta conta = new Conta();
        conta.setSaldo(0.0);
        conta.setNumero(new Date().getTime());

        correntista.setConta(conta);
        correntistaRepository.save(correntista);
    }
}
