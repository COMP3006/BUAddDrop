package com.example.demo.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class SearchActivity extends AppCompatActivity implements View.OnClickListener {

    public Button tBarLogin, tBarRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        tBarLogin = (Button) findViewById(R.id.tBarLogin);
        tBarRegister = (Button) findViewById(R.id.tBarRegister);
        tBarLogin.setOnClickListener(this);
        tBarRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tBarLogin:
                startActivity(new Intent(this, LoginActivity.class));
                break;

            case R.id.tBarRegister:
                startActivity(new Intent(this, RegistrationActivity.class));
                break;
        }
    }
}
