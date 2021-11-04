package com.pil.inventory.controller;

import com.pil.inventory.dto.ItemDto;
import com.pil.inventory.model.Item;
import com.pil.inventory.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ItemController {
    @Autowired
    protected ModelMapper modelMapper;

    private ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    @GetMapping
    Page<ItemDto> getItemsByPage(Pageable pageable) {
        Page<Item> itemPage = this.service.getByPage(pageable);
        Page<ItemDto> itemDtoPage = itemPage.map(item -> modelMapper.map(item, ItemDto.class));
        return itemDtoPage;
    }

    @GetMapping("/search")
    Page<ItemDto> getItemsBySearchNameAndPage(Pageable pageable, @RequestParam String name) {
        Page<Item> itemPage = this.service.searchByPage(pageable, name);
        Page<ItemDto> itemDtoPage = itemPage.map(item -> modelMapper.map(item, ItemDto.class));
        return itemDtoPage;
    }

    @GetMapping("/{id}")
    Optional<ItemDto> getItemById(@PathVariable("id") Long id) {
        return Optional.of(modelMapper.map(this.service.getById(id).get(), ItemDto.class));
    }

    @PostMapping
    Item createItem(@RequestBody ItemDto itemDto) {
        return (Item) this.service.create(modelMapper.map(itemDto, Item.class));
    }

    @PutMapping("/{id}")
    Optional<Item> UpdateItem(@RequestBody ItemDto itemDto, @PathVariable("id") Long id) {
        return this.service.update(id, modelMapper.map(itemDto, Item.class));
    }

    @DeleteMapping("/{id}")
    Optional<Item> UpdateItem(@PathVariable("id") Long id) {
        return this.service.delete(id);
    }
}
