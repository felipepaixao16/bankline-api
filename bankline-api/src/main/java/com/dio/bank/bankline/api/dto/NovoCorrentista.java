package com.dio.bank.bankline.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NovoCorrentista {

    /*Para que esse correntista tenha uma conta e saldo, eu preciso ter uma regra de negócio
    * que é feita na minha camada service*/

    private String nome;

    private String cpf;
}
