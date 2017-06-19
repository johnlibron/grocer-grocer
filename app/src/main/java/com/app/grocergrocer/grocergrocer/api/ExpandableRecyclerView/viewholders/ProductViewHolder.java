package com.app.grocergrocer.grocergrocer.api.ExpandableRecyclerView.viewholders;

import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import com.app.grocergrocer.grocergrocer.R;
import com.facebook.drawee.view.SimpleDraweeView;

public class ProductViewHolder extends ChildViewHolder {

    private SimpleDraweeView sdvProductImage;
    private TextView txtProductName;

    public ProductViewHolder(View itemView) {
        super(itemView);
        sdvProductImage = (SimpleDraweeView) itemView.findViewById(R.id.list_item_product_image);
        txtProductName = (TextView) itemView.findViewById(R.id.list_item_product_name);
    }

    public void setProductImage(String image) {
        Uri uri = Uri.parse(image);
        sdvProductImage.setImageURI(uri);
    }

    public void setProductName(String name) {
        txtProductName.setText(name);
    }
}
