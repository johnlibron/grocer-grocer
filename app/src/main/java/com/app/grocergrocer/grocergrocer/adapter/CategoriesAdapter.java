package com.app.grocergrocer.grocergrocer.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.grocergrocer.grocergrocer.R;
import com.app.grocergrocer.grocergrocer.ui.CategoryActivity;
import com.facebook.drawee.view.SimpleDraweeView;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {

    private String[] categoryNames = {
            "Toothpaste",
            "Eggs",
            "Drinks",
            "Soap",
            "Ice cream",
            "Junk foods",
            "Cheese",
            "Water",
            "Vegetables",
            "Meat"
    };

    private String[] categoryImages = {
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

        SimpleDraweeView sdvCategoryImage;
        TextView txtCategoryName;

        ViewHolder(View itemView) {
            super(itemView);
            sdvCategoryImage = (SimpleDraweeView) itemView.findViewById(R.id.category_image);
            txtCategoryName = (TextView)itemView.findViewById(R.id.category_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    int position = getAdapterPosition();
                    Context context = v.getContext();
                    Intent intent = new Intent(context, CategoryActivity.class);
                    intent.putExtra("categoryName", categoryNames[position]);
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public CategoriesAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_categories, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CategoriesAdapter.ViewHolder viewHolder, int i) {
        Uri uri = Uri.parse(categoryImages[i]);
        viewHolder.sdvCategoryImage.setImageURI(uri);
        viewHolder.txtCategoryName.setText(categoryNames[i]);
    }

    @Override
    public int getItemCount() {
        return categoryNames.length;
    }
}