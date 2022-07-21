package com.tudogain.controller;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tudogain.controller.assembler.OperacaoAssembler;
import com.tudogain.controller.form.OperacaoForm;
import com.tudogain.model.Operacao;
import com.tudogain.service.OperacaoService;
import com.tudogain.util.RequestUtils;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/operacoes")
public class OperacaoController {

    private final OperacaoService operacaoService;
    private final OperacaoAssembler operacaoAssembler;

    @GetMapping
    public Page<Operacao> pesquisar(@PageableDefault(sort = "dataAbertura", direction = Direction.DESC) Pageable pageable) {
        return operacaoService.pesquisar(pageable);
    }

    @GetMapping("/{id}")
    public Operacao buscarPorId(@PathVariable Long id) {
        return operacaoService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<Object> salvar(@Valid @RequestBody OperacaoForm operacaoForm) {
        Operacao operacao = operacaoAssembler.toEntity(operacaoForm);
        operacao = operacaoService.salvar(operacao);
        return ResponseEntity.created(RequestUtils.location(operacao)).build();
    }

}
