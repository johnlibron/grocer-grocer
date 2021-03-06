package com.app.grocergrocer.grocergrocer.ui;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.app.grocergrocer.grocergrocer.R;
import com.app.grocergrocer.grocergrocer.adapters.GroceryListAdapter;
import com.app.grocergrocer.grocergrocer.models.GroceryList;

import java.util.ArrayList;
import java.util.List;

public class GroceryListActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(4).setChecked(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View fab) {
                @SuppressLint("InflateParams")
                View view = getLayoutInflater().inflate(R.layout.dialog_create_grocery_list, null);
                final TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.text_list_name);
                final EditText listName = (EditText) view.findViewById(R.id.list_name);
                final EditText listDescription = (EditText) view.findViewById(R.id.list_description);
                final String nameRequiredMessage = getString(R.string.err_required);

                final AlertDialog dialog = new AlertDialog.Builder(view.getContext())
                        .setTitle(R.string.dialog_create_grocery_list_title)
                        .setView(view)
                        .setPositiveButton(R.string.btn_save, null)
                        .setNegativeButton(R.string.btn_cancel, null)
                        .create();

                dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(final DialogInterface d) {
                        Button save = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
                        Button cancel = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);

                        save.setTextColor(ContextCompat.getColor(fab.getContext(), R.color.colorPrimary));
                        cancel.setTextColor(ContextCompat.getColor(fab.getContext(), R.color.colorPrimary));
                        save.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String name = listName.getText().toString().trim();

                                if (!name.isEmpty()) {
                                    Snackbar.make(fab, "List " + name + " added.", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                                    d.dismiss();
                                } else {
                                    if (!textInputLayout.isErrorEnabled()) {
                                        textInputLayout.setError(nameRequiredMessage);
                                    }
                                    if (textInputLayout.isErrorEnabled()) {
                                        listName.setText("");
                                        listName.setSelection(0);
                                        listName.requestFocus();
                                    }
                                }
                            }
                        });
                    }
                });
                dialog.show();
            }
        });

        List<GroceryList> groceryList = new ArrayList<>();
        groceryList.add(new GroceryList("My List 1", "Description 1", 8, "http://i.imgur.com/8lu1aR9.png", "http://i.imgur.com/ErQsnTA.png", "http://i.imgur.com/6AKLMix.png", "http://i.imgur.com/zFMnLNY.png"));
        groceryList.add(new GroceryList("My List 2", null, 0, null, null, null, null));
        groceryList.add(new GroceryList("My List 3", null, 0, null, null, null, null));
        groceryList.add(new GroceryList("My List 4", "Description 4", 2, "http://i.imgur.com/ErQsnTA.png", "http://i.imgur.com/ShVxwd2.png", null, null));
        groceryList.add(new GroceryList("My List 5", null, 0, null, null, null, null));
        groceryList.add(new GroceryList("My List 6", "Description 6", 11, "http://i.imgur.com/6AKLMix.png", "http://i.imgur.com/i3JYPxQ.png", "http://i.imgur.com/8lu1aR9.png", "http://i.imgur.com/do90fSj.png"));
        groceryList.add(new GroceryList("My List 7", "Description 7", 5, "http://i.imgur.com/zb2ZZhN.png", "http://i.imgur.com/do90fSj.png", "http://i.imgur.com/i3JYPxQ.png", "http://i.imgur.com/zFMnLNY.png"));
        groceryList.add(new GroceryList("My List 8", "Description 8", 1, "http://i.imgur.com/do90fSj.png", null, null, null));
        groceryList.add(new GroceryList("My List 9", null, 0, null, null, null, null));
        groceryList.add(new GroceryList("My List 10", "Description 10", 25, "http://i.imgur.com/ShVxwd2.png", "http://i.imgur.com/zb2ZZhN.png", "http://i.imgur.com/ErQsnTA.png", "http://i.imgur.com/i3JYPxQ.png"));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.Adapter adapter = new GroceryListAdapter(groceryList);
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
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Intent intent;

        if (id == R.id.nav_explore) {
            intent = new Intent(this, CategoriesActivity.class);
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
            // grocery list
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
}