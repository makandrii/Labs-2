package org.makandrii.lab1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Spliterator;

public class Cart implements Iterable<Map.Entry<Product, Integer>> {
    private final Map<Product, Integer> cart;

    protected Cart() {
        cart = new HashMap<>();
    }

    protected void add(Product product, Integer amount) {
        cart.merge(product, amount, Integer::sum);
    }

    protected Order makeOrder() {
        return new Order(cart);
    }

    @Override
    public Iterator<Map.Entry<Product, Integer>> iterator() {
        return cart.entrySet().iterator();
    }

    @Override
    public Spliterator<Map.Entry<Product, Integer>> spliterator() {
        return cart.entrySet().spliterator();
    }
}
