package com.example.demo.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button blogin;
    EditText etUsername, etPassword;
    TextView tvRegisterlink, tvInputinfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        blogin = (Button) findViewById(R.id.blogin);
        tvRegisterlink = (TextView) findViewById(R.id.tvRegisterLink);
        tvInputinfo = (TextView) findViewById(R.id.tvInputinfo);


        blogin.setOnClickListener(this);
        tvRegisterlink.setOnClickListener(this);

    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.blogin:


                break;


            case R.id.tvRegisterLink:
                startActivity(new Intent(this, MainActivity.class));

                break;
        }
    }
}
