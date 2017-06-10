package com.app.grocergrocer.grocergrocer.models;

import com.app.grocergrocer.grocergrocer.api.ExpandableRecyclerView.models.ExpandableGroup;

import java.util.List;

public class Order extends ExpandableGroup<Product> {

    public Order(String orderName, String orderDate, List<Product> items) {
        super(orderName, orderDate, items);
    }
}