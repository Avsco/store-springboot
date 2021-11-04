package com.pil.inventory.repository;

import com.pil.inventory.model.ModelBase;
import org.springframework.data.jpa.repository.JpaRepository;

@SuppressWarnings("rawtypes")
public interface GenericRepository <T extends ModelBase> extends JpaRepository<T, Long> {
}
