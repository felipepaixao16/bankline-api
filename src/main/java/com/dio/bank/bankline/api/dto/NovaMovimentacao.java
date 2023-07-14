package com.dio.bank.bankline.api.dto;

import com.dio.bank.bankline.api.model.MovimentacaoTipo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NovaMovimentacao {

    private String descricao;

    private Double valor;

    private MovimentacaoTipo tipo;

    private Integer idConta;
}
