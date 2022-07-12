package com.application.mydsu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.application.mydsu.presentation.main_activity.MainActivity;

import static java.lang.Thread.sleep;

public class SplashScreen extends AppCompatActivity {
    private SharedPreferences prefsTheme = null;
    boolean flagTheme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        prefsTheme = getSharedPreferences("Theme", MODE_PRIVATE);
        flagTheme = prefsTheme.getBoolean("lightAndDarkTheme", false);
        if(flagTheme){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash_screen_dark);
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(500);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    firstrun();
                    overridePendingTransition(R.anim.alpha_zero_one,R.anim.alpha_one_zero);
                }
            }
        };
        thread.start();
    }
    private void firstrun() {
            startActivity(new Intent(SplashScreen.this, MainActivity.class));
    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    //Скрываем Navigation Bar (кнопки)
    @Override
    protected void onStart() {
        super.onStart();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void hideSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }

}