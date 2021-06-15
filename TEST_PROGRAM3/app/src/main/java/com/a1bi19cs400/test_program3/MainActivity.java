package com.a1bi19cs400.test_program3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText unameField,passwdField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unameField = findViewById(R.id.unameField);
        passwdField = findViewById(R.id.passwdField);
    }

    public void signUp(View view){
        String uname = unameField.getText().toString();
        String passwd  = passwdField.getText().toString();
        if(uname != null && passwd.length() >= 8 && validatePassword(passwd)){
            Toast.makeText(this,"Sign-up success",Toast.LENGTH_LONG).show();
            Intent signInIntent = new Intent(this,SignInActivity.class);
            Bundle b = new Bundle();
            b.putString("uname",uname);
            b.putString("passwd",passwd);
            signInIntent.putExtras(b);
            startActivity(signInIntent);
        }else{
            Toast.makeText(this,"Sign-up failed Try again!! \n constraints are not matching",Toast.LENGTH_LONG).show();
        }
    }

    public boolean validatePassword(String password){
        Pattern pattern;
        Matcher matcher;
        String passwordptrn="^(?=.*[A-Z])(?=.[a-z])(?=.*[0-9])(?=.*[<>/@%$#+=])(?=\\S+$).{8,}$";
        pattern=Pattern.compile(passwordptrn);
        matcher=pattern.matcher(password);
        return matcher.matches();
    }
}