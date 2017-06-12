package com.app.grocergrocer.grocergrocer.adapters;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.grocergrocer.grocergrocer.R;
import com.app.grocergrocer.grocergrocer.models.DeliverySlot;

import java.util.List;

public class DeliveryTimeAdapter extends RecyclerView.Adapter<DeliveryTimeAdapter.ViewHolder> {

    private List<DeliverySlot> mDeliverySlotList;
    private int mSelectedItem = -1;

    public DeliveryTimeAdapter(List<DeliverySlot> deliverySlotList) {
        mDeliverySlotList = deliverySlotList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private View view;
        private TextView txtDeliverySlot;

        ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            txtDeliverySlot = (TextView)itemView.findViewById(R.id.delivery_slot);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    notifyItemChanged(mSelectedItem);
                    mSelectedItem = getAdapterPosition();
                    notifyItemChanged(mSelectedItem);
                }
            });
        }
    }

    @Override
    public DeliveryTimeAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_delivery_time, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final DeliveryTimeAdapter.ViewHolder viewHolder, int position) {
        final DeliverySlot deliverySlot = mDeliverySlotList.get(position);

        viewHolder.txtDeliverySlot.setText(deliverySlot.getSlot());
        if (position == mSelectedItem) {
            viewHolder.view.setBackgroundColor(Color.parseColor("#ff5252"));
            viewHolder.txtDeliverySlot.setTextColor(Color.WHITE);
        } else {
            viewHolder.view.setBackgroundColor(Color.WHITE);
            viewHolder.txtDeliverySlot.setTextColor(Color.parseColor("#212121"));
        }
    }

    @Override
    public int getItemCount() {
        return mDeliverySlotList == null ? 0 : mDeliverySlotList.size();
    }
}