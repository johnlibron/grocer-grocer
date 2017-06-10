package com.app.grocergrocer.grocergrocer.api;

import com.app.grocergrocer.grocergrocer.models.Product;
import com.app.grocergrocer.grocergrocer.models.Order;

import java.util.Arrays;
import java.util.List;

public class GenerateData {

    public static List<Order> makeOrders() {
        return Arrays.asList(makeGadgetOrder(),
                makeGadgetOrder(),
                makeGadgetOrder(),
                makeGadgetOrder(),
                makeGadgetOrder());
    }

    private static Order makeGadgetOrder() {
        return new Order("Order # 323786236", "Placed on September 25, 2016", makeGadgetProducts());
    }

    private static List<Product> makeGadgetProducts() {
        Product product1 = new Product("http://i.imgur.com/6AKLMix.png", "Palmolive Naturals Soap Calming Pleasure");
        Product product2 = new Product("http://i.imgur.com/6AKLMix.png", "Coca-Cola Can");
        Product product3 = new Product("http://i.imgur.com/6AKLMix.png", "Wilkins Pure Purified Water");
        Product product4 = new Product("http://i.imgur.com/6AKLMix.png", "Colgate Max Clean Smart Foam");

        return Arrays.asList(product1, product2, product3, product4);
    }
}