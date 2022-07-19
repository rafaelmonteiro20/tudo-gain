package com.tudogain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.tudogain.model.enumeration.TipoOperacao;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = Operacao.SEQ_OPERACAO, sequenceName = Operacao.SEQ_OPERACAO, allocationSize = 1)
public class Operacao implements Identifiable<Long> {

    public static final String SEQ_OPERACAO = "seq_operacao";

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_OPERACAO)
    private Long id;

    @NotBlank
    private String ativo;

    @NotNull
    private LocalDateTime dataAbertura;

    @NotNull
    private LocalDateTime dataFechamento;

    private int quantidade;

    @NotNull
    private BigDecimal precoCompra;

    @NotNull
    private BigDecimal precoVenda;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoOperacao tipoOperacao;

    @NotNull
    private BigDecimal resultado;

    @NotNull
    private BigDecimal resultadoPontos;

    private String observacao;

    @ManyToOne
    @JoinColumn(name = "id_estrategia")
    private Estrategia estrategia;

}
