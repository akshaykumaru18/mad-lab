package com.a1bi19cs400.program5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    TextView countField;
    String[] colors = {"ff0000","2F2440"};
    int count = 0;
    int shouldCount = 0;
    public Handler countThreadhandler;
    Thread countTrd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countField = findViewById(R.id.countValue);
        countThreadhandler = new Handler();

    }

    public void start(View view){
        countThreadhandler.postDelayed(ThreadCount,100);
    }
    public void stop(View view){
            countThreadhandler.removeCallbacks(ThreadCount);
            count=0;
    }


   public Runnable ThreadCount = new Runnable() {
       @Override
       public void run() {
           count++;
           countField.setText(String.valueOf(count));
           countThreadhandler.postDelayed(ThreadCount,100);
       }
   };


}