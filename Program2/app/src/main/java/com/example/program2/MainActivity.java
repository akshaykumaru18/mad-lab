package com.example.program2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView resultView;
    EditText number1, number2;

    String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultView = findViewById(R.id.result);
        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            number1.setShowSoftInputOnFocus(false);
            number2.setShowSoftInputOnFocus(false);
        }


    }

    public void buttonClick(View view) {
        switch (view.getId()) {
            case R.id.n0:
                appCharacter("0");
                break;
            case R.id.n1:
                appCharacter("1");
                break;
            case R.id.n2:
                appCharacter("2");
                break;
            case R.id.n3:
                appCharacter("3");
                break;
            case R.id.n4:
                appCharacter("4");
                break;
            case R.id.n5:
                appCharacter("5");
                break;
            case R.id.n6:
                appCharacter("6");
                break;
            case R.id.n7:
                appCharacter("7");
                break;
            case R.id.n8:
                appCharacter("8");
                break;
            case R.id.n9:
                appCharacter("9");
                break;
            case R.id.dot:
                appCharacter(".");
                break;
            case R.id.calculate:
                calculate();
                break;
            case R.id.addition:
                setOperator("+");
                break;
            case R.id.substract:
                setOperator("-");
                break;
            case R.id.multiplication:
                setOperator("*");
                break;
            case R.id.division:
                setOperator("/");
                break;
            case R.id.clear:
                clear();
                break;
            case R.id.ac:
                allClear();
                break;
            case R.id.del:
                delete();
                break;

        }
    }

    public void appCharacter(String s) {
        if (s == ".") {
            if (number1.hasFocus()) {
                if (!number1.getText().toString().contains("."))
                    //set for number1 edittext
                    number1.append(s);

            } else if (number2.hasFocus()) {
                if (!number2.getText().toString().contains("."))
                    number2.append(s);
            } else {
                Toast.makeText(this, "None of Textbox is selected\nKindly select either one of them", Toast.LENGTH_LONG).show();
            }
        } else if (number1.hasFocus()) {

            number1.append(s);

        } else if (number2.hasFocus()) {
            number2.append(s);
        } else {
            Toast.makeText(this, "None of Textbox is selected\nKindly select either one of them", Toast.LENGTH_LONG).show();
        }
    }

    public void setOperator(String c) {

        operator = c;
    }

    public void calculate() {
        String result;
        float num1 = Float.parseFloat(number1.getText().toString());
        float num2 = Float.parseFloat(number2.getText().toString());
        switch (operator) {
            case "+":
                result = String.valueOf((num1 + num2));
                resultView.setText(result);
                break;
            case "-":
                result = String.valueOf((num1 - num2));
                resultView.setText(result);
                break;
            case "*":
                result = String.valueOf((num1 * num2));
                resultView.setText(result);
                break;

            case "/":
                if (number1.getText().toString() != null && num2 != 0.0) {
                    result = String.valueOf((num1 / num2));
                    resultView.setText(result);
                } else {
                    Toast.makeText(this, "Cannot divide number by 0", Toast.LENGTH_LONG).show();
                }

                break;


        }
    }

    public void clear() {
        if (number1.hasFocus()) {
            number1.setText("");
        } else if (number2.hasFocus()) {
            number2.setText("");
        } else {
            Toast.makeText(this, "Select TextBox to clear", Toast.LENGTH_LONG).show();
        }


        //resultView.setText("");

    }

    public void delete() {
        if (number1.hasFocus()) {
            int n = number1.getText().toString().length();
            number1.setText(number1.getText().subSequence(0, n - 1));
        } else if (number2.hasFocus()) {
            int n = number2.getText().toString().length();
            number2.setText(number2.getText().subSequence(0, n - 1));
        } else {
            Toast.makeText(this, "Select TextBox to delete", Toast.LENGTH_LONG).show();
        }
    }

    public void allClear() {
        number1.setText("");
        number2.setText("");
        resultView.setText("");

    }


}

//    public void zero(View view) {
//        if (number1.hasFocus()) {
//            //set for number1 edittext
//            number1.append("0");
//        } else if (number2.hasFocus()) {
//            number2.append("0");
//        } else {
//            Toast.makeText(this, "None of Textbox is selected\nKindly select either one of them", Toast.LENGTH_LONG).show();
//        }
//    }
//
//    public void one(View view) {
//        if (number1.hasFocus()) {
//            //set for number1 edittext
//            number1.append("1");
//        } else if (number2.hasFocus()) {
//            number2.append("1");
//        } else {
//            Toast.makeText(this, "None of Textbox is selected\nKindly select either one of them", Toast.LENGTH_LONG).show();
//        }
//    }
//
//    public void two(View view) {
//        if (number1.hasFocus()) {
//            //set for number1 edittext
//            number1.append("2");
//        } else if (number2.hasFocus()) {
//            number2.append("2");
//        } else {
//            Toast.makeText(this, "None of Textbox is selected\nKindly select either one of them", Toast.LENGTH_LONG).show();
//        }
//    }
//
//
//    public void three(View view) {
//        if (number1.hasFocus()) {
//            //set for number1 edittext
//            number1.append("3");
//        } else if (number2.hasFocus()) {
//            number2.append("3");
//        } else {
//            Toast.makeText(this, "None of Textbox is selected\nKindly select either one of them", Toast.LENGTH_LONG).show();
//        }
//    }
//
//    public void four(View view) {
//        if (number1.hasFocus()) {
//            //set for number1 edittext
//            number1.append("4");
//        } else if (number2.hasFocus()) {
//            number2.append("4");
//        } else {
//            Toast.makeText(this, "None of Textbox is selected\nKindly select either one of them", Toast.LENGTH_LONG).show();
//        }
//    }
//
//    public void five(View view) {
//        if (number1.hasFocus()) {
//            //set for number1 edittext
//            number1.append("5");
//        } else if (number2.hasFocus()) {
//            number2.append("5");
//        } else {
//            Toast.makeText(this, "None of Textbox is selected\nKindly select either one of them", Toast.LENGTH_LONG).show();
//        }
//    }
//
//    public void six(View view) {
//        if (number1.hasFocus()) {
//            //set for number1 edittext
//            number1.append("6");
//        } else if (number2.hasFocus()) {
//            number2.append("6");
//        } else {
//            Toast.makeText(this, "None of Textbox is selected\nKindly select either one of them", Toast.LENGTH_LONG).show();
//        }
//    }
//
//    public void seven(View view) {
//        if (number1.hasFocus()) {
//            //set for number1 edittext
//            number1.append("7");
//        } else if (number2.hasFocus()) {
//            number2.append("7");
//        } else {
//            Toast.makeText(this, "None of Textbox is selected\nKindly select either one of them", Toast.LENGTH_LONG).show();
//        }
//    }
//
//    public void eight(View view) {
//        if (number1.hasFocus()) {
//            //set for number1 edittext
//            number1.append("8");
//        } else if (number2.hasFocus()) {
//            number2.append("8");
//        } else {
//            Toast.makeText(this, "None of Textbox is selected\nKindly select either one of them", Toast.LENGTH_LONG).show();
//        }
//    }
//
//    public void nine(View view) {
//        if (number1.hasFocus()) {
//            //set for number1 edittext
//            number1.append("9");
//        } else if (number2.hasFocus()) {
//            number2.append("9");
//        } else {
//            Toast.makeText(this, "None of Textbox is selected\nKindly select either one of them", Toast.LENGTH_LONG).show();
//        }
//    }
//
//    public void division(View view) {
//
//    }
//
//    public void multiplication(View view) {
//
//    }
//
//    public void substract(View view) {
//
//    }
//
//    public void calculate(View view) {
//
//    }
//
//    public void addition(View view) {
//
//    }
//    public void clear(View view) {
//
//    }