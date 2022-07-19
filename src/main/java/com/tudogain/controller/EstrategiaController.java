package com.tudogain.controller;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tudogain.model.Estrategia;
import com.tudogain.service.EstrategiaService;
import com.tudogain.util.RequestUtils;

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

    @PostMapping
    public ResponseEntity<Object> salvar(@Valid @RequestBody Estrategia estrategia) {
        estrategia = estrategiaService.salvar(estrategia);
        return ResponseEntity.created(RequestUtils.location(estrategia)).build();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void editar(@PathVariable Long id, @Valid @RequestBody Estrategia estrategia) {
        Estrategia estrategiaSalva = estrategiaService.buscarPorId(id);
        estrategiaSalva.setDescricao(estrategia.getDescricao());
        estrategiaService.salvar(estrategiaSalva);
    }

}
