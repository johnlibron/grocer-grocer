package com.app.grocergrocer.grocergrocer.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.app.grocergrocer.grocergrocer.Constant;
import com.app.grocergrocer.grocergrocer.R;
import com.facebook.drawee.view.SimpleDraweeView;

import static com.app.grocergrocer.grocergrocer.views.ExpandableTextView.makeTextViewResizable;

public class ProductActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        Bundle extras = getIntent().getExtras();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(extras.getString("productName"));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SimpleDraweeView sdvProductImage = (SimpleDraweeView) findViewById(R.id.product_image);
        TextView txtProductName = (TextView) findViewById(R.id.product_name);
        TextView txtProductMeasurement = (TextView) findViewById(R.id.product_measurement);
        TextView txtProductPrice = (TextView) findViewById(R.id.product_price);
        TextView txtProductDescription = (TextView) findViewById(R.id.product_description);
        TextView txtProductOriginalPrice = (TextView) findViewById(R.id.product_original_price);
        TextView txtProductLessPrice = (TextView) findViewById(R.id.product_less_price);
        Button btnAddToCart = (Button) findViewById(R.id.btn_add_to_cart);
        Button btnSaveToList = (Button) findViewById(R.id.btn_save_to_list);

        Uri uri = Uri.parse(extras.getString("productImage"));
        sdvProductImage.setImageURI(uri);
        txtProductName.setText(extras.getString("productName"));
        txtProductMeasurement.setText(extras.getString("productMeasurement"));
        txtProductPrice.setText(extras.getString("productPrice"));
        if (!Constant.isNullOrEmpty(extras.getString("productOriginalPrice"))) {
            txtProductOriginalPrice.setText(extras.getString("productOriginalPrice"));
        } else {
            txtProductOriginalPrice.setVisibility(View.GONE);
        }
        if (!Constant.isNullOrEmpty(extras.getString("productLessPrice"))) {
            txtProductLessPrice.setText(extras.getString("productLessPrice"));
        } else {
            txtProductLessPrice.setVisibility(View.GONE);
        }

        btnAddToCart.setOnClickListener(this);
        btnSaveToList.setOnClickListener(this);

        makeTextViewResizable(txtProductDescription, 3, "Read More", true);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_to_cart:
                Snackbar.make(v, "Add To Cart Button Clicked!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                break;
            case R.id.btn_save_to_list:
                Snackbar.make(v, "Save To Cart Button Clicked!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                break;
        }
    }
}