package com.dio.bank.bankline.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tab_correntista") // Dizemos ao JPA que os registros dessa classe será salvo na tabela de no tab_correntista
public class Correntista {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 20)
    private String cpf;

    @Column(length = 60)
    private String nome;

    @Embedded // Essa anotação informa que as informações que estiverem na classe Conta vai estar
              // na mesma tabela da classe Correntista
    private Conta conta;
}
