package com.example.demo.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demo.myapplication.Components.Interface.DBCommunicator;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, DBCommunicator {

    private Button blogin;
    EditText etUsername, etPassword;
    TextView tvRegisterlink, tvInputinfo;

    private MainController mMainController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        blogin = (Button) findViewById(R.id.blogin);
        tvRegisterlink = (TextView) findViewById(R.id.tvRegisterLink);
        tvInputinfo = (TextView) findViewById(R.id.tvInputinfo);
        mMainController = new MainController(this);


        blogin.setOnClickListener(this);
        tvRegisterlink.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.blogin:
                String username = etUsername.getText().toString().trim();
                String userpassword = etPassword.getText().toString().trim();

                if (username.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Error: Username is missing",Toast.LENGTH_LONG).show();
                } else if (userpassword.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Error: Password is missing",Toast.LENGTH_LONG).show();
                } else {
                    mMainController.login(username,userpassword);
                }
                break;


            case R.id.tvRegisterLink:
                startActivity(new Intent(this, RegistrationActivity.class));

                break;
        }
    }

    public void onResultReceived(String text){
        Toast.makeText(getApplicationContext(),"Login successfully with: " + text,Toast.LENGTH_LONG).show();
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    public void onErrorReceived(String text){
        Toast.makeText(getApplicationContext(), "Error: " + "Username or password is incorrect.", Toast.LENGTH_LONG).show();
    }
}
