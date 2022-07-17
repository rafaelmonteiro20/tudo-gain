package com.tudogain.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tudogain.model.Estrategia;
import com.tudogain.service.EstrategiaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/estrategias")
public class EstrategiaController {

    private final EstrategiaService estrategiaService;

    @GetMapping
    public Page<Estrategia> pesquisar(@PageableDefault(sort = "descricao") Pageable pageable) {
        return estrategiaService.pesquisar(pageable);
    }

    @GetMapping("/{id}")
    public Estrategia buscarPorId(@PathVariable Long id) {
        return estrategiaService.buscarPorId(id);
    }

}
