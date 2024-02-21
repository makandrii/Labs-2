package org.makandrii.lab1;

import java.util.*;

public class Cart implements Iterable<Map.Entry<Product, Integer>> {
    private Map<Product, Integer> cart;

    protected Cart() {
        cart = new HashMap<>();
    }

    protected void add(Product product, Integer amount) {
        cart.merge(product, amount, Integer::sum);
    }

    protected void remove(Product product, Integer amount) {
        Integer value = cart.get(product);
        if (value <= amount) {
            cart.put(product, 0);
        } else {
            cart.put(product, value - amount);
        }
    }

    protected int size() {
        return cart.size();
    }

    protected Optional<Product> findBy(String name) {
        return cart.keySet().stream().filter(product -> Objects.equals(product.getName(), name)).findFirst();
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
