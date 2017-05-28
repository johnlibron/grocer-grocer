package com.app.grocergrocer.grocergrocer.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.app.grocergrocer.grocergrocer.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnEmail = (Button) findViewById(R.id.login_form_email_btn);
        Button btnFacebook = (Button) findViewById(R.id.login_form_facebook);
        TextView txtSignUp = (TextView) findViewById(R.id.login_form_signup_btn);
        TextView txtSkip = (TextView) findViewById(R.id.login_form_skip);

        btnEmail.setOnClickListener(this);
        btnFacebook.setOnClickListener(this);
        txtSignUp.setOnClickListener(this);
        txtSkip.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.login_form_email_btn:
                intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.login_form_facebook:
                intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.login_form_signup_btn:
                intent = new Intent(this, SignUpActivity.class);
                startActivity(intent);
                break;
            case R.id.login_form_skip:
                intent = new Intent(this, ExploreActivity.class);
                startActivity(intent);
                break;
        }
    }
}
