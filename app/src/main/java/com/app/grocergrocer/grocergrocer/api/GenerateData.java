package com.app.grocergrocer.grocergrocer.api;

import com.app.grocergrocer.grocergrocer.models.Product;
import com.app.grocergrocer.grocergrocer.models.Order;

import java.util.Arrays;
import java.util.List;

public class GenerateData {

    public static List<Order> orders() {
        return Arrays.asList(makeOrder1(), makeOrder2(), makeOrder3(), makeOrder4(), makeOrder5(), makeOrder6(),
                makeOrder7(), makeOrder8(), makeOrder9(), makeOrder10(), makeOrder11(), makeOrder12());
    }

    private static Order makeOrder1() {
        return new Order("Order # 323786201", "Placed on January 01, 2016", makeProducts1());
    }

    private static Order makeOrder2() {
        return new Order("Order # 323786202", "Placed on February 02, 2016", makeProducts2());
    }

    private static Order makeOrder3() {
        return new Order("Order # 323786203", "Placed on March 03, 2016", makeProducts3());
    }

    private static Order makeOrder4() {
        return new Order("Order # 323786204", "Placed on April 04, 2016", makeProducts4());
    }

    private static Order makeOrder5() {
        return new Order("Order # 323786205", "Placed on May 05, 2016", makeProducts5());
    }

    private static Order makeOrder6() {
        return new Order("Order # 323786206", "Placed on June 06, 2016", makeProducts6());
    }

    private static Order makeOrder7() {
        return new Order("Order # 323786207", "Placed on July 07, 2016", makeProducts7());
    }

    private static Order makeOrder8() {
        return new Order("Order # 323786208", "Placed on August 08, 2016", makeProducts8());
    }

    private static Order makeOrder9() {
        return new Order("Order # 323786209", "Placed on September 09, 2016", makeProducts9());
    }

    private static Order makeOrder10() {
        return new Order("Order # 323786210", "Placed on October 10, 2016", makeProducts10());
    }

    private static Order makeOrder11() {
        return new Order("Order # 323786211", "Placed on November 11, 2016", makeProducts11());
    }

    private static Order makeOrder12() {
        return new Order("Order # 323786212", "Placed on December 12, 2016", makeProducts12());
    }

    private static List<Product> makeProducts1() {
        Product product1 = new Product("http://i.imgur.com/8lu1aR9.png", "Colgate Max Clean Smart Foam");

        return Arrays.asList(product1);
    }

    private static List<Product> makeProducts2() {
        Product product1 = new Product("http://i.imgur.com/8lu1aR9.png", "Colgate Max Clean Smart Foam");
        Product product2 = new Product("http://i.imgur.com/ErQsnTA.png", "Eggs");
        Product product3 = new Product("http://i.imgur.com/6AKLMix.png", "Coca-Cola Can");

        return Arrays.asList(product1, product2, product3);
    }

    private static List<Product> makeProducts3() {
        Product product1 = new Product("http://i.imgur.com/8lu1aR9.png", "Colgate Max Clean Smart Foam");
        Product product2 = new Product("http://i.imgur.com/ErQsnTA.png", "Eggs");
        Product product3 = new Product("http://i.imgur.com/6AKLMix.png", "Coca-Cola Can");
        Product product4 = new Product("http://i.imgur.com/zFMnLNY.png", "Palmolive Naturals Soap Calming Pleasure");
        Product product5 = new Product("http://i.imgur.com/3aInE2Y.png", "Cornetto Classic Vanilla");

        return Arrays.asList(product1, product2, product3, product4, product5);
    }

    private static List<Product> makeProducts4() {
        Product product1 = new Product("http://i.imgur.com/8lu1aR9.png", "Colgate Max Clean Smart Foam");
        Product product2 = new Product("http://i.imgur.com/ErQsnTA.png", "Eggs");
        Product product3 = new Product("http://i.imgur.com/6AKLMix.png", "Coca-Cola Can");
        Product product4 = new Product("http://i.imgur.com/zFMnLNY.png", "Palmolive Naturals Soap Calming Pleasure");
        Product product5 = new Product("http://i.imgur.com/3aInE2Y.png", "Cornetto Classic Vanilla");
        Product product6 = new Product("http://i.imgur.com/HKPro8L.png", "Piattos Cheese");
        Product product7 = new Product("http://i.imgur.com/zb2ZZhN.png", "Eden Original");

        return Arrays.asList(product1, product2, product3, product4, product5, product6, product7);
    }

    private static List<Product> makeProducts5() {
        Product product1 = new Product("http://i.imgur.com/8lu1aR9.png", "Colgate Max Clean Smart Foam");
        Product product2 = new Product("http://i.imgur.com/ErQsnTA.png", "Eggs");
        Product product3 = new Product("http://i.imgur.com/6AKLMix.png", "Coca-Cola Can");
        Product product4 = new Product("http://i.imgur.com/zFMnLNY.png", "Palmolive Naturals Soap Calming Pleasure");
        Product product5 = new Product("http://i.imgur.com/3aInE2Y.png", "Cornetto Classic Vanilla");
        Product product6 = new Product("http://i.imgur.com/HKPro8L.png", "Piattos Cheese");
        Product product7 = new Product("http://i.imgur.com/zb2ZZhN.png", "Eden Original");
        Product product8 = new Product("http://i.imgur.com/do90fSj.png", "Wilkins Pure Purified Water");
        Product product9 = new Product("http://i.imgur.com/i3JYPxQ.png", "Cabbage");

        return Arrays.asList(product1, product2, product3, product4, product5, product6, product7, product8, product9);
    }

    private static List<Product> makeProducts6() {
        Product product10 = new Product("http://i.imgur.com/ShVxwd2.png", "Whole Chicken");

        return Arrays.asList(product10);
    }


    private static List<Product> makeProducts7() {
        Product product8 = new Product("http://i.imgur.com/do90fSj.png", "Wilkins Pure Purified Water");
        Product product9 = new Product("http://i.imgur.com/i3JYPxQ.png", "Cabbage");
        Product product10 = new Product("http://i.imgur.com/ShVxwd2.png", "Whole Chicken");

        return Arrays.asList(product8, product9, product10);
    }

    private static List<Product> makeProducts8() {
        Product product6 = new Product("http://i.imgur.com/HKPro8L.png", "Piattos Cheese");
        Product product7 = new Product("http://i.imgur.com/zb2ZZhN.png", "Eden Original");
        Product product8 = new Product("http://i.imgur.com/do90fSj.png", "Wilkins Pure Purified Water");
        Product product9 = new Product("http://i.imgur.com/i3JYPxQ.png", "Cabbage");
        Product product10 = new Product("http://i.imgur.com/ShVxwd2.png", "Whole Chicken");

        return Arrays.asList(product6, product7, product8, product9, product10);
    }

    private static List<Product> makeProducts9() {
        Product product4 = new Product("http://i.imgur.com/zFMnLNY.png", "Palmolive Naturals Soap Calming Pleasure");
        Product product5 = new Product("http://i.imgur.com/3aInE2Y.png", "Cornetto Classic Vanilla");
        Product product6 = new Product("http://i.imgur.com/HKPro8L.png", "Piattos Cheese");
        Product product7 = new Product("http://i.imgur.com/zb2ZZhN.png", "Eden Original");
        Product product8 = new Product("http://i.imgur.com/do90fSj.png", "Wilkins Pure Purified Water");
        Product product9 = new Product("http://i.imgur.com/i3JYPxQ.png", "Cabbage");
        Product product10 = new Product("http://i.imgur.com/ShVxwd2.png", "Whole Chicken");

        return Arrays.asList(product4, product5, product6, product7, product8, product9, product10);
    }

    private static List<Product> makeProducts10() {
        Product product2 = new Product("http://i.imgur.com/ErQsnTA.png", "Eggs");
        Product product3 = new Product("http://i.imgur.com/6AKLMix.png", "Coca-Cola Can");
        Product product4 = new Product("http://i.imgur.com/zFMnLNY.png", "Palmolive Naturals Soap Calming Pleasure");
        Product product5 = new Product("http://i.imgur.com/3aInE2Y.png", "Cornetto Classic Vanilla");
        Product product6 = new Product("http://i.imgur.com/HKPro8L.png", "Piattos Cheese");
        Product product7 = new Product("http://i.imgur.com/zb2ZZhN.png", "Eden Original");
        Product product8 = new Product("http://i.imgur.com/do90fSj.png", "Wilkins Pure Purified Water");
        Product product9 = new Product("http://i.imgur.com/i3JYPxQ.png", "Cabbage");
        Product product10 = new Product("http://i.imgur.com/ShVxwd2.png", "Whole Chicken");

        return Arrays.asList(product2, product3, product4, product5, product6, product7, product8, product9, product10);
    }

    private static List<Product> makeProducts11() {
        Product product3 = new Product("http://i.imgur.com/6AKLMix.png", "Coca-Cola Can");
        Product product4 = new Product("http://i.imgur.com/zFMnLNY.png", "Palmolive Naturals Soap Calming Pleasure");
        Product product5 = new Product("http://i.imgur.com/3aInE2Y.png", "Cornetto Classic Vanilla");
        Product product8 = new Product("http://i.imgur.com/do90fSj.png", "Wilkins Pure Purified Water");
        Product product10 = new Product("http://i.imgur.com/ShVxwd2.png", "Whole Chicken");

        return Arrays.asList(product3, product4, product5, product8, product10);
    }

    private static List<Product> makeProducts12() {
        Product product1 = new Product("http://i.imgur.com/8lu1aR9.png", "Colgate Max Clean Smart Foam");
        Product product6 = new Product("http://i.imgur.com/HKPro8L.png", "Piattos Cheese");
        Product product9 = new Product("http://i.imgur.com/i3JYPxQ.png", "Cabbage");

        return Arrays.asList(product1, product6, product9);
    }
}