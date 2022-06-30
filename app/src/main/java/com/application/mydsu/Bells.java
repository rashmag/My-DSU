package com.application.mydsu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.application.mydsu.Utils.Swipe;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Bells extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private TextView nameSchedule, surNameSchedule, course, sobgroup, textview, remainingTime, textRemained;
    private String setElementSpinnerCource, elementSpinnerSubgroupCource, elementSpinnerDirection;
    private static final long START_TIME_IN_MILLIS = 600000;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;
    private Calendar calendar;
    boolean flagTheme;
    private SharedPreferences prefsTheme = null;
    private ConstraintLayout main_layout;

    private final int SEC = 1 * 1000;
    private final int MIN = 60 * SEC;
    private GregorianCalendar date;

    @SuppressLint({"SetTextI18n", "ClickableViewAccessibility"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bells);
        //ПРОВЕРЯЕМ КАКАЯ ТЕМА ВЫБРАНА
        prefsTheme = getSharedPreferences("Theme", MODE_PRIVATE);
        flagTheme = prefsTheme.getBoolean("lightAndDarkTheme", false);
        if(flagTheme){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        //Обробатываем свайп
        main_layout = (ConstraintLayout) findViewById(R.id.main_layout);
        main_layout.setOnTouchListener(new Swipe(Bells.this) {
            @Override
            public void onSwipeRight() {
                Intent intent = new Intent(Bells.this, Schedule.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.diagonaltranslateleft,R.anim.alpha_one_zero);
            }
        });
        //ОПРЕДЕЛЯЕМ ЭЛЕМЕНТЫ
        findElements();
        calendar = Calendar.getInstance();
        int sunday = calendar.get(Calendar.DAY_OF_WEEK);
        if (sunday == Calendar.SUNDAY) {
            remainingTime.setVisibility(View.GONE);
            textRemained.setText("Сегодня выходной :)");
        } else {
            chekedTime();
        }
        //ПОЛУЧАЕМ И УСТОНАВЛИВАЕМ ДАННЫЕ В userName и surName
        sharedPreferences = getSharedPreferences("userdata", Context.MODE_PRIVATE);
        String setUserName = sharedPreferences.getString("setUserName", "");
        String setUserSurName = sharedPreferences.getString("setUserSurName", "");
        setElementSpinnerCource = sharedPreferences.getString("setElementSpinnerCource", "");
        elementSpinnerSubgroupCource = sharedPreferences.getString("elementSpinnerSubgroupCource", "");

        nameSchedule.setText(setUserName);
        surNameSchedule.setText(setUserSurName);
        course.setText(setElementSpinnerCource + " курс, ");
        sobgroup.setText(elementSpinnerSubgroupCource + " группа");
    }

    //Определяем какое время
    private void chekedTime() {
        date = new GregorianCalendar();

        int hours = date.get(date.HOUR_OF_DAY); //date.getHours();
        int min = date.get(date.MINUTE); //date.getMinutes();
        int sec = date.get(date.SECOND); //date.getSeconds();
        String[] text = new String[2];

        GregorianCalendar date1start = new GregorianCalendar();
        //  date1start.clear();
        date1start.set(Calendar.HOUR_OF_DAY, 8);
        date1start.set(Calendar.MINUTE, 29);

        GregorianCalendar date1end = new GregorianCalendar();
        //    date1end.clear();
        date1end.set(Calendar.HOUR_OF_DAY, 9);
        date1end.set(Calendar.MINUTE, 15);
        date1end.set(Calendar.SECOND, 0);

        GregorianCalendar date2start = new GregorianCalendar();
        //      date2start.clear();
        date2start.set(Calendar.HOUR_OF_DAY, 9);
        date2start.set(Calendar.MINUTE, 19);

        GregorianCalendar date2end = new GregorianCalendar();
        //      date2end.clear();
        date2end.set(Calendar.HOUR_OF_DAY, 10);
        date2end.set(Calendar.MINUTE, 5);
        date2end.set(Calendar.SECOND, 0);

        GregorianCalendar date3start = new GregorianCalendar();
        //      date3start.clear();
        date3start.set(Calendar.HOUR_OF_DAY, 10);
        date3start.set(Calendar.MINUTE, 14);

        GregorianCalendar date3end = new GregorianCalendar();
        //       date3end.clear();
        date3end.set(Calendar.HOUR_OF_DAY, 11);
        date3end.set(Calendar.MINUTE, 0);
        date3end.set(Calendar.SECOND, 0);

        GregorianCalendar date4start = new GregorianCalendar();
        //       date4start.clear();
        date4start.set(Calendar.HOUR_OF_DAY, 11);
        date4start.set(Calendar.MINUTE, 4);

        GregorianCalendar date4end = new GregorianCalendar();
        //       date4end.clear();
        date4end.set(Calendar.HOUR_OF_DAY, 11);
        date4end.set(Calendar.MINUTE, 50);
        date4end.set(Calendar.SECOND, 0);

        GregorianCalendar date5start = new GregorianCalendar();
        //       date5start.clear();
        date5start.set(Calendar.HOUR_OF_DAY, 12);
        date5start.set(Calendar.MINUTE, 19);

        GregorianCalendar date5end = new GregorianCalendar();
        //       date5end.clear();
        date5end.set(Calendar.HOUR_OF_DAY, 13);
        date5end.set(Calendar.MINUTE, 5);
        date5end.set(Calendar.SECOND, 0);

        GregorianCalendar date6start = new GregorianCalendar();
        //       date6start.clear();
        date6start.set(Calendar.HOUR_OF_DAY, 13);
        date6start.set(Calendar.MINUTE, 9);

        GregorianCalendar date6end = new GregorianCalendar();
        //      date6end.clear();
        date6end.set(Calendar.HOUR_OF_DAY, 13);
        date6end.set(Calendar.MINUTE, 55);
        date6end.set(Calendar.SECOND, 0);

        GregorianCalendar date7start = new GregorianCalendar();
        //      date7start.clear();
        date7start.set(Calendar.HOUR_OF_DAY, 13);
        date7start.set(Calendar.MINUTE, 59);

        GregorianCalendar date7end = new GregorianCalendar();
        //      date7end.clear();
        date7end.set(Calendar.HOUR_OF_DAY, 15);
        date7end.set(Calendar.MINUTE, 20);

        GregorianCalendar date8start = new GregorianCalendar();
        //      date8start.clear();
        date8start.set(Calendar.HOUR_OF_DAY, 15);
        date8start.set(Calendar.MINUTE, 29);

        GregorianCalendar date8end = new GregorianCalendar();
        //      date8end.clear();
        date8end.set(Calendar.HOUR_OF_DAY, 16);
        date8end.set(Calendar.MINUTE, 40);

        GregorianCalendar date9start = new GregorianCalendar();
        //      date9start.clear();
        date9start.set(Calendar.HOUR_OF_DAY, 16);
        date9start.set(Calendar.MINUTE, 49);

        GregorianCalendar date9end = new GregorianCalendar();
        //      date9end.clear();
        date9end.set(Calendar.HOUR_OF_DAY, 18);
        date9end.set(Calendar.MINUTE, 0);
        date9end.set(Calendar.SECOND, 0);
//
//        if (hours > 18) {
//            remainingTime.setVisibility(View.GONE);
//            textRemained.setText("Пары закончились.");
//            textRemained.setTextSize(14);
//        }
        if (hours >= 18) {
            remainingTime.setVisibility(View.GONE);
            textRemained.setText("Пары закончились.");
            textRemained.setTextSize(14);
        }
        if((hours <= 7) & (min <= 59)){
            remainingTime.setVisibility(View.GONE);
            textRemained.setVisibility(View.GONE);
        }
        if (((hours == 8) & (min <= 29))) {
            remainingTime.setVisibility(View.GONE);
            textRemained.setText("Занятия еще не начались.");
            textRemained.setTextSize(14);
        }
        //обработка окончания 1 часа
        if (date.after(date1start) & date.before(date1end)) {
            textRemained.setText("осталось до конца пары");
            long dif = date1end.getTimeInMillis() - date.getTimeInMillis();
            new CountDownTimer(dif, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    mTimeLeftInMillis = millisUntilFinished;
                    updateCountDownText();
                }

                @Override
                public void onFinish() {
                    chekedTime();
                }
            }.start();

        }


        //обработка окончания 2 часа
        if (date.after(date2start) & date.before(date2end)) {
            textRemained.setText("осталось до конца пары");
            long dif = date2end.getTimeInMillis() - date.getTimeInMillis();
            new CountDownTimer(dif, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    mTimeLeftInMillis = millisUntilFinished;
                    updateCountDownText();
                }

                @Override
                public void onFinish() {
                    chekedTime();
                }
            }.start();
        }

        //обработка окончания 3 часа
        if (date.after(date3start) & date.before(date3end)) {
            textRemained.setText("осталось до конца пары");
            long dif = date3end.getTimeInMillis() - date.getTimeInMillis();
            new CountDownTimer(dif, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    mTimeLeftInMillis = millisUntilFinished;
                    updateCountDownText();
                }

                @Override
                public void onFinish() {
                    chekedTime();
                }
            }.start();
        }

        //обработка окончания 4 часа
        if (date.after(date4start) & date.before(date4end)) {
            textRemained.setText("осталось до конца пары");
            long dif = date4end.getTimeInMillis() - date.getTimeInMillis();
            new CountDownTimer(dif, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    mTimeLeftInMillis = millisUntilFinished;
                    updateCountDownText();
                }

                @Override
                public void onFinish() {
                    chekedTime();
                }
            }.start();
        }

        //обработка окончания 5 часа
        if (date.after(date5start) & date.before(date5end)) {
            textRemained.setText("осталось до конца пары");
            long dif = date5end.getTimeInMillis() - date.getTimeInMillis();
            new CountDownTimer(dif, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    mTimeLeftInMillis = millisUntilFinished;
                    updateCountDownText();
                }

                @Override
                public void onFinish() {
                    chekedTime();
                }
            }.start();
        }

        //обработка окончания 6 часа
        if (date.after(date6start) & date.before(date6end)) {
            textRemained.setText("осталось до конца пары");
            long dif = date6end.getTimeInMillis() - date.getTimeInMillis();
            new CountDownTimer(dif, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    mTimeLeftInMillis = millisUntilFinished;
                    updateCountDownText();
                }

                @Override
                public void onFinish() {
                    chekedTime();
                }
            }.start();
        }

        //обработка окончания 7 часа
        if (date.after(date7start) & date.before(date7end)) {
            textRemained.setText("осталось до конца пары");
            long dif = date7end.getTimeInMillis() - date.getTimeInMillis();
            new CountDownTimer(dif, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    mTimeLeftInMillis = millisUntilFinished;
                    updateCountDownText();
                }

                @Override
                public void onFinish() {
                    chekedTime();
                }
            }.start();
        }
        //обработка окончания 8 часа
        if (date.after(date8start) & date.before(date8end)) {
            textRemained.setText("осталось до конца пары");
            long dif = date8end.getTimeInMillis() - date.getTimeInMillis();
            new CountDownTimer(dif, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    mTimeLeftInMillis = millisUntilFinished;
                    updateCountDownText();
                }

                @Override
                public void onFinish() {
                    chekedTime();
                }
            }.start();
        }
        //обработка окончания 9 часа
        if (date.after(date9start) & date.before(date9end)) {
            textRemained.setText("осталось до конца пары");
            long dif = date9end.getTimeInMillis() - date.getTimeInMillis();
            new CountDownTimer(dif, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    mTimeLeftInMillis = millisUntilFinished;
                    updateCountDownText();
                }

                @Override
                public void onFinish() {
                    chekedTime();
                }
            }.start();
        }

        //GregorianCalendar для перемен
        //Для 1 и 2 часа
        GregorianCalendar date1endPeremena = new GregorianCalendar();
        //    date1end.clear();
        date1endPeremena.set(Calendar.HOUR_OF_DAY, 9);
        date1endPeremena.set(Calendar.MINUTE, 14);

        GregorianCalendar date2startPeremena = new GregorianCalendar();
        //      date2start.clear();
        date2startPeremena.set(Calendar.HOUR_OF_DAY, 9);
        date2startPeremena.set(Calendar.MINUTE, 20);
        //Для 2 и 3 часа
        GregorianCalendar date2endPeremena = new GregorianCalendar();
        //    date1end.clear();
        date2endPeremena.set(Calendar.HOUR_OF_DAY, 10);
        date2endPeremena.set(Calendar.MINUTE, 04);

        GregorianCalendar date3startPeremena = new GregorianCalendar();
        //      date2start.clear();
        date3startPeremena.set(Calendar.HOUR_OF_DAY, 10);
        date3startPeremena.set(Calendar.MINUTE, 15);
        //Для 3 и 4 часа
        GregorianCalendar date3endPeremena = new GregorianCalendar();
        //       date3end.clear();
        date3endPeremena.set(Calendar.HOUR_OF_DAY, 10);
        date3endPeremena.set(Calendar.MINUTE, 59);

        GregorianCalendar date4startPeremena = new GregorianCalendar();
        //       date4start.clear();
        date4startPeremena.set(Calendar.HOUR_OF_DAY, 11);
        date4startPeremena.set(Calendar.MINUTE, 5);
        //Для 4 и 5 часа
        GregorianCalendar date4endPeremena = new GregorianCalendar();
        //       date3end.clear();
        date4endPeremena.set(Calendar.HOUR_OF_DAY, 11);
        date4endPeremena.set(Calendar.MINUTE, 49);

        GregorianCalendar date5startPeremena = new GregorianCalendar();
        //       date4start.clear();
        date5startPeremena.set(Calendar.HOUR_OF_DAY, 12);
        date5startPeremena.set(Calendar.MINUTE, 20);
        //Для 5 и 6 часа
        GregorianCalendar date5endPeremena = new GregorianCalendar();
        //       date5end.clear();
        date5endPeremena.set(Calendar.HOUR_OF_DAY, 13);
        date5endPeremena.set(Calendar.MINUTE, 4);

        GregorianCalendar date6startPeremena = new GregorianCalendar();
        //       date6start.clear();
        date6startPeremena.set(Calendar.HOUR_OF_DAY, 13);
        date6startPeremena.set(Calendar.MINUTE, 10);
        //Для 6 и 7 часа
        GregorianCalendar date6endPeremena = new GregorianCalendar();
        //       date5end.clear();
        date6endPeremena.set(Calendar.HOUR_OF_DAY, 13);
        date6endPeremena.set(Calendar.MINUTE, 54);

        GregorianCalendar date7startPeremena = new GregorianCalendar();
        //       date6start.clear();
        date7startPeremena.set(Calendar.HOUR_OF_DAY, 14);
        date7startPeremena.set(Calendar.MINUTE, 10);
        //Для 7 и 8 часа
        GregorianCalendar date7endPeremena = new GregorianCalendar();
        //      date7end.clear();
        date7endPeremena.set(Calendar.HOUR_OF_DAY, 15);
        date7endPeremena.set(Calendar.MINUTE, 19);

        GregorianCalendar date8startPeremena = new GregorianCalendar();
        //      date7start.clear();
        date8startPeremena.set(Calendar.HOUR_OF_DAY, 15);
        date8startPeremena.set(Calendar.MINUTE, 30);
        //Для 8 и 9 часа
        GregorianCalendar date8endPeremena = new GregorianCalendar();
        //      date7end.clear();
        date8endPeremena.set(Calendar.HOUR_OF_DAY, 16);
        date8endPeremena.set(Calendar.MINUTE, 39);

        GregorianCalendar date9startPeremena = new GregorianCalendar();
        //      date7start.clear();
        date9startPeremena.set(Calendar.HOUR_OF_DAY, 16);
        date9startPeremena.set(Calendar.MINUTE, 50);

        //Обработка перемены между 1 и 2 часом
        if (date.after(date1endPeremena) & date.before(date2startPeremena)) {
            textRemained.setText("осталось до конца перемены");
            long dif = date2startPeremena.getTimeInMillis() - date.getTimeInMillis();
            new CountDownTimer(dif, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    mTimeLeftInMillis = millisUntilFinished;
                    updateCountDownText();
                }

                @Override
                public void onFinish() {
                    chekedTime();
                }
            }.start();
        }
        //Обработка перемены между 2 и 3 часом
        if (date.after(date2endPeremena) & date.before(date3startPeremena)) {
            textRemained.setText("осталось до конца перемены");
            long dif = date3startPeremena.getTimeInMillis() - date.getTimeInMillis();
            new CountDownTimer(dif, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    mTimeLeftInMillis = millisUntilFinished;
                    updateCountDownText();
                }

                @Override
                public void onFinish() {
                    chekedTime();
                }
            }.start();
        }
        //Обработка перемены между 3 и 4 часом
        if (date.after(date3endPeremena) & date.before(date4startPeremena)) {
            textRemained.setText("осталось до конца перемены");
            long dif = date4startPeremena.getTimeInMillis() - date.getTimeInMillis();
            new CountDownTimer(dif, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    mTimeLeftInMillis = millisUntilFinished;
                    updateCountDownText();
                }

                @Override
                public void onFinish() {
                    chekedTime();
                }
            }.start();

        }
        //Обработка перемены между 4 и 5 часом
        if (date.after(date4endPeremena) & date.before(date5startPeremena)) {
            textRemained.setText("осталось до конца перемены");
            long dif = date5startPeremena.getTimeInMillis() - date.getTimeInMillis();
            new CountDownTimer(dif, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    mTimeLeftInMillis = millisUntilFinished;
                    updateCountDownText();
                }

                @Override
                public void onFinish() {
                    chekedTime();
                }
            }.start();

        }
        //Обработка перемены между 5 и 6 часом
        if (date.after(date5endPeremena) & date.before(date6startPeremena)) {
            textRemained.setText("осталось до конца перемены");
            long dif = date6startPeremena.getTimeInMillis() - date.getTimeInMillis();
            new CountDownTimer(dif, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    mTimeLeftInMillis = millisUntilFinished;
                    updateCountDownText();
                }

                @Override
                public void onFinish() {
                    chekedTime();
                }
            }.start();

        }
        //Обработка перемены между 6 и 7 часом
        if (date.after(date6endPeremena) & date.before(date7startPeremena)) {
            textRemained.setText("осталось до конца перемены");
            long dif = date7startPeremena.getTimeInMillis() - date.getTimeInMillis();
            new CountDownTimer(dif, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    mTimeLeftInMillis = millisUntilFinished;
                    updateCountDownText();
                }

                @Override
                public void onFinish() {
                    chekedTime();
                }
            }.start();

        }
        //Обработка перемены между 7 и 8 часом
        if (date.after(date7endPeremena) & date.before(date8startPeremena)) {
            textRemained.setText("осталось до конца перемены");
            long dif = date8startPeremena.getTimeInMillis() - date.getTimeInMillis();
            new CountDownTimer(dif, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    mTimeLeftInMillis = millisUntilFinished;
                    updateCountDownText();
                }

                @Override
                public void onFinish() {
                    chekedTime();
                }
            }.start();

        }
        //Обработка перемены между 8 и 9 часом
        if (date.after(date8endPeremena) & date.before(date9startPeremena)) {
            textRemained.setText("осталось до конца перемены");
            long dif = date9startPeremena.getTimeInMillis() - date.getTimeInMillis();
            new CountDownTimer(dif, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    mTimeLeftInMillis = millisUntilFinished;
                    updateCountDownText();
                }

                @Override
                public void onFinish() {
                    chekedTime();
                }
            }.start();
        }
    }

    //Находим элементы
    private void findElements() {
        course = findViewById(R.id.course);
        sobgroup = findViewById(R.id.sobgroup);
        textRemained = findViewById(R.id.textRemained);
        remainingTime = findViewById(R.id.remainingTime);
        nameSchedule = findViewById(R.id.nameSchedule);
        surNameSchedule = findViewById(R.id.surNameSchedule);
    }

    //Кнопка назад
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Bells.this, Schedule.class));
        finish();
        overridePendingTransition(R.anim.alpha_zero_one,R.anim.alpha_one_zero);
    }

    //Устонавливает отсчёт времени на remainingTime
    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60 % 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;
        int hours = (int) (mTimeLeftInMillis / 3600000);
        if (hours == 0) {
            String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
            remainingTime.setText(timeLeftFormatted);
        } else {
            String timeLeftFormatted = String.format(Locale.getDefault(), "%01d:%02d:%02d", hours, minutes, seconds);
            remainingTime.setText(timeLeftFormatted);
        }
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