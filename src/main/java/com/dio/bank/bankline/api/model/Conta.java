package com.dio.bank.bankline.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable // Informa que essa classe(tabela) está sendo estanciada por outra classe(tabela), e terá
            // as informações da tabela "Conta" na classe que está estanciando ela "Correntista".
public class Conta {

    @Column(name = "conta_numero") // estou atribuindo um nome para essa coluna no meu banco de dados
    private Long numero;

    @Column(name = "conta_saldo") // estou atribuindo um nome para essa coluna no meu banco de dados
    private Double saldo;
}
