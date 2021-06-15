package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SigninActivity extends AppCompatActivity {

    EditText username,password;
    int attempts;
    Button signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        username=findViewById(R.id.uid);
        password=findViewById(R.id.pwd);
        signin=findViewById(R.id.signin);

    }
    public void signin(View v)
    {
        Bundle b=getIntent().getExtras();
        String uname=b.getString("uid");
        String passwd=b.getString("password");
        if(username.getText().toString().equals(uname)&& password.getText().toString().equals(passwd))
        {
            Toast.makeText(this, "SIGN-IN SUCCESFUL", Toast.LENGTH_LONG).show();
            attempts=0;
            Intent i= new Intent(this,SuccessActivity.class);
            startActivity(i);
        }
        else
        {

            Toast.makeText(this, "SIGN-IN UNSUCCESFUL. Number of Attempts="+attempts, Toast.LENGTH_LONG).show();
            attempts++;
            if(attempts==3) {
                signin.setEnabled(false);
            }
        }
    }
}