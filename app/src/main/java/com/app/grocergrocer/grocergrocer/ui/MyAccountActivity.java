package com.app.grocergrocer.grocergrocer.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.app.grocergrocer.grocergrocer.R;
import com.facebook.drawee.view.SimpleDraweeView;

public class MyAccountActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(5).setChecked(true);

        SimpleDraweeView sdvUserProfilePhoto = (SimpleDraweeView) findViewById(R.id.user_profile_photo);
        sdvUserProfilePhoto.setImageURI(Uri.parse("http://i.imgur.com/YHzCNks.jpg"));

        Button btnEditProfile = (Button) findViewById(R.id.btn_edit_profile);

        btnEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), EditProfileActivity.class);
                startActivity(intent);
            }
        });
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
            intent = new Intent(this, ShoppingCartActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_order_history) {
            intent = new Intent(this, OrderHistoryActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_grocery_list) {
            intent = new Intent(this, GroceryListActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_my_account) {
            // my account
        } else if (id == R.id.nav_logout) {
            intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}