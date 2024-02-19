package org.makandrii.lab1;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Product {
    private String id;
    private String name;
    private double price;

    public Product(String name, double price) {
        id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
    }
}
