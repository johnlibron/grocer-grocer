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
import com.app.grocergrocer.grocergrocer.models.Category;
import com.app.grocergrocer.grocergrocer.ui.CategoryActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {

    private List<Category> mCategoryList;

    public CategoriesAdapter(List<Category> categoryList) {
        mCategoryList = categoryList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

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
                    intent.putExtra("categoryName", mCategoryList.get(position).getCategoryName());
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public CategoriesAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_categories, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CategoriesAdapter.ViewHolder viewHolder, int position) {
        final Category category = mCategoryList.get(position);

        Uri uri = Uri.parse(category.getCategoryImage());
        viewHolder.sdvCategoryImage.setImageURI(uri);
        viewHolder.txtCategoryName.setText(category.getCategoryName());
    }

    @Override
    public int getItemCount() {
        return null == mCategoryList ? 0 : mCategoryList.size();
    }
}