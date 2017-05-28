package com.app.grocergrocer.grocergrocer.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.app.grocergrocer.grocergrocer.R;
import com.facebook.drawee.view.SimpleDraweeView;

public class ExploreAdapter extends RecyclerView.Adapter<ExploreAdapter.ViewHolder> {

    private String[] productNames = {
            "Colgate Max Clean Smart Foam",
            "Eggs",
            "Coca-Cola Can",
            "Palmolive Naturals Soap Calming Pleasure",
            "Cornetto Classic Vanilla",
            "Piattos Cheese",
            "Eden Original",
            "Wilkins Pure Purified Water",
            "Cabbage",
            "Whole Chicken"
    };

    private String[] productMeasurements = {
            "1 box",
            "6 pcs.",
            "1 can",
            "1 box",
            "1 pc.",
            "1 pc.",
            "1 box",
            "1 gal.",
            "1 pc.",
            "1 pc."
    };

    private String[] productPrices = {
            "87.00",
            "50.00",
            "35.00",
            "23.00",
            "25.00",
            "28.00",
            "30.00",
            "69.00",
            "16.00",
            "398.00"
    };

    private String[] productImages = {
            "http://i.imgur.com/8lu1aR9.png",
            "http://i.imgur.com/ErQsnTA.png",
            "http://i.imgur.com/6AKLMix.png",
            "http://i.imgur.com/zFMnLNY.png",
            "http://i.imgur.com/3aInE2Y.png",
            "http://i.imgur.com/HKPro8L.png",
            "http://i.imgur.com/zb2ZZhN.png",
            "http://i.imgur.com/do90fSj.png",
            "http://i.imgur.com/i3JYPxQ.png",
            "http://i.imgur.com/ShVxwd2.png"
    };

    class ViewHolder extends RecyclerView.ViewHolder{

        SimpleDraweeView sdvProductImage;
        TextView txtProductName;
        TextView txtProductMeasurement;
        TextView txtProductPrice;
        Button btnAddToCart;

        ViewHolder(View itemView) {
            super(itemView);
            sdvProductImage = (SimpleDraweeView) itemView.findViewById(R.id.product_image);
            txtProductName = (TextView)itemView.findViewById(R.id.product_name);
            txtProductMeasurement = (TextView)itemView.findViewById(R.id.product_measurement);
            txtProductPrice = (TextView)itemView.findViewById(R.id.product_price);
            btnAddToCart = (Button) itemView.findViewById(R.id.button_add_to_cart);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_explore, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        Uri uri = Uri.parse(productImages[i]);
        viewHolder.sdvProductImage.setImageURI(uri);
        viewHolder.txtProductName.setText(productNames[i]);
        viewHolder.txtProductMeasurement.setText(productMeasurements[i]);
        viewHolder.txtProductPrice.setText("₱ " + productPrices[i]);
    }

    @Override
    public int getItemCount() {
        return productNames.length;
    }
}