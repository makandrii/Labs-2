package org.makandrii.lab1;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Product {
    private final String id;
    private final String name;
    private final double price;

    public Product(String name, double price) {
        id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
    }
}
