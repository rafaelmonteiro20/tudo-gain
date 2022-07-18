package com.tudogain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = Estrategia.SEQ_ESTRATEGIA, sequenceName = Estrategia.SEQ_ESTRATEGIA, allocationSize = 1)
public class Estrategia implements Identifiable<Long> {

    public static final String SEQ_ESTRATEGIA = "seq_estrategia";

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_ESTRATEGIA)
    private Long id;

    @NotBlank
    private String descricao;

}
