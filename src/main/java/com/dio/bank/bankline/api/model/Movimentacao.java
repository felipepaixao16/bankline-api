package com.dio.bank.bankline.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "tab_movimentacao")
public class Movimentacao {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "data")
    private LocalDate data;

    @Column
    private LocalTime time;

    private String descricao;

    private Double valor;

    @Enumerated(EnumType.STRING) // Aqui informamos que vamos salvar o próprio valor literal, ou seja,  se houver
    // uma movimentação do tipo Receita, terá uma coluna do tipo "MovimentacaoTipo" e vai salvar Recita.
    private MovimentacaoTipo tipo;

    @Column(name = "id_conta")
    private Integer idConta;
}
