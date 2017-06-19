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

public class ReviewOrderAdapter extends RecyclerView.Adapter<ReviewOrderAdapter.ViewHolder> {

    private List<Product> mProductList;

    public ReviewOrderAdapter(List<Product> productList) {
        mProductList = productList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        SimpleDraweeView sdvProductImage;
        TextView txtProductName;
        TextView txtProductMeasurement;
        TextView txtProductQuantity;
        TextView txtProductPrice;
        TextView txtProductTotalPrice;

        ViewHolder(View itemView) {
            super(itemView);
            sdvProductImage = (SimpleDraweeView) itemView.findViewById(R.id.product_image);
            txtProductName = (TextView)itemView.findViewById(R.id.product_name);
            txtProductMeasurement = (TextView)itemView.findViewById(R.id.product_measurement);
            txtProductQuantity = (TextView) itemView.findViewById(R.id.product_quantity);
            txtProductPrice = (TextView)itemView.findViewById(R.id.product_price);
            txtProductTotalPrice = (TextView) itemView.findViewById(R.id.product_total_price);
        }
    }

    @Override
    public ReviewOrderAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_review_items_ordered, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ReviewOrderAdapter.ViewHolder viewHolder, int position) {
        final Product product = mProductList.get(position);

        viewHolder.sdvProductImage.setImageURI(Uri.parse(product.getProductImage()));
        viewHolder.txtProductName.setText(product.getProductName());
        viewHolder.txtProductMeasurement.setText(product.getProductMeasurement());
        viewHolder.txtProductQuantity.setText(String.format("%d x ", product.getProductQuantity()));
        viewHolder.txtProductPrice.setText(product.getProductPrice());
        viewHolder.txtProductTotalPrice.setText(String.format("₱ %s", product.getProductTotalPrice()));
    }

    @Override
    public int getItemCount() {
        return null == mProductList ? 0 : mProductList.size();
    }
}