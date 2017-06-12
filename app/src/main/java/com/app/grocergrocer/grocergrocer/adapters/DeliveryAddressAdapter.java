package com.app.grocergrocer.grocergrocer.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.app.grocergrocer.grocergrocer.R;

public class DeliveryAddressAdapter extends RecyclerView.Adapter<DeliveryAddressAdapter.ViewHolder> {

    private String[] names = {
            "John James Libron",
            "Julrecha Lumambas",
            "Virgil John Lomocso",
            "Maria Reynalen Quijada",
            "Artis Bulawit",
            "Michael Libosada",
            "John Paul Ybanez",
            "Daniel Jared Yap",
            "Vin Venture",
            "Cett Ashweather"
    };

    private String[] completeAddress = {
            "Corazon Vill. 2, San Isidro Talisay City, Cebu",
            "Corazon Vill. 2, San Isidro Talisay City, Cebu",
            "Corazon Vill. 2, San Isidro Talisay City, Cebu",
            "Corazon Vill. 2, San Isidro Talisay City, Cebu",
            "Corazon Vill. 2, San Isidro Talisay City, Cebu",
            "Corazon Vill. 2, San Isidro Talisay City, Cebu",
            "Corazon Vill. 2, San Isidro Talisay City, Cebu",
            "Corazon Vill. 2, San Isidro Talisay City, Cebu",
            "Corazon Vill. 2, San Isidro Talisay City, Cebu",
            "Corazon Vill. 2, San Isidro Talisay City, Cebu"
    };

    private String[] provinces = {
            "Cebu",
            "Cebu",
            "Cebu",
            "Cebu",
            "Cebu",
            "Cebu",
            "Cebu",
            "Cebu",
            "Cebu",
            "Cebu"
    };

    private String[] city_municipality = {
            "Talisay City",
            "Cebu City",
            "Talisay City",
            "Cebu City",
            "Talisay City",
            "Cebu City",
            "Talisay City",
            "Cebu City",
            "Talisay City",
            "Cebu City"
    };

    private String[] barangay = {
            "San Isidro",
            "San Isidro",
            "San Isidro",
            "San Isidro",
            "San Isidro",
            "San Isidro",
            "San Isidro",
            "San Isidro",
            "San Isidro",
            "San Isidro"
    };

    private String[] mobileNo = {
            "0923127129",
            "0923127129",
            "0923127129",
            "0923127129",
            "0923127129",
            "0923127129",
            "0923127129",
            "0923127129",
            "0923127129",
            "0923127129"
    };

    private String[] addressSpecificInstructions = {
            "Call this number when you arrived.",
            "Call this number when you arrived.",
            "Call this number when you arrived.",
            "Call this number when you arrived.",
            "Call this number when you arrived.",
            "Call this number when you arrived.",
            "Call this number when you arrived.",
            "Call this number when you arrived.",
            "Call this number when you arrived.",
            "Call this number when you arrived."
    };

    private int mSelectedItem = 1;

    class ViewHolder extends RecyclerView.ViewHolder{

        RadioButton rbBillngAddress;
        TextView txtName;
        TextView txtCompleteAddress;
        TextView txtProvince;
        TextView txtCityMunicipality;
        TextView txtBarangay;
        TextView txtMobileNo;
        TextView txtAddressSpecificInstructions;

        ViewHolder(View itemView) {
            super(itemView);
            rbBillngAddress = (RadioButton)itemView.findViewById(R.id.radio_billing_address);
            txtName = (TextView)itemView.findViewById(R.id.text_name);
            txtCompleteAddress = (TextView)itemView.findViewById(R.id.text_complete_address);
            txtProvince = (TextView)itemView.findViewById(R.id.text_province);
            txtCityMunicipality = (TextView) itemView.findViewById(R.id.text_city_municipality);
            txtBarangay = (TextView)itemView.findViewById(R.id.text_barangay);
            txtMobileNo = (TextView)itemView.findViewById(R.id.text_mobile_no);
            txtAddressSpecificInstructions = (TextView) itemView.findViewById(R.id.text_address_specific_instructions);
        }
    }

    @Override
    public DeliveryAddressAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_delivery_address, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final DeliveryAddressAdapter.ViewHolder viewHolder, int i) {
        viewHolder.txtName.setText(names[i]);
        viewHolder.txtCompleteAddress.setText(completeAddress[i]);
        viewHolder.txtProvince.setText(provinces[i]);
        viewHolder.txtCityMunicipality.setText(city_municipality[i]);
        viewHolder.txtBarangay.setText(barangay[i]);
        viewHolder.txtMobileNo.setText(mobileNo[i]);
        viewHolder.txtAddressSpecificInstructions.setText(addressSpecificInstructions[i]);
    }

    @Override
    public int getItemCount() {
        return names.length;
    }
}