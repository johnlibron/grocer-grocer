package com.app.grocergrocer.grocergrocer.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.app.grocergrocer.grocergrocer.R;
import com.app.grocergrocer.grocergrocer.adapters.CategoriesAdapter;
import com.app.grocergrocer.grocergrocer.models.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoriesActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(1).setChecked(true);

        View headerView = navigationView.getHeaderView(0);
        LinearLayout header = (LinearLayout) headerView.findViewById(R.id.header_view);
        header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AccountDetailsActivity.class);
                startActivity(intent);
            }
        });

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category("http://i.imgur.com/8lu1aR9.png", "Toothpaste"));
        categoryList.add(new Category("http://i.imgur.com/ErQsnTA.png", "Eggs"));
        categoryList.add(new Category("http://i.imgur.com/6AKLMix.png", "Drinks"));
        categoryList.add(new Category("http://i.imgur.com/zFMnLNY.png", "Soap"));
        categoryList.add(new Category("http://i.imgur.com/3aInE2Y.png", "Ice cream"));
        categoryList.add(new Category("http://i.imgur.com/HKPro8L.png", "Junk foods"));
        categoryList.add(new Category("http://i.imgur.com/zb2ZZhN.png", "Cheese"));
        categoryList.add(new Category("http://i.imgur.com/do90fSj.png", "Water"));
        categoryList.add(new Category("http://i.imgur.com/i3JYPxQ.png", "Vegetables"));
        categoryList.add(new Category("http://i.imgur.com/ShVxwd2.png", "Meat"));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        RecyclerView.Adapter adapter = new CategoriesAdapter(categoryList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_shopping_cart) {
            Intent intent = new Intent(this, ShoppingCartActivity.class);
            startActivity(intent);
        } else if (id == R.id.action_search) {
            Intent intent = new Intent(this, SearchActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent;

        if (id == R.id.nav_explore) {
            intent = new Intent(this, ExploreActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_categories) {
            // categories
        } else if (id == R.id.nav_shopping_cart) {
            intent = new Intent(this, ShoppingCartActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_order_history) {
            intent = new Intent(this, OrderHistoryActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_grocery_list) {
            intent = new Intent(this, GroceryListActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_logout) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}