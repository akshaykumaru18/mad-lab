package com.example.sample2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Declare 1 Button , 1 EditText, 1 TextView
    Button greetButton;
    EditText nameInput;
    TextView msgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Initialize it here
        greetButton = findViewById(R.id.greetBtn);
        nameInput = findViewById(R.id.inputName);
        msgView = findViewById(R.id.msg);

    }

    public void greet(View v){
        //Fetching text entered in the editext using getText() and Converting it to String format
        String name = nameInput.getText().toString();
        msgView.setText("Hello : " + name + "Welcome to MAD Lab");

    }
}