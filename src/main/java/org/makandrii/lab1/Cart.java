package org.makandrii.lab1;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> cart;

    protected Cart() {
        cart = new HashMap<>();
    }

    protected void add(Product product, Integer amount) {
        cart.merge(product, amount, Integer::sum);
    }
}
