package com.dio.bank.bankline.api.controller;

import com.dio.bank.bankline.api.dto.NovoCorrentista;
import com.dio.bank.bankline.api.model.Correntista;
import com.dio.bank.bankline.api.repository.CorrentistaRepository;
import com.dio.bank.bankline.api.service.CorrentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {

    @Autowired
    private CorrentistaRepository correntistaRepository;

    @Autowired
    private CorrentistaService correntistaService;

    @GetMapping
    public List<Correntista> pegarTodos() {
        return correntistaRepository.findAll();
    }

    @PostMapping
    public void salvar(@RequestBody NovoCorrentista novoCorrentista) {
        correntistaService.salvar(novoCorrentista);
    }
}
