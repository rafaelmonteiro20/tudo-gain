package com.tudogain.controller.assembler;

import org.springframework.stereotype.Component;

import com.tudogain.controller.form.OperacaoForm;
import com.tudogain.model.Estrategia;
import com.tudogain.model.Operacao;
import com.tudogain.service.EstrategiaService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OperacaoAssembler {

    private final EstrategiaService estrategiaService;

    public Operacao toEntity(OperacaoForm operacaoForm) {

        Operacao operacao = new Operacao();
        operacao.setAtivo(operacaoForm.getAtivo());
        operacao.setDataAbertura(operacaoForm.getDataAbertura());
        operacao.setDataFechamento(operacaoForm.getDataFechamento());
        operacao.setQuantidade(operacaoForm.getQuantidade());
        operacao.setPrecoCompra(operacaoForm.getPrecoCompra());
        operacao.setPrecoVenda(operacaoForm.getPrecoVenda());
        operacao.setTipoOperacao(operacaoForm.getTipoOperacao());
        operacao.setObservacao(operacaoForm.getObservacao());

        Estrategia estrategia = operacaoForm.getEstrategia();
        if (estrategia != null) {
            operacao.setEstrategia(estrategiaService.buscarPorId(estrategia.getId()));
        }

        return operacao;
    }

}
