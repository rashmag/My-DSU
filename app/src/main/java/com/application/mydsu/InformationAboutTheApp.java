package com.application.mydsu;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.application.mydsu.Utils.Swipe;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class InformationAboutTheApp extends AppCompatActivity {
    private ConstraintLayout mainLayout;
    private ExpandableRelativeLayout mycontent1, mycontent2, mycontent3, mycontent4;
    private ImageView spinner_arrow, spinner_arrow2, spinner_arrow3, spinner_arrow4;
    private boolean flag_arrow = true;
    private boolean flag_arrow2 = true;
    private boolean flag_arrow3 = true;
    private boolean flag_arrow4 = true;
    private TextView cardNumber;
    private InterstitialAd mInterstitialAd;
    private static final String TAG = "myLog1";
    boolean flagTheme;
    private SharedPreferences prefsTheme = null;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_about_the_app);
        //Реклама
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this,"ca-app-pub-6029526207746824/8092402385", adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull com.google.android.gms.ads.interstitial.InterstitialAd interstitialAd) {
                // The mInterstitialAd reference will be null until
                // an ad is loaded.
                mInterstitialAd = interstitialAd;
                Log.i(TAG, "onAdLoaded");
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                // Handle the error
                Log.i(TAG, loadAdError.getMessage());
                mInterstitialAd = null;
            }
        });

        //ПРОВЕРЯЕМ КАКАЯ ТЕМА ВЫБРАНА
        prefsTheme = getSharedPreferences("Theme", MODE_PRIVATE);
        flagTheme = prefsTheme.getBoolean("lightAndDarkTheme", false);
        if(flagTheme){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        cardNumber = findViewById(R.id.cardNumber);
        mycontent1 = (ExpandableRelativeLayout) findViewById(R.id.mycontent1);
        mycontent1.expand();
        mycontent2 = (ExpandableRelativeLayout) findViewById(R.id.mycontent2);
        mycontent2.expand();
        mycontent3 = (ExpandableRelativeLayout) findViewById(R.id.mycontent3);
        mycontent3.expand();
        mycontent4 = (ExpandableRelativeLayout) findViewById(R.id.mycontent4);
        mycontent4.expand();
        mainLayout = (ConstraintLayout) findViewById(R.id.mainLayout);
        mainLayout.setOnTouchListener(new Swipe(InformationAboutTheApp.this) {
            @Override
            public void onSwipeRight() {
                Intent intent = new Intent(InformationAboutTheApp.this, MainActivity.class);
                startActivity(intent);
                fileList();
                overridePendingTransition(R.anim.diagonaltranslateleft,R.anim.alpha_one_zero);
                if(mInterstitialAd != null){
                    mInterstitialAd.show(InformationAboutTheApp.this);
                }else{
                }
            }
        });
    }

    //Скрываем Navigation Bar (кнопки)
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

    @Override
    protected void onStart() {
        super.onStart();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    public void mycontent1(View view) {
        spinner_arrow = findViewById(R.id.spinner_arrow);
        spinner_arrow2 = findViewById(R.id.spinner_arrow2);
        spinner_arrow3 = findViewById(R.id.spinner_arrow3);
        spinner_arrow4 = findViewById(R.id.spinner_arrow4);
        switch (view.getId()) {
            case R.id.textView10:
                mycontent1.toggle();
                if (flag_arrow) {
                    spinner_arrow.setRotation(180);
                    flag_arrow = false;
                } else if (!flag_arrow) {
                    if(!mycontent2.isExpanded() && !mycontent3.isExpanded() && !mycontent4.isExpanded()){
                    }
                    spinner_arrow.setRotation(0);
                    flag_arrow = true;
                }
                break;
            case R.id.spinner_arrow:
                mycontent1.toggle();
                if (flag_arrow) {
                    spinner_arrow.setRotation(180);
                    flag_arrow = false;
                } else if (!flag_arrow) {
                    if(!mycontent2.isExpanded() && !mycontent3.isExpanded() && !mycontent4.isExpanded()){
                    }
                    spinner_arrow.setRotation(0);
                    flag_arrow = true;
                }
                break;
            case R.id.textView12:
                mycontent2.toggle();
                if (flag_arrow2) {
                    spinner_arrow2.setRotation(180);
                    flag_arrow2 = false;
                } else if (!flag_arrow2) {
                    if(!mycontent1.isExpanded() && !mycontent3.isExpanded() && !mycontent4.isExpanded()){
                    }
                    spinner_arrow2.setRotation(0);
                    flag_arrow2 = true;
                }
                break;
            case R.id.spinner_arrow2:
                mycontent2.toggle();
                if (flag_arrow2) {
                    spinner_arrow2.setRotation(180);
                    flag_arrow2 = false;
                } else if (!flag_arrow2) {
                    if(!mycontent1.isExpanded() && !mycontent3.isExpanded() && !mycontent4.isExpanded()){
                    }
                    spinner_arrow2.setRotation(0);
                    flag_arrow2 = true;
                }
                break;
            case R.id.textView16:
                mycontent3.toggle();
                if (flag_arrow3) {
                    spinner_arrow3.setRotation(180);
                    flag_arrow3 = false;
                } else if (!flag_arrow3) {
                    if(!mycontent1.isExpanded() && !mycontent2.isExpanded() && !mycontent4.isExpanded()){
                    }
                    spinner_arrow3.setRotation(0);
                    flag_arrow3 = true;
                }
                break;
            case R.id.spinner_arrow3:
                mycontent3.toggle();
                if (flag_arrow3) {
                    spinner_arrow3.setRotation(180);
                    flag_arrow3 = false;
                } else if (!flag_arrow3) {
                    if(!mycontent1.isExpanded() && !mycontent2.isExpanded() && !mycontent4.isExpanded()){
                    }
                    spinner_arrow3.setRotation(0);
                    flag_arrow3 = true;
                }
                break;
            case R.id.textView18:
                mycontent4.toggle();
                if (flag_arrow4) {
                    spinner_arrow4.setRotation(180);
                    flag_arrow4 = false;
                } else if (!flag_arrow4) {
                    if(!mycontent1.isExpanded() && !mycontent2.isExpanded() && !mycontent3.isExpanded()){
                    }
                    spinner_arrow4.setRotation(0);
                    flag_arrow4 = true;
                }
                break;
            case R.id.spinner_arrow4:
                mycontent4.toggle();
                if (flag_arrow4) {
                    spinner_arrow4.setRotation(180);
                    flag_arrow4 = false;
                } else if (!flag_arrow4) {
                    if(!mycontent1.isExpanded() && !mycontent2.isExpanded() && !mycontent3.isExpanded()){
                    }
                    spinner_arrow4.setRotation(0);
                    flag_arrow4 = true;
                }
                break;
        }
    }

    public void copiedText(View view) {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("", cardNumber.getText().toString());
        clipboard.setPrimaryClip(clip);
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_form_dark,
                (ViewGroup) findViewById(R.id.custom_toast_container));

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL,0,300);
        toast.show();
    }

    //СИСТЕМНАЯ КНОПКА НАЗАД - НАЧАЛО
    @Override
    public void onBackPressed() {
        Intent intentBack = new Intent(this, MainActivity.class);
        startActivity(intentBack);
        finish();
        overridePendingTransition(R.anim.alpha_zero_one, R.anim.alpha_one_zero);
        if(mInterstitialAd != null){
            mInterstitialAd.show(InformationAboutTheApp.this);
        }else{
        }
    }
}