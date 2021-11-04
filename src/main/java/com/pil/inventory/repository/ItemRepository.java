package com.pil.inventory.repository;

import com.pil.inventory.model.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemRepository extends GenericRepository<Item> {
    @Query(value = "SELECT i FROM Item i WHERE i.name LIKE %:name%")
    Page<Item> searchByName(Pageable pageable, @Param("name") String name);
}
