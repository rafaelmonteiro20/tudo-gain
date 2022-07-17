package com.tudogain.util;

import java.io.Serializable;
import java.net.URI;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tudogain.model.Identifiable;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RequestUtils {

    public static <T extends Serializable> URI locationById(T id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    public static <T extends Serializable> URI location(Identifiable<T> entity) {
        return locationById(entity.getId());
    }

}
