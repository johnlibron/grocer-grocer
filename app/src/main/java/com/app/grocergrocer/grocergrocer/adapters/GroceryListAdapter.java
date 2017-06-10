package com.app.grocergrocer.grocergrocer.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.grocergrocer.grocergrocer.R;
import com.app.grocergrocer.grocergrocer.ui.GroceryListItemActivity;
import com.facebook.drawee.view.SimpleDraweeView;

public class GroceryListAdapter extends RecyclerView.Adapter<GroceryListAdapter.ViewHolder> {

    private String[] groceryListNames = {
            "My List 1",
            "My List 2",
            "My List 3",
            "My List 4",
            "My List 5",
            "My List 6",
            "My List 7",
            "My List 8",
            "My List 9",
            "My List 10",
    };

    private String[] groceryListImages = {
            "http://i.imgur.com/8lu1aR9.png",
            "http://i.imgur.com/ErQsnTA.png",
            "http://i.imgur.com/6AKLMix.png",
            "http://i.imgur.com/zFMnLNY.png"
    };

    class ViewHolder extends RecyclerView.ViewHolder{

        SimpleDraweeView sdvListImage1;
        SimpleDraweeView sdvListImage2;
        SimpleDraweeView sdvListImage3;
        SimpleDraweeView sdvListImage4;
        TextView txtListName;
        TextView txtListDescription;
        TextView txtTotalProducts;

        ViewHolder(View itemView) {
            super(itemView);
            sdvListImage1 = (SimpleDraweeView)itemView.findViewById(R.id.list_image_1);
            sdvListImage2 = (SimpleDraweeView)itemView.findViewById(R.id.list_image_2);
            sdvListImage3 = (SimpleDraweeView)itemView.findViewById(R.id.list_image_3);
            sdvListImage4 = (SimpleDraweeView)itemView.findViewById(R.id.list_image_4);
            txtListName = (TextView)itemView.findViewById(R.id.list_name);
            txtListDescription = (TextView)itemView.findViewById(R.id.list_description);
            txtTotalProducts = (TextView)itemView.findViewById(R.id.total_products);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    int position = getAdapterPosition();
                    Context context = v.getContext();
                    Intent intent = new Intent(context, GroceryListItemActivity.class);
                    intent.putExtra("listName", groceryListNames[position]);
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public GroceryListAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_grocery_list, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final GroceryListAdapter.ViewHolder viewHolder, int i) {
        viewHolder.sdvListImage1.setImageURI(Uri.parse(groceryListImages[0]));
        viewHolder.sdvListImage2.setImageURI(Uri.parse(groceryListImages[1]));
        viewHolder.sdvListImage3.setImageURI(Uri.parse(groceryListImages[2]));
        viewHolder.sdvListImage4.setImageURI(Uri.parse(groceryListImages[3]));
        viewHolder.txtListName.setText(groceryListNames[i]);
        viewHolder.txtListDescription.setText(R.string.grocery_list_default_description);
        viewHolder.txtTotalProducts.setText("5 products");
    }

    @Override
    public int getItemCount() {
        return groceryListNames.length;
    }
}