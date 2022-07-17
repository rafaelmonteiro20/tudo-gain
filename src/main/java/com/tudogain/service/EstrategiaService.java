package com.tudogain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tudogain.exception.ResourceNotFoundException;
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

    public Estrategia buscarPorId(Long id) {
        return estrategiaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Estratégia não encontrada."));
    }

    @Transactional
    public Estrategia salvar(Estrategia estrategia) {
        return estrategiaRepository.save(estrategia);
    }

}
