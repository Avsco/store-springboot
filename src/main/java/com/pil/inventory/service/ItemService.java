package com.pil.inventory.service;

import com.pil.inventory.model.ModelBase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ItemService<E extends ModelBase> {
    Page<E> getByPage(Pageable pageable);

    Page<E> searchByPage(Pageable pageable, String name);

    Optional<E> getById(Long id);

    E create(E item);

    Optional<E> update(Long id, E item);

    Optional<E> delete(Long id);
}
