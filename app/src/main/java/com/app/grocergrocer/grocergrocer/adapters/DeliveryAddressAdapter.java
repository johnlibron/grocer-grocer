package com.app.grocergrocer.grocergrocer.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.app.grocergrocer.grocergrocer.R;
import com.app.grocergrocer.grocergrocer.models.DeliveryAddress;

import java.util.List;

public class DeliveryAddressAdapter extends RecyclerView.Adapter<DeliveryAddressAdapter.ViewHolder> {

    private List<DeliveryAddress> mDeliveryAddressList;
    private int mSelectedItem = -1;

    public DeliveryAddressAdapter(List<DeliveryAddress> deliveryAddressList) {
        mDeliveryAddressList = deliveryAddressList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        RadioButton rbDeliveryAddress;
        TextView txtName;
        TextView txtCompleteAddress;
        TextView txtProvince;
        TextView txtCity;
        TextView txtBarangay;
        TextView txtMobileNo;
        TextView txtAddressSpecificInstructions;

        ViewHolder(View itemView) {
            super(itemView);
            rbDeliveryAddress = (RadioButton)itemView.findViewById(R.id.radio_delivery_address);
            txtName = (TextView)itemView.findViewById(R.id.text_name);
            txtCompleteAddress = (TextView)itemView.findViewById(R.id.text_complete_address);
            txtProvince = (TextView)itemView.findViewById(R.id.text_province);
            txtCity = (TextView) itemView.findViewById(R.id.text_city);
            txtBarangay = (TextView)itemView.findViewById(R.id.text_barangay);
            txtMobileNo = (TextView)itemView.findViewById(R.id.text_mobile_no);
            txtAddressSpecificInstructions = (TextView) itemView.findViewById(R.id.text_address_specific_instructions);

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
    public DeliveryAddressAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_delivery_address, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final DeliveryAddressAdapter.ViewHolder viewHolder, int position) {
        final DeliveryAddress deliveryAddress = mDeliveryAddressList.get(position);

        viewHolder.txtName.setText(deliveryAddress.getName());
        viewHolder.txtCompleteAddress.setText(deliveryAddress.getCompleteAddress());
        viewHolder.txtProvince.setText(deliveryAddress.getProvince());
        viewHolder.txtCity.setText(deliveryAddress.getCity());
        viewHolder.txtBarangay.setText(deliveryAddress.getBarangay());
        viewHolder.txtMobileNo.setText(deliveryAddress.getMobileNo());
        viewHolder.txtAddressSpecificInstructions.setText(deliveryAddress.getAddressSpecificInstructions());
        if (position == mSelectedItem) {
            viewHolder.rbDeliveryAddress.setChecked(true);
        } else {
            viewHolder.rbDeliveryAddress.setChecked(false);
        }
    }

    @Override
    public int getItemCount() {
        return null == mDeliveryAddressList ? 0 : mDeliveryAddressList.size();
    }
}