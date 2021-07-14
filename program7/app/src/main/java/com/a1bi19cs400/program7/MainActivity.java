package com.a1bi19cs400.program7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText pitchField,speedRate,textField;
    TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pitchField = findViewById(R.id.pitchRate);
        speedRate = findViewById(R.id.speedRate);
        textField = findViewById(R.id.contentField);

        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                    textToSpeech.setLanguage(Locale.ENGLISH);
                }else{
                    Toast.makeText(MainActivity.this,"Not inititialized",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    public void convert(View view){
        String text = textField.getText().toString();
        if(pitchField.getText().toString().equals("")){
            textToSpeech.setPitch(1.0f);

        }else{
            textToSpeech.setPitch(Float.parseFloat(pitchField.getText().toString()));

        }
        if(speedRate.getText().toString().equals("")){
            textToSpeech.setSpeechRate(1.0f);
            
        }else{
            textToSpeech.setSpeechRate(Float.parseFloat(speedRate.getText().toString()));

        }


        textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null);
    }
}