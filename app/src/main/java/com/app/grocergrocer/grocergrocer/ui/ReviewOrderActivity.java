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
import android.widget.RelativeLayout;

import com.app.grocergrocer.grocergrocer.R;
import com.app.grocergrocer.grocergrocer.adapters.ReviewOrderAdapter;

public class ReviewOrderActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_order);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RelativeLayout deliveryAddressSection = (RelativeLayout) findViewById(R.id.delivery_address_section);
        RelativeLayout deliveryTimeSection = (RelativeLayout) findViewById(R.id.delivery_time_section);
        RelativeLayout itemsOrderedSection = (RelativeLayout) findViewById(R.id.items_ordered_section);

        deliveryAddressSection.setOnClickListener(this);
        deliveryTimeSection.setOnClickListener(this);
        itemsOrderedSection.setOnClickListener(this);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view_items_ordered);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.Adapter adapter = new ReviewOrderAdapter();
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setFocusable(false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
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
            case R.id.delivery_address_section:
                intent = new Intent(this, DeliveryAddressActivity.class);
                startActivity(intent);
                break;
            case R.id.delivery_time_section:
                intent = new Intent(this, DeliveryTimeActivity.class);
                startActivity(intent);
                break;
            case R.id.items_ordered_section:
                intent = new Intent(this, ShoppingCartActivity.class);
                startActivity(intent);
                break;
        }
    }
}