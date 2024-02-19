package org.makandrii.lab1;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Product {
    private final String id;
    private final String name;
    private final Category category;
    private final double price;

    public Product(String name, Category category, double price) {
        id = UUID.randomUUID().toString();
        this.name = name;
        this.category = category;
        this.price = price;
    }
}
