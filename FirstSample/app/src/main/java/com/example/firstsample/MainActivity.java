package com.example.firstsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Declare Button and TextView
    Button incrementButton;
    Button decrementButton;
    TextView msgView;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Initialize here
        incrementButton = findViewById(R.id.increment);
        decrementButton = findViewById(R.id.decrement);
        msgView = findViewById(R.id.msg);


    }

    public void increment(View v) {
        count++;
        msgView.setText("Count : Incremented to : " + count);
    }

    public void decrement(View v) {
        count--;
        msgView.setText("Count : Decremented to : " + count);
    }
}