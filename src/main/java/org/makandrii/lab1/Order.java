package org.makandrii.lab1;

import java.time.LocalDate;
import java.util.Map;

public class Order {
    private final Map<Product, Integer> products;
    private final double totalPrice;
    private final LocalDate date;

    public Order(Map<Product, Integer> products) {
        this.products = products;
        this.totalPrice = calculateTotalPrice();
        this.date = LocalDate.now();
    }

    private double calculateTotalPrice() {
        return products.entrySet().stream().reduce(0.0, (sum, entry) ->
                sum + entry.getKey().getPrice() * entry.getValue(), Double::sum);
    }
}
