package org.makandrii.lab1;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> cart;

    protected Cart() {
        cart = new HashMap<>();
    }
}
