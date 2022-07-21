package com.tudogain.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tudogain.model.Operacao;
import com.tudogain.service.OperacaoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/operacoes")
public class OperacaoController {

    private final OperacaoService operacaoService;

    @GetMapping
    public Page<Operacao> pesquisar(@PageableDefault(sort = "dataAbertura",
        direction = Direction.DESC) Pageable pageable) {
        return operacaoService.pesquisar(pageable);
    }

    @GetMapping("/{id}")
    public Operacao buscarPorId(@PathVariable Long id) {
        return operacaoService.buscarPorId(id);
    }

}
