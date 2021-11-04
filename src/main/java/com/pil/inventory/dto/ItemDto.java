package com.pil.inventory.dto;

import com.pil.inventory.model.Item;

import java.math.BigInteger;

public class ItemDto extends  DtoBase<Item>{
    private String name;
    private String image;
    private BigInteger stock = BigInteger.ZERO;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public BigInteger getStock() {
        return stock;
    }

    public void setStock(BigInteger stock) {
        this.stock = stock;
    }
}
