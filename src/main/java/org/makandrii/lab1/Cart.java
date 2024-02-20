package org.makandrii.lab1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Cart implements Iterable<Map.Entry<Product, Integer>> {
    private Map<Product, Integer> cart;

    protected Cart() {
        cart = new HashMap<>();
    }

    protected void add(Product product, Integer amount) {
        cart.merge(product, amount, Integer::sum);
    }

    protected Order makeOrder() {
        Order order = new Order(cart);
        cart = new HashMap<>();
        return order;
    }

    @Override
    public Iterator<Map.Entry<Product, Integer>> iterator() {
        return cart.entrySet().iterator();
    }
}
