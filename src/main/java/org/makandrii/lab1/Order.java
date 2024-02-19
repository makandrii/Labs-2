package org.makandrii.lab1;

import java.time.LocalDate;
import java.util.Map;

public class Order {
    private Map<Product, Integer> products;
    private double totalPrice;
    private LocalDate date;

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
