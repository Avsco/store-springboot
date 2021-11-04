package com.pil.inventory.service;

import com.pil.inventory.model.Item;
import com.pil.inventory.repository.ItemRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemServiceImp implements ItemService<Item> {
    private ItemRepository repository;

    public ItemServiceImp(ItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<Item> getByPage(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    @Override
    public Page<Item> searchByPage(Pageable pageable, String name) {
        return this.repository.searchByName(pageable, name);
    }

    @Override
    public Optional<Item> getById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public Item create(Item item) {
        return this.repository.save(item);
    }

    @Override
    public Optional<Item> update(Long id, Item item) {
        Optional<Item> update = this.repository.findById(id);
        if (update.isPresent()){
            update.get().setName(item.getName());
            update.get().setStock(item.getStock());
            update.get().setImage(item.getImage());
            this.repository.save(update.get());
        }
        return update;
    }

    @Override
    public Optional<Item> delete(Long id) {
        Optional<Item> deleted = this.repository.findById(id);
        if(deleted.isPresent()){
            this.repository.delete(deleted.get());
        }
        return deleted;

    }
}
