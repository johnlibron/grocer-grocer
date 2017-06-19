package com.app.grocergrocer.grocergrocer.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.app.grocergrocer.grocergrocer.R;
import com.app.grocergrocer.grocergrocer.adapters.OrderDetailsAdapter;
import com.app.grocergrocer.grocergrocer.models.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        Bundle extras = getIntent().getExtras();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView txtOrderNo = (TextView) findViewById(R.id.order_no);
        TextView txtOrderDate = (TextView) findViewById(R.id.place_order);
        txtOrderNo.setText(extras.getString("orderNo"));
        txtOrderDate.setText(extras.getString("orderDate"));

        List<Product> productList = new ArrayList<>();
        productList.add(new Product("http://i.imgur.com/8lu1aR9.png", "Colgate Max Clean Smart Foam Colgate Max Clean Smart Foam wrap_content", "1 box", "87.00", null, null));
        productList.add(new Product("http://i.imgur.com/ErQsnTA.png", "Eggs", "6 pcs.", "50.00", null, null));
        productList.add(new Product("http://i.imgur.com/6AKLMix.png", "Coca-Cola Can", "1 can", "35.00", null, null));
        productList.add(new Product("http://i.imgur.com/zFMnLNY.png", "Palmolive Naturals Soap Calming Pleasure", "1 box", "23.00", null, null));
        productList.add(new Product("http://i.imgur.com/3aInE2Y.png", "Cornetto Classic Vanilla", "1 pc.", "25.00", null, null));
        productList.add(new Product("http://i.imgur.com/HKPro8L.png", "Piattos Cheese Colgate Max Clean Smart Foam wrap_content", "1 pc.", "28.00", null, null));
        productList.add(new Product("http://i.imgur.com/zb2ZZhN.png", "Eden Original", "1 box", "30.00", null, null));
        productList.add(new Product("http://i.imgur.com/do90fSj.png", "Wilkins Pure Purified Water", "1 bottle", "69.00", null, null));
        productList.add(new Product("http://i.imgur.com/i3JYPxQ.png", "Cabbage", "1 pc.", "16.00", null, null));
        productList.add(new Product("http://i.imgur.com/ShVxwd2.png", "Whole Chicken", "1 pc.", "398.00", null, null));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.Adapter adapter = new OrderDetailsAdapter(productList);
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.action_shopping_cart:
                intent = new Intent(this, ShoppingCartActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_search:
                intent = new Intent(this, SearchActivity.class);
                startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}