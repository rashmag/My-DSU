package com.application.mydsu.Tutorial;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.application.mydsu.R;
import com.rd.PageIndicatorView;

public class FragmentMain extends AppCompatActivity {
    PageIndicatorView pageIndicatorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_main);

        pageIndicatorView = (PageIndicatorView) findViewById(R.id.pageIndicatorView);
        MyAdapter adapter = new MyAdapter(getSupportFragmentManager());

        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter); // устанавливаем адаптер
        viewPager.setCurrentItem(0); // выводим второй экран
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

    public static class MyAdapter extends FragmentPagerAdapter {
        MyAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 4;
        }

        @NonNull
        @Override
        public androidx.fragment.app.Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Fragment1();
                case 1:
                    return new Fragment2();
                case 2:
                    return new Fragment3();
                case 3:
                    return new FragmentEnd();
                default:
                    return new Fragment1();
            }
        }
    }
}