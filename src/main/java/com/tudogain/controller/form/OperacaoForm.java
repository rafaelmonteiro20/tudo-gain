package com.tudogain.controller.form;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.tudogain.model.Estrategia;
import com.tudogain.model.enumeration.TipoOperacao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OperacaoForm {

    @NotBlank
    private String ativo;

    @NotNull
    private LocalDateTime dataAbertura;

    @NotNull
    private LocalDateTime dataFechamento;

    @NotNull
    @Min(value = 1)
    private Integer quantidade;

    @NotNull
    private BigDecimal precoCompra;

    @NotNull
    private BigDecimal precoVenda;

    @NotNull
    private TipoOperacao tipoOperacao;

    private String observacao;

    private Estrategia estrategia;

}
