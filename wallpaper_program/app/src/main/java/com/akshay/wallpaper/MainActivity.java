package com.akshay.wallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;
import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Timer timer;
    Drawable drawable;
    WallpaperManager wallpaperManager;
    Integer next = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer = new Timer();
        wallpaperManager = WallpaperManager.getInstance(this);
    }


    public  void setWallpaper(View view){
        changeWallpaper();
    }
    public void changeWallpaper() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                switch (next) {
                    case 1:
                        drawable = getResources().getDrawable(R.drawable.wp1);
                        next = 2;
                        break;
                    case 2:
                        drawable = getResources().getDrawable(R.drawable.wp2);
                        next = 3;
                        break;
                    case 3:
                        drawable = getResources().getDrawable(R.drawable.wp3);
                        next = 4;
                        break;
                    case 4:
                        drawable = getResources().getDrawable(R.drawable.wp4);
                        next = 5;
                        break;
                    case 5:
                        drawable = getResources().getDrawable(R.drawable.wp5);
                        next = 6;
                        break;
                    case 6:
                        drawable = getResources().getDrawable(R.drawable.wp6);
                        next = 7;
                        break;
                    case 7:
                        drawable = getResources().getDrawable(R.drawable.wp7);
                        next = 8;
                        break;
                    case 8:
                        drawable = getResources().getDrawable(R.drawable.wp8);
                        next = 9;
                        break;
                    case 9:
                        drawable = getResources().getDrawable(R.drawable.wp9);
                        next = 10;
                        break;
                    case 10:
                        drawable = getResources().getDrawable(R.drawable.wp10);
                        next = 1;
                        break;
                }
                Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
                try {
                    wallpaperManager.setBitmap(bitmap);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }, 5000, 5000);
    }
}