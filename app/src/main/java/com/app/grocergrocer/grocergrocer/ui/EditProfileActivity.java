package com.app.grocergrocer.grocergrocer.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.app.grocergrocer.grocergrocer.R;

public class EditProfileActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button btnUpdateProfile = (Button) findViewById(R.id.btn_update_profile);
        Button btnUpdatePassword = (Button) findViewById(R.id.btn_update_password);

        btnUpdateProfile.setOnClickListener(this);
        btnUpdatePassword.setOnClickListener(this);
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
        getMenuInflater().inflate(R.menu.search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
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
            case R.id.btn_update_profile:
                Snackbar.make(v, "Update Profile Button Clicked!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                break;
            case R.id.btn_update_password:
                Snackbar.make(v, "Update Password Button Clicked!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                break;
        }
    }
}