package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class MainActivity extends AppCompatActivity {

    EditText username,passwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.uid);
        passwd=findViewById(R.id.pwd);
    }
    public void signup(View v)
    {
        if(passwd.getText().toString().length()>=8 && validatepassword(passwd.getText().toString()))
        {
            Toast.makeText(this, "SIGN-UP Success", Toast.LENGTH_LONG).show();
            Intent i=new Intent(this,SigninActivity.class);
            Bundle b=new Bundle();
            b.putString("uid",username.getText().toString());
            b.putString("password",passwd.getText().toString());
            i.putExtras(b);
            startActivity(i);
        }
        else
            Toast.makeText(this, "Password is not meeting the constraints", Toast.LENGTH_LONG).show();
    }
    public boolean validatepassword(String password)
    {
        Pattern ptrn;
        Matcher mat;


    }
}