package com.pil.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigInteger;

@Entity
public class Item extends ModelBase {
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
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