package com.app.grocergrocer.grocergrocer.adapters;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.grocergrocer.grocergrocer.R;
import com.app.grocergrocer.grocergrocer.models.Product;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class OrderDetailsAdapter extends RecyclerView.Adapter<OrderDetailsAdapter.ViewHolder> {

    private List<Product> mProductList;

    public OrderDetailsAdapter(List<Product> productList) {
        mProductList = productList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        SimpleDraweeView sdvProductImage;
        TextView txtProductName;
        TextView txtProductMeasurement;
        TextView txtProductQuantity;
        TextView txtProductPrice;

        ViewHolder(View itemView) {
            super(itemView);
            sdvProductImage = (SimpleDraweeView) itemView.findViewById(R.id.product_image);
            txtProductName = (TextView)itemView.findViewById(R.id.product_name);
            txtProductMeasurement = (TextView)itemView.findViewById(R.id.product_measurement);
            txtProductQuantity = (TextView) itemView.findViewById(R.id.product_quantity);
            txtProductPrice = (TextView)itemView.findViewById(R.id.product_price);
        }
    }

    @Override
    public OrderDetailsAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_order_details_items, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final OrderDetailsAdapter.ViewHolder viewHolder, int position) {
        final Product product = mProductList.get(position);

        viewHolder.sdvProductImage.setImageURI(Uri.parse(product.getProductImage()));
        viewHolder.txtProductName.setText(product.getProductName());
        viewHolder.txtProductMeasurement.setText(product.getProductMeasurement());
        viewHolder.txtProductQuantity.setText(String.format("x %d", product.getProductQuantity()));
        viewHolder.txtProductPrice.setText(String.format("₱ %s", product.getProductPrice()));
    }

    @Override
    public int getItemCount() {
        return null == mProductList ? 0 : mProductList.size();
    }
}