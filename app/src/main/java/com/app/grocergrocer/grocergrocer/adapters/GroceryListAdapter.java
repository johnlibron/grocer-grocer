package com.app.grocergrocer.grocergrocer.adapters;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.app.grocergrocer.grocergrocer.R;
import com.app.grocergrocer.grocergrocer.models.Product;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class GroceryListAdapter extends RecyclerView.Adapter<GroceryListAdapter.ViewHolder> {

    private List<Product> mProductList;

    public GroceryListAdapter(List<Product> productList) {
        mProductList = productList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        SimpleDraweeView sdvProductImage;
        TextView txtProductName;
        TextView txtProductMeasurement;
        TextView txtProductPrice;
        TextView txtProductOriginalPrice;
        TextView txtProductLessPrice;
        TextView txtProductQuantity;
        ImageButton btnPlus;
        ImageButton btnMinus;

        ViewHolder(View itemView) {
            super(itemView);
            sdvProductImage = (SimpleDraweeView) itemView.findViewById(R.id.product_image);
            txtProductName = (TextView)itemView.findViewById(R.id.product_name);
            txtProductMeasurement = (TextView)itemView.findViewById(R.id.product_measurement);
            txtProductPrice = (TextView)itemView.findViewById(R.id.product_price);
            txtProductOriginalPrice = (TextView)itemView.findViewById(R.id.product_original_price);
            txtProductLessPrice = (TextView)itemView.findViewById(R.id.product_less_price);
            txtProductQuantity = (TextView)itemView.findViewById(R.id.product_quantity);
            btnPlus = (ImageButton) itemView.findViewById(R.id.btn_plus);
            btnMinus = (ImageButton) itemView.findViewById(R.id.btn_minus);
        }
    }

    @Override
    public GroceryListAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_explore, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final GroceryListAdapter.ViewHolder viewHolder, int position) {
        final Product product = mProductList.get(position);

        Uri uri = Uri.parse(product.getProductImage());
        viewHolder.sdvProductImage.setImageURI(uri);
        viewHolder.txtProductName.setText(product.getProductName());
        viewHolder.txtProductMeasurement.setText(product.getProductMeasurement());
        viewHolder.txtProductPrice.setText(product.getProductPrice());

        if (null != product.getProductOriginalPrice() && null != product.getProductLessPrice()) {
            viewHolder.txtProductOriginalPrice.setText(product.getProductOriginalPrice());
            viewHolder.txtProductLessPrice.setText(product.getProductLessPrice());
        } else {
            viewHolder.txtProductOriginalPrice.setVisibility(View.GONE);
            viewHolder.txtProductLessPrice.setVisibility(View.GONE);
        }

        viewHolder.btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                int value = Integer.parseInt(viewHolder.txtProductQuantity.getText().toString());
                viewHolder.txtProductQuantity.setText(String.valueOf(value + 1));
            }
        });

        viewHolder.btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                int value = Integer.parseInt(viewHolder.txtProductQuantity.getText().toString());
                if (value > 0) {
                    viewHolder.txtProductQuantity.setText(String.valueOf(value - 1));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return null == mProductList ? 0 : mProductList.size();
    }
}