package com.tudogain.service;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tudogain.exception.ResourceNotFoundException;
import com.tudogain.model.Operacao;
import com.tudogain.repository.OperacaoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OperacaoService {

    private final OperacaoRepository operacaoRepository;

    public Page<Operacao> pesquisar(Pageable pageable) {
        return operacaoRepository.findAll(pageable);
    }

    public Operacao buscarPorId(Long id) {
        return operacaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Operação não encontrada."));
    }

    @Transactional
    public Operacao salvar(Operacao operacao) {
        // TODO: Calcular resultado.
        operacao.setResultado(BigDecimal.ZERO);
        operacao.setResultadoPontos(BigDecimal.ZERO);
        return operacaoRepository.save(operacao);
    }

}
