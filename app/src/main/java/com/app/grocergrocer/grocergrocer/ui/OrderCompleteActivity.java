package com.app.grocergrocer.grocergrocer.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.app.grocergrocer.grocergrocer.R;

public class OrderCompleteActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_complete);

        Button btnReviewOrder = (Button) findViewById(R.id.btn_review_order);
        Button btnKeepShopping = (Button) findViewById(R.id.btn_keep_shopping);
        btnReviewOrder.setOnClickListener(this);
        btnKeepShopping.setOnClickListener(this);
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

    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case  R.id.btn_review_order:
                intent = new Intent(this, OrderHistoryActivity.class);
                startActivity(intent);
                break;
            case  R.id.btn_keep_shopping:
                intent = new Intent(this, ExploreActivity.class);
                startActivity(intent);
                break;
        }
    }
}