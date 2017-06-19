package com.app.grocergrocer.grocergrocer.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.app.grocergrocer.grocergrocer.R;
import com.app.grocergrocer.grocergrocer.adapters.DeliveryAddressAdapter;
import com.app.grocergrocer.grocergrocer.models.DeliveryAddress;

import java.util.ArrayList;
import java.util.List;

public class DeliveryAddressActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_address);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        List<DeliveryAddress> deliveryAddressList = new ArrayList<>();

        deliveryAddressList.add(new DeliveryAddress("John James Libron", "Corazon Vill. 2, San Isidro Talisay City, Cebu", "Cebu", "Talisay City", "San Isidro", "0923127129", "Call this number when you arrived."));
        deliveryAddressList.add(new DeliveryAddress("Julrecha Lumambas", "Corazon Vill. 2, San Isidro Talisay City, Cebu", "Cebu", "Talisay City", "San Isidro", "0923127129", "Call this number when you arrived."));
        deliveryAddressList.add(new DeliveryAddress("Maria Reynalen Quijada", "Corazon Vill. 2, San Isidro Talisay City, Cebu", "Cebu", "Talisay City", "San Isidro", "0923127129", "Call this number when you arrived."));
        deliveryAddressList.add(new DeliveryAddress("Virgil John Lomocso", "Corazon Vill. 2, San Isidro Talisay City, Cebu", "Cebu", "Talisay City", "San Isidro", "0923127129", "Call this number when you arrived."));
        deliveryAddressList.add(new DeliveryAddress("Michael Libosada", "Corazon Vill. 2, San Isidro Talisay City, Cebu", "Cebu", "Talisay City", "San Isidro", "0923127129", "Call this number when you arrived."));
        deliveryAddressList.add(new DeliveryAddress("Jean Paul Ybanez", "Corazon Vill. 2, San Isidro Talisay City, Cebu", "Cebu", "Talisay City", "San Isidro", "0923127129", "Call this number when you arrived."));
        deliveryAddressList.add(new DeliveryAddress("Daniel Jared Yap", "Corazon Vill. 2, San Isidro Talisay City, Cebu", "Cebu", "Talisay City", "San Isidro", "0923127129", "Call this number when you arrived."));
        deliveryAddressList.add(new DeliveryAddress("Artis Bulawit", "Corazon Vill. 2, San Isidro Talisay City, Cebu", "Cebu", "Talisay City", "San Isidro", "0923127129", "Call this number when you arrived."));
        deliveryAddressList.add(new DeliveryAddress("Rey Dakay", "Corazon Vill. 2, San Isidro Talisay City, Cebu", "Cebu", "Talisay City", "San Isidro", "0923127129", "Call this number when you arrived."));
        deliveryAddressList.add(new DeliveryAddress("Christina Debuayan", "Corazon Vill. 2, San Isidro Talisay City, Cebu", "Cebu", "Talisay City", "San Isidro", "0923127129", "Call this number when you arrived."));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.Adapter adapter = new DeliveryAddressAdapter(deliveryAddressList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        Button btnAddDifferentAddress = (Button) findViewById(R.id.btn_add_different_address);
        Button btnDeliveryTiming = (Button) findViewById(R.id.btn_delivery_timing);

        btnDeliveryTiming.setOnClickListener(this);
        btnAddDifferentAddress.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(final View v) {
        Intent intent;
        switch (v.getId()) {
                case R.id.btn_add_different_address:
                intent = new Intent(this, AddDeliveryAddressActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_delivery_timing:
                intent = new Intent(this, DeliveryTimeActivity.class);
                startActivity(intent);
                break;
        }
    }
}