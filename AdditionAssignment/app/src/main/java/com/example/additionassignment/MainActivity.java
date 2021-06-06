package com.example.additionassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button Add, Sub, Mul, Div;
    EditText num1,num2;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Add = findViewById(R.id.Add);
        Sub = findViewById(R.id.substract);
        Mul = findViewById(R.id.multiplication);
        Div = findViewById(R.id.divide);

        num1 = findViewById(R.id.number1);
        num2 = findViewById(R.id.number2);

        result = findViewById(R.id.result);
    }

    public void addition(View view) {
        float number1  = Float.parseFloat(num1.getText().toString());
        float number2 = Float.parseFloat(num2.getText().toString());

        String res = String.valueOf((number1 + number2));
        result.setText(res);
    }

    public void substract(View view) {
        float number1  = Float.parseFloat(num1.getText().toString());
        float number2 = Float.parseFloat(num2.getText().toString());

        String res = String.valueOf((number1 - number2));
        result.setText(res);
    }

    public void multiply(View view) {
        float number1  = Float.parseFloat(num1.getText().toString());
        float number2 = Float.parseFloat(num2.getText().toString());

        String res = String.valueOf((number1 * number2));
        result.setText(res);
    }

    public void divide(View view) {
        float number1  = Float.parseFloat(num1.getText().toString());
        float number2 = Float.parseFloat(num2.getText().toString());

        String res = String.valueOf((number1 / number2));
        result.setText(res);
    }
}