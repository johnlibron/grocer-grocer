package com.app.grocergrocer.grocergrocer.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.grocergrocer.grocergrocer.R;
import com.app.grocergrocer.grocergrocer.api.ExpandableRecyclerView.adapters.ExpandableRecyclerViewAdapter;
import com.app.grocergrocer.grocergrocer.models.Product;
import com.app.grocergrocer.grocergrocer.models.Order;
import com.app.grocergrocer.grocergrocer.api.ExpandableRecyclerView.viewholders.ProductViewHolder;
import com.app.grocergrocer.grocergrocer.api.ExpandableRecyclerView.viewholders.OrderViewHolder;
import com.app.grocergrocer.grocergrocer.api.ExpandableRecyclerView.models.ExpandableGroup;

import java.util.List;

public class OrderHistoryAdapter extends ExpandableRecyclerViewAdapter<OrderViewHolder, ProductViewHolder> {

    public OrderHistoryAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public OrderViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_order_history_header, parent, false);
        return new OrderViewHolder(view);
    }

    @Override
    public ProductViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_order_history_subheader, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(ProductViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final Product product = ((Order) group).getItems().get(childIndex);
        holder.setProductImage(product.getProductImage());
        holder.setProductName(product.getProductName());
    }

    @Override
    public void onBindGroupViewHolder(OrderViewHolder holder, int flatPosition, ExpandableGroup group) {
        holder.setOrder(group);
    }
}

