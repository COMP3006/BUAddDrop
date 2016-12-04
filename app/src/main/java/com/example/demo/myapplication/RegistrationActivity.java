package com.example.demo.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demo.myapplication.Components.Interface.DBCommunicator;

public class RegistrationActivity extends AppCompatActivity implements DBCommunicator, View.OnClickListener {

    public Button tBarLogin, tBarHome, mRegisterButton;
    private TextView mUsernameField, mPasswordField, mPassword2Field;

    private MainController mMainController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mRegisterButton = (Button)findViewById(R.id.mRegisterButton);
        mUsernameField  = (TextView)findViewById(R.id.register_edit_text_username);
        mPasswordField  = (TextView)findViewById(R.id.register_edit_text_userpassword);
        mPassword2Field  = (TextView)findViewById(R.id.register_edit_text_userpassword2);
        tBarLogin = (Button) findViewById(R.id.tBarLogin);
        tBarHome = (Button) findViewById(R.id.tBarHome);

        tBarLogin.setOnClickListener(this);
        tBarHome.setOnClickListener(this);
        mRegisterButton.setOnClickListener(this);

        mMainController = new MainController(this);
    }


    @Override
    public void onClick(View view) {
        //Toast.makeText(getApplicationContext(),"username: " + username + "\n" + "password: " + userpassword,Toast.LENGTH_LONG).show();
        switch (view.getId()) {
            case R.id.mRegisterButton:
                String username = mUsernameField.getText().toString().trim();
                String userpassword = mPasswordField.getText().toString().trim();
                String userpassword2 = mPassword2Field.getText().toString().trim();
                if (username.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Error: Username is missing", Toast.LENGTH_LONG).show();
                } else if (userpassword.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Error: Password is missing", Toast.LENGTH_LONG).show();
                } else if (userpassword2.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Error: Confirmed password is missing", Toast.LENGTH_LONG).show();
                } else if (!userpassword.equals(userpassword2)) {
                    Toast.makeText(getApplicationContext(), "Error: Unmatched Password", Toast.LENGTH_LONG).show();
                } else {
                    mMainController.register(username, userpassword);
                }
                break;

            case R.id.tBarLogin:
                startActivity(new Intent(this, LoginActivity.class));
                break;

            case R.id.tBarHome:
                startActivity(new Intent(this, SearchActivity.class));
                break;
        }
    }

    public void onResultReceived(String text){
        Toast.makeText(getApplicationContext(),"Register successfully with: " + text,Toast.LENGTH_LONG).show();
        startActivity(new Intent(RegistrationActivity.this, HomeActivity.class));
        finish();
    }

    public void onErrorReceived(String text){
        Toast.makeText(getApplicationContext(), "Error: " + "Username is being used already.", Toast.LENGTH_LONG).show();
    }

}
