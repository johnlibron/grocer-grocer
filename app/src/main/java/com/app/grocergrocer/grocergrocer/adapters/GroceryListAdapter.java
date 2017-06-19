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
import com.app.grocergrocer.grocergrocer.models.GroceryList;
import com.app.grocergrocer.grocergrocer.ui.GroceryListItemActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class GroceryListAdapter extends RecyclerView.Adapter<GroceryListAdapter.ViewHolder> {

    private List<GroceryList> mGroceryList;

    public GroceryListAdapter(List<GroceryList> groceryList) {
        mGroceryList = groceryList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        SimpleDraweeView sdvListImage1;
        SimpleDraweeView sdvListImage2;
        SimpleDraweeView sdvListImage3;
        SimpleDraweeView sdvListImage4;
        TextView txtListName;
        TextView txtListDescription;
        TextView txtTotalProducts;

        ViewHolder(View itemView) {
            super(itemView);
            sdvListImage1 = (SimpleDraweeView) itemView.findViewById(R.id.list_image_1);
            sdvListImage2 = (SimpleDraweeView) itemView.findViewById(R.id.list_image_2);
            sdvListImage3 = (SimpleDraweeView) itemView.findViewById(R.id.list_image_3);
            sdvListImage4 = (SimpleDraweeView) itemView.findViewById(R.id.list_image_4);
            txtListName = (TextView) itemView.findViewById(R.id.list_name);
            txtListDescription = (TextView) itemView.findViewById(R.id.list_description);
            txtTotalProducts = (TextView) itemView.findViewById(R.id.total_products);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    int position = getAdapterPosition();
                    final GroceryList groceryList = mGroceryList.get(position);
                    Context context = v.getContext();
                    Intent intent = new Intent(context, GroceryListItemActivity.class);
                    intent.putExtra("listName", groceryList.getListName());
                    intent.putExtra("listDescription", groceryList.getListDescription());
                    intent.putExtra("totalProducts", groceryList.getTotalProducts());
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public GroceryListAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_grocery_list, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final GroceryListAdapter.ViewHolder viewHolder, int position) {
        final GroceryList groceryList = mGroceryList.get(position);

        viewHolder.txtListName.setText(groceryList.getListName());
        if (null != groceryList.getListDescription()) {
            viewHolder.txtListDescription.setText(groceryList.getListDescription());
        } else {
            viewHolder.txtListDescription.setText(R.string.grocery_list_default_description);
        }
        viewHolder.txtTotalProducts.setText(groceryList.getTotalProducts());
        viewHolder.sdvListImage1.setImageURI(Uri.parse(groceryList.getListImage1()));
        viewHolder.sdvListImage2.setImageURI(Uri.parse(groceryList.getListImage2()));
        viewHolder.sdvListImage3.setImageURI(Uri.parse(groceryList.getListImage3()));
        viewHolder.sdvListImage4.setImageURI(Uri.parse(groceryList.getListImage4()));
    }

    @Override
    public int getItemCount() {
        return null == mGroceryList ? 0 : mGroceryList.size();
    }
}