package com.app.grocergrocer.grocergrocer.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.app.grocergrocer.grocergrocer.R;
import com.app.grocergrocer.grocergrocer.models.Product;
import com.app.grocergrocer.grocergrocer.ui.ProductActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class ShoppingCartAdapter extends RecyclerView.Adapter<ShoppingCartAdapter.ViewHolder> {

    private List<Product> mProductList;

    public ShoppingCartAdapter(List<Product> productList) {
        mProductList = productList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

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

            sdvProductImage.setOnClickListener(this);
            txtProductName.setOnClickListener(this);
            txtProductMeasurement.setOnClickListener(this);
            txtProductPrice.setOnClickListener(this);
            txtProductOriginalPrice.setOnClickListener(this);
            txtProductLessPrice.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.product_image:
                case R.id.product_name:
                case R.id.product_measurement:
                case R.id.product_price:
                case R.id.product_original_price:
                case R.id.product_less_price:
                    int position = getAdapterPosition();
                    final Product product = mProductList.get(position);
                    Context context = v.getContext();
                    Intent intent = new Intent(context, ProductActivity.class);
                    intent.putExtra("productImage", product.getProductImage());
                    intent.putExtra("productName", product.getProductName());
                    intent.putExtra("productMeasurement", product.getProductMeasurement());
                    intent.putExtra("productPrice", product.getProductPrice());
                    intent.putExtra("productOriginalPrice", product.getProductOriginalPrice());
                    intent.putExtra("productLessPrice", product.getProductLessPrice());
                    context.startActivity(intent);
                    break;
            }
        }
    }

    @Override
    public ShoppingCartAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_shopping_cart, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ShoppingCartAdapter.ViewHolder viewHolder, int position) {
        final Product product = mProductList.get(position);

        Uri uri = Uri.parse(product.getProductImage());
        viewHolder.sdvProductImage.setImageURI(uri);
        viewHolder.txtProductName.setText(product.getProductName());
        viewHolder.txtProductMeasurement.setText(product.getProductMeasurement());
        viewHolder.txtProductPrice.setText(product.getProductPrice());

        if (null != product.getProductOriginalPrice() && null != product.getProductLessPrice()) {
            viewHolder.txtProductOriginalPrice.setText(product.getProductOriginalPrice());
            viewHolder.txtProductLessPrice.setText(product.getProductLessPrice());
            viewHolder.txtProductOriginalPrice.setPadding( 0, 0, 0, 10);
            viewHolder.txtProductLessPrice.setPadding( 0, 0, 0, 10);
        } else {
            viewHolder.txtProductPrice.setPadding( 0, 0, 0, 10);
            viewHolder.txtProductOriginalPrice.setVisibility(View.GONE);
            viewHolder.txtProductLessPrice.setVisibility(View.GONE);
        }

        viewHolder.btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                int productQuantity = product.getProductQuantity();
                if (productQuantity < 10) {
                    productQuantity += 1;
                    product.setProductQuantity(productQuantity);
                    viewHolder.txtProductQuantity.setText(String.valueOf(productQuantity));
                }
            }
        });

        viewHolder.btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                int productQuantity = product.getProductQuantity();
                if (productQuantity > 0) {
                    productQuantity -= 1;
                    product.setProductQuantity(productQuantity);
                    viewHolder.txtProductQuantity.setText(String.valueOf(productQuantity));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return null == mProductList ? 0 : mProductList.size();
    }
}