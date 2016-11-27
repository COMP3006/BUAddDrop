package com.example.demo.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demo.myapplication.Components.Interface.DBCommunicator;

public class RegistrationActivity extends AppCompatActivity implements DBCommunicator{

    private Button mRegisterButton;
    private TextView mUsernameField, mPasswordField, mPassword2Field;
    private MainController mMainController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        mRegisterButton = (Button)findViewById(R.id.register_button_registration);
        mUsernameField  = (TextView)findViewById(R.id.register_edit_text_username);
        mPasswordField  = (TextView)findViewById(R.id.register_edit_text_userpassword);
        mPassword2Field  = (TextView)findViewById(R.id.register_edit_text_userpassword2);
        mMainController = new MainController(this);
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = mUsernameField.getText().toString().trim();
                String userpassword = mPasswordField.getText().toString().trim();
                String userpassword2 = mPassword2Field.getText().toString().trim();
                //Toast.makeText(getApplicationContext(),"username: " + username + "\n" + "password: " + userpassword,Toast.LENGTH_LONG).show();
                if (username.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Error: Username is missing",Toast.LENGTH_LONG).show();
                } else if (userpassword.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Error: Password is missing",Toast.LENGTH_LONG).show();
                } else if (userpassword2.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Error: Confirmed password is missing",Toast.LENGTH_LONG).show();
                } else if (!userpassword.equals(userpassword2)) {
                    Toast.makeText(getApplicationContext(),"Error: Unmatched Password",Toast.LENGTH_LONG).show();
                } else {
                    mMainController.register(username,userpassword);
                }
            }
        });
    }

    public void onResultReceived(String text){
        Toast.makeText(getApplicationContext(),"Register successfully with: " + text,Toast.LENGTH_LONG).show();
        Intent intent = new Intent(RegistrationActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    public void onErrorReceived(String text){
        Toast.makeText(getApplicationContext(), "Error: " + "Username is being used already.", Toast.LENGTH_LONG).show();
    }


}
