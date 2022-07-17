package com.tudogain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tudogain.model.Estrategia;
import com.tudogain.repository.EstrategiaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EstrategiaService {

    private final EstrategiaRepository estrategiaRepository;

    public Page<Estrategia> pesquisar(Pageable pageable) {
        return estrategiaRepository.findAll(pageable);
    }

}
