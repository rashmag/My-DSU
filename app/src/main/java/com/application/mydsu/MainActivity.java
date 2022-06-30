package com.application.mydsu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.application.mydsu.HomeWork.HomeWork;
import com.application.mydsu.Tutorial.ActivityStart;
import com.application.mydsu.Utils.CircularTransformation;
import com.application.mydsu.Utils.Swipe;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class MainActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private SharedPreferences prefs,prefsTheme = null;
    private ImageView img;
    private ExpandableRelativeLayout mycontent;
    private TextView surName;
    private TextView name;
    private TextView direction;
    private TextView course;
    private TextView textViewSwipe;
    @SuppressLint("SdCardPath")
    private String strDirectory = "/data/user/0/com.application.mydsu/app_imageDir/";
    private String setUserName;
    private String setUserSurName;
    private String elementSpinnerSubgroupCource;
    private String elementSpinnerDirection;
    private ScrollView scrollView;
    private boolean openBtnSwipe = false;
    private ConstraintLayout main_layout,constraintSwipe;
    boolean flagTheme;
    private ImageView btnClose;
    private ImageView btnHomewWork;

    @SuppressLint({"ClickableViewAccessibility", "SetTextI18n", "UseCompatLoadingForDrawables"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        prefsTheme = getSharedPreferences("Theme", MODE_PRIVATE);
        flagTheme = prefsTheme.getBoolean("lightAndDarkTheme", false);
        if(flagTheme){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefs = getSharedPreferences("FirstRunMainActivity", MODE_PRIVATE);

        ImageView stroke = findViewById(R.id.stroke);
        if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            stroke.setImageDrawable(getResources().getDrawable(R.drawable.stroke_light));
        }else{
            stroke.setImageDrawable(getResources().getDrawable(R.drawable.stroke_dark));
        }
        constraintSwipe = (ConstraintLayout)findViewById(R.id.constraintSwipe);
        btnClose = findViewById(R.id.btnClose);
        if(prefs.getInt("FirstRunSwipeMainAcitivity", 1) == 0){
            constraintSwipe.setVisibility(View.INVISIBLE);
        }
        firstrun();
        //Находим UserPhoto
        img = (ImageView) findViewById(R.id.userPhoto);
        loadImageFromStorage(strDirectory);
        //Обробатываем свайп
        main_layout = (ConstraintLayout) findViewById(R.id.main_layout);
        scrollView = (ScrollView) findViewById(R.id.scrollViewMainActivity);
        main_layout.setOnTouchListener(new Swipe(MainActivity.this) {
            @Override
            public void onSwipeLeft() {
                Intent intent = new Intent(MainActivity.this, Schedule.class);
                startActivity(intent);
                prefs.edit().putInt("FirstRunSwipeMainAcitivity", 0).apply();
                overridePendingTransition(R.anim.diagonaltranslateright,R.anim.alpha_one_zero);
            }

            public void onSwipeRight() {
                //эмулируем нажатие на HOME, сворачивая приложение
                Intent i = new Intent(Intent.ACTION_MAIN);
                i.addCategory(Intent.CATEGORY_HOME);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();
            }
        });
        scrollView.setOnTouchListener(new Swipe(MainActivity.this) {
            @Override
            public void onSwipeLeft() {
                Intent intent = new Intent(MainActivity.this, Schedule.class);
                startActivity(intent);
                prefs.edit().putInt("FirstRunSwipeMainAcitivity", 0).apply();
                overridePendingTransition(R.anim.diagonaltranslateright,R.anim.alpha_one_zero);
            }

            public void onSwipeRight() {
                //эмулируем нажатие на HOME, сворачивая приложение
                Intent i = new Intent(Intent.ACTION_MAIN);
                i.addCategory(Intent.CATEGORY_HOME);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });

        btnHomewWork = findViewById(R.id.btnHomeWork);
        if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            btnHomewWork.setImageDrawable(getResources().getDrawable(R.drawable.ic_home_work));
        }
        //ПОЛУЧАЕМ И УСТОНАВЛИВАЕМ ДАННЫЕ В userName и surName - НАЧАЛО
        sharedPreferences = getSharedPreferences("userdata", Context.MODE_PRIVATE);
        setUserName = sharedPreferences.getString("setUserName", "");
        setUserSurName = sharedPreferences.getString("setUserSurName", "");
        String setElementSpinnerCource = sharedPreferences.getString("setElementSpinnerCource", "");
        elementSpinnerSubgroupCource = sharedPreferences.getString("elementSpinnerSubgroupCource", "");
        elementSpinnerDirection = sharedPreferences.getString("elementSpinnerDirection", "");
        name = findViewById(R.id.name);
        surName = findViewById(R.id.surName);
        course = findViewById(R.id.course);
        TextView subgroup = findViewById(R.id.subgroup);
        direction = findViewById(R.id.direction);
        subgroup.setText(elementSpinnerSubgroupCource + " группа");
        direction.setText(elementSpinnerDirection + ", " + setElementSpinnerCource + " курс");
        surName.setText(setUserSurName);
        name.setText(setUserName);
        ChekedLength();
        //СПИСОК НОВОСТЕЙ - НАЧАЛО
        mycontent = findViewById(R.id.mycontent);
        mycontent.expand();
    }

    private void firstrun() {
        if (prefs.getBoolean("FirstRunMainActivity", true)) {
            Intent intentFragment = new Intent(MainActivity.this, ActivityStart.class);
            startActivity(intentFragment);
            prefs.edit().putBoolean("FirstRunMainActivity", false).apply();
        }
        if(prefs.getInt("FirstRunSwipeMainAcitivity", 1) != 0){
            constraintSwipe.setVisibility(View.VISIBLE);
        }
    }

    //ПРОВЕРЯЕМ ДЛИННУ ИМЕНИ
    private void ChekedLength() {
        if (setUserName.length() <= 0) {
            name.setTextSize(40);
            surName.setTextSize(40);
        } else if (setUserName.length() <= 5) {
            name.setTextSize(47);
            surName.setTextSize(47);
        } else if (setUserName.length() <= 8) {
            name.setTextSize(50);
            surName.setTextSize(50);
        } else if (setUserName.length() <= 10) {
            name.setTextSize(45);
            surName.setTextSize(45);
        } else if (setUserName.length() <= 12) {
            name.setTextSize(40);
            surName.setTextSize(40);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //эмулируем нажатие на HOME, сворачивая приложение
        Intent i = new Intent(Intent.ACTION_MAIN);
        i.addCategory(Intent.CATEGORY_HOME);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        finish();
    }

    //ЗАГРУЖАЕТ ИЗОБРАЖЕНИЕ ИЗ ФАЙЛА
    private void loadImageFromStorage(String path) {

        try {
            File f = new File(path, "phone.jpg");
            Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
            Picasso.with(MainActivity.this).load(f).transform(new CircularTransformation(150)).noPlaceholder().centerCrop().fit()
                    .into(img);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    //CLICK НА КНОПКУ НОВОСТИ
    public void showmyinformation(View view) {
        //СКРЫВАЕМ СВАЙП ПРИ РАСКРЫТИИ ШТОРКИ И ПОКАЗЫВАЕМ ПРИ ЗАКРЫТИИ
        if(prefs.getInt("FirstRunSwipeMainAcitivity", 1) != 0){
            if (!openBtnSwipe){
                constraintSwipe.setVisibility(View.INVISIBLE);
                openBtnSwipe = true;
            }else {
                constraintSwipe.setVisibility(View.VISIBLE);
                openBtnSwipe = false;
            }
        }
        mycontent.toggle();
    }

    //ПЕРЕХОД НА Schedule ACTIVITY
    public void onScheduleActivity(View view) {
        Intent intentSchedule = new Intent(this, Schedule.class);
        startActivity(intentSchedule);
        finish();
        overridePendingTransition(R.anim.alpha_zero_one,R.anim.alpha_one_zero);
    }

    public void InAboutMe(View view) {
        Intent intent = new Intent(MainActivity.this, AboutMe.class);
        startActivity(intent);
        finish();
//        overridePendingTransition(R.anim.alpha_zero_one,R.anim.alpha_one_zero);
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
    //ПЕРЕХОД НА АКТИВИТИ InformationAboutTheApp
    public void InformationAboutTheApp(View view) {
        Intent intentAboumeTut = new Intent(MainActivity.this, InformationAboutTheApp.class);
        startActivity(intentAboumeTut);
        finish();
        overridePendingTransition(R.anim.alpha_zero_one,R.anim.alpha_one_zero);
    }

    public void InHomewWork(View view) {
        Intent i = new Intent(MainActivity.this, HomeWork.class);
        i.putExtra("backPressed","MainActivity");
        startActivity(i);
        finish();
        overridePendingTransition(R.anim.alpha_zero_one,R.anim.alpha_one_zero);
    }

    public void closeSwipe(View view) {
        constraintSwipe.setVisibility(View.INVISIBLE);
        prefs.edit().putInt("FirstRunSwipeMainAcitivity", 0).apply();
    }
}
