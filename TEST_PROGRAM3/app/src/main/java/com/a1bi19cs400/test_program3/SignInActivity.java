package com.a1bi19cs400.test_program3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {

    EditText unameField,passwdField;
    Button signInBtn;
    int attempts = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        unameField = findViewById(R.id.uname2Field);
        passwdField = findViewById(R.id.passwd2Field);
        signInBtn = findViewById(R.id.signInButton);
    }

    public void signIn(View view){
        Bundle b = getIntent().getExtras();
        String uname = b.getString("uname");
        String passwd = b.getString("passwd");

        String enteredUname = unameField.getText().toString();
        String enteredPass = passwdField.getText().toString();

        if(enteredUname.equals(uname) && enteredPass.equals(passwd)){
            Toast.makeText(this,"Sign-in success",Toast.LENGTH_LONG).show();
            Intent successIntent = new Intent(this,SuccessActivity.class);

            startActivity(successIntent);
        }else{
            Toast.makeText(this,"Sign-in failed attempts left is : " + attempts,Toast.LENGTH_LONG).show();
            attempts--;
            if(attempts <= 0){
                signInBtn.setEnabled(false);
            }
        }
    }
}