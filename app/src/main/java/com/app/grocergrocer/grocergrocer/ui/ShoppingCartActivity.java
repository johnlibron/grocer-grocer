package com.app.grocergrocer.grocergrocer.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.app.grocergrocer.grocergrocer.R;
import com.app.grocergrocer.grocergrocer.adapters.ShoppingCartAdapter;
import com.app.grocergrocer.grocergrocer.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(2).setChecked(true);

        List<Product> productList = new ArrayList<>();
        productList.add(new Product("http://i.imgur.com/8lu1aR9.png", "Colgate Max Clean Smart Foam", "1 box", "₱ 87.00", "₱ 100.00", "-21%"));
        productList.add(new Product("http://i.imgur.com/ErQsnTA.png", "Eggs", "6 pcs.", "₱ 50.00", null, null));
        productList.add(new Product("http://i.imgur.com/6AKLMix.png", "Coca-Cola Can", "1 can", "₱ 35.00", "₱ 50.00", "-10%"));
        productList.add(new Product("http://i.imgur.com/zFMnLNY.png", "Palmolive Naturals Soap Calming Pleasure", "1 box", "₱ 23.00", "₱ 30.00", "-5%"));
        productList.add(new Product("http://i.imgur.com/3aInE2Y.png", "Cornetto Classic Vanilla", "1 pc.", "₱ 25.00", null, null));
        productList.add(new Product("http://i.imgur.com/HKPro8L.png", "Piattos Cheese", "1 pc.", "₱ 28.00", null, null));
        productList.add(new Product("http://i.imgur.com/zb2ZZhN.png", "Eden Original", "1 box", "₱ 30.00", "₱ 40.00", "-8%"));
        productList.add(new Product("http://i.imgur.com/do90fSj.png", "Wilkins Pure Purified Water", "1 bottle", "₱ 69.00", null, null));
        productList.add(new Product("http://i.imgur.com/i3JYPxQ.png", "Cabbage", "1 pc.", "₱ 16.00", "₱ 25.00", "-2%"));
        productList.add(new Product("http://i.imgur.com/ShVxwd2.png", "Whole Chicken", "1 pc.", "₱ 398.00", "₱ 500.00", "-40%"));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.Adapter adapter = new ShoppingCartAdapter(productList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        Button btnCheckout = (Button) findViewById(R.id.btn_checkout);
        btnCheckout.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_search) {
            Intent intent = new Intent(this, SearchActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Intent intent;

        if (id == R.id.nav_explore) {
            intent = new Intent(this, ExploreActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_categories) {
            intent = new Intent(this, CategoriesActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_shopping_cart) {
            // shopping cart
        } else if (id == R.id.nav_order_history) {
            intent = new Intent(this, OrderHistoryActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_grocery_list) {
            intent = new Intent(this, GroceryListActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_my_account) {
            intent = new Intent(this, MyAccountActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_logout) {
            intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_checkout:
                Intent intent = new Intent(this, DeliveryAddressActivity.class);
                startActivity(intent);
                break;
        }
    }
}