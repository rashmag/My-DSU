package com.application.mydsu;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

import com.application.mydsu.HomeWork.HomeWork;
import com.application.mydsu.Utils.Swipe;
import com.application.mydsu.putSchedule.SettingSchedule;

import java.util.Calendar;

public class Schedule extends AppCompatActivity {
    private SharedPreferences prefs = null;
    private final String LOG_TAG = "myLogs";
    private Button buttonDefault, btnWeekDay1, btnWeekDay2, btnWeekDay3, btnWeekDay4, btnWeekDay5, btnWeekDay6,
            btnWeekDay8, btnWeekDay9, btnWeekDay10, btnWeekDay11, btnWeekDay12, btnWeekDay13,
            buttonWeekOne, buttonWeekTwo;
    private SharedPreferences sharedPreferences;
    private ScrollView scrollView;
    private Calendar calendar, maxDayOfMonth;
    private TextView nameSchedule, surNameSchedule, course, sobgroup, tochka, tochka2, form_lessons_sunday, form_lessons_sunday_text;
    private LinearLayout linearLayout1, linearLayout2, linearLayout3, linearLayout4, linearLayout5,
            linearLayout6, linearLayout8, linearLayout9, linearLayout10, linearLayout11,
            linearLayout12, linearLayout13, groupsButton1, groupsButton2;
    private ImageView imageReady, pencilImage, imageBell, imageBellRealy, imageEllipse, imageEllipse2;
    private AnimatedVectorDrawableCompat avd;
    private AnimatedVectorDrawable avd2;
    private ConstraintLayout main_layout;
    boolean flagTheme;
    private SharedPreferences prefsTheme = null;
    private ImageView btnHomewWork;
    private int dayOfMonth, dayOfMonthMax, dayOfMonthMinus1, dayOfMonthMinus2, dayOfMonthMinus3, dayOfMonthMinus4, dayOfMonthMinus5,
            dayOfMonthMinus6, dayOfMonthMinus7, dayOfMonthMinus8, dayOfMonthMinus9, dayOfMonthMinus10,
            dayOfMonthMinus11, dayOfMonthMinus12, dayOfMonthMinus13, dayOfMonthPlus1, dayOfMonthPlus2, dayOfMonthPlus3, dayOfMonthPlus4, dayOfMonthPlus5,
            dayOfMonthPlus6, dayOfMonthPlus7, dayOfMonthPlus8, dayOfMonthPlus9, dayOfMonthPlus10,
            dayOfMonthPlus11, dayOfMonthPlus12, dayOfMonthPlus13;
    private String setUserName, setUserSurName, setElementSpinnerCource,
            elementSpinnerSubgroupCource, elementSpinnerDirection;

    //1 ДЕНЬ
    EditText editTextLesson11, editTextAuditores11, editTextTeacher11,
            editTextLesson12, editTextAuditores12, editTextTeacher12,
            editTextLesson13, editTextAuditores13, editTextTeacher13,
            editTextLesson14, editTextAuditores14, editTextTeacher14,
            editTextLesson15, editTextAuditores15, editTextTeacher15,
            editTextLesson16, editTextAuditores16, editTextTeacher16;
//            editTextLesson17, editTextAuditores17, editTextTeacher17;

    String editTextLessonDB1, editTextAuditoresDB1, editTextTeacherDB1,
            editTextLessonDB2, editTextAuditoresDB2, editTextTeacherDB2,
            editTextLessonDB3, editTextAuditoresDB3, editTextTeacherDB3,
            editTextLessonDB4, editTextAuditoresDB4, editTextTeacherDB4,
            editTextLessonDB5, editTextAuditoresDB5, editTextTeacherDB5,
            editTextLessonDB6, editTextAuditoresDB6, editTextTeacherDB6;
    //2 ДЕНЬ
    EditText editTextLesson21, editTextAuditores21, editTextTeacher21,
            editTextLesson22, editTextAuditores22, editTextTeacher22,
            editTextLesson23, editTextAuditores23, editTextTeacher23,
            editTextLesson24, editTextAuditores24, editTextTeacher24,
            editTextLesson25, editTextAuditores25, editTextTeacher25,
            editTextLesson26, editTextAuditores26, editTextTeacher26;

    String editTextLessonDB21, editTextAuditoresDB21, editTextTeacherDB21,
            editTextLessonDB22, editTextAuditoresDB22, editTextTeacherDB22,
            editTextLessonDB23, editTextAuditoresDB23, editTextTeacherDB23,
            editTextLessonDB24, editTextAuditoresDB24, editTextTeacherDB24,
            editTextLessonDB25, editTextAuditoresDB25, editTextTeacherDB25,
            editTextLessonDB26, editTextAuditoresDB26, editTextTeacherDB26;
    //3 ДЕНЬ
    EditText editTextLesson31, editTextAuditores31, editTextTeacher31,
            editTextLesson32, editTextAuditores32, editTextTeacher32,
            editTextLesson33, editTextAuditores33, editTextTeacher33,
            editTextLesson34, editTextAuditores34, editTextTeacher34,
            editTextLesson35, editTextAuditores35, editTextTeacher35,
            editTextLesson36, editTextAuditores36, editTextTeacher36;

    String editTextLessonDB31, editTextAuditoresDB31, editTextTeacherDB31,
            editTextLessonDB32, editTextAuditoresDB32, editTextTeacherDB32,
            editTextLessonDB33, editTextAuditoresDB33, editTextTeacherDB33,
            editTextLessonDB34, editTextAuditoresDB34, editTextTeacherDB34,
            editTextLessonDB35, editTextAuditoresDB35, editTextTeacherDB35,
            editTextLessonDB36, editTextAuditoresDB36, editTextTeacherDB36;
    //4 ДЕНЬ
    EditText editTextLesson41, editTextAuditores41, editTextTeacher41,
            editTextLesson42, editTextAuditores42, editTextTeacher42,
            editTextLesson43, editTextAuditores43, editTextTeacher43,
            editTextLesson44, editTextAuditores44, editTextTeacher44,
            editTextLesson45, editTextAuditores45, editTextTeacher45,
            editTextLesson46, editTextAuditores46, editTextTeacher46;

    String editTextLessonDB41, editTextAuditoresDB41, editTextTeacherDB41,
            editTextLessonDB42, editTextAuditoresDB42, editTextTeacherDB42,
            editTextLessonDB43, editTextAuditoresDB43, editTextTeacherDB43,
            editTextLessonDB44, editTextAuditoresDB44, editTextTeacherDB44,
            editTextLessonDB45, editTextAuditoresDB45, editTextTeacherDB45,
            editTextLessonDB46, editTextAuditoresDB46, editTextTeacherDB46;
    //5 ДЕНЬ
    EditText editTextLesson51, editTextAuditores51, editTextTeacher51,
            editTextLesson52, editTextAuditores52, editTextTeacher52,
            editTextLesson53, editTextAuditores53, editTextTeacher53,
            editTextLesson54, editTextAuditores54, editTextTeacher54,
            editTextLesson55, editTextAuditores55, editTextTeacher55,
            editTextLesson56, editTextAuditores56, editTextTeacher56;

    String editTextLessonDB51, editTextAuditoresDB51, editTextTeacherDB51,
            editTextLessonDB52, editTextAuditoresDB52, editTextTeacherDB52,
            editTextLessonDB53, editTextAuditoresDB53, editTextTeacherDB53,
            editTextLessonDB54, editTextAuditoresDB54, editTextTeacherDB54,
            editTextLessonDB55, editTextAuditoresDB55, editTextTeacherDB55,
            editTextLessonDB56, editTextAuditoresDB56, editTextTeacherDB56;
    //6 ДЕНЬ
    EditText editTextLesson61, editTextAuditores61, editTextTeacher61,
            editTextLesson62, editTextAuditores62, editTextTeacher62,
            editTextLesson63, editTextAuditores63, editTextTeacher63,
            editTextLesson64, editTextAuditores64, editTextTeacher64,
            editTextLesson65, editTextAuditores65, editTextTeacher65,
            editTextLesson66, editTextAuditores66, editTextTeacher66;

    String editTextLessonDB61, editTextAuditoresDB61, editTextTeacherDB61,
            editTextLessonDB62, editTextAuditoresDB62, editTextTeacherDB62,
            editTextLessonDB63, editTextAuditoresDB63, editTextTeacherDB63,
            editTextLessonDB64, editTextAuditoresDB64, editTextTeacherDB64,
            editTextLessonDB65, editTextAuditoresDB65, editTextTeacherDB65,
            editTextLessonDB66, editTextAuditoresDB66, editTextTeacherDB66;
    //8 ДЕНЬ
    EditText editTextLesson81, editTextAuditores81, editTextTeacher81,
            editTextLesson82, editTextAuditores82, editTextTeacher82,
            editTextLesson83, editTextAuditores83, editTextTeacher83,
            editTextLesson84, editTextAuditores84, editTextTeacher84,
            editTextLesson85, editTextAuditores85, editTextTeacher85,
            editTextLesson86, editTextAuditores86, editTextTeacher86;

    String editTextLessonDB81, editTextAuditoresDB81, editTextTeacherDB81,
            editTextLessonDB82, editTextAuditoresDB82, editTextTeacherDB82,
            editTextLessonDB83, editTextAuditoresDB83, editTextTeacherDB83,
            editTextLessonDB84, editTextAuditoresDB84, editTextTeacherDB84,
            editTextLessonDB85, editTextAuditoresDB85, editTextTeacherDB85,
            editTextLessonDB86, editTextAuditoresDB86, editTextTeacherDB86;
    //9 ДЕНЬ
    EditText editTextLesson91, editTextAuditores91, editTextTeacher91,
            editTextLesson92, editTextAuditores92, editTextTeacher92,
            editTextLesson93, editTextAuditores93, editTextTeacher93,
            editTextLesson94, editTextAuditores94, editTextTeacher94,
            editTextLesson95, editTextAuditores95, editTextTeacher95,
            editTextLesson96, editTextAuditores96, editTextTeacher96;

    String editTextLessonDB91, editTextAuditoresDB91, editTextTeacherDB91,
            editTextLessonDB92, editTextAuditoresDB92, editTextTeacherDB92,
            editTextLessonDB93, editTextAuditoresDB93, editTextTeacherDB93,
            editTextLessonDB94, editTextAuditoresDB94, editTextTeacherDB94,
            editTextLessonDB95, editTextAuditoresDB95, editTextTeacherDB95,
            editTextLessonDB96, editTextAuditoresDB96, editTextTeacherDB96;
    //10 ДЕНЬ
    EditText editTextLesson101, editTextAuditores101, editTextTeacher101,
            editTextLesson102, editTextAuditores102, editTextTeacher102,
            editTextLesson103, editTextAuditores103, editTextTeacher103,
            editTextLesson104, editTextAuditores104, editTextTeacher104,
            editTextLesson105, editTextAuditores105, editTextTeacher105,
            editTextLesson106, editTextAuditores106, editTextTeacher106;

    String editTextLessonDB101, editTextAuditoresDB101, editTextTeacherDB101,
            editTextLessonDB102, editTextAuditoresDB102, editTextTeacherDB102,
            editTextLessonDB103, editTextAuditoresDB103, editTextTeacherDB103,
            editTextLessonDB104, editTextAuditoresDB104, editTextTeacherDB104,
            editTextLessonDB105, editTextAuditoresDB105, editTextTeacherDB105,
            editTextLessonDB106, editTextAuditoresDB106, editTextTeacherDB106;
    //11 ДЕНЬ
    EditText editTextLesson111, editTextAuditores111, editTextTeacher111,
            editTextLesson112, editTextAuditores112, editTextTeacher112,
            editTextLesson113, editTextAuditores113, editTextTeacher113,
            editTextLesson114, editTextAuditores114, editTextTeacher114,
            editTextLesson115, editTextAuditores115, editTextTeacher115,
            editTextLesson116, editTextAuditores116, editTextTeacher116;

    String editTextLessonDB111, editTextAuditoresDB111, editTextTeacherDB111,
            editTextLessonDB112, editTextAuditoresDB112, editTextTeacherDB112,
            editTextLessonDB113, editTextAuditoresDB113, editTextTeacherDB113,
            editTextLessonDB114, editTextAuditoresDB114, editTextTeacherDB114,
            editTextLessonDB115, editTextAuditoresDB115, editTextTeacherDB115,
            editTextLessonDB116, editTextAuditoresDB116, editTextTeacherDB116;
    //12 ДЕНЬ

    EditText editTextLesson121, editTextAuditores121, editTextTeacher121,
            editTextLesson122, editTextAuditores122, editTextTeacher122,
            editTextLesson123, editTextAuditores123, editTextTeacher123,
            editTextLesson124, editTextAuditores124, editTextTeacher124,
            editTextLesson125, editTextAuditores125, editTextTeacher125,
            editTextLesson126, editTextAuditores126, editTextTeacher126;

    String editTextLessonDB121, editTextAuditoresDB121, editTextTeacherDB121,
            editTextLessonDB122, editTextAuditoresDB122, editTextTeacherDB122,
            editTextLessonDB123, editTextAuditoresDB123, editTextTeacherDB123,
            editTextLessonDB124, editTextAuditoresDB124, editTextTeacherDB124,
            editTextLessonDB125, editTextAuditoresDB125, editTextTeacherDB125,
            editTextLessonDB126, editTextAuditoresDB126, editTextTeacherDB126;
    //13 ДЕНЬ

    EditText editTextLesson131, editTextAuditores131, editTextTeacher131,
            editTextLesson132, editTextAuditores132, editTextTeacher132,
            editTextLesson133, editTextAuditores133, editTextTeacher133,
            editTextLesson134, editTextAuditores134, editTextTeacher134,
            editTextLesson135, editTextAuditores135, editTextTeacher135,
            editTextLesson136, editTextAuditores136, editTextTeacher136;

    String editTextLessonDB131, editTextAuditoresDB131, editTextTeacherDB131,
            editTextLessonDB132, editTextAuditoresDB132, editTextTeacherDB132,
            editTextLessonDB133, editTextAuditoresDB133, editTextTeacherDB133,
            editTextLessonDB134, editTextAuditoresDB134, editTextTeacherDB134,
            editTextLessonDB135, editTextAuditoresDB135, editTextTeacherDB135,
            editTextLessonDB136, editTextAuditoresDB136, editTextTeacherDB136;
    DBHelper dbHelper;
    SQLiteDatabase db;
    Dialog dialog, dialog_default;
    private int weeekOfMonth, toDay, max, weekOfYearMax, weekOfYear;
    boolean onClicKweek = false, onClicDaySunday = false;
    ImageView pencilImageWhiteAndDark;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        //ПРОВЕРЯЕМ КАКАЯ ТЕМА ВЫБРАНА
        prefsTheme = getSharedPreferences("Theme", MODE_PRIVATE);
        flagTheme = prefsTheme.getBoolean("lightAndDarkTheme", false);
        if (flagTheme) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        //Обробатываем свайп
        main_layout = (ConstraintLayout) findViewById(R.id.main_layout);
        main_layout.setOnTouchListener(new Swipe(Schedule.this) {
            @Override
            public void onSwipeLeft() {
                Intent intent = new Intent(Schedule.this, Bells.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.diagonaltranslateright, R.anim.alpha_one_zero);
            }

            public void onSwipeRight() {
                Intent intent = new Intent(Schedule.this, MainActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.diagonaltranslateleft, R.anim.alpha_one_zero);
            }
        });
        prefs = getSharedPreferences("FirstRun", MODE_PRIVATE);
        groupsButton1 = findViewById(R.id.groupButtons1);
        groupsButton2 = findViewById(R.id.groupButtons2);
        //СВЯЗЫВАЕМ ВСЕ EditText'ы и ScrollView
        findViewEditText();
        scrollView = findViewById(R.id.scrollView);
        //ОТМЕНЯЕМ РЕДАКТИРОВАНИЕ ПОЛЕЙ
        setDontEdit();
        //ПОЛУЧАЕМ ДАТУ
        calendar = Calendar.getInstance();
        maxDayOfMonth = Calendar.getInstance();
        maxDayOfMonth.add(Calendar.MONTH, -1);
        dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        dayOfMonthMax = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        weeekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH);
        toDay = calendar.get(Calendar.DAY_OF_WEEK);
        max = calendar.get(Calendar.MONTH);
        weekOfYearMax = calendar.get(Calendar.WEEK_OF_YEAR);
        weekOfYear = calendar.get(Calendar.YEAR);
        //форма когда в субботу нету пар
        form_lessons_sunday = findViewById(R.id.form_lessons_sunday);
        form_lessons_sunday.setVisibility(View.INVISIBLE);
        form_lessons_sunday_text = findViewById(R.id.form_lessons_sunday_text);
        //ЗАПУСКАЕМ ДИАЛОГОВОЕ ОКНО В ВОСКРЕСЕНЬЕ 1 РАЗ В НЕДЕЛЮ
        checkSunday();
        //ОПРЕДЕЛЯЕМ ImageView и btnDefault
        buttonDefault = (Button) findViewById(R.id.buttonDefault);
        imageReady = (ImageView) findViewById(R.id.imageReady);
        pencilImage = (ImageView) findViewById(R.id.pencilImage);
        imageBell = (ImageView) findViewById(R.id.imageBell);
        imageBellRealy = (ImageView) findViewById(R.id.imageBellRealy);
        imageEllipse2 = (ImageView) findViewById(R.id.imageEllipse2);
        imageEllipse = (ImageView) findViewById(R.id.imageEllipse);
        //СКРЫВАЕМ КНОПКИ READY И DEFAULT
        buttonDefault.setVisibility(View.INVISIBLE);
        //ОПРЕДЕЛЯЕМ LinearLayout'Ы
        linearLayout1 = findViewById(R.id.mainLinLayout1);
        linearLayout2 = findViewById(R.id.mainLinLayout2);
        linearLayout3 = findViewById(R.id.mainLinLayout3);
        linearLayout4 = findViewById(R.id.mainLinLayout4);
        linearLayout5 = findViewById(R.id.mainLinLayout5);
        linearLayout6 = findViewById(R.id.mainLinLayout6);
        linearLayout8 = findViewById(R.id.mainLinLayout8);
        linearLayout9 = findViewById(R.id.mainLinLayout9);
        linearLayout10 = findViewById(R.id.mainLinLayout10);
        linearLayout11 = findViewById(R.id.mainLinLayout11);
        linearLayout12 = findViewById(R.id.mainLinLayout12);
        linearLayout13 = findViewById(R.id.mainLinLayout13);

        //ОПРЕДЕЛЯЕМ КНОПКИ И ФОРМЫ (ТОЧКИ)
        tochka = findViewById(R.id.tochka);
        tochka2 = findViewById(R.id.tochka2);
        btnWeekDay1 = findViewById(R.id.btnWeekDay1);
        btnWeekDay2 = findViewById(R.id.btnWeekDay2);
        btnWeekDay3 = findViewById(R.id.btnWeekDay3);
        btnWeekDay4 = findViewById(R.id.btnWeekDay4);
        btnWeekDay5 = findViewById(R.id.btnWeekDay5);
        btnWeekDay6 = findViewById(R.id.btnWeekDay6);
        btnWeekDay8 = findViewById(R.id.btnWeekDay8);
        btnWeekDay13 = findViewById(R.id.btnWeekDay13);
        btnWeekDay9 = findViewById(R.id.btnWeekDay9);
        btnWeekDay10 = findViewById(R.id.btnWeekDay10);
        btnWeekDay11 = findViewById(R.id.btnWeekDay11);
        btnWeekDay12 = findViewById(R.id.btnWeekDay12);

        buttonWeekOne = findViewById(R.id.buttonWeekOne);
        buttonWeekTwo = findViewById(R.id.buttonWeekTwo);

        btnHomewWork = findViewById(R.id.btnHomewWok);
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            btnHomewWork.setImageDrawable(getResources().getDrawable(R.drawable.ic_home_work));
        }
        pencilImageWhiteAndDark = findViewById(R.id.pencilImage);
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO) {
            pencilImageWhiteAndDark.setImageDrawable(getResources().getDrawable(R.drawable.ic_pencil_edit_white_theme));
        } else {
            pencilImageWhiteAndDark.setImageDrawable(getResources().getDrawable(R.drawable.pencil));
        }
        //ПОДКЛЮЧАЕМСЯ К БД
        dbHelper = new DBHelper(getApplicationContext());
        db = dbHelper.getWritableDatabase();
        //УСТОНАВЛИВАЕМ СЕГОДНЯШНИЙ ДЕНЬ
        new ChooseDay().execute();
        //УСТАНОВКА ДАННЫХ В SHARED PREFERENCES
        setData();
        //УСТОНАВЛИВАЕМ ТЕКСТ ПРИ ИЗМЕНЕНИИ НАПРАВЛЕНИЯ, ИНАЧЕ УСТОНАВЛИВАЕМ ТЕКСТ ИЗ БД
        setTextAutoChangedDirection();
        //УСТОНАВЛИВАЕМ ТОЧКУ НЕДЕЛИ
        setTochka();
        //ПЕРВЫЙ ЗАПУСК
        firstrun();
    }

    public void InHomeWork(View view) {
        Intent i = new Intent(this, HomeWork.class);
        i.putExtra("backPressed", "Schedule");
        startActivity(i);
        finish();
        overridePendingTransition(R.anim.alpha_zero_one, R.anim.alpha_one_zero);
    }

    private class ChooseDay extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            choosedDay();
            return null;
        }
    }

    private class putDB extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            cursor();
            return null;
        }
    }

    private class outActivityDB extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            String selection, selection2, selection3, selection4, selection5,
                    selection6, selection8, selection9, selection10,
                    selection11, selection12, selection13 = null;
            String[] selectionArgs, selectionArgs2, selectionArgs3, selectionArgs4, selectionArgs5,
                    selectionArgs6, selectionArgs8, selectionArgs9, selectionArgs10, selectionArgs11,
                    selectionArgs12, selectionArgs13 = null;

            Log.d(LOG_TAG, "--- Update mytable: ---");
            getText();
            db = dbHelper.getWritableDatabase();
            //
            ContentValues contentValues = new ContentValues();
            String[] key = {"lessonOne", "lessonTwo", "lessonThree", "lessonFour", "lessonFive", "lessonSix",
                    "auditoreOne", "auditoreTwo", "auditoreThree", "auditoreFour", "auditoreFive", "auditoreSix",
                    "teacherOne", "teacherTwo", "teacherThree", "teacherFour", "teacherFive", "teacherSix"};
            //1 ДЕНЬ
            String[] textValue = {editTextLessonDB1, editTextLessonDB2, editTextLessonDB3, editTextLessonDB4, editTextLessonDB5, editTextLessonDB6,
                    editTextAuditoresDB1, editTextAuditoresDB2, editTextAuditoresDB3, editTextAuditoresDB4, editTextAuditoresDB5, editTextAuditoresDB6,
                    editTextTeacherDB1, editTextTeacherDB2, editTextTeacherDB3, editTextTeacherDB4, editTextTeacherDB5, editTextTeacherDB6};
            for (int i = 0; i < 18; i++) {
                contentValues.put(key[i], textValue[i]);
            }
            selection = "id = ?";
            selectionArgs = new String[]{"1"};
            int updCount = db.update("mydgu", contentValues, selection, selectionArgs);

            //2 ДЕНЬ
            String[] textValue2 = {editTextLessonDB21, editTextLessonDB22, editTextLessonDB23, editTextLessonDB24, editTextLessonDB25, editTextLessonDB26,
                    editTextAuditoresDB21, editTextAuditoresDB22, editTextAuditoresDB23, editTextAuditoresDB24, editTextAuditoresDB25, editTextAuditoresDB26,
                    editTextTeacherDB21, editTextTeacherDB22, editTextTeacherDB23, editTextTeacherDB24, editTextTeacherDB25, editTextTeacherDB26};
            for (int i = 0; i < 18; i++) {
                contentValues.put(key[i], textValue2[i]);
            }
            selection2 = "id = ?";
            selectionArgs2 = new String[]{"2"};
            int updCount2 = db.update("mydgu", contentValues, selection2, selectionArgs2);
            //3 ДЕНЬ
            String[] textValue3 = {editTextLessonDB31, editTextLessonDB32, editTextLessonDB33, editTextLessonDB34, editTextLessonDB35, editTextLessonDB36,
                    editTextAuditoresDB31, editTextAuditoresDB32, editTextAuditoresDB33, editTextAuditoresDB34, editTextAuditoresDB35, editTextAuditoresDB36,
                    editTextTeacherDB31, editTextTeacherDB32, editTextTeacherDB33, editTextTeacherDB34, editTextTeacherDB35, editTextTeacherDB36};
            for (int i = 0; i < 18; i++) {
                contentValues.put(key[i], textValue3[i]);
            }
            selection3 = "id = ?";
            selectionArgs3 = new String[]{"3"};
            int updCount3 = db.update("mydgu", contentValues, selection3, selectionArgs3);
            //4 ДЕНЬ
            String[] textValue4 = {editTextLessonDB41, editTextLessonDB42, editTextLessonDB43, editTextLessonDB44, editTextLessonDB45, editTextLessonDB46,
                    editTextAuditoresDB41, editTextAuditoresDB42, editTextAuditoresDB43, editTextAuditoresDB44, editTextAuditoresDB45, editTextAuditoresDB46,
                    editTextTeacherDB41, editTextTeacherDB42, editTextTeacherDB43, editTextTeacherDB44, editTextTeacherDB45, editTextTeacherDB46};
            for (int i = 0; i < 18; i++) {
                contentValues.put(key[i], textValue4[i]);
            }
            selection4 = "id = ?";
            selectionArgs4 = new String[]{"4"};
            int updCount4 = db.update("mydgu", contentValues, selection4, selectionArgs4);
            //5 ДЕНЬ
            String[] textValue5 = {editTextLessonDB51, editTextLessonDB52, editTextLessonDB53, editTextLessonDB54, editTextLessonDB55, editTextLessonDB56,
                    editTextAuditoresDB51, editTextAuditoresDB52, editTextAuditoresDB53, editTextAuditoresDB54, editTextAuditoresDB55, editTextAuditoresDB56,
                    editTextTeacherDB51, editTextTeacherDB52, editTextTeacherDB53, editTextTeacherDB54, editTextTeacherDB55, editTextTeacherDB56};
            for (int i = 0; i < 18; i++) {
                contentValues.put(key[i], textValue5[i]);
            }
            selection5 = "id = ?";
            selectionArgs5 = new String[]{"5"};
            int updCount5 = db.update("mydgu", contentValues, selection5, selectionArgs5);
            //6 ДЕНЬ
            String[] textValue6 = {editTextLessonDB61, editTextLessonDB62, editTextLessonDB63, editTextLessonDB64, editTextLessonDB65, editTextLessonDB66,
                    editTextAuditoresDB61, editTextAuditoresDB62, editTextAuditoresDB63, editTextAuditoresDB64, editTextAuditoresDB65, editTextAuditoresDB66,
                    editTextTeacherDB61, editTextTeacherDB62, editTextTeacherDB63, editTextTeacherDB64, editTextTeacherDB65, editTextTeacherDB66};
            for (int i = 0; i < 18; i++) {
                contentValues.put(key[i], textValue6[i]);
            }
            selection6 = "id = ?";
            selectionArgs6 = new String[]{"6"};
            int updCount6 = db.update("mydgu", contentValues, selection6, selectionArgs6);
            //8 ДЕНЬ
            String[] textValue8 = {editTextLessonDB81, editTextLessonDB82, editTextLessonDB83, editTextLessonDB84, editTextLessonDB85, editTextLessonDB86,
                    editTextAuditoresDB81, editTextAuditoresDB82, editTextAuditoresDB83, editTextAuditoresDB84, editTextAuditoresDB85, editTextAuditoresDB86,
                    editTextTeacherDB81, editTextTeacherDB82, editTextTeacherDB83, editTextTeacherDB84, editTextTeacherDB85, editTextTeacherDB86};
            for (int i = 0; i < 18; i++) {
                contentValues.put(key[i], textValue8[i]);
            }
            selection8 = "id = ?";
            selectionArgs8 = new String[]{"7"};
            int updCount8 = db.update("mydgu", contentValues, selection8, selectionArgs8);
            //9 ДЕНЬ
            String[] textValue9 = {editTextLessonDB91, editTextLessonDB92, editTextLessonDB93, editTextLessonDB94, editTextLessonDB95, editTextLessonDB96,
                    editTextAuditoresDB91, editTextAuditoresDB92, editTextAuditoresDB93, editTextLessonDB94, editTextLessonDB95, editTextLessonDB96,
                    editTextTeacherDB91, editTextTeacherDB92, editTextTeacherDB93, editTextTeacherDB94, editTextTeacherDB95, editTextTeacherDB96};
            for (int i = 0; i < 18; i++) {
                contentValues.put(key[i], textValue9[i]);
            }
            selection9 = "id = ?";
            selectionArgs9 = new String[]{"8"};
            int updCount9 = db.update("mydgu", contentValues, selection9, selectionArgs9);
            //10 ДЕНЬ
            String[] textValue10 = {editTextLessonDB101, editTextLessonDB102, editTextLessonDB103, editTextLessonDB104, editTextLessonDB105, editTextLessonDB106,
                    editTextAuditoresDB101, editTextAuditoresDB102, editTextAuditoresDB103, editTextAuditoresDB104, editTextAuditoresDB105, editTextAuditoresDB106,
                    editTextTeacherDB101, editTextTeacherDB102, editTextTeacherDB103, editTextTeacherDB104, editTextTeacherDB105, editTextTeacherDB106};
            for (int i = 0; i < 18; i++) {
                contentValues.put(key[i], textValue10[i]);
            }
            selection10 = "id = ?";
            selectionArgs10 = new String[]{"9"};
            int updCount10 = db.update("mydgu", contentValues, selection10, selectionArgs10);
            //11 ДЕНЬ
            String[] textValue11 = {editTextLessonDB111, editTextLessonDB112, editTextLessonDB113, editTextLessonDB114, editTextLessonDB115, editTextLessonDB116,
                    editTextAuditoresDB111, editTextAuditoresDB112, editTextAuditoresDB113, editTextAuditoresDB114, editTextAuditoresDB115, editTextAuditoresDB116,
                    editTextTeacherDB111, editTextTeacherDB112, editTextTeacherDB113, editTextTeacherDB114, editTextTeacherDB115, editTextTeacherDB116};
            for (int i = 0; i < 18; i++) {
                contentValues.put(key[i], textValue11[i]);
            }
            selection11 = "id = ?";
            selectionArgs11 = new String[]{"10"};
            int updCount11 = db.update("mydgu", contentValues, selection11, selectionArgs11);
            //12 ДЕНЬ
            String[] textValue12 = {editTextLessonDB121, editTextLessonDB122, editTextLessonDB123, editTextLessonDB124, editTextLessonDB125, editTextLessonDB126,
                    editTextAuditoresDB121, editTextAuditoresDB122, editTextAuditoresDB123, editTextAuditoresDB124, editTextAuditoresDB125, editTextAuditoresDB126,
                    editTextTeacherDB121, editTextTeacherDB122, editTextTeacherDB123, editTextTeacherDB124, editTextTeacherDB125, editTextTeacherDB126};
            for (int i = 0; i < 18; i++) {
                contentValues.put(key[i], textValue12[i]);
            }
            selection12 = "id = ?";
            selectionArgs12 = new String[]{"11"};
            int updCount12 = db.update("mydgu", contentValues, selection12, selectionArgs12);
            //13 ДЕНЬ
            String[] textValue13 = {editTextLessonDB131, editTextLessonDB132, editTextLessonDB133, editTextLessonDB134, editTextLessonDB135, editTextLessonDB136,
                    editTextAuditoresDB131, editTextAuditoresDB132, editTextAuditoresDB133, editTextAuditoresDB134, editTextAuditoresDB135, editTextAuditoresDB136,
                    editTextTeacherDB131, editTextTeacherDB132, editTextTeacherDB133, editTextTeacherDB134, editTextTeacherDB135, editTextTeacherDB136};
            for (int i = 0; i < 18; i++) {
                contentValues.put(key[i], textValue13[i]);
            }
            selection13 = "id = ?";
            selectionArgs13 = new String[]{"12"};
            int updCount13 = db.update("mydgu", contentValues, selection13, selectionArgs13);
            return null;
        }
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

    //УСТОНАВЛИВАЕМ РАСПИСАНИЕ, ЕСЛИ ПОЛЬЗОВАТЕЛЬ ИЗМЕНИЛ НАПРАВЛЕНИЕ
    private void setTextAutoChangedDirection() {
        SharedPreferences changedDirection = getSharedPreferences("ChangedDirection", MODE_PRIVATE);
        SharedPreferences.Editor changedDirectionEdit = changedDirection.edit();
        String lastDirection = changedDirection.getString("changedDirection", "ИСиТ");
        String lastCource = changedDirection.getString("changedCource", "2");
        if (!lastDirection.equals(elementSpinnerDirection) || !lastCource.equals(setElementSpinnerCource)) {
            setTextSchedule();
            if (!onClicKweek && onClicDaySunday) {
                sundayFormWeek1();
            } else if (onClicKweek && onClicDaySunday) {
                sundayFormWeek2();
            }
            changedDirectionEdit.putString("changedDirection", elementSpinnerDirection).apply();
            changedDirectionEdit.putString("changedCource", setElementSpinnerCource).apply();
        } else {
            //УСТОНАВЛИВАЕМ ТЕКСТ
            new putDB().execute();
        }
    }

    //ПРОВЕРЯЕМ ВОСКРЕСЕНЬЕ ЛИ СЕГОДНЯ И ЗАПУСКАЕМ ОДИН РАЗ В НЕДЕЛЮ ДИАЛОГОВОЕ ОКНО
    private void checkSunday() {
        SharedPreferences dialogPref = getSharedPreferences("Dialog", MODE_PRIVATE);
        SharedPreferences.Editor dialogEdit = dialogPref.edit();
        int lastWeek = dialogPref.getInt("week", 10);
        if (toDay == Calendar.SUNDAY) {
            if (lastWeek != weeekOfMonth) {
                dialogWindow();
                dialogEdit.putInt("week", weeekOfMonth).apply();
            }
        }
    }


    //ВЫТАСКИВАЕМ ДЫННЫЕ ИЗ БД С ПОМОЩЬЮ CURSOR'а
    private void cursor() {
        Log.d(LOG_TAG, "--- Rows in mytable: ---");
        //1 ДЕНЬ
        String selection = null;
        String[] selectionArgs = null;
        selection = "id = ?";
        selectionArgs = new String[]{"1"};
        Cursor c = db.query("mydgu", null, selection, selectionArgs, null, null, null);
        if (c.moveToFirst()) {
            int idColIndex = c.getColumnIndex("id");
            int lessonsOneColIndex = c.getColumnIndex("lessonOne");
            int lessonTwoColIndex = c.getColumnIndex("lessonTwo");
            int lessonThreeColIndex = c.getColumnIndex("lessonThree");
            int lessonFourColIndex = c.getColumnIndex("lessonFour");
            int lessonFiveColIndex = c.getColumnIndex("lessonFive");
            int lessonSixColIndex = c.getColumnIndex("lessonSix");

            int auditoreOneColIndex = c.getColumnIndex("auditoreOne");
            int auditoreTwoColIndex = c.getColumnIndex("auditoreTwo");
            int auditoreThreeColIndex = c.getColumnIndex("auditoreThree");
            int auditoreFourColIndex = c.getColumnIndex("auditoreFour");
            int auditoreFiveColIndex = c.getColumnIndex("auditoreFive");
            int auditoreSixColIndex = c.getColumnIndex("auditoreSix");

            int teacherOneColIndex = c.getColumnIndex("teacherOne");
            int teacherTwoColIndex = c.getColumnIndex("teacherTwo");
            int teacherThreeColIndex = c.getColumnIndex("teacherThree");
            int teacherFourColIndex = c.getColumnIndex("teacherFour");
            int teacherFiveColIndex = c.getColumnIndex("teacherFive");
            int teacherSixColIndex = c.getColumnIndex("teacherSix");

            do {
                editTextLesson11.setText(c.getString(lessonsOneColIndex));
                editTextAuditores11.setText(c.getString(auditoreOneColIndex));
                editTextTeacher11.setText(c.getString(teacherOneColIndex));

                editTextLesson12.setText(c.getString(lessonTwoColIndex));
                editTextAuditores12.setText(c.getString(auditoreTwoColIndex));
                editTextTeacher12.setText(c.getString(teacherTwoColIndex));

                editTextLesson13.setText(c.getString(lessonThreeColIndex));
                editTextAuditores13.setText(c.getString(auditoreThreeColIndex));
                editTextTeacher13.setText(c.getString(teacherThreeColIndex));

                editTextLesson14.setText(c.getString(lessonFourColIndex));
                editTextAuditores14.setText(c.getString(auditoreFourColIndex));
                editTextTeacher14.setText(c.getString(teacherFourColIndex));

                editTextLesson15.setText(c.getString(lessonFiveColIndex));
                editTextAuditores15.setText(c.getString(auditoreFiveColIndex));
                editTextTeacher15.setText(c.getString(teacherFiveColIndex));

                editTextLesson16.setText(c.getString(lessonSixColIndex));
                editTextAuditores16.setText(c.getString(auditoreSixColIndex));
                editTextTeacher16.setText(c.getString(teacherSixColIndex));
            } while (c.moveToNext());
        }
        //2 ДЕНЬ
        String selection2 = null;
        String[] selectionArgs2 = null;
        selection2 = "id = ?";
        selectionArgs2 = new String[]{"2"};
        Cursor c2 = db.query("mydgu", null, selection2, selectionArgs2, null, null, null);
        if (c2.moveToFirst()) {
            int idColIndex = c2.getColumnIndex("id");
            int lessons21ColIndex = c2.getColumnIndex("lessonOne");
            int lesson22ColIndex = c2.getColumnIndex("lessonTwo");
            int lesson23ColIndex = c2.getColumnIndex("lessonThree");
            int lesson24ColIndex = c2.getColumnIndex("lessonFour");
            int lesson25ColIndex = c2.getColumnIndex("lessonFive");
            int lesson26ColIndex = c2.getColumnIndex("lessonSix");

            int auditore21ColIndex = c2.getColumnIndex("auditoreOne");
            int auditore22ColIndex = c2.getColumnIndex("auditoreTwo");
            int auditore23ColIndex = c2.getColumnIndex("auditoreThree");
            int auditore24ColIndex = c2.getColumnIndex("auditoreFour");
            int auditore25ColIndex = c2.getColumnIndex("auditoreFive");
            int auditore26ColIndex = c2.getColumnIndex("auditoreSix");

            int teacher21ColIndex = c2.getColumnIndex("teacherOne");
            int teacher22ColIndex = c2.getColumnIndex("teacherTwo");
            int teacher23ColIndex = c2.getColumnIndex("teacherThree");
            int teacher24ColIndex = c2.getColumnIndex("teacherFour");
            int teacher25ColIndex = c2.getColumnIndex("teacherFive");
            int teacher26ColIndex = c2.getColumnIndex("teacherSix");

            do {
                editTextLesson21.setText(c2.getString(lessons21ColIndex));
                editTextAuditores21.setText(c2.getString(auditore21ColIndex));
                editTextTeacher21.setText(c2.getString(teacher21ColIndex));

                editTextLesson22.setText(c2.getString(lesson22ColIndex));
                editTextAuditores22.setText(c2.getString(auditore22ColIndex));
                editTextTeacher22.setText(c2.getString(teacher22ColIndex));

                editTextLesson23.setText(c2.getString(lesson23ColIndex));
                editTextAuditores23.setText(c2.getString(auditore23ColIndex));
                editTextTeacher23.setText(c2.getString(teacher23ColIndex));

                editTextLesson24.setText(c2.getString(lesson24ColIndex));
                editTextAuditores24.setText(c2.getString(auditore24ColIndex));
                editTextTeacher24.setText(c2.getString(teacher24ColIndex));

                editTextLesson25.setText(c2.getString(lesson25ColIndex));
                editTextAuditores25.setText(c2.getString(auditore25ColIndex));
                editTextTeacher25.setText(c2.getString(teacher25ColIndex));

                editTextLesson26.setText(c2.getString(lesson26ColIndex));
                editTextAuditores26.setText(c2.getString(auditore26ColIndex));
                editTextTeacher26.setText(c2.getString(teacher26ColIndex));
            } while (c2.moveToNext());
        }
        //3 ДЕНЬ
        String selection3 = null;
        String[] selectionArgs3 = null;
        selection3 = "id = ?";
        selectionArgs3 = new String[]{"3"};
        Cursor c3 = db.query("mydgu", null, selection3, selectionArgs3, null, null, null);
        if (c3.moveToFirst()) {
            int idColIndex = c3.getColumnIndex("id");
            int lessons31ColIndex = c3.getColumnIndex("lessonOne");
            int lesson32ColIndex = c3.getColumnIndex("lessonTwo");
            int lesson33ColIndex = c3.getColumnIndex("lessonThree");
            int lesson34ColIndex = c3.getColumnIndex("lessonFour");
            int lesson35ColIndex = c3.getColumnIndex("lessonFive");
            int lesson36ColIndex = c3.getColumnIndex("lessonSix");

            int auditore31ColIndex = c3.getColumnIndex("auditoreOne");
            int auditore32ColIndex = c3.getColumnIndex("auditoreTwo");
            int auditore33ColIndex = c3.getColumnIndex("auditoreThree");
            int auditore34ColIndex = c3.getColumnIndex("auditoreFour");
            int auditore35ColIndex = c3.getColumnIndex("auditoreFive");
            int auditore36ColIndex = c3.getColumnIndex("auditoreSix");

            int teacher31ColIndex = c3.getColumnIndex("teacherOne");
            int teacher32ColIndex = c3.getColumnIndex("teacherTwo");
            int teacher33ColIndex = c3.getColumnIndex("teacherThree");
            int teacher34ColIndex = c3.getColumnIndex("teacherFour");
            int teacher35ColIndex = c3.getColumnIndex("teacherFive");
            int teacher36ColIndex = c3.getColumnIndex("teacherSix");

            do {
                editTextLesson31.setText(c3.getString(lessons31ColIndex));
                editTextAuditores31.setText(c3.getString(auditore31ColIndex));
                editTextTeacher31.setText(c3.getString(teacher31ColIndex));

                editTextLesson32.setText(c3.getString(lesson32ColIndex));
                editTextAuditores32.setText(c3.getString(auditore32ColIndex));
                editTextTeacher32.setText(c3.getString(teacher32ColIndex));

                editTextLesson33.setText(c3.getString(lesson33ColIndex));
                editTextAuditores33.setText(c3.getString(auditore33ColIndex));
                editTextTeacher33.setText(c3.getString(teacher33ColIndex));

                editTextLesson34.setText(c3.getString(lesson34ColIndex));
                editTextAuditores34.setText(c3.getString(auditore34ColIndex));
                editTextTeacher34.setText(c3.getString(teacher34ColIndex));

                editTextLesson35.setText(c3.getString(lesson35ColIndex));
                editTextAuditores35.setText(c3.getString(auditore35ColIndex));
                editTextTeacher35.setText(c3.getString(teacher35ColIndex));

                editTextLesson36.setText(c3.getString(lesson36ColIndex));
                editTextAuditores36.setText(c3.getString(auditore36ColIndex));
                editTextTeacher36.setText(c3.getString(teacher36ColIndex));
            } while (c3.moveToNext());
        }
        //4 ДЕНЬ
        String selection4 = null;
        String[] selectionArgs4 = null;
        selection4 = "id = ?";
        selectionArgs4 = new String[]{"4"};
        Cursor c4 = db.query("mydgu", null, selection4, selectionArgs4, null, null, null);
        if (c4.moveToFirst()) {
            int idColIndex = c4.getColumnIndex("id");
            int lessons41ColIndex = c4.getColumnIndex("lessonOne");
            int lesson42ColIndex = c4.getColumnIndex("lessonTwo");
            int lesson43ColIndex = c4.getColumnIndex("lessonThree");
            int lesson44ColIndex = c4.getColumnIndex("lessonFour");
            int lesson45ColIndex = c4.getColumnIndex("lessonFive");
            int lesson46ColIndex = c4.getColumnIndex("lessonSix");

            int auditore41ColIndex = c4.getColumnIndex("auditoreOne");
            int auditore42ColIndex = c4.getColumnIndex("auditoreTwo");
            int auditore43ColIndex = c4.getColumnIndex("auditoreThree");
            int auditore44ColIndex = c4.getColumnIndex("auditoreFour");
            int auditore45ColIndex = c4.getColumnIndex("auditoreFive");
            int auditore46ColIndex = c4.getColumnIndex("auditoreSix");

            int teacher41ColIndex = c4.getColumnIndex("teacherOne");
            int teacher42ColIndex = c4.getColumnIndex("teacherTwo");
            int teacher43ColIndex = c4.getColumnIndex("teacherThree");
            int teacher44ColIndex = c4.getColumnIndex("teacherFour");
            int teacher45ColIndex = c4.getColumnIndex("teacherFive");
            int teacher46ColIndex = c4.getColumnIndex("teacherSix");

            do {
                editTextLesson41.setText(c4.getString(lessons41ColIndex));
                editTextAuditores41.setText(c4.getString(auditore41ColIndex));
                editTextTeacher41.setText(c4.getString(teacher41ColIndex));

                editTextLesson42.setText(c4.getString(lesson42ColIndex));
                editTextAuditores42.setText(c4.getString(auditore42ColIndex));
                editTextTeacher42.setText(c4.getString(teacher42ColIndex));

                editTextLesson43.setText(c4.getString(lesson43ColIndex));
                editTextAuditores43.setText(c4.getString(auditore43ColIndex));
                editTextTeacher43.setText(c4.getString(teacher43ColIndex));

                editTextLesson44.setText(c4.getString(lesson44ColIndex));
                editTextAuditores44.setText(c4.getString(auditore44ColIndex));
                editTextTeacher44.setText(c4.getString(teacher44ColIndex));

                editTextLesson45.setText(c4.getString(lesson45ColIndex));
                editTextAuditores45.setText(c4.getString(auditore45ColIndex));
                editTextTeacher45.setText(c4.getString(teacher45ColIndex));

                editTextLesson46.setText(c4.getString(lesson46ColIndex));
                editTextAuditores46.setText(c4.getString(auditore46ColIndex));
                editTextTeacher46.setText(c4.getString(teacher46ColIndex));
            } while (c4.moveToNext());
        }
        //5 ДЕНЬ
        String selection5 = null;
        String[] selectionArgs5 = null;
        selection5 = "id = ?";
        selectionArgs5 = new String[]{"5"};
        Cursor c5 = db.query("mydgu", null, selection5, selectionArgs5, null, null, null);
        if (c5.moveToFirst()) {
            int idColIndex = c5.getColumnIndex("id");
            int lessons51ColIndex = c5.getColumnIndex("lessonOne");
            int lesson52ColIndex = c5.getColumnIndex("lessonTwo");
            int lesson53ColIndex = c5.getColumnIndex("lessonThree");
            int lesson54ColIndex = c5.getColumnIndex("lessonFour");
            int lesson55ColIndex = c5.getColumnIndex("lessonFive");
            int lesson56ColIndex = c5.getColumnIndex("lessonSix");

            int auditore51ColIndex = c5.getColumnIndex("auditoreOne");
            int auditore52ColIndex = c5.getColumnIndex("auditoreTwo");
            int auditore53ColIndex = c5.getColumnIndex("auditoreThree");
            int auditore54ColIndex = c5.getColumnIndex("auditoreFour");
            int auditore55ColIndex = c5.getColumnIndex("auditoreFive");
            int auditore56ColIndex = c5.getColumnIndex("auditoreSix");

            int teacher51ColIndex = c5.getColumnIndex("teacherOne");
            int teacher52ColIndex = c5.getColumnIndex("teacherTwo");
            int teacher53ColIndex = c5.getColumnIndex("teacherThree");
            int teacher54ColIndex = c5.getColumnIndex("teacherFour");
            int teacher55ColIndex = c5.getColumnIndex("teacherFive");
            int teacher56ColIndex = c5.getColumnIndex("teacherSix");

            do {
                editTextLesson51.setText(c5.getString(lessons51ColIndex));
                editTextAuditores51.setText(c5.getString(auditore51ColIndex));
                editTextTeacher51.setText(c5.getString(teacher51ColIndex));

                editTextLesson52.setText(c5.getString(lesson52ColIndex));
                editTextAuditores52.setText(c5.getString(auditore52ColIndex));
                editTextTeacher52.setText(c5.getString(teacher52ColIndex));

                editTextLesson53.setText(c5.getString(lesson53ColIndex));
                editTextAuditores53.setText(c5.getString(auditore53ColIndex));
                editTextTeacher53.setText(c5.getString(teacher53ColIndex));

                editTextLesson54.setText(c5.getString(lesson54ColIndex));
                editTextAuditores54.setText(c5.getString(auditore54ColIndex));
                editTextTeacher54.setText(c5.getString(teacher54ColIndex));

                editTextLesson55.setText(c5.getString(lesson55ColIndex));
                editTextAuditores55.setText(c5.getString(auditore55ColIndex));
                editTextTeacher55.setText(c5.getString(teacher55ColIndex));

                editTextLesson56.setText(c5.getString(lesson56ColIndex));
                editTextAuditores56.setText(c5.getString(auditore56ColIndex));
                editTextTeacher56.setText(c5.getString(teacher56ColIndex));
            } while (c5.moveToNext());
        }
        //6 ДЕНЬ
        String selection6 = null;
        String[] selectionArgs6 = null;
        selection6 = "id = ?";
        selectionArgs6 = new String[]{"6"};
        Cursor c6 = db.query("mydgu", null, selection6, selectionArgs6, null, null, null);
        if (c6.moveToFirst()) {
            int idColIndex = c6.getColumnIndex("id");
            int lessons61ColIndex = c6.getColumnIndex("lessonOne");
            int lesson62ColIndex = c6.getColumnIndex("lessonTwo");
            int lesson63ColIndex = c6.getColumnIndex("lessonThree");
            int lesson64ColIndex = c6.getColumnIndex("lessonFour");
            int lesson65ColIndex = c6.getColumnIndex("lessonFive");
            int lesson66ColIndex = c6.getColumnIndex("lessonSix");

            int auditore61ColIndex = c6.getColumnIndex("auditoreOne");
            int auditore62ColIndex = c6.getColumnIndex("auditoreTwo");
            int auditore63ColIndex = c6.getColumnIndex("auditoreThree");
            int auditore64ColIndex = c6.getColumnIndex("auditoreFour");
            int auditore65ColIndex = c6.getColumnIndex("auditoreFive");
            int auditore66ColIndex = c6.getColumnIndex("auditoreSix");

            int teacher61ColIndex = c6.getColumnIndex("teacherOne");
            int teacher62ColIndex = c6.getColumnIndex("teacherTwo");
            int teacher63ColIndex = c6.getColumnIndex("teacherThree");
            int teacher64ColIndex = c6.getColumnIndex("teacherFour");
            int teacher65ColIndex = c6.getColumnIndex("teacherFive");
            int teacher66ColIndex = c6.getColumnIndex("teacherSix");

            do {
                editTextLesson61.setText(c6.getString(lessons61ColIndex));
                editTextAuditores61.setText(c6.getString(auditore61ColIndex));
                editTextTeacher61.setText(c6.getString(teacher61ColIndex));

                editTextLesson62.setText(c6.getString(lesson62ColIndex));
                editTextAuditores62.setText(c6.getString(auditore62ColIndex));
                editTextTeacher62.setText(c6.getString(teacher62ColIndex));

                editTextLesson63.setText(c6.getString(lesson63ColIndex));
                editTextAuditores63.setText(c6.getString(auditore63ColIndex));
                editTextTeacher63.setText(c6.getString(teacher63ColIndex));

                editTextLesson64.setText(c6.getString(lesson64ColIndex));
                editTextAuditores64.setText(c6.getString(auditore64ColIndex));
                editTextTeacher64.setText(c6.getString(teacher64ColIndex));

                editTextLesson65.setText(c6.getString(lesson65ColIndex));
                editTextAuditores65.setText(c6.getString(auditore65ColIndex));
                editTextTeacher65.setText(c6.getString(teacher65ColIndex));

                editTextLesson66.setText(c6.getString(lesson66ColIndex));
                editTextAuditores66.setText(c6.getString(auditore66ColIndex));
                editTextTeacher66.setText(c6.getString(teacher66ColIndex));
            } while (c6.moveToNext());
        }
        //8 ДЕНЬ
        String selection8 = null;
        String[] selectionArgs8 = null;
        selection8 = "id = ?";
        selectionArgs8 = new String[]{"7"};
        Cursor c8 = db.query("mydgu", null, selection8, selectionArgs8, null, null, null);
        if (c8.moveToFirst()) {
            int idColIndex = c8.getColumnIndex("id");
            int lessons81ColIndex = c8.getColumnIndex("lessonOne");
            int lesson82ColIndex = c8.getColumnIndex("lessonTwo");
            int lesson83ColIndex = c8.getColumnIndex("lessonThree");
            int lesson84ColIndex = c8.getColumnIndex("lessonFour");
            int lesson85ColIndex = c8.getColumnIndex("lessonFive");
            int lesson86ColIndex = c8.getColumnIndex("lessonSix");

            int auditore81ColIndex = c8.getColumnIndex("auditoreOne");
            int auditore82ColIndex = c8.getColumnIndex("auditoreTwo");
            int auditore83ColIndex = c8.getColumnIndex("auditoreThree");
            int auditore84ColIndex = c8.getColumnIndex("auditoreFour");
            int auditore85ColIndex = c8.getColumnIndex("auditoreFive");
            int auditore86ColIndex = c8.getColumnIndex("auditoreSix");

            int teacher81ColIndex = c8.getColumnIndex("teacherOne");
            int teacher82ColIndex = c8.getColumnIndex("teacherTwo");
            int teacher83ColIndex = c8.getColumnIndex("teacherThree");
            int teacher84ColIndex = c8.getColumnIndex("teacherFour");
            int teacher85ColIndex = c8.getColumnIndex("teacherFive");
            int teacher86ColIndex = c8.getColumnIndex("teacherSix");

            do {
                editTextLesson81.setText(c8.getString(lessons81ColIndex));
                editTextAuditores81.setText(c8.getString(auditore81ColIndex));
                editTextTeacher81.setText(c8.getString(teacher81ColIndex));

                editTextLesson82.setText(c8.getString(lesson82ColIndex));
                editTextAuditores82.setText(c8.getString(auditore82ColIndex));
                editTextTeacher82.setText(c8.getString(teacher82ColIndex));

                editTextLesson83.setText(c8.getString(lesson83ColIndex));
                editTextAuditores83.setText(c8.getString(auditore83ColIndex));
                editTextTeacher83.setText(c8.getString(teacher83ColIndex));

                editTextLesson84.setText(c8.getString(lesson84ColIndex));
                editTextAuditores84.setText(c8.getString(auditore84ColIndex));
                editTextTeacher84.setText(c8.getString(teacher84ColIndex));

                editTextLesson85.setText(c8.getString(lesson85ColIndex));
                editTextAuditores85.setText(c8.getString(auditore85ColIndex));
                editTextTeacher85.setText(c8.getString(teacher85ColIndex));

                editTextLesson86.setText(c8.getString(lesson86ColIndex));
                editTextAuditores86.setText(c8.getString(auditore86ColIndex));
                editTextTeacher86.setText(c8.getString(teacher86ColIndex));
            } while (c8.moveToNext());
        }
        //9 ДЕНЬ
        String selection9 = null;
        String[] selectionArgs9 = null;
        selection9 = "id = ?";
        selectionArgs9 = new String[]{"8"};
        Cursor c9 = db.query("mydgu", null, selection9, selectionArgs9, null, null, null);
        if (c9.moveToFirst()) {
            int idColIndex = c9.getColumnIndex("id");
            int lessons91ColIndex = c9.getColumnIndex("lessonOne");
            int lesson92ColIndex = c9.getColumnIndex("lessonTwo");
            int lesson93ColIndex = c9.getColumnIndex("lessonThree");
            int lesson94ColIndex = c9.getColumnIndex("lessonFour");
            int lesson95ColIndex = c9.getColumnIndex("lessonFive");
            int lesson96ColIndex = c9.getColumnIndex("lessonSix");

            int auditore91ColIndex = c9.getColumnIndex("auditoreOne");
            int auditore92ColIndex = c9.getColumnIndex("auditoreTwo");
            int auditore93ColIndex = c9.getColumnIndex("auditoreThree");
            int auditore94ColIndex = c9.getColumnIndex("auditoreFour");
            int auditore95ColIndex = c9.getColumnIndex("auditoreFive");
            int auditore96ColIndex = c9.getColumnIndex("auditoreSix");
            int auditore97ColIndex = c9.getColumnIndex("auditoreSeven");

            int teacher91ColIndex = c9.getColumnIndex("teacherOne");
            int teacher92ColIndex = c9.getColumnIndex("teacherTwo");
            int teacher93ColIndex = c9.getColumnIndex("teacherThree");
            int teacher94ColIndex = c9.getColumnIndex("teacherFour");
            int teacher95ColIndex = c9.getColumnIndex("teacherFive");
            int teacher96ColIndex = c9.getColumnIndex("teacherSix");

            do {
                editTextLesson91.setText(c9.getString(lessons91ColIndex));
                editTextAuditores91.setText(c9.getString(auditore91ColIndex));
                editTextTeacher91.setText(c9.getString(teacher91ColIndex));

                editTextLesson92.setText(c9.getString(lesson92ColIndex));
                editTextAuditores92.setText(c9.getString(auditore92ColIndex));
                editTextTeacher92.setText(c9.getString(teacher92ColIndex));

                editTextLesson93.setText(c9.getString(lesson93ColIndex));
                editTextAuditores93.setText(c9.getString(auditore93ColIndex));
                editTextTeacher93.setText(c9.getString(teacher93ColIndex));

                editTextLesson94.setText(c9.getString(lesson94ColIndex));
                editTextAuditores94.setText(c9.getString(auditore94ColIndex));
                editTextTeacher94.setText(c9.getString(teacher94ColIndex));

                editTextLesson95.setText(c9.getString(lesson95ColIndex));
                editTextAuditores95.setText(c9.getString(auditore95ColIndex));
                editTextTeacher95.setText(c9.getString(teacher95ColIndex));

                editTextLesson96.setText(c9.getString(lesson96ColIndex));
                editTextAuditores96.setText(c9.getString(auditore96ColIndex));
                editTextTeacher96.setText(c9.getString(teacher96ColIndex));
            } while (c9.moveToNext());
        }
        //10 ДЕНЬ
        String selection10 = null;
        String[] selectionArgs10 = null;
        selection10 = "id = ?";
        selectionArgs10 = new String[]{"9"};
        Cursor c10 = db.query("mydgu", null, selection10, selectionArgs10, null, null, null);
        if (c10.moveToFirst()) {
            int idColIndex = c10.getColumnIndex("id");
            int lessons101ColIndex = c10.getColumnIndex("lessonOne");
            int lesson102ColIndex = c10.getColumnIndex("lessonTwo");
            int lesson103ColIndex = c10.getColumnIndex("lessonThree");
            int lesson104ColIndex = c10.getColumnIndex("lessonFour");
            int lesson105ColIndex = c10.getColumnIndex("lessonFive");
            int lesson106ColIndex = c10.getColumnIndex("lessonSix");

            int auditore101ColIndex = c10.getColumnIndex("auditoreOne");
            int auditore102ColIndex = c10.getColumnIndex("auditoreTwo");
            int auditore103ColIndex = c10.getColumnIndex("auditoreThree");
            int auditore104ColIndex = c10.getColumnIndex("auditoreFour");
            int auditore105ColIndex = c10.getColumnIndex("auditoreFive");
            int auditore106ColIndex = c10.getColumnIndex("auditoreSix");

            int teacher101ColIndex = c10.getColumnIndex("teacherOne");
            int teacher102ColIndex = c10.getColumnIndex("teacherTwo");
            int teacher103ColIndex = c10.getColumnIndex("teacherThree");
            int teacher104ColIndex = c10.getColumnIndex("teacherFour");
            int teacher105ColIndex = c10.getColumnIndex("teacherFive");
            int teacher106ColIndex = c10.getColumnIndex("teacherSix");

            do {
                editTextLesson101.setText(c10.getString(lessons101ColIndex));
                editTextAuditores101.setText(c10.getString(auditore101ColIndex));
                editTextTeacher101.setText(c10.getString(teacher101ColIndex));

                editTextLesson102.setText(c10.getString(lesson102ColIndex));
                editTextAuditores102.setText(c10.getString(auditore102ColIndex));
                editTextTeacher102.setText(c10.getString(teacher102ColIndex));

                editTextLesson103.setText(c10.getString(lesson103ColIndex));
                editTextAuditores103.setText(c10.getString(auditore103ColIndex));
                editTextTeacher103.setText(c10.getString(teacher103ColIndex));

                editTextLesson104.setText(c10.getString(lesson104ColIndex));
                editTextAuditores104.setText(c10.getString(auditore104ColIndex));
                editTextTeacher104.setText(c10.getString(teacher104ColIndex));

                editTextLesson105.setText(c10.getString(lesson105ColIndex));
                editTextAuditores105.setText(c10.getString(auditore105ColIndex));
                editTextTeacher105.setText(c10.getString(teacher105ColIndex));

                editTextLesson106.setText(c10.getString(lesson106ColIndex));
                editTextAuditores106.setText(c10.getString(auditore106ColIndex));
                editTextTeacher106.setText(c10.getString(teacher106ColIndex));
            } while (c10.moveToNext());
        }
        //11 ДЕНЬ
        String selection11 = null;
        String[] selectionArgs11 = null;
        selection11 = "id = ?";
        selectionArgs11 = new String[]{"10"};
        Cursor c11 = db.query("mydgu", null, selection11, selectionArgs11, null, null, null);
        if (c11.moveToFirst()) {
            int idColIndex = c11.getColumnIndex("id");
            int lessons111ColIndex = c11.getColumnIndex("lessonOne");
            int lesson112ColIndex = c11.getColumnIndex("lessonTwo");
            int lesson113ColIndex = c11.getColumnIndex("lessonThree");
            int lesson114ColIndex = c11.getColumnIndex("lessonFour");
            int lesson115ColIndex = c11.getColumnIndex("lessonFive");
            int lesson116ColIndex = c11.getColumnIndex("lessonSix");

            int auditore111ColIndex = c11.getColumnIndex("auditoreOne");
            int auditore112ColIndex = c11.getColumnIndex("auditoreTwo");
            int auditore113ColIndex = c11.getColumnIndex("auditoreThree");
            int auditore114ColIndex = c11.getColumnIndex("auditoreFour");
            int auditore115ColIndex = c11.getColumnIndex("auditoreFive");
            int auditore116ColIndex = c11.getColumnIndex("auditoreSix");

            int teacher111ColIndex = c11.getColumnIndex("teacherOne");
            int teacher112ColIndex = c11.getColumnIndex("teacherTwo");
            int teacher113ColIndex = c11.getColumnIndex("teacherThree");
            int teacher114ColIndex = c11.getColumnIndex("teacherFour");
            int teacher115ColIndex = c11.getColumnIndex("teacherFive");
            int teacher116ColIndex = c11.getColumnIndex("teacherSix");

            do {
                editTextLesson111.setText(c11.getString(lessons111ColIndex));
                editTextAuditores111.setText(c11.getString(auditore111ColIndex));
                editTextTeacher111.setText(c11.getString(teacher111ColIndex));

                editTextLesson112.setText(c11.getString(lesson112ColIndex));
                editTextAuditores112.setText(c11.getString(auditore112ColIndex));
                editTextTeacher112.setText(c11.getString(teacher112ColIndex));

                editTextLesson113.setText(c11.getString(lesson113ColIndex));
                editTextAuditores113.setText(c11.getString(auditore113ColIndex));
                editTextTeacher113.setText(c11.getString(teacher113ColIndex));

                editTextLesson114.setText(c11.getString(lesson114ColIndex));
                editTextAuditores114.setText(c11.getString(auditore114ColIndex));
                editTextTeacher114.setText(c11.getString(teacher114ColIndex));

                editTextLesson115.setText(c11.getString(lesson115ColIndex));
                editTextAuditores115.setText(c11.getString(auditore115ColIndex));
                editTextTeacher115.setText(c11.getString(teacher115ColIndex));

                editTextLesson116.setText(c11.getString(lesson116ColIndex));
                editTextAuditores116.setText(c11.getString(auditore116ColIndex));
                editTextTeacher116.setText(c11.getString(teacher116ColIndex));
            } while (c11.moveToNext());
        }
        //12 ДЕНЬ
        String selection12 = null;
        String[] selectionArgs12 = null;
        selection12 = "id = ?";
        selectionArgs12 = new String[]{"11"};
        Cursor c12 = db.query("mydgu", null, selection12, selectionArgs12, null, null, null);
        if (c12.moveToFirst()) {
            int idColIndex = c12.getColumnIndex("id");
            int lessons121ColIndex = c12.getColumnIndex("lessonOne");
            int lesson122ColIndex = c12.getColumnIndex("lessonTwo");
            int lesson123ColIndex = c12.getColumnIndex("lessonThree");
            int lesson124ColIndex = c12.getColumnIndex("lessonFour");
            int lesson125ColIndex = c12.getColumnIndex("lessonFive");
            int lesson126ColIndex = c12.getColumnIndex("lessonSix");

            int auditore121ColIndex = c12.getColumnIndex("auditoreOne");
            int auditore122ColIndex = c12.getColumnIndex("auditoreTwo");
            int auditore123ColIndex = c12.getColumnIndex("auditoreThree");
            int auditore124ColIndex = c12.getColumnIndex("auditoreFour");
            int auditore125ColIndex = c12.getColumnIndex("auditoreFive");
            int auditore126ColIndex = c12.getColumnIndex("auditoreSix");

            int teacher121ColIndex = c12.getColumnIndex("teacherOne");
            int teacher122ColIndex = c12.getColumnIndex("teacherTwo");
            int teacher123ColIndex = c12.getColumnIndex("teacherThree");
            int teacher124ColIndex = c12.getColumnIndex("teacherFour");
            int teacher125ColIndex = c12.getColumnIndex("teacherFive");
            int teacher126ColIndex = c12.getColumnIndex("teacherSix");

            do {
                editTextLesson121.setText(c12.getString(lessons121ColIndex));
                editTextAuditores121.setText(c12.getString(auditore121ColIndex));
                editTextTeacher121.setText(c12.getString(teacher121ColIndex));

                editTextLesson122.setText(c12.getString(lesson122ColIndex));
                editTextAuditores122.setText(c12.getString(auditore122ColIndex));
                editTextTeacher122.setText(c12.getString(teacher122ColIndex));

                editTextLesson123.setText(c12.getString(lesson123ColIndex));
                editTextAuditores123.setText(c12.getString(auditore123ColIndex));
                editTextTeacher123.setText(c12.getString(teacher123ColIndex));

                editTextLesson124.setText(c12.getString(lesson124ColIndex));
                editTextAuditores124.setText(c12.getString(auditore124ColIndex));
                editTextTeacher124.setText(c12.getString(teacher124ColIndex));

                editTextLesson125.setText(c12.getString(lesson125ColIndex));
                editTextAuditores125.setText(c12.getString(auditore125ColIndex));
                editTextTeacher125.setText(c12.getString(teacher125ColIndex));

                editTextLesson126.setText(c12.getString(lesson126ColIndex));
                editTextAuditores126.setText(c12.getString(auditore126ColIndex));
                editTextTeacher126.setText(c12.getString(teacher126ColIndex));
            } while (c12.moveToNext());
        }
        //13 ДЕНЬ
        String selection13 = null;
        String[] selectionArgs13 = null;
        selection13 = "id = ?";
        selectionArgs13 = new String[]{"12"};
        Cursor c13 = db.query("mydgu", null, selection13, selectionArgs13, null, null, null);
        if (c13.moveToFirst()) {
            int idColIndex = c13.getColumnIndex("id");
            int lessons131ColIndex = c13.getColumnIndex("lessonOne");
            int lesson132ColIndex = c13.getColumnIndex("lessonTwo");
            int lesson133ColIndex = c13.getColumnIndex("lessonThree");
            int lesson134ColIndex = c13.getColumnIndex("lessonFour");
            int lesson135ColIndex = c13.getColumnIndex("lessonFive");
            int lesson136ColIndex = c13.getColumnIndex("lessonSix");

            int auditore131ColIndex = c13.getColumnIndex("auditoreOne");
            int auditore132ColIndex = c13.getColumnIndex("auditoreTwo");
            int auditore133ColIndex = c13.getColumnIndex("auditoreThree");
            int auditore134ColIndex = c13.getColumnIndex("auditoreFour");
            int auditore135ColIndex = c13.getColumnIndex("auditoreFive");
            int auditore136ColIndex = c13.getColumnIndex("auditoreSix");

            int teacher131ColIndex = c13.getColumnIndex("teacherOne");
            int teacher132ColIndex = c13.getColumnIndex("teacherTwo");
            int teacher133ColIndex = c13.getColumnIndex("teacherThree");
            int teacher134ColIndex = c13.getColumnIndex("teacherFour");
            int teacher135ColIndex = c13.getColumnIndex("teacherFive");
            int teacher136ColIndex = c13.getColumnIndex("teacherSix");

            do {
                editTextLesson131.setText(c13.getString(lessons131ColIndex));
                editTextAuditores131.setText(c13.getString(auditore131ColIndex));
                editTextTeacher131.setText(c13.getString(teacher131ColIndex));

                editTextLesson132.setText(c13.getString(lesson132ColIndex));
                editTextAuditores132.setText(c13.getString(auditore132ColIndex));
                editTextTeacher132.setText(c13.getString(teacher132ColIndex));

                editTextLesson133.setText(c13.getString(lesson133ColIndex));
                editTextAuditores133.setText(c13.getString(auditore133ColIndex));
                editTextTeacher133.setText(c13.getString(teacher133ColIndex));

                editTextLesson134.setText(c13.getString(lesson134ColIndex));
                editTextAuditores134.setText(c13.getString(auditore134ColIndex));
                editTextTeacher134.setText(c13.getString(teacher134ColIndex));

                editTextLesson135.setText(c13.getString(lesson135ColIndex));
                editTextAuditores135.setText(c13.getString(auditore135ColIndex));
                editTextTeacher135.setText(c13.getString(teacher135ColIndex));

                editTextLesson136.setText(c13.getString(lesson136ColIndex));
                editTextAuditores136.setText(c13.getString(auditore136ColIndex));
                editTextTeacher136.setText(c13.getString(teacher136ColIndex));
            } while (c13.moveToNext());
        }

    }

    //ПОЛУЧАЕМ ДАННЫЕ ИЗ ВСЕХ EditText'ов
    private void getText() {
        //1 ДЕНЬ
        editTextLessonDB1 = editTextLesson11.getText().toString();
        editTextLessonDB2 = editTextLesson12.getText().toString();
        editTextLessonDB3 = editTextLesson13.getText().toString();
        editTextLessonDB4 = editTextLesson14.getText().toString();
        editTextLessonDB5 = editTextLesson15.getText().toString();
        editTextLessonDB6 = editTextLesson16.getText().toString();

        editTextAuditoresDB1 = editTextAuditores11.getText().toString();
        editTextAuditoresDB2 = editTextAuditores12.getText().toString();
        editTextAuditoresDB3 = editTextAuditores13.getText().toString();
        editTextAuditoresDB4 = editTextAuditores14.getText().toString();
        editTextAuditoresDB5 = editTextAuditores15.getText().toString();
        editTextAuditoresDB6 = editTextAuditores16.getText().toString();

        editTextTeacherDB1 = editTextTeacher11.getText().toString();
        editTextTeacherDB2 = editTextTeacher12.getText().toString();
        editTextTeacherDB3 = editTextTeacher13.getText().toString();
        editTextTeacherDB4 = editTextTeacher14.getText().toString();
        editTextTeacherDB5 = editTextTeacher15.getText().toString();
        editTextTeacherDB6 = editTextTeacher16.getText().toString();
        //2 ДЕНЬ
        editTextLessonDB21 = editTextLesson21.getText().toString();
        editTextLessonDB22 = editTextLesson22.getText().toString();
        editTextLessonDB23 = editTextLesson23.getText().toString();
        editTextLessonDB24 = editTextLesson24.getText().toString();
        editTextLessonDB25 = editTextLesson25.getText().toString();
        editTextLessonDB26 = editTextLesson26.getText().toString();

        editTextAuditoresDB21 = editTextAuditores21.getText().toString();
        editTextAuditoresDB22 = editTextAuditores22.getText().toString();
        editTextAuditoresDB23 = editTextAuditores23.getText().toString();
        editTextAuditoresDB24 = editTextAuditores24.getText().toString();
        editTextAuditoresDB25 = editTextAuditores25.getText().toString();
        editTextAuditoresDB26 = editTextAuditores26.getText().toString();

        editTextTeacherDB21 = editTextTeacher21.getText().toString();
        editTextTeacherDB22 = editTextTeacher22.getText().toString();
        editTextTeacherDB23 = editTextTeacher23.getText().toString();
        editTextTeacherDB24 = editTextTeacher24.getText().toString();
        editTextTeacherDB25 = editTextTeacher25.getText().toString();
        editTextTeacherDB26 = editTextTeacher26.getText().toString();
        //3 ДЕНЬ
        editTextLessonDB31 = editTextLesson31.getText().toString();
        editTextLessonDB32 = editTextLesson32.getText().toString();
        editTextLessonDB33 = editTextLesson33.getText().toString();
        editTextLessonDB34 = editTextLesson34.getText().toString();
        editTextLessonDB35 = editTextLesson35.getText().toString();
        editTextLessonDB36 = editTextLesson36.getText().toString();

        editTextAuditoresDB31 = editTextAuditores31.getText().toString();
        editTextAuditoresDB32 = editTextAuditores32.getText().toString();
        editTextAuditoresDB33 = editTextAuditores33.getText().toString();
        editTextAuditoresDB34 = editTextAuditores34.getText().toString();
        editTextAuditoresDB35 = editTextAuditores35.getText().toString();
        editTextAuditoresDB36 = editTextAuditores36.getText().toString();

        editTextTeacherDB31 = editTextTeacher31.getText().toString();
        editTextTeacherDB32 = editTextTeacher32.getText().toString();
        editTextTeacherDB33 = editTextTeacher33.getText().toString();
        editTextTeacherDB34 = editTextTeacher34.getText().toString();
        editTextTeacherDB35 = editTextTeacher35.getText().toString();
        editTextTeacherDB36 = editTextTeacher36.getText().toString();
        //4 ДЕНЬ
        editTextLessonDB41 = editTextLesson41.getText().toString();
        editTextLessonDB42 = editTextLesson42.getText().toString();
        editTextLessonDB43 = editTextLesson43.getText().toString();
        editTextLessonDB44 = editTextLesson44.getText().toString();
        editTextLessonDB45 = editTextLesson45.getText().toString();
        editTextLessonDB46 = editTextLesson46.getText().toString();

        editTextAuditoresDB41 = editTextAuditores41.getText().toString();
        editTextAuditoresDB42 = editTextAuditores42.getText().toString();
        editTextAuditoresDB43 = editTextAuditores43.getText().toString();
        editTextAuditoresDB44 = editTextAuditores44.getText().toString();
        editTextAuditoresDB45 = editTextAuditores45.getText().toString();
        editTextAuditoresDB46 = editTextAuditores46.getText().toString();

        editTextTeacherDB41 = editTextTeacher41.getText().toString();
        editTextTeacherDB42 = editTextTeacher42.getText().toString();
        editTextTeacherDB43 = editTextTeacher43.getText().toString();
        editTextTeacherDB44 = editTextTeacher44.getText().toString();
        editTextTeacherDB45 = editTextTeacher45.getText().toString();
        editTextTeacherDB46 = editTextTeacher46.getText().toString();
        //5 ДЕНЬ
        editTextLessonDB51 = editTextLesson51.getText().toString();
        editTextLessonDB52 = editTextLesson52.getText().toString();
        editTextLessonDB53 = editTextLesson53.getText().toString();
        editTextLessonDB54 = editTextLesson54.getText().toString();
        editTextLessonDB55 = editTextLesson55.getText().toString();
        editTextLessonDB56 = editTextLesson56.getText().toString();

        editTextAuditoresDB51 = editTextAuditores51.getText().toString();
        editTextAuditoresDB52 = editTextAuditores52.getText().toString();
        editTextAuditoresDB53 = editTextAuditores53.getText().toString();
        editTextAuditoresDB54 = editTextAuditores54.getText().toString();
        editTextAuditoresDB55 = editTextAuditores55.getText().toString();
        editTextAuditoresDB56 = editTextAuditores56.getText().toString();

        editTextTeacherDB51 = editTextTeacher51.getText().toString();
        editTextTeacherDB52 = editTextTeacher52.getText().toString();
        editTextTeacherDB53 = editTextTeacher53.getText().toString();
        editTextTeacherDB54 = editTextTeacher54.getText().toString();
        editTextTeacherDB55 = editTextTeacher55.getText().toString();
        editTextTeacherDB56 = editTextTeacher56.getText().toString();
        //6 ДЕНЬ
        editTextLessonDB61 = editTextLesson61.getText().toString();
        editTextLessonDB62 = editTextLesson62.getText().toString();
        editTextLessonDB63 = editTextLesson63.getText().toString();
        editTextLessonDB64 = editTextLesson64.getText().toString();
        editTextLessonDB65 = editTextLesson65.getText().toString();
        editTextLessonDB66 = editTextLesson66.getText().toString();

        editTextAuditoresDB61 = editTextAuditores61.getText().toString();
        editTextAuditoresDB62 = editTextAuditores62.getText().toString();
        editTextAuditoresDB63 = editTextAuditores63.getText().toString();
        editTextAuditoresDB64 = editTextAuditores64.getText().toString();
        editTextAuditoresDB65 = editTextAuditores65.getText().toString();
        editTextAuditoresDB66 = editTextAuditores66.getText().toString();

        editTextTeacherDB61 = editTextTeacher61.getText().toString();
        editTextTeacherDB62 = editTextTeacher62.getText().toString();
        editTextTeacherDB63 = editTextTeacher63.getText().toString();
        editTextTeacherDB64 = editTextTeacher64.getText().toString();
        editTextTeacherDB65 = editTextTeacher65.getText().toString();
        editTextTeacherDB66 = editTextTeacher66.getText().toString();
        //8 ДЕНЬ
        editTextLessonDB81 = editTextLesson81.getText().toString();
        editTextLessonDB82 = editTextLesson82.getText().toString();
        editTextLessonDB83 = editTextLesson83.getText().toString();
        editTextLessonDB84 = editTextLesson84.getText().toString();
        editTextLessonDB85 = editTextLesson85.getText().toString();
        editTextLessonDB86 = editTextLesson86.getText().toString();

        editTextAuditoresDB81 = editTextAuditores81.getText().toString();
        editTextAuditoresDB82 = editTextAuditores82.getText().toString();
        editTextAuditoresDB83 = editTextAuditores83.getText().toString();
        editTextAuditoresDB84 = editTextAuditores84.getText().toString();
        editTextAuditoresDB85 = editTextAuditores85.getText().toString();
        editTextAuditoresDB86 = editTextAuditores86.getText().toString();

        editTextTeacherDB81 = editTextTeacher81.getText().toString();
        editTextTeacherDB82 = editTextTeacher82.getText().toString();
        editTextTeacherDB83 = editTextTeacher83.getText().toString();
        editTextTeacherDB84 = editTextTeacher84.getText().toString();
        editTextTeacherDB85 = editTextTeacher85.getText().toString();
        editTextTeacherDB86 = editTextTeacher86.getText().toString();
        //9 ДЕНЬ
        editTextLessonDB91 = editTextLesson91.getText().toString();
        editTextLessonDB92 = editTextLesson92.getText().toString();
        editTextLessonDB93 = editTextLesson93.getText().toString();
        editTextLessonDB94 = editTextLesson94.getText().toString();
        editTextLessonDB95 = editTextLesson95.getText().toString();
        editTextLessonDB96 = editTextLesson96.getText().toString();

        editTextAuditoresDB91 = editTextAuditores91.getText().toString();
        editTextAuditoresDB92 = editTextAuditores92.getText().toString();
        editTextAuditoresDB93 = editTextAuditores93.getText().toString();
        editTextAuditoresDB94 = editTextAuditores94.getText().toString();
        editTextAuditoresDB95 = editTextAuditores95.getText().toString();
        editTextAuditoresDB96 = editTextAuditores96.getText().toString();

        editTextTeacherDB91 = editTextTeacher91.getText().toString();
        editTextTeacherDB92 = editTextTeacher92.getText().toString();
        editTextTeacherDB93 = editTextTeacher93.getText().toString();
        editTextTeacherDB94 = editTextTeacher94.getText().toString();
        editTextTeacherDB95 = editTextTeacher95.getText().toString();
        editTextTeacherDB96 = editTextTeacher96.getText().toString();
        //10 ДЕНЬ
        editTextLessonDB101 = editTextLesson101.getText().toString();
        editTextLessonDB102 = editTextLesson102.getText().toString();
        editTextLessonDB103 = editTextLesson103.getText().toString();
        editTextLessonDB104 = editTextLesson104.getText().toString();
        editTextLessonDB105 = editTextLesson105.getText().toString();
        editTextLessonDB106 = editTextLesson106.getText().toString();

        editTextAuditoresDB101 = editTextAuditores101.getText().toString();
        editTextAuditoresDB102 = editTextAuditores102.getText().toString();
        editTextAuditoresDB103 = editTextAuditores103.getText().toString();
        editTextAuditoresDB104 = editTextAuditores104.getText().toString();
        editTextAuditoresDB105 = editTextAuditores105.getText().toString();
        editTextAuditoresDB106 = editTextAuditores106.getText().toString();

        editTextTeacherDB101 = editTextTeacher101.getText().toString();
        editTextTeacherDB102 = editTextTeacher102.getText().toString();
        editTextTeacherDB103 = editTextTeacher103.getText().toString();
        editTextTeacherDB104 = editTextTeacher104.getText().toString();
        editTextTeacherDB105 = editTextTeacher105.getText().toString();
        editTextTeacherDB106 = editTextTeacher106.getText().toString();
        //11 ДЕНЬ
        editTextLessonDB111 = editTextLesson111.getText().toString();
        editTextLessonDB112 = editTextLesson112.getText().toString();
        editTextLessonDB113 = editTextLesson113.getText().toString();
        editTextLessonDB114 = editTextLesson114.getText().toString();
        editTextLessonDB115 = editTextLesson115.getText().toString();
        editTextLessonDB116 = editTextLesson116.getText().toString();

        editTextAuditoresDB111 = editTextAuditores111.getText().toString();
        editTextAuditoresDB112 = editTextAuditores112.getText().toString();
        editTextAuditoresDB113 = editTextAuditores113.getText().toString();
        editTextAuditoresDB114 = editTextAuditores114.getText().toString();
        editTextAuditoresDB115 = editTextAuditores115.getText().toString();
        editTextAuditoresDB116 = editTextAuditores116.getText().toString();

        editTextTeacherDB111 = editTextTeacher111.getText().toString();
        editTextTeacherDB112 = editTextTeacher112.getText().toString();
        editTextTeacherDB113 = editTextTeacher113.getText().toString();
        editTextTeacherDB114 = editTextTeacher114.getText().toString();
        editTextTeacherDB115 = editTextTeacher115.getText().toString();
        editTextTeacherDB116 = editTextTeacher116.getText().toString();
        //11 ДЕНЬ
        editTextLessonDB111 = editTextLesson111.getText().toString();
        editTextLessonDB112 = editTextLesson112.getText().toString();
        editTextLessonDB113 = editTextLesson113.getText().toString();
        editTextLessonDB114 = editTextLesson114.getText().toString();
        editTextLessonDB115 = editTextLesson115.getText().toString();
        editTextLessonDB116 = editTextLesson116.getText().toString();

        editTextAuditoresDB111 = editTextAuditores111.getText().toString();
        editTextAuditoresDB112 = editTextAuditores112.getText().toString();
        editTextAuditoresDB113 = editTextAuditores113.getText().toString();
        editTextAuditoresDB114 = editTextAuditores114.getText().toString();
        editTextAuditoresDB115 = editTextAuditores115.getText().toString();
        editTextAuditoresDB116 = editTextAuditores116.getText().toString();

        editTextTeacherDB111 = editTextTeacher111.getText().toString();
        editTextTeacherDB112 = editTextTeacher112.getText().toString();
        editTextTeacherDB113 = editTextTeacher113.getText().toString();
        editTextTeacherDB114 = editTextTeacher114.getText().toString();
        editTextTeacherDB115 = editTextTeacher115.getText().toString();
        editTextTeacherDB116 = editTextTeacher116.getText().toString();
        //12 ДЕНЬ
        editTextLessonDB121 = editTextLesson121.getText().toString();
        editTextLessonDB122 = editTextLesson122.getText().toString();
        editTextLessonDB123 = editTextLesson123.getText().toString();
        editTextLessonDB124 = editTextLesson124.getText().toString();
        editTextLessonDB125 = editTextLesson125.getText().toString();
        editTextLessonDB126 = editTextLesson126.getText().toString();

        editTextAuditoresDB121 = editTextAuditores121.getText().toString();
        editTextAuditoresDB122 = editTextAuditores122.getText().toString();
        editTextAuditoresDB123 = editTextAuditores123.getText().toString();
        editTextAuditoresDB124 = editTextAuditores124.getText().toString();
        editTextAuditoresDB125 = editTextAuditores125.getText().toString();
        editTextAuditoresDB126 = editTextAuditores126.getText().toString();

        editTextTeacherDB121 = editTextTeacher121.getText().toString();
        editTextTeacherDB122 = editTextTeacher122.getText().toString();
        editTextTeacherDB123 = editTextTeacher123.getText().toString();
        editTextTeacherDB124 = editTextTeacher124.getText().toString();
        editTextTeacherDB125 = editTextTeacher125.getText().toString();
        editTextTeacherDB126 = editTextTeacher126.getText().toString();
        //13 ДЕНЬ
        editTextLessonDB131 = editTextLesson131.getText().toString();
        editTextLessonDB132 = editTextLesson132.getText().toString();
        editTextLessonDB133 = editTextLesson133.getText().toString();
        editTextLessonDB134 = editTextLesson134.getText().toString();
        editTextLessonDB135 = editTextLesson135.getText().toString();
        editTextLessonDB136 = editTextLesson136.getText().toString();

        editTextAuditoresDB131 = editTextAuditores131.getText().toString();
        editTextAuditoresDB132 = editTextAuditores132.getText().toString();
        editTextAuditoresDB133 = editTextAuditores133.getText().toString();
        editTextAuditoresDB134 = editTextAuditores134.getText().toString();
        editTextAuditoresDB135 = editTextAuditores135.getText().toString();
        editTextAuditoresDB136 = editTextAuditores136.getText().toString();

        editTextTeacherDB131 = editTextTeacher131.getText().toString();
        editTextTeacherDB132 = editTextTeacher132.getText().toString();
        editTextTeacherDB133 = editTextTeacher133.getText().toString();
        editTextTeacherDB134 = editTextTeacher134.getText().toString();
        editTextTeacherDB135 = editTextTeacher135.getText().toString();
        editTextTeacherDB136 = editTextTeacher136.getText().toString();
    }

    //ОПРЕДЕЛЯЕМ В ПЕРВЫЙ ЛИ РАЗ БЫЛО ЗАПУЩЕННО ПРИЛОЖЕНИЕ, ЕСЛИ ДА, ТО СОЗДАЕМ БД
    private void firstrun() {
        if (prefs.getBoolean("firstrun", true)) {

            db = dbHelper.getWritableDatabase();
            getText();
            Log.d(LOG_TAG, "--- Insert in mytable: ---");
            ContentValues contentValues = new ContentValues();
            String[] key = {"lessonOne", "lessonTwo", "lessonThree", "lessonFour", "lessonFive", "lessonSix",
                    "auditoreOne", "auditoreTwo", "auditoreThree", "auditoreFour", "auditoreFive", "auditoreSix",
                    "teacherOne", "teacherTwo", "teacherThree", "teacherFour", "teacherFive", "teacherSix"};
            //1 ДЕНЬ
            String[] textValue = {editTextLessonDB1, editTextLessonDB2, editTextLessonDB3, editTextLessonDB4, editTextLessonDB5, editTextLessonDB6,
                    editTextAuditoresDB1, editTextAuditoresDB2, editTextAuditoresDB3, editTextAuditoresDB4, editTextAuditoresDB45, editTextAuditoresDB6,
                    editTextTeacherDB1, editTextTeacherDB2, editTextTeacherDB3, editTextTeacherDB4, editTextTeacherDB5, editTextTeacherDB6};
            for (int i = 0; i < 18; i++) {
                contentValues.put(key[i], textValue[i]);
            }
            long rowID1 = db.insert("mydgu", null, contentValues);
            Log.d(LOG_TAG, "row inserted, ID = " + rowID1);

            //2 ДЕНЬ
            String[] textValue2 = {editTextLessonDB21, editTextLessonDB22, editTextLessonDB23, editTextLessonDB24, editTextLessonDB25, editTextLessonDB26,
                    editTextAuditoresDB21, editTextAuditoresDB22, editTextAuditoresDB23, editTextAuditoresDB24, editTextAuditoresDB25, editTextAuditoresDB26,
                    editTextTeacherDB21, editTextTeacherDB22, editTextTeacherDB23, editTextTeacherDB24, editTextTeacherDB25, editTextTeacherDB26};
            for (int i = 0; i < 18; i++) {
                contentValues.put(key[i], textValue2[i]);
            }
            long rowID2 = db.insert("mydgu", null, contentValues);
            Log.d(LOG_TAG, "row inserted, ID = " + rowID2);
            //3 ДЕНЬ
            String[] textValue3 = {editTextLessonDB31, editTextLessonDB32, editTextLessonDB33, editTextLessonDB34, editTextLessonDB35, editTextLessonDB36,
                    editTextAuditoresDB31, editTextAuditoresDB32, editTextAuditoresDB33, editTextAuditoresDB34, editTextAuditoresDB35, editTextAuditoresDB36,
                    editTextTeacherDB31, editTextTeacherDB32, editTextTeacherDB33, editTextTeacherDB34, editTextTeacherDB35, editTextTeacherDB36};
            for (int i = 0; i < 18; i++) {
                contentValues.put(key[i], textValue3[i]);
            }
            long rowID3 = db.insert("mydgu", null, contentValues);
            Log.d(LOG_TAG, "row inserted, ID = " + rowID3);
            //4 ДЕНЬ
            String[] textValue4 = {editTextLessonDB41, editTextLessonDB42, editTextLessonDB43, editTextLessonDB44, editTextLessonDB45, editTextLessonDB46,
                    editTextAuditoresDB41, editTextAuditoresDB42, editTextAuditoresDB43, editTextAuditoresDB44, editTextAuditoresDB45, editTextAuditoresDB46,
                    editTextTeacherDB41, editTextTeacherDB42, editTextTeacherDB43, editTextTeacherDB44, editTextTeacherDB45, editTextTeacherDB46};
            for (int i = 0; i < 18; i++) {
                contentValues.put(key[i], textValue4[i]);
            }
            long rowID4 = db.insert("mydgu", null, contentValues);
            Log.d(LOG_TAG, "row inserted, ID = " + rowID4);
            //5 ДЕНЬ
            String[] textValue5 = {editTextLessonDB51, editTextLessonDB52, editTextLessonDB53, editTextLessonDB54, editTextLessonDB55, editTextLessonDB56,
                    editTextAuditoresDB51, editTextAuditoresDB52, editTextAuditoresDB53, editTextAuditoresDB54, editTextAuditoresDB55, editTextAuditoresDB56,
                    editTextTeacherDB51, editTextTeacherDB52, editTextTeacherDB53, editTextTeacherDB54, editTextTeacherDB55, editTextTeacherDB56};
//editTextTeacherDB57};
            for (int i = 0; i < 18; i++) {
                contentValues.put(key[i], textValue5[i]);
            }
            long rowID5 = db.insert("mydgu", null, contentValues);
            Log.d(LOG_TAG, "row inserted, ID = " + rowID5);
            //6 ДЕНЬ
            String[] textValue6 = {editTextLessonDB61, editTextLessonDB62, editTextLessonDB63, editTextLessonDB64, editTextLessonDB65, editTextLessonDB66,
                    editTextAuditoresDB61, editTextAuditoresDB62, editTextAuditoresDB63, editTextAuditoresDB64, editTextAuditoresDB65, editTextAuditoresDB66,
                    editTextTeacherDB61, editTextTeacherDB62, editTextTeacherDB63, editTextTeacherDB64, editTextTeacherDB65, editTextTeacherDB66};
            for (int i = 0; i < 18; i++) {
                contentValues.put(key[i], textValue6[i]);
            }
            long rowID6 = db.insert("mydgu", null, contentValues);
            Log.d(LOG_TAG, "row inserted, ID = " + rowID6);
            //8 ДЕНЬ
            String[] textValue8 = {editTextLessonDB81, editTextLessonDB82, editTextLessonDB83, editTextLessonDB84, editTextLessonDB85, editTextLessonDB86,
                    editTextAuditoresDB81, editTextAuditoresDB82, editTextAuditoresDB83, editTextAuditoresDB84, editTextAuditoresDB85, editTextAuditoresDB86,
                    editTextTeacherDB81, editTextTeacherDB82, editTextTeacherDB83, editTextTeacherDB84, editTextTeacherDB85, editTextTeacherDB86};
            for (int i = 0; i < 18; i++) {
                contentValues.put(key[i], textValue8[i]);
            }
            long rowID7 = db.insert("mydgu", null, contentValues);
            Log.d(LOG_TAG, "row inserted, ID = " + rowID7);
            //9 ДЕНЬ
            String[] textValue9 = {editTextLessonDB91, editTextLessonDB92, editTextLessonDB93, editTextLessonDB94, editTextLessonDB95, editTextLessonDB96,
                    editTextAuditoresDB91, editTextAuditoresDB92, editTextAuditoresDB93, editTextLessonDB94, editTextLessonDB95, editTextLessonDB96,
                    editTextTeacherDB91, editTextTeacherDB92, editTextTeacherDB93, editTextTeacherDB94, editTextTeacherDB95, editTextTeacherDB96};
            for (int i = 0; i < 18; i++) {
                contentValues.put(key[i], textValue9[i]);
            }
            long rowID9 = db.insert("mydgu", null, contentValues);
            Log.d(LOG_TAG, "row inserted, ID = " + rowID9);
            //10 ДЕНЬ
            String[] textValue10 = {editTextLessonDB101, editTextLessonDB102, editTextLessonDB103, editTextLessonDB104, editTextLessonDB105, editTextLessonDB106,
                    editTextAuditoresDB101, editTextAuditoresDB102, editTextAuditoresDB103, editTextAuditoresDB104, editTextAuditoresDB105, editTextAuditoresDB106,
                    editTextTeacherDB101, editTextTeacherDB102, editTextTeacherDB103, editTextTeacherDB104, editTextTeacherDB105, editTextTeacherDB106};
            for (int i = 0; i < 18; i++) {
                contentValues.put(key[i], textValue10[i]);
            }
            long rowID10 = db.insert("mydgu", null, contentValues);
            Log.d(LOG_TAG, "row inserted, ID = " + rowID10);
            //11 ДЕНЬ
            String[] textValue11 = {editTextLessonDB111, editTextLessonDB112, editTextLessonDB113, editTextLessonDB114, editTextLessonDB115, editTextLessonDB116,
                    editTextAuditoresDB111, editTextAuditoresDB112, editTextAuditoresDB113, editTextAuditoresDB114, editTextAuditoresDB115, editTextAuditoresDB116,
                    editTextTeacherDB111, editTextTeacherDB112, editTextTeacherDB113, editTextTeacherDB114, editTextTeacherDB115, editTextTeacherDB116};
            for (int i = 0; i < 18; i++) {
                contentValues.put(key[i], textValue11[i]);
            }
            long rowID11 = db.insert("mydgu", null, contentValues);
            Log.d(LOG_TAG, "row inserted, ID = " + rowID11);
            //12 ДЕНЬ
            String[] textValue12 = {editTextLessonDB121, editTextLessonDB122, editTextLessonDB123, editTextLessonDB124, editTextLessonDB125, editTextLessonDB126,
                    editTextAuditoresDB121, editTextAuditoresDB122, editTextAuditoresDB123, editTextAuditoresDB124, editTextAuditoresDB125, editTextAuditoresDB126,
                    editTextTeacherDB121, editTextTeacherDB122, editTextTeacherDB123, editTextTeacherDB124, editTextTeacherDB125, editTextTeacherDB126};
            for (int i = 0; i < 18; i++) {
                contentValues.put(key[i], textValue12[i]);
            }
            long rowID12 = db.insert("mydgu", null, contentValues);
            Log.d(LOG_TAG, "row inserted, ID = " + rowID12);
            //13 ДЕНЬ
            String[] textValue13 = {editTextLessonDB131, editTextLessonDB132, editTextLessonDB133, editTextLessonDB134, editTextLessonDB135, editTextLessonDB136,
                    editTextAuditoresDB131, editTextAuditoresDB132, editTextAuditoresDB133, editTextAuditoresDB134, editTextAuditoresDB135, editTextAuditoresDB136,
                    editTextTeacherDB131, editTextTeacherDB132, editTextTeacherDB133, editTextTeacherDB134, editTextTeacherDB135, editTextTeacherDB136};
            for (int i = 0; i < 18; i++) {
                contentValues.put(key[i], textValue13[i]);
            }
            long rowID13 = db.insert("mydgu", null, contentValues);
            Log.d(LOG_TAG, "row inserted, ID = " + rowID13);
            setTextSchedule();
            choosedDay();
            prefs.edit().putBoolean("firstrun", false).apply();
        }
    }


    //ПРИ ВЫХОДЕ ИЗ ACTIVITY ОБНОВЛЯЕМ БД
    @Override
    protected void onPause() {
        super.onPause();
        new outActivityDB().execute();
    }

    //УСТОНАВЛИВАЕМ ДАННЫЕ О ПОЛЬЗОВАТЕЛЕ ПОЛУЧЕННЫЕ С AboutMe
    @SuppressLint("SetTextI18n")
    private void setData() {
        sharedPreferences = getSharedPreferences("userdata", Context.MODE_PRIVATE);

        setUserName = sharedPreferences.getString("setUserName", "");
        setUserSurName = sharedPreferences.getString("setUserSurName", "");
        setElementSpinnerCource = sharedPreferences.getString("setElementSpinnerCource", "");
        elementSpinnerSubgroupCource = sharedPreferences.getString("elementSpinnerSubgroupCource", "");
        elementSpinnerDirection = sharedPreferences.getString("elementSpinnerDirection", "");

        nameSchedule = findViewById(R.id.nameSchedule);
        surNameSchedule = findViewById(R.id.surNameSchedule);
        course = findViewById(R.id.course);
        sobgroup = findViewById(R.id.sobgroup);

        nameSchedule.setText(setUserName);
        surNameSchedule.setText(setUserSurName);
        course.setText(setElementSpinnerCource + " курс, ");
        sobgroup.setText(elementSpinnerSubgroupCource + " подгруппа");
    }

    //РЕАЛИЗАЦИЯ ТОЧКИ
    private void setTochka() {
        if (weekOfYear == 2021) {
            if (weekOfYearMax == 1 || weekOfYearMax == 3 || weekOfYearMax == 5 || weekOfYearMax == 7 || weekOfYearMax == 9 || weekOfYearMax == 11 || weekOfYearMax == 13 || weekOfYearMax == 15
                    || weekOfYearMax == 17 || weekOfYearMax == 19 || weekOfYearMax == 21 || weekOfYearMax == 23 || weekOfYearMax == 25 || weekOfYearMax == 27 || weekOfYearMax == 29
                    || weekOfYearMax == 31 || weekOfYearMax == 33 || weekOfYearMax == 35 || weekOfYearMax == 37 || weekOfYearMax == 39 || weekOfYearMax == 41 || weekOfYearMax == 43 || weekOfYearMax == 45
                    || weekOfYearMax == 47 || weekOfYearMax == 49 || weekOfYearMax == 51 || weekOfYearMax == 53) {
                switch (toDay) {
                    case Calendar.SUNDAY:
                        tochka2.setVisibility(View.VISIBLE);
                        tochka.setVisibility(View.GONE);
                        break;

                    default:
                        tochka.setVisibility(View.VISIBLE);
                        tochka2.setVisibility(View.GONE);
                        break;
                }
            } else if (weekOfYearMax == 2 || weekOfYearMax == 4 || weekOfYearMax == 6 || weekOfYearMax == 8 || weekOfYearMax == 10 || weekOfYearMax == 12 || weekOfYearMax == 14 || weekOfYearMax == 16
                    || weekOfYearMax == 18 || weekOfYearMax == 20 || weekOfYearMax == 22 || weekOfYearMax == 24 || weekOfYearMax == 26 || weekOfYearMax == 28 || weekOfYearMax == 30 || weekOfYearMax == 32
                    || weekOfYearMax == 34 || weekOfYearMax == 36 || weekOfYearMax == 38 || weekOfYearMax == 40 || weekOfYearMax == 42 || weekOfYearMax == 44 || weekOfYearMax == 46
                    || weekOfYearMax == 48 || weekOfYearMax == 50 || weekOfYearMax == 52) {
                switch (toDay) {
                    case Calendar.SUNDAY:
                        tochka.setVisibility(View.VISIBLE);
                        tochka2.setVisibility(View.GONE);
                        break;

                    default:
                        tochka2.setVisibility(View.VISIBLE);
                        tochka.setVisibility(View.GONE);
                        break;
                }
            }
        } else {
            if (weekOfYearMax == 1 || weekOfYearMax == 3 || weekOfYearMax == 5 || weekOfYearMax == 7 || weekOfYearMax == 9 || weekOfYearMax == 11 || weekOfYearMax == 13 || weekOfYearMax == 15
                    || weekOfYearMax == 17 || weekOfYearMax == 19 || weekOfYearMax == 21 || weekOfYearMax == 23 || weekOfYearMax == 25 || weekOfYearMax == 27 || weekOfYearMax == 29
                    || weekOfYearMax == 31 || weekOfYearMax == 33 || weekOfYearMax == 35 || weekOfYearMax == 37 || weekOfYearMax == 39 || weekOfYearMax == 41 || weekOfYearMax == 43 || weekOfYearMax == 45
                    || weekOfYearMax == 47 || weekOfYearMax == 49 || weekOfYearMax == 51) {
                switch (toDay) {
                    case Calendar.SUNDAY:
                        tochka2.setVisibility(View.VISIBLE);
                        tochka.setVisibility(View.GONE);
                        break;

                    default:
                        tochka.setVisibility(View.VISIBLE);
                        tochka2.setVisibility(View.GONE);
                        break;
                }
            } else if (weekOfYearMax == 2 || weekOfYearMax == 4 || weekOfYearMax == 6 || weekOfYearMax == 8 || weekOfYearMax == 10 || weekOfYearMax == 12 || weekOfYearMax == 14 || weekOfYearMax == 16
                    || weekOfYearMax == 18 || weekOfYearMax == 20 || weekOfYearMax == 22 || weekOfYearMax == 24 || weekOfYearMax == 26 || weekOfYearMax == 28 || weekOfYearMax == 30 || weekOfYearMax == 32
                    || weekOfYearMax == 34 || weekOfYearMax == 36 || weekOfYearMax == 38 || weekOfYearMax == 40 || weekOfYearMax == 42 || weekOfYearMax == 44 || weekOfYearMax == 46
                    || weekOfYearMax == 48 || weekOfYearMax == 50 || weekOfYearMax == 52 || weekOfYearMax == 53) {
                switch (toDay) {
                    case Calendar.SUNDAY:
                        tochka.setVisibility(View.VISIBLE);
                        tochka2.setVisibility(View.GONE);
                        break;

                    default:
                        tochka2.setVisibility(View.VISIBLE);
                        tochka.setVisibility(View.GONE);
                        break;
                }
            }
        }

    }

    //РЕАЛИЗАЦИЯ НАЖАТИЯ НЕДЕЛИ
    public void onClickWeek(View view) {
        //ВЫЗЫВАЕМ МЕТОД КОТОРЫЙ ОТПРЕДЕЛЯЕТ СЕГОДНЯЕШНИЙ ДЕНЬ
        //  СКРЫВАЕМ LinearLayout'Ы
        linInvisible();
        btnWeekDay1.setBackgroundResource(R.drawable.form_schedule_btn);
        btnWeekDay2.setBackgroundResource(R.drawable.form_schedule_btn);
        btnWeekDay3.setBackgroundResource(R.drawable.form_schedule_btn);
        btnWeekDay4.setBackgroundResource(R.drawable.form_schedule_btn);
        btnWeekDay5.setBackgroundResource(R.drawable.form_schedule_btn);
        btnWeekDay6.setBackgroundResource(R.drawable.form_schedule_btn);
        btnWeekDay8.setBackgroundResource(R.drawable.form_schedule_btn);
        btnWeekDay9.setBackgroundResource(R.drawable.form_schedule_btn);
        btnWeekDay10.setBackgroundResource(R.drawable.form_schedule_btn);
        btnWeekDay11.setBackgroundResource(R.drawable.form_schedule_btn);
        btnWeekDay12.setBackgroundResource(R.drawable.form_schedule_btn);
        btnWeekDay13.setBackgroundResource(R.drawable.form_schedule_btn);
        scrollView.setVisibility(View.VISIBLE);
        form_lessons_sunday.setVisibility(View.INVISIBLE);
        form_lessons_sunday_text.setVisibility(View.INVISIBLE);
        switch (toDay) {
            case Calendar.SUNDAY:
                if (weekOfYear == 2021) {
                    switch (view.getId()) {
                        case R.id.buttonWeekOne:
                            groupsButton1.setVisibility(View.VISIBLE);
                            groupsButton2.setVisibility(View.GONE);
                            if (weekOfYearMax == 2 || weekOfYearMax == 4 || weekOfYearMax == 6 || weekOfYearMax == 8 || weekOfYearMax == 10 || weekOfYearMax == 12 || weekOfYearMax == 14 || weekOfYearMax == 16
                                    || weekOfYearMax == 18 || weekOfYearMax == 20 || weekOfYearMax == 22 || weekOfYearMax == 24 || weekOfYearMax == 26 || weekOfYearMax == 28 || weekOfYearMax == 30 || weekOfYearMax == 32
                                    || weekOfYearMax == 34 || weekOfYearMax == 36 || weekOfYearMax == 38 || weekOfYearMax == 40 || weekOfYearMax == 42 || weekOfYearMax == 44 || weekOfYearMax == 46
                                    || weekOfYearMax == 48 || weekOfYearMax == 50 || weekOfYearMax == 52) {
                                choosedDay();
                                groupsButton1.setVisibility(View.VISIBLE);
                                groupsButton2.setVisibility(View.GONE);
                                btnWeekDay1.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                                linearLayout1.setVisibility(View.VISIBLE);
                                linearLayout8.setVisibility(View.INVISIBLE);
                            } else {
                                btnWeekDay1.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                                linearLayout1.setVisibility(View.VISIBLE);
                            }
                            break;
                        case R.id.buttonWeekTwo:
                            groupsButton2.setVisibility(View.VISIBLE);
                            groupsButton1.setVisibility(View.GONE);
                            if (weekOfYearMax == 1 || weekOfYearMax == 3 || weekOfYearMax == 5 || weekOfYearMax == 7 || weekOfYearMax == 9 || weekOfYearMax == 11 || weekOfYearMax == 13 || weekOfYearMax == 15
                                    || weekOfYearMax == 17 || weekOfYearMax == 19 || weekOfYearMax == 21 || weekOfYearMax == 23 || weekOfYearMax == 25 || weekOfYearMax == 27 || weekOfYearMax == 29
                                    || weekOfYearMax == 31 || weekOfYearMax == 33 || weekOfYearMax == 35 || weekOfYearMax == 37 || weekOfYearMax == 39 || weekOfYearMax == 41 || weekOfYearMax == 43 || weekOfYearMax == 45
                                    || weekOfYearMax == 47 || weekOfYearMax == 49 || weekOfYearMax == 51 || weekOfYearMax == 53) {
                                choosedDay();
                                groupsButton2.setVisibility(View.VISIBLE);
                                groupsButton1.setVisibility(View.GONE);
                                btnWeekDay8.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                                linearLayout8.setVisibility(View.VISIBLE);
                                linearLayout1.setVisibility(View.INVISIBLE);
                            } else {
                                btnWeekDay8.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                                linearLayout8.setVisibility(View.VISIBLE);
                            }
                            break;
                    }
                } else {
                    switch (view.getId()) {
                        case R.id.buttonWeekOne:
                            groupsButton1.setVisibility(View.VISIBLE);
                            groupsButton2.setVisibility(View.GONE);
                            if (weekOfYearMax == 1 || weekOfYearMax == 3 || weekOfYearMax == 5 || weekOfYearMax == 7 || weekOfYearMax == 9 || weekOfYearMax == 11 || weekOfYearMax == 13 || weekOfYearMax == 15
                                    || weekOfYearMax == 17 || weekOfYearMax == 19 || weekOfYearMax == 21 || weekOfYearMax == 23 || weekOfYearMax == 25 || weekOfYearMax == 27 || weekOfYearMax == 29
                                    || weekOfYearMax == 31 || weekOfYearMax == 33 || weekOfYearMax == 35 || weekOfYearMax == 37 || weekOfYearMax == 39 || weekOfYearMax == 41 || weekOfYearMax == 43 || weekOfYearMax == 45
                                    || weekOfYearMax == 47 || weekOfYearMax == 49 || weekOfYearMax == 51) {
                                choosedDay();
                                groupsButton1.setVisibility(View.VISIBLE);
                                groupsButton2.setVisibility(View.GONE);
                                btnWeekDay1.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                                linearLayout1.setVisibility(View.VISIBLE);
                                linearLayout8.setVisibility(View.INVISIBLE);
                            } else {
                                btnWeekDay1.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                                linearLayout1.setVisibility(View.VISIBLE);
                            }
                            break;
                        case R.id.buttonWeekTwo:
                            groupsButton2.setVisibility(View.VISIBLE);
                            groupsButton1.setVisibility(View.GONE);
                            if (weekOfYearMax == 2 || weekOfYearMax == 4 || weekOfYearMax == 6 || weekOfYearMax == 8 || weekOfYearMax == 10 || weekOfYearMax == 12 || weekOfYearMax == 14 || weekOfYearMax == 16
                                    || weekOfYearMax == 18 || weekOfYearMax == 20 || weekOfYearMax == 22 || weekOfYearMax == 24 || weekOfYearMax == 26 || weekOfYearMax == 28 || weekOfYearMax == 30 || weekOfYearMax == 32
                                    || weekOfYearMax == 34 || weekOfYearMax == 36 || weekOfYearMax == 38 || weekOfYearMax == 40 || weekOfYearMax == 42 || weekOfYearMax == 44 || weekOfYearMax == 46
                                    || weekOfYearMax == 48 || weekOfYearMax == 50 || weekOfYearMax == 52 || weekOfYearMax == 53) {
                                choosedDay();
                                groupsButton2.setVisibility(View.VISIBLE);
                                groupsButton1.setVisibility(View.GONE);
                                btnWeekDay8.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                                linearLayout8.setVisibility(View.VISIBLE);
                                linearLayout1.setVisibility(View.INVISIBLE);
                            } else {
                                btnWeekDay8.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                                linearLayout8.setVisibility(View.VISIBLE);
                            }
                            break;
                    }
                }
                break;
            default:
                if (weekOfYear == 2021) {
                    switch (view.getId()) {

                        case R.id.buttonWeekOne:
                            groupsButton1.setVisibility(View.VISIBLE);
                            groupsButton2.setVisibility(View.GONE);
                            if (weekOfYearMax == 1 || weekOfYearMax == 3 || weekOfYearMax == 5 || weekOfYearMax == 7 || weekOfYearMax == 9 || weekOfYearMax == 11 || weekOfYearMax == 13 || weekOfYearMax == 15
                                    || weekOfYearMax == 17 || weekOfYearMax == 19 || weekOfYearMax == 21 || weekOfYearMax == 23 || weekOfYearMax == 25 || weekOfYearMax == 27 || weekOfYearMax == 29
                                    || weekOfYearMax == 31 || weekOfYearMax == 33 || weekOfYearMax == 35 || weekOfYearMax == 37 || weekOfYearMax == 39 || weekOfYearMax == 41 || weekOfYearMax == 43 || weekOfYearMax == 45
                                    || weekOfYearMax == 47 || weekOfYearMax == 49 || weekOfYearMax == 51 || weekOfYearMax == 53) {
                                choosedDay();
                            } else {
                                btnWeekDay1.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                                linearLayout1.setVisibility(View.VISIBLE);
                            }
                            break;
                        case R.id.buttonWeekTwo:
                            groupsButton2.setVisibility(View.VISIBLE);
                            groupsButton1.setVisibility(View.GONE);
                            if (weekOfYearMax == 2 || weekOfYearMax == 4 || weekOfYearMax == 6 || weekOfYearMax == 8 || weekOfYearMax == 10 || weekOfYearMax == 12 || weekOfYearMax == 14 || weekOfYearMax == 16
                                    || weekOfYearMax == 18 || weekOfYearMax == 20 || weekOfYearMax == 22 || weekOfYearMax == 24 || weekOfYearMax == 26 || weekOfYearMax == 28 || weekOfYearMax == 30 || weekOfYearMax == 32
                                    || weekOfYearMax == 34 || weekOfYearMax == 36 || weekOfYearMax == 38 || weekOfYearMax == 40 || weekOfYearMax == 42 || weekOfYearMax == 44 || weekOfYearMax == 46
                                    || weekOfYearMax == 48 || weekOfYearMax == 50 || weekOfYearMax == 52) {
                                choosedDay();
                            } else {
                                btnWeekDay8.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                                linearLayout8.setVisibility(View.VISIBLE);
                            }
                            break;
                    }
                } else {
                    switch (view.getId()) {

                        case R.id.buttonWeekOne:
                            groupsButton1.setVisibility(View.VISIBLE);
                            groupsButton2.setVisibility(View.GONE);
                            if (weekOfYearMax == 1 || weekOfYearMax == 3 || weekOfYearMax == 5 || weekOfYearMax == 7 || weekOfYearMax == 9 || weekOfYearMax == 11 || weekOfYearMax == 13 || weekOfYearMax == 15
                                    || weekOfYearMax == 17 || weekOfYearMax == 19 || weekOfYearMax == 21 || weekOfYearMax == 23 || weekOfYearMax == 25 || weekOfYearMax == 27 || weekOfYearMax == 29
                                    || weekOfYearMax == 31 || weekOfYearMax == 33 || weekOfYearMax == 35 || weekOfYearMax == 37 || weekOfYearMax == 39 || weekOfYearMax == 41 || weekOfYearMax == 43 || weekOfYearMax == 45
                                    || weekOfYearMax == 47 || weekOfYearMax == 49 || weekOfYearMax == 51) {
                                choosedDay();
                            } else {
                                btnWeekDay1.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                                linearLayout1.setVisibility(View.VISIBLE);
                            }
                            break;
                        case R.id.buttonWeekTwo:
                            groupsButton2.setVisibility(View.VISIBLE);
                            groupsButton1.setVisibility(View.GONE);
                            if (weekOfYearMax == 2 || weekOfYearMax == 4 || weekOfYearMax == 6 || weekOfYearMax == 8 || weekOfYearMax == 10 || weekOfYearMax == 12 || weekOfYearMax == 14 || weekOfYearMax == 16
                                    || weekOfYearMax == 18 || weekOfYearMax == 20 || weekOfYearMax == 22 || weekOfYearMax == 24 || weekOfYearMax == 26 || weekOfYearMax == 28 || weekOfYearMax == 30 || weekOfYearMax == 32
                                    || weekOfYearMax == 34 || weekOfYearMax == 36 || weekOfYearMax == 38 || weekOfYearMax == 40 || weekOfYearMax == 42 || weekOfYearMax == 44 || weekOfYearMax == 46
                                    || weekOfYearMax == 48 || weekOfYearMax == 50 || weekOfYearMax == 52 || weekOfYearMax == 53) {
                                choosedDay();
                            } else {
                                btnWeekDay8.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                                linearLayout8.setVisibility(View.VISIBLE);
                            }
                            break;
                    }
                }
                break;
        }


        switch (view.getId()) {
            case R.id.buttonWeekOne:
                buttonWeekOne.setBackgroundResource(R.drawable.form_schedule_btn);
                buttonWeekTwo.setBackgroundResource(R.drawable.form_schedule_lessons);
                if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO) {
                    buttonWeekOne.setTextColor(Color.WHITE);
                    buttonWeekTwo.setTextColor(getResources().getColor(R.color.colorBlack));
                } else {
                    buttonWeekOne.setTextColor(getResources().getColor(R.color.colorBlack));
                    buttonWeekTwo.setTextColor(Color.WHITE);
                }
                onClicKweek = false;
                break;
            case R.id.buttonWeekTwo:
                buttonWeekTwo.setBackgroundResource(R.drawable.form_schedule_btn);
                buttonWeekOne.setBackgroundResource(R.drawable.form_schedule_lessons);
                if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO) {
                    buttonWeekTwo.setTextColor(Color.WHITE);
                    buttonWeekOne.setTextColor(getResources().getColor(R.color.colorBlack));
                } else {
                    buttonWeekTwo.setTextColor(getResources().getColor(R.color.colorBlack));
                    buttonWeekOne.setTextColor(Color.WHITE);
                }
                onClicKweek = true;
                break;
        }
    }

    //СКРЫВАЕМ LinearLayout'Ы
    private void linInvisible() {
        linearLayout1.setVisibility(View.INVISIBLE);
        linearLayout2.setVisibility(View.INVISIBLE);
        linearLayout3.setVisibility(View.INVISIBLE);
        linearLayout4.setVisibility(View.INVISIBLE);
        linearLayout6.setVisibility(View.INVISIBLE);
        linearLayout5.setVisibility(View.INVISIBLE);
        linearLayout8.setVisibility(View.INVISIBLE);
        linearLayout9.setVisibility(View.INVISIBLE);
        linearLayout10.setVisibility(View.INVISIBLE);
        linearLayout11.setVisibility(View.INVISIBLE);
        linearLayout12.setVisibility(View.INVISIBLE);
        linearLayout13.setVisibility(View.INVISIBLE);
    }

    //РЕАЛИЗАЦИЯ НАЖАТИЯ НА ДНИ
    public void onClickDay(View view) {
        //УСТАНОВКА DEFAULT ЦВЕТА (ГОЛУБОЙ) НА КНОПКИ
        btnWeekDay1.setBackgroundResource(R.drawable.form_schedule_btn);
        btnWeekDay2.setBackgroundResource(R.drawable.form_schedule_btn);
        btnWeekDay3.setBackgroundResource(R.drawable.form_schedule_btn);
        btnWeekDay4.setBackgroundResource(R.drawable.form_schedule_btn);
        btnWeekDay5.setBackgroundResource(R.drawable.form_schedule_btn);
        btnWeekDay6.setBackgroundResource(R.drawable.form_schedule_btn);
        btnWeekDay8.setBackgroundResource(R.drawable.form_schedule_btn);
        btnWeekDay9.setBackgroundResource(R.drawable.form_schedule_btn);
        btnWeekDay10.setBackgroundResource(R.drawable.form_schedule_btn);
        btnWeekDay11.setBackgroundResource(R.drawable.form_schedule_btn);
        btnWeekDay12.setBackgroundResource(R.drawable.form_schedule_btn);
        btnWeekDay13.setBackgroundResource(R.drawable.form_schedule_btn);

        //ВЫЗЫВАЕМ МЕТОД КОТОРЫЙ ОТПРЕДЕЛЯЕТ СЕГОДНЯЕШНИЙ ДЕНЬ
        //setFormGreenOnToDay();
        //УСТАНОВКА DEFAULT INVISIBLE (НЕВИДИМОСТЬ) НА КНОПКИ
        linearLayout1.setVisibility(View.INVISIBLE);
        linearLayout2.setVisibility(View.INVISIBLE);
        linearLayout3.setVisibility(View.INVISIBLE);
        linearLayout4.setVisibility(View.INVISIBLE);
        linearLayout5.setVisibility(View.INVISIBLE);
        linearLayout6.setVisibility(View.INVISIBLE);
        linearLayout8.setVisibility(View.INVISIBLE);
        linearLayout9.setVisibility(View.INVISIBLE);
        linearLayout10.setVisibility(View.INVISIBLE);
        linearLayout11.setVisibility(View.INVISIBLE);
        linearLayout12.setVisibility(View.INVISIBLE);
        linearLayout13.setVisibility(View.INVISIBLE);
        scrollView.setVisibility(View.VISIBLE);
        form_lessons_sunday.setVisibility(View.INVISIBLE);
        form_lessons_sunday_text.setVisibility(View.INVISIBLE);
        onClicDaySunday = false;

        switch (view.getId()) {
            case R.id.btnWeekDay1:
                linearLayout1.setVisibility(View.VISIBLE);
                btnWeekDay1.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                break;
            case R.id.btnWeekDay2:
                linearLayout2.setVisibility(View.VISIBLE);
                btnWeekDay2.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                break;
            case R.id.btnWeekDay3:
                linearLayout3.setVisibility(View.VISIBLE);
                btnWeekDay3.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                break;
            case R.id.btnWeekDay4:
                linearLayout4.setVisibility(View.VISIBLE);
                btnWeekDay4.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                break;
            case R.id.btnWeekDay5:
                linearLayout5.setVisibility(View.VISIBLE);
                btnWeekDay5.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                break;
            case R.id.btnWeekDay6:
                sundayFormWeek1();
                onClicDaySunday = true;
                break;
            case R.id.btnWeekDay8:
                linearLayout8.setVisibility(View.VISIBLE);
                btnWeekDay8.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                break;
            case R.id.btnWeekDay9:
                linearLayout9.setVisibility(View.VISIBLE);
                btnWeekDay9.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                break;
            case R.id.btnWeekDay10:
                linearLayout10.setVisibility(View.VISIBLE);
                btnWeekDay10.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                break;
            case R.id.btnWeekDay11:
                linearLayout11.setVisibility(View.VISIBLE);
                btnWeekDay11.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                break;
            case R.id.btnWeekDay12:
                linearLayout12.setVisibility(View.VISIBLE);
                btnWeekDay12.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                break;
            case R.id.btnWeekDay13:
                sundayFormWeek2();
                onClicDaySunday = true;
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void editSchedule(View view) {
        imageBellRealy.setVisibility(View.INVISIBLE);
        imageEllipse.setVisibility(View.INVISIBLE);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.pencil_hide_anim);
        pencilImage.startAnimation(animation);
        pencilImage.setVisibility(View.INVISIBLE);
        imageReady.setVisibility(View.INVISIBLE);
        imageEllipse2.setVisibility(View.VISIBLE);
        imageBell.setVisibility(View.VISIBLE);
        Animation animDef = AnimationUtils.loadAnimation(this, R.anim.pencil_visible_anim);
        buttonDefault.startAnimation(animDef);
        setPermissionsEdit();
        Drawable drawableready = imageBell.getDrawable();
        if (drawableready instanceof AnimatedVectorDrawableCompat) {
            avd = (AnimatedVectorDrawableCompat) drawableready;
            avd.start();
        } else if (drawableready instanceof AnimatedVectorDrawable) {
            avd2 = (AnimatedVectorDrawable) drawableready;
            avd2.start();
        }
    }

    //Class БАЗЫ ДЫННЫХ
    class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            // конструктор суперкласса
            super(context, "myDB", null, 1);
        }

        public void onCreate(SQLiteDatabase db) {
            Log.d(LOG_TAG, "--- onCreate database ---");
            // создаем таблицу с полями
            db.execSQL("create table mydgu ("
                    + "id integer primary key autoincrement,"
                    + "lessonOne text,"
                    + "auditoreOne integer,"
                    + "teacherOne text,"
                    + "lessonTwo text,"
                    + "auditoreTwo integer,"
                    + "teacherTwo text,"
                    + "lessonThree text,"
                    + "auditoreThree integer,"
                    + "teacherThree text,"
                    + "lessonFour text,"
                    + "auditoreFour integer,"
                    + "teacherFour text,"
                    + "lessonFive text,"
                    + "auditoreFive integer,"
                    + "teacherFive text,"
                    + "lessonSix text,"
                    + "auditoreSix integer,"
                    + "teacherSix text" + ");");
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

    //ОПРЕДЕЛЯЕМ ВСЕ EditText'Ы
    public void findViewEditText() {
        //1Й ДЕНЬ
        editTextLesson11 = findViewById(R.id.editTextLesson11);
        editTextLesson12 = findViewById(R.id.editTextLesson12);
        editTextLesson13 = findViewById(R.id.editTextLesson13);
        editTextLesson14 = findViewById(R.id.editTextLesson14);
        editTextLesson15 = findViewById(R.id.editTextLesson15);
        editTextLesson16 = findViewById(R.id.editTextLesson16);

        editTextAuditores11 = findViewById(R.id.editTextAuditores11);
        editTextAuditores12 = findViewById(R.id.editTextAuditores12);
        editTextAuditores13 = findViewById(R.id.editTextAuditores13);
        editTextAuditores14 = findViewById(R.id.editTextAuditores14);
        editTextAuditores15 = findViewById(R.id.editTextAuditores15);
        editTextAuditores16 = findViewById(R.id.editTextAuditores16);

        editTextTeacher11 = findViewById(R.id.editTextTeacher11);
        editTextTeacher12 = findViewById(R.id.editTextTeacher12);
        editTextTeacher13 = findViewById(R.id.editTextTeacher13);
        editTextTeacher14 = findViewById(R.id.editTextTeacher14);
        editTextTeacher15 = findViewById(R.id.editTextTeacher15);
        editTextTeacher16 = findViewById(R.id.editTextTeacher16);
        //2Й ДЕНЬ
        editTextLesson21 = findViewById(R.id.editTextLesson21);
        editTextLesson22 = findViewById(R.id.editTextLesson22);
        editTextLesson23 = findViewById(R.id.editTextLesson23);
        editTextLesson24 = findViewById(R.id.editTextLesson24);
        editTextLesson25 = findViewById(R.id.editTextLesson25);
        editTextLesson26 = findViewById(R.id.editTextLesson26);

        editTextAuditores21 = findViewById(R.id.editTextAuditores21);
        editTextAuditores22 = findViewById(R.id.editTextAuditores22);
        editTextAuditores23 = findViewById(R.id.editTextAuditores23);
        editTextAuditores24 = findViewById(R.id.editTextAuditores24);
        editTextAuditores25 = findViewById(R.id.editTextAuditores25);
        editTextAuditores26 = findViewById(R.id.editTextAuditores26);

        editTextTeacher21 = findViewById(R.id.editTextTeacher21);
        editTextTeacher22 = findViewById(R.id.editTextTeacher22);
        editTextTeacher23 = findViewById(R.id.editTextTeacher23);
        editTextTeacher24 = findViewById(R.id.editTextTeacher24);
        editTextTeacher25 = findViewById(R.id.editTextTeacher25);
        editTextTeacher26 = findViewById(R.id.editTextTeacher26);

        //3Й ДЕНЬ
        editTextLesson31 = findViewById(R.id.editTextLesson31);
        editTextLesson32 = findViewById(R.id.editTextLesson32);
        editTextLesson33 = findViewById(R.id.editTextLesson33);
        editTextLesson34 = findViewById(R.id.editTextLesson34);
        editTextLesson35 = findViewById(R.id.editTextLesson35);
        editTextLesson36 = findViewById(R.id.editTextLesson36);

        editTextAuditores31 = findViewById(R.id.editTextAuditores31);
        editTextAuditores32 = findViewById(R.id.editTextAuditores32);
        editTextAuditores33 = findViewById(R.id.editTextAuditores33);
        editTextAuditores34 = findViewById(R.id.editTextAuditores34);
        editTextAuditores35 = findViewById(R.id.editTextAuditores35);
        editTextAuditores36 = findViewById(R.id.editTextAuditores36);

        editTextTeacher31 = findViewById(R.id.editTextTeacher31);
        editTextTeacher32 = findViewById(R.id.editTextTeacher32);
        editTextTeacher33 = findViewById(R.id.editTextTeacher33);
        editTextTeacher34 = findViewById(R.id.editTextTeacher34);
        editTextTeacher35 = findViewById(R.id.editTextTeacher35);
        editTextTeacher36 = findViewById(R.id.editTextTeacher36);

        //4Й ДЕНЬ
        editTextLesson41 = findViewById(R.id.editTextLesson41);
        editTextLesson42 = findViewById(R.id.editTextLesson42);
        editTextLesson43 = findViewById(R.id.editTextLesson43);
        editTextLesson44 = findViewById(R.id.editTextLesson44);
        editTextLesson45 = findViewById(R.id.editTextLesson45);
        editTextLesson46 = findViewById(R.id.editTextLesson46);

        editTextAuditores41 = findViewById(R.id.editTextAuditores41);
        editTextAuditores42 = findViewById(R.id.editTextAuditores42);
        editTextAuditores43 = findViewById(R.id.editTextAuditores43);
        editTextAuditores44 = findViewById(R.id.editTextAuditores44);
        editTextAuditores45 = findViewById(R.id.editTextAuditores45);
        editTextAuditores46 = findViewById(R.id.editTextAuditores46);

        editTextTeacher41 = findViewById(R.id.editTextTeacher41);
        editTextTeacher42 = findViewById(R.id.editTextTeacher42);
        editTextTeacher43 = findViewById(R.id.editTextTeacher43);
        editTextTeacher44 = findViewById(R.id.editTextTeacher44);
        editTextTeacher45 = findViewById(R.id.editTextTeacher45);
        editTextTeacher46 = findViewById(R.id.editTextTeacher46);
//        editTextTeacher47 = findViewById(R.id.editTextTeacher47)

        //5Й ДЕНЬ
        editTextLesson51 = findViewById(R.id.editTextLesson51);
        editTextLesson52 = findViewById(R.id.editTextLesson52);
        editTextLesson53 = findViewById(R.id.editTextLesson53);
        editTextLesson54 = findViewById(R.id.editTextLesson54);
        editTextLesson55 = findViewById(R.id.editTextLesson55);
        editTextLesson56 = findViewById(R.id.editTextLesson56);

        editTextAuditores51 = findViewById(R.id.editTextAuditores51);
        editTextAuditores52 = findViewById(R.id.editTextAuditores52);
        editTextAuditores53 = findViewById(R.id.editTextAuditores53);
        editTextAuditores54 = findViewById(R.id.editTextAuditores54);
        editTextAuditores55 = findViewById(R.id.editTextAuditores55);
        editTextAuditores56 = findViewById(R.id.editTextAuditores56);

        editTextTeacher51 = findViewById(R.id.editTextTeacher51);
        editTextTeacher52 = findViewById(R.id.editTextTeacher52);
        editTextTeacher53 = findViewById(R.id.editTextTeacher53);
        editTextTeacher54 = findViewById(R.id.editTextTeacher54);
        editTextTeacher55 = findViewById(R.id.editTextTeacher55);
        editTextTeacher56 = findViewById(R.id.editTextTeacher56);

        //6Й ДЕНЬ
        editTextLesson61 = findViewById(R.id.editTextLesson61);
        editTextLesson62 = findViewById(R.id.editTextLesson62);
        editTextLesson63 = findViewById(R.id.editTextLesson63);
        editTextLesson64 = findViewById(R.id.editTextLesson64);
        editTextLesson65 = findViewById(R.id.editTextLesson65);
        editTextLesson66 = findViewById(R.id.editTextLesson66);
//        editTextLesson67 = findViewById(R.id.editTextLesson67)

        editTextAuditores61 = findViewById(R.id.editTextAuditores61);
        editTextAuditores62 = findViewById(R.id.editTextAuditores62);
        editTextAuditores63 = findViewById(R.id.editTextAuditores63);
        editTextAuditores64 = findViewById(R.id.editTextAuditores64);
        editTextAuditores65 = findViewById(R.id.editTextAuditores65);
        editTextAuditores66 = findViewById(R.id.editTextAuditores66);

        editTextTeacher61 = findViewById(R.id.editTextTeacher61);
        editTextTeacher62 = findViewById(R.id.editTextTeacher62);
        editTextTeacher63 = findViewById(R.id.editTextTeacher63);
        editTextTeacher64 = findViewById(R.id.editTextTeacher64);
        editTextTeacher65 = findViewById(R.id.editTextTeacher65);
        editTextTeacher66 = findViewById(R.id.editTextTeacher66);

        //8Й ДЕНЬ
        editTextLesson81 = findViewById(R.id.editTextLesson81);
        editTextLesson82 = findViewById(R.id.editTextLesson82);
        editTextLesson83 = findViewById(R.id.editTextLesson83);
        editTextLesson84 = findViewById(R.id.editTextLesson84);
        editTextLesson85 = findViewById(R.id.editTextLesson85);
        editTextLesson86 = findViewById(R.id.editTextLesson86);

        editTextAuditores81 = findViewById(R.id.editTextAuditores81);
        editTextAuditores82 = findViewById(R.id.editTextAuditores82);
        editTextAuditores83 = findViewById(R.id.editTextAuditores83);
        editTextAuditores84 = findViewById(R.id.editTextAuditores84);
        editTextAuditores85 = findViewById(R.id.editTextAuditores85);
        editTextAuditores86 = findViewById(R.id.editTextAuditores86);

        editTextTeacher81 = findViewById(R.id.editTextTeacher81);
        editTextTeacher82 = findViewById(R.id.editTextTeacher82);
        editTextTeacher83 = findViewById(R.id.editTextTeacher83);
        editTextTeacher84 = findViewById(R.id.editTextTeacher84);
        editTextTeacher85 = findViewById(R.id.editTextTeacher85);
        editTextTeacher86 = findViewById(R.id.editTextTeacher86);

        //9Й ДЕНЬ
        editTextLesson91 = findViewById(R.id.editTextLesson91);
        editTextLesson92 = findViewById(R.id.editTextLesson92);
        editTextLesson93 = findViewById(R.id.editTextLesson93);
        editTextLesson94 = findViewById(R.id.editTextLesson94);
        editTextLesson95 = findViewById(R.id.editTextLesson95);
        editTextLesson96 = findViewById(R.id.editTextLesson96);

        editTextAuditores91 = findViewById(R.id.editTextAuditores91);
        editTextAuditores92 = findViewById(R.id.editTextAuditores92);
        editTextAuditores93 = findViewById(R.id.editTextAuditores93);
        editTextAuditores94 = findViewById(R.id.editTextAuditores94);
        editTextAuditores95 = findViewById(R.id.editTextAuditores95);
        editTextAuditores96 = findViewById(R.id.editTextAuditores96);

        editTextTeacher91 = findViewById(R.id.editTextTeacher91);
        editTextTeacher92 = findViewById(R.id.editTextTeacher92);
        editTextTeacher93 = findViewById(R.id.editTextTeacher93);
        editTextTeacher94 = findViewById(R.id.editTextTeacher94);
        editTextTeacher95 = findViewById(R.id.editTextTeacher95);
        editTextTeacher96 = findViewById(R.id.editTextTeacher96);

        //10Й ДЕНЬ
        editTextLesson101 = findViewById(R.id.editTextLesson101);
        editTextLesson102 = findViewById(R.id.editTextLesson102);
        editTextLesson103 = findViewById(R.id.editTextLesson103);
        editTextLesson104 = findViewById(R.id.editTextLesson104);
        editTextLesson105 = findViewById(R.id.editTextLesson105);
        editTextLesson106 = findViewById(R.id.editTextLesson106);

        editTextAuditores101 = findViewById(R.id.editTextAuditores101);
        editTextAuditores102 = findViewById(R.id.editTextAuditores102);
        editTextAuditores103 = findViewById(R.id.editTextAuditores103);
        editTextAuditores104 = findViewById(R.id.editTextAuditores104);
        editTextAuditores105 = findViewById(R.id.editTextAuditores105);
        editTextAuditores106 = findViewById(R.id.editTextAuditores106);

        editTextTeacher101 = findViewById(R.id.editTextTeacher101);
        editTextTeacher102 = findViewById(R.id.editTextTeacher102);
        editTextTeacher103 = findViewById(R.id.editTextTeacher103);
        editTextTeacher104 = findViewById(R.id.editTextTeacher104);
        editTextTeacher105 = findViewById(R.id.editTextTeacher105);
        editTextTeacher106 = findViewById(R.id.editTextTeacher106);

        //11Й ДЕНЬ
        editTextLesson111 = findViewById(R.id.editTextLesson111);
        editTextLesson112 = findViewById(R.id.editTextLesson112);
        editTextLesson113 = findViewById(R.id.editTextLesson113);
        editTextLesson114 = findViewById(R.id.editTextLesson114);
        editTextLesson115 = findViewById(R.id.editTextLesson115);
        editTextLesson116 = findViewById(R.id.editTextLesson116);

        editTextAuditores111 = findViewById(R.id.editTextAuditores111);
        editTextAuditores112 = findViewById(R.id.editTextAuditores112);
        editTextAuditores113 = findViewById(R.id.editTextAuditores113);
        editTextAuditores114 = findViewById(R.id.editTextAuditores114);
        editTextAuditores115 = findViewById(R.id.editTextAuditores115);
        editTextAuditores116 = findViewById(R.id.editTextAuditores116);

        editTextTeacher111 = findViewById(R.id.editTextTeacher111);
        editTextTeacher112 = findViewById(R.id.editTextTeacher112);
        editTextTeacher113 = findViewById(R.id.editTextTeacher113);
        editTextTeacher114 = findViewById(R.id.editTextTeacher114);
        editTextTeacher115 = findViewById(R.id.editTextTeacher115);
        editTextTeacher116 = findViewById(R.id.editTextTeacher116);

        //12Й ДЕНЬ
        editTextLesson121 = findViewById(R.id.editTextLesson121);
        editTextLesson122 = findViewById(R.id.editTextLesson122);
        editTextLesson123 = findViewById(R.id.editTextLesson123);
        editTextLesson124 = findViewById(R.id.editTextLesson124);
        editTextLesson125 = findViewById(R.id.editTextLesson125);
        editTextLesson126 = findViewById(R.id.editTextLesson126);

        editTextAuditores121 = findViewById(R.id.editTextAuditores121);
        editTextAuditores122 = findViewById(R.id.editTextAuditores122);
        editTextAuditores123 = findViewById(R.id.editTextAuditores123);
        editTextAuditores124 = findViewById(R.id.editTextAuditores124);
        editTextAuditores125 = findViewById(R.id.editTextAuditores125);
        editTextAuditores126 = findViewById(R.id.editTextAuditores126);

        editTextTeacher121 = findViewById(R.id.editTextTeacher121);
        editTextTeacher122 = findViewById(R.id.editTextTeacher122);
        editTextTeacher123 = findViewById(R.id.editTextTeacher123);
        editTextTeacher124 = findViewById(R.id.editTextTeacher124);
        editTextTeacher125 = findViewById(R.id.editTextTeacher125);
        editTextTeacher126 = findViewById(R.id.editTextTeacher126);

        //13Й ДЕНЬ
        editTextLesson131 = findViewById(R.id.editTextLesson131);
        editTextLesson132 = findViewById(R.id.editTextLesson132);
        editTextLesson133 = findViewById(R.id.editTextLesson133);
        editTextLesson134 = findViewById(R.id.editTextLesson134);
        editTextLesson135 = findViewById(R.id.editTextLesson135);
        editTextLesson136 = findViewById(R.id.editTextLesson136);

        editTextAuditores131 = findViewById(R.id.editTextAuditores131);
        editTextAuditores132 = findViewById(R.id.editTextAuditores132);
        editTextAuditores133 = findViewById(R.id.editTextAuditores133);
        editTextAuditores134 = findViewById(R.id.editTextAuditores134);
        editTextAuditores135 = findViewById(R.id.editTextAuditores135);
        editTextAuditores136 = findViewById(R.id.editTextAuditores136);

        editTextTeacher131 = findViewById(R.id.editTextTeacher131);
        editTextTeacher132 = findViewById(R.id.editTextTeacher132);
        editTextTeacher133 = findViewById(R.id.editTextTeacher133);
        editTextTeacher134 = findViewById(R.id.editTextTeacher134);
        editTextTeacher135 = findViewById(R.id.editTextTeacher135);
        editTextTeacher136 = findViewById(R.id.editTextTeacher136);

    }

    //НАЖАТИЕ НА КНОПКУ НАЗАД
    @Override
    public void onBackPressed() {
        try {
            Intent intentBack = new Intent(Schedule.this, MainActivity.class);
            startActivity(intentBack);
            finish();
            overridePendingTransition(R.anim.alpha_zero_one, R.anim.alpha_one_zero);
        } catch (Exception e) {

        }
    }

    //ПОЛУЧАЕМ И ПОКАЗЫВАЕМ СЕГОДНЯШНИЙ ДЕНЬ
    private void choosedDay() {
        linInvisible();

        int max = maxDayOfMonth.getActualMaximum(Calendar.DAY_OF_MONTH);

        dayOfMonthMinus1 = dayOfMonth - 1;
        dayOfMonthMinus2 = dayOfMonth - 2;
        dayOfMonthMinus3 = dayOfMonth - 3;
        dayOfMonthMinus4 = dayOfMonth - 4;
        dayOfMonthMinus5 = dayOfMonth - 5;
        dayOfMonthMinus6 = dayOfMonth - 6;
        dayOfMonthMinus7 = dayOfMonth - 7;
        dayOfMonthMinus8 = dayOfMonth - 8;
        dayOfMonthMinus9 = dayOfMonth - 9;
        dayOfMonthMinus10 = dayOfMonth - 10;
        dayOfMonthMinus11 = dayOfMonth - 11;
        dayOfMonthMinus12 = dayOfMonth - 12;
        dayOfMonthMinus13 = dayOfMonth - 13;

        dayOfMonthPlus1 = dayOfMonth + 1;
        dayOfMonthPlus2 = dayOfMonth + 2;
        dayOfMonthPlus3 = dayOfMonth + 3;
        dayOfMonthPlus4 = dayOfMonth + 4;
        dayOfMonthPlus5 = dayOfMonth + 5;
        dayOfMonthPlus6 = dayOfMonth + 6;
        dayOfMonthPlus7 = dayOfMonth + 7;
        dayOfMonthPlus8 = dayOfMonth + 8;
        dayOfMonthPlus9 = dayOfMonth + 9;
        dayOfMonthPlus10 = dayOfMonth + 10;
        dayOfMonthPlus11 = dayOfMonth + 11;
        dayOfMonthPlus12 = dayOfMonth + 12;
        dayOfMonthPlus13 = dayOfMonth + 13;

        //ОГРАНИЧЕНИЕ БОЛЬШЕ 31 ЧИСЛА
        if (dayOfMonthMax == 30) {
            if (dayOfMonthPlus1 == 31) {
                dayOfMonthPlus1 = 1;
                dayOfMonthPlus2 = 2;
                dayOfMonthPlus3 = 3;
                dayOfMonthPlus4 = 4;
                dayOfMonthPlus5 = 5;
                dayOfMonthPlus6 = 6;
                dayOfMonthPlus7 = 7;
                dayOfMonthPlus8 = 8;
                dayOfMonthPlus9 = 9;
                dayOfMonthPlus10 = 10;
                dayOfMonthPlus11 = 11;
                dayOfMonthPlus12 = 12;
                dayOfMonthPlus13 = 13;
            } else if (dayOfMonthPlus2 == 31) {
                dayOfMonthPlus2 = 1;
                dayOfMonthPlus3 = 2;
                dayOfMonthPlus4 = 3;
                dayOfMonthPlus5 = 4;
                dayOfMonthPlus6 = 5;
                dayOfMonthPlus7 = 6;
                dayOfMonthPlus8 = 7;
                dayOfMonthPlus9 = 8;
                dayOfMonthPlus10 = 9;
                dayOfMonthPlus11 = 10;
                dayOfMonthPlus12 = 11;
                dayOfMonthPlus13 = 12;
            } else if (dayOfMonthPlus3 == 31) {
                dayOfMonthPlus3 = 1;
                dayOfMonthPlus4 = 2;
                dayOfMonthPlus5 = 3;
                dayOfMonthPlus6 = 4;
                dayOfMonthPlus7 = 5;
                dayOfMonthPlus8 = 6;
                dayOfMonthPlus9 = 7;
                dayOfMonthPlus10 = 8;
                dayOfMonthPlus11 = 9;
                dayOfMonthPlus12 = 10;
                dayOfMonthPlus13 = 11;
            } else if (dayOfMonthPlus4 == 31) {
                dayOfMonthPlus4 = 1;
                dayOfMonthPlus5 = 2;
                dayOfMonthPlus6 = 3;
                dayOfMonthPlus7 = 4;
                dayOfMonthPlus8 = 5;
                dayOfMonthPlus9 = 6;
                dayOfMonthPlus10 = 7;
                dayOfMonthPlus11 = 8;
                dayOfMonthPlus12 = 9;
                dayOfMonthPlus13 = 10;
            } else if (dayOfMonthPlus5 == 31) {
                dayOfMonthPlus5 = 1;
                dayOfMonthPlus6 = 2;
                dayOfMonthPlus7 = 3;
                dayOfMonthPlus8 = 4;
                dayOfMonthPlus9 = 5;
                dayOfMonthPlus10 = 6;
                dayOfMonthPlus11 = 7;
                dayOfMonthPlus12 = 8;
                dayOfMonthPlus13 = 9;
            } else if (dayOfMonthPlus6 == 31) {
                dayOfMonthPlus6 = 1;
                dayOfMonthPlus7 = 2;
                dayOfMonthPlus8 = 3;
                dayOfMonthPlus9 = 4;
                dayOfMonthPlus10 = 5;
                dayOfMonthPlus11 = 6;
                dayOfMonthPlus12 = 7;
                dayOfMonthPlus13 = 8;
            } else if (dayOfMonthPlus7 == 31) {
                dayOfMonthPlus7 = 1;
                dayOfMonthPlus8 = 2;
                dayOfMonthPlus9 = 3;
                dayOfMonthPlus10 = 4;
                dayOfMonthPlus11 = 5;
                dayOfMonthPlus12 = 6;
                dayOfMonthPlus13 = 7;
            } else if (dayOfMonthPlus8 == 31) {
                dayOfMonthPlus8 = 1;
                dayOfMonthPlus9 = 2;
                dayOfMonthPlus10 = 3;
                dayOfMonthPlus11 = 4;
                dayOfMonthPlus12 = 5;
                dayOfMonthPlus13 = 6;
            } else if (dayOfMonthPlus9 == 31) {
                dayOfMonthPlus9 = 1;
                dayOfMonthPlus10 = 2;
                dayOfMonthPlus11 = 3;
                dayOfMonthPlus12 = 4;
                dayOfMonthPlus13 = 5;
            } else if (dayOfMonthPlus10 == 31) {
                dayOfMonthPlus10 = 1;
                dayOfMonthPlus11 = 2;
                dayOfMonthPlus12 = 3;
                dayOfMonthPlus13 = 4;
            } else if (dayOfMonthPlus11 == 31) {
                dayOfMonthPlus11 = 1;
                dayOfMonthPlus12 = 2;
                dayOfMonthPlus13 = 3;
            } else if (dayOfMonthPlus12 == 31) {
                dayOfMonthPlus12 = 1;
                dayOfMonthPlus13 = 2;
            } else if (dayOfMonthPlus13 == 31) {
                dayOfMonthPlus13 = 1;
            }
        } else if (dayOfMonthMax == 31) {
            if (dayOfMonthPlus1 == 32) {
                dayOfMonthPlus1 = 1;
                dayOfMonthPlus2 = 2;
                dayOfMonthPlus3 = 3;
                dayOfMonthPlus4 = 4;
                dayOfMonthPlus5 = 5;
                dayOfMonthPlus6 = 6;
                dayOfMonthPlus7 = 7;
                dayOfMonthPlus8 = 8;
                dayOfMonthPlus9 = 9;
                dayOfMonthPlus10 = 10;
                dayOfMonthPlus11 = 11;
                dayOfMonthPlus12 = 12;
                dayOfMonthPlus13 = 13;
            } else if (dayOfMonthPlus2 == 32) {
                dayOfMonthPlus2 = 1;
                dayOfMonthPlus3 = 2;
                dayOfMonthPlus4 = 3;
                dayOfMonthPlus5 = 4;
                dayOfMonthPlus6 = 5;
                dayOfMonthPlus7 = 6;
                dayOfMonthPlus8 = 7;
                dayOfMonthPlus9 = 8;
                dayOfMonthPlus10 = 9;
                dayOfMonthPlus11 = 10;
                dayOfMonthPlus12 = 11;
                dayOfMonthPlus13 = 12;
            } else if (dayOfMonthPlus3 == 32) {
                dayOfMonthPlus3 = 1;
                dayOfMonthPlus4 = 2;
                dayOfMonthPlus5 = 3;
                dayOfMonthPlus6 = 4;
                dayOfMonthPlus7 = 5;
                dayOfMonthPlus8 = 6;
                dayOfMonthPlus9 = 7;
                dayOfMonthPlus10 = 8;
                dayOfMonthPlus11 = 9;
                dayOfMonthPlus12 = 10;
                dayOfMonthPlus13 = 11;
            } else if (dayOfMonthPlus4 == 32) {
                dayOfMonthPlus4 = 1;
                dayOfMonthPlus5 = 2;
                dayOfMonthPlus6 = 3;
                dayOfMonthPlus7 = 4;
                dayOfMonthPlus8 = 5;
                dayOfMonthPlus9 = 6;
                dayOfMonthPlus10 = 7;
                dayOfMonthPlus11 = 8;
                dayOfMonthPlus12 = 9;
                dayOfMonthPlus13 = 10;
            } else if (dayOfMonthPlus5 == 32) {
                dayOfMonthPlus5 = 1;
                dayOfMonthPlus6 = 2;
                dayOfMonthPlus7 = 3;
                dayOfMonthPlus8 = 4;
                dayOfMonthPlus9 = 5;
                dayOfMonthPlus10 = 6;
                dayOfMonthPlus11 = 7;
                dayOfMonthPlus12 = 8;
                dayOfMonthPlus13 = 9;
            } else if (dayOfMonthPlus6 == 32) {
                dayOfMonthPlus6 = 1;
                dayOfMonthPlus7 = 2;
                dayOfMonthPlus8 = 3;
                dayOfMonthPlus9 = 4;
                dayOfMonthPlus10 = 5;
                dayOfMonthPlus11 = 6;
                dayOfMonthPlus12 = 7;
                dayOfMonthPlus13 = 8;
            } else if (dayOfMonthPlus7 == 32) {
                dayOfMonthPlus7 = 1;
                dayOfMonthPlus8 = 2;
                dayOfMonthPlus9 = 3;
                dayOfMonthPlus10 = 4;
                dayOfMonthPlus11 = 5;
                dayOfMonthPlus12 = 6;
                dayOfMonthPlus13 = 7;
            } else if (dayOfMonthPlus8 == 32) {
                dayOfMonthPlus8 = 1;
                dayOfMonthPlus9 = 2;
                dayOfMonthPlus10 = 3;
                dayOfMonthPlus11 = 4;
                dayOfMonthPlus12 = 5;
                dayOfMonthPlus13 = 6;
            } else if (dayOfMonthPlus9 == 32) {
                dayOfMonthPlus9 = 1;
                dayOfMonthPlus10 = 2;
                dayOfMonthPlus11 = 3;
                dayOfMonthPlus12 = 4;
                dayOfMonthPlus13 = 5;
            } else if (dayOfMonthPlus10 == 32) {
                dayOfMonthPlus10 = 1;
                dayOfMonthPlus11 = 2;
                dayOfMonthPlus12 = 3;
                dayOfMonthPlus13 = 4;
            } else if (dayOfMonthPlus11 == 32) {
                dayOfMonthPlus11 = 1;
                dayOfMonthPlus12 = 2;
                dayOfMonthPlus13 = 3;
            } else if (dayOfMonthPlus12 == 32) {
                dayOfMonthPlus12 = 1;
                dayOfMonthPlus13 = 2;
            } else if (dayOfMonthPlus13 == 32) {
                dayOfMonthPlus13 = 1;
            }
        } else if (dayOfMonthMax == 28) {
            if (dayOfMonthPlus1 == 29) {
                dayOfMonthPlus1 = 1;
                dayOfMonthPlus2 = 2;
                dayOfMonthPlus3 = 3;
                dayOfMonthPlus4 = 4;
                dayOfMonthPlus5 = 5;
                dayOfMonthPlus6 = 6;
                dayOfMonthPlus7 = 7;
                dayOfMonthPlus8 = 8;
                dayOfMonthPlus9 = 9;
                dayOfMonthPlus10 = 10;
                dayOfMonthPlus11 = 11;
                dayOfMonthPlus12 = 12;
                dayOfMonthPlus13 = 13;
            } else if (dayOfMonthPlus2 == 29) {
                dayOfMonthPlus2 = 1;
                dayOfMonthPlus3 = 2;
                dayOfMonthPlus4 = 3;
                dayOfMonthPlus5 = 4;
                dayOfMonthPlus6 = 5;
                dayOfMonthPlus7 = 6;
                dayOfMonthPlus8 = 7;
                dayOfMonthPlus9 = 8;
                dayOfMonthPlus10 = 9;
                dayOfMonthPlus11 = 10;
                dayOfMonthPlus12 = 11;
                dayOfMonthPlus13 = 12;
            } else if (dayOfMonthPlus3 == 29) {
                dayOfMonthPlus3 = 1;
                dayOfMonthPlus4 = 2;
                dayOfMonthPlus5 = 3;
                dayOfMonthPlus6 = 4;
                dayOfMonthPlus7 = 5;
                dayOfMonthPlus8 = 6;
                dayOfMonthPlus9 = 7;
                dayOfMonthPlus10 = 8;
                dayOfMonthPlus11 = 9;
                dayOfMonthPlus12 = 10;
                dayOfMonthPlus13 = 11;
            } else if (dayOfMonthPlus4 == 29) {
                dayOfMonthPlus4 = 1;
                dayOfMonthPlus5 = 2;
                dayOfMonthPlus6 = 3;
                dayOfMonthPlus7 = 4;
                dayOfMonthPlus8 = 5;
                dayOfMonthPlus9 = 6;
                dayOfMonthPlus10 = 7;
                dayOfMonthPlus11 = 8;
                dayOfMonthPlus12 = 9;
                dayOfMonthPlus13 = 10;
            } else if (dayOfMonthPlus5 == 29) {
                dayOfMonthPlus5 = 1;
                dayOfMonthPlus6 = 2;
                dayOfMonthPlus7 = 3;
                dayOfMonthPlus8 = 4;
                dayOfMonthPlus9 = 5;
                dayOfMonthPlus10 = 6;
                dayOfMonthPlus11 = 7;
                dayOfMonthPlus12 = 8;
                dayOfMonthPlus13 = 9;
            } else if (dayOfMonthPlus6 == 29) {
                dayOfMonthPlus6 = 1;
                dayOfMonthPlus7 = 2;
                dayOfMonthPlus8 = 3;
                dayOfMonthPlus9 = 4;
                dayOfMonthPlus10 = 5;
                dayOfMonthPlus11 = 6;
                dayOfMonthPlus12 = 7;
                dayOfMonthPlus13 = 8;
            } else if (dayOfMonthPlus7 == 29) {
                dayOfMonthPlus7 = 1;
                dayOfMonthPlus8 = 2;
                dayOfMonthPlus9 = 3;
                dayOfMonthPlus10 = 4;
                dayOfMonthPlus11 = 5;
                dayOfMonthPlus12 = 6;
                dayOfMonthPlus13 = 7;
            } else if (dayOfMonthPlus8 == 29) {
                dayOfMonthPlus8 = 1;
                dayOfMonthPlus9 = 2;
                dayOfMonthPlus10 = 3;
                dayOfMonthPlus11 = 4;
                dayOfMonthPlus12 = 5;
                dayOfMonthPlus13 = 6;
            } else if (dayOfMonthPlus9 == 29) {
                dayOfMonthPlus9 = 1;
                dayOfMonthPlus10 = 2;
                dayOfMonthPlus11 = 3;
                dayOfMonthPlus12 = 4;
                dayOfMonthPlus13 = 5;
            } else if (dayOfMonthPlus10 == 29) {
                dayOfMonthPlus10 = 1;
                dayOfMonthPlus11 = 2;
                dayOfMonthPlus12 = 3;
                dayOfMonthPlus13 = 4;
            } else if (dayOfMonthPlus11 == 29) {
                dayOfMonthPlus11 = 1;
                dayOfMonthPlus12 = 2;
                dayOfMonthPlus13 = 3;
            } else if (dayOfMonthPlus12 == 29) {
                dayOfMonthPlus12 = 1;
                dayOfMonthPlus13 = 2;
            } else if (dayOfMonthPlus13 == 29) {
                dayOfMonthPlus13 = 1;
            }
        }

        //ОГРАНИЧЕНИЕ МЕНЬШЕ 0 ЧИСЛА
        if (max == 30) {
            if (dayOfMonthMinus1 == 0) {
                dayOfMonthMinus1 = 30;
                dayOfMonthMinus2 = 29;
                dayOfMonthMinus3 = 28;
                dayOfMonthMinus4 = 27;
                dayOfMonthMinus5 = 26;
                dayOfMonthMinus6 = 25;
                dayOfMonthMinus7 = 24;
                dayOfMonthMinus8 = 23;
                dayOfMonthMinus9 = 22;
                dayOfMonthMinus10 = 21;
                dayOfMonthMinus11 = 20;
                dayOfMonthMinus12 = 19;
                dayOfMonthMinus13 = 18;
            } else if (dayOfMonthMinus2 == 0) {
                dayOfMonthMinus2 = 30;
                dayOfMonthMinus3 = 29;
                dayOfMonthMinus4 = 28;
                dayOfMonthMinus5 = 27;
                dayOfMonthMinus6 = 26;
                dayOfMonthMinus7 = 25;
                dayOfMonthMinus8 = 24;
                dayOfMonthMinus9 = 23;
                dayOfMonthMinus10 = 22;
                dayOfMonthMinus11 = 21;
                dayOfMonthMinus12 = 20;
                dayOfMonthMinus13 = 19;
            } else if (dayOfMonthMinus3 == 0) {
                dayOfMonthMinus3 = 30;
                dayOfMonthMinus4 = 29;
                dayOfMonthMinus5 = 28;
                dayOfMonthMinus6 = 27;
                dayOfMonthMinus7 = 26;
                dayOfMonthMinus8 = 25;
                dayOfMonthMinus9 = 24;
                dayOfMonthMinus10 = 23;
                dayOfMonthMinus11 = 22;
                dayOfMonthMinus12 = 21;
                dayOfMonthMinus13 = 20;
            } else if (dayOfMonthMinus4 == 0) {
                dayOfMonthMinus4 = 30;
                dayOfMonthMinus5 = 29;
                dayOfMonthMinus6 = 28;
                dayOfMonthMinus7 = 27;
                dayOfMonthMinus8 = 26;
                dayOfMonthMinus9 = 25;
                dayOfMonthMinus10 = 24;
                dayOfMonthMinus11 = 23;
                dayOfMonthMinus12 = 22;
                dayOfMonthMinus13 = 21;
            } else if (dayOfMonthMinus5 == 0) {
                dayOfMonthMinus5 = 30;
                dayOfMonthMinus6 = 29;
                dayOfMonthMinus7 = 28;
                dayOfMonthMinus8 = 27;
                dayOfMonthMinus9 = 26;
                dayOfMonthMinus10 = 25;
                dayOfMonthMinus11 = 24;
                dayOfMonthMinus12 = 23;
                dayOfMonthMinus13 = 22;
            } else if (dayOfMonthMinus6 == 0) {
                dayOfMonthMinus6 = 30;
                dayOfMonthMinus7 = 29;
                dayOfMonthMinus8 = 28;
                dayOfMonthMinus9 = 27;
                dayOfMonthMinus10 = 26;
                dayOfMonthMinus11 = 25;
                dayOfMonthMinus12 = 24;
                dayOfMonthMinus13 = 23;
            } else if (dayOfMonthMinus7 == 0) {
                dayOfMonthMinus7 = 30;
                dayOfMonthMinus8 = 29;
                dayOfMonthMinus9 = 28;
                dayOfMonthMinus10 = 27;
                dayOfMonthMinus11 = 26;
                dayOfMonthMinus12 = 25;
                dayOfMonthMinus13 = 24;
            } else if (dayOfMonthMinus8 == 0) {
                dayOfMonthMinus8 = 30;
                dayOfMonthMinus9 = 29;
                dayOfMonthMinus10 = 28;
                dayOfMonthMinus11 = 27;
                dayOfMonthMinus12 = 26;
                dayOfMonthMinus13 = 25;
            } else if (dayOfMonthMinus9 == 0) {
                dayOfMonthMinus9 = 30;
                dayOfMonthMinus10 = 29;
                dayOfMonthMinus11 = 28;
                dayOfMonthMinus12 = 27;
                dayOfMonthMinus13 = 26;
            } else if (dayOfMonthMinus10 == 0) {
                dayOfMonthMinus10 = 30;
                dayOfMonthMinus11 = 29;
                dayOfMonthMinus12 = 28;
                dayOfMonthMinus13 = 27;
            } else if (dayOfMonthMinus11 == 0) {
                dayOfMonthMinus11 = 30;
                dayOfMonthMinus12 = 29;
                dayOfMonthMinus13 = 28;
            } else if (dayOfMonthMinus12 == 0) {
                dayOfMonthMinus12 = 30;
                dayOfMonthMinus13 = 29;
            } else if (dayOfMonthMinus13 == 0) {
                dayOfMonthMinus13 = 30;
            }
        } else if (max == 31) {
            if (dayOfMonthMinus1 == 0) {
                dayOfMonthMinus1 = 31;
                dayOfMonthMinus2 = 30;
                dayOfMonthMinus3 = 29;
                dayOfMonthMinus4 = 28;
                dayOfMonthMinus5 = 27;
                dayOfMonthMinus6 = 26;
                dayOfMonthMinus7 = 25;
                dayOfMonthMinus8 = 24;
                dayOfMonthMinus9 = 23;
                dayOfMonthMinus10 = 22;
                dayOfMonthMinus11 = 21;
                dayOfMonthMinus12 = 20;
                dayOfMonthMinus13 = 19;
            } else if (dayOfMonthMinus2 == 0) {
                dayOfMonthMinus2 = 31;
                dayOfMonthMinus3 = 30;
                dayOfMonthMinus4 = 29;
                dayOfMonthMinus5 = 28;
                dayOfMonthMinus6 = 27;
                dayOfMonthMinus7 = 26;
                dayOfMonthMinus8 = 25;
                dayOfMonthMinus9 = 24;
                dayOfMonthMinus10 = 23;
                dayOfMonthMinus11 = 22;
                dayOfMonthMinus12 = 21;
                dayOfMonthMinus13 = 20;
            } else if (dayOfMonthMinus3 == 0) {
                dayOfMonthMinus3 = 31;
                dayOfMonthMinus4 = 30;
                dayOfMonthMinus5 = 29;
                dayOfMonthMinus6 = 28;
                dayOfMonthMinus7 = 27;
                dayOfMonthMinus8 = 26;
                dayOfMonthMinus9 = 25;
                dayOfMonthMinus10 = 24;
                dayOfMonthMinus11 = 23;
                dayOfMonthMinus12 = 22;
                dayOfMonthMinus13 = 21;
            } else if (dayOfMonthMinus4 == 0) {
                dayOfMonthMinus4 = 31;
                dayOfMonthMinus5 = 30;
                dayOfMonthMinus6 = 29;
                dayOfMonthMinus7 = 28;
                dayOfMonthMinus8 = 27;
                dayOfMonthMinus9 = 26;
                dayOfMonthMinus10 = 25;
                dayOfMonthMinus11 = 24;
                dayOfMonthMinus12 = 23;
                dayOfMonthMinus13 = 22;
            } else if (dayOfMonthMinus5 == 0) {
                dayOfMonthMinus5 = 31;
                dayOfMonthMinus6 = 30;
                dayOfMonthMinus7 = 29;
                dayOfMonthMinus8 = 28;
                dayOfMonthMinus9 = 27;
                dayOfMonthMinus10 = 26;
                dayOfMonthMinus11 = 25;
                dayOfMonthMinus12 = 24;
                dayOfMonthMinus13 = 23;
            } else if (dayOfMonthMinus6 == 0) {
                dayOfMonthMinus6 = 31;
                dayOfMonthMinus7 = 30;
                dayOfMonthMinus8 = 29;
                dayOfMonthMinus9 = 28;
                dayOfMonthMinus10 = 27;
                dayOfMonthMinus11 = 26;
                dayOfMonthMinus12 = 25;
                dayOfMonthMinus13 = 24;
            } else if (dayOfMonthMinus7 == 0) {
                dayOfMonthMinus7 = 31;
                dayOfMonthMinus8 = 30;
                dayOfMonthMinus9 = 29;
                dayOfMonthMinus10 = 28;
                dayOfMonthMinus11 = 27;
                dayOfMonthMinus12 = 26;
                dayOfMonthMinus13 = 25;
            } else if (dayOfMonthMinus8 == 0) {
                dayOfMonthMinus8 = 31;
                dayOfMonthMinus9 = 30;
                dayOfMonthMinus10 = 29;
                dayOfMonthMinus11 = 28;
                dayOfMonthMinus12 = 27;
                dayOfMonthMinus13 = 26;
            } else if (dayOfMonthMinus9 == 0) {
                dayOfMonthMinus9 = 31;
                dayOfMonthMinus10 = 30;
                dayOfMonthMinus11 = 29;
                dayOfMonthMinus12 = 28;
                dayOfMonthMinus13 = 27;
            } else if (dayOfMonthMinus10 == 0) {
                dayOfMonthMinus10 = 31;
                dayOfMonthMinus11 = 30;
                dayOfMonthMinus12 = 29;
                dayOfMonthMinus13 = 28;
            } else if (dayOfMonthMinus11 == 0) {
                dayOfMonthMinus11 = 31;
                dayOfMonthMinus12 = 30;
                dayOfMonthMinus13 = 29;
            } else if (dayOfMonthMinus12 == 0) {
                dayOfMonthMinus12 = 31;
                dayOfMonthMinus13 = 30;
            } else if (dayOfMonthMinus13 == 0) {
                dayOfMonthMinus13 = 31;
            }
        } else if (max == 28) {
            if (dayOfMonthMinus1 == 0) {
                dayOfMonthMinus1 = 28;
                dayOfMonthMinus2 = 27;
                dayOfMonthMinus3 = 26;
                dayOfMonthMinus4 = 25;
                dayOfMonthMinus5 = 24;
                dayOfMonthMinus6 = 23;
                dayOfMonthMinus7 = 22;
                dayOfMonthMinus8 = 21;
                dayOfMonthMinus9 = 20;
                dayOfMonthMinus10 = 19;
                dayOfMonthMinus11 = 18;
                dayOfMonthMinus12 = 17;
                dayOfMonthMinus13 = 16;
            } else if (dayOfMonthMinus2 == 0) {
                dayOfMonthMinus2 = 28;
                dayOfMonthMinus3 = 27;
                dayOfMonthMinus4 = 26;
                dayOfMonthMinus5 = 25;
                dayOfMonthMinus6 = 24;
                dayOfMonthMinus7 = 23;
                dayOfMonthMinus8 = 22;
                dayOfMonthMinus9 = 21;
                dayOfMonthMinus10 = 20;
                dayOfMonthMinus11 = 19;
                dayOfMonthMinus12 = 18;
                dayOfMonthMinus13 = 17;
            } else if (dayOfMonthMinus3 == 0) {
                dayOfMonthMinus3 = 28;
                dayOfMonthMinus4 = 27;
                dayOfMonthMinus5 = 26;
                dayOfMonthMinus6 = 25;
                dayOfMonthMinus7 = 24;
                dayOfMonthMinus8 = 23;
                dayOfMonthMinus9 = 22;
                dayOfMonthMinus10 = 21;
                dayOfMonthMinus11 = 20;
                dayOfMonthMinus12 = 19;
                dayOfMonthMinus13 = 18;
            } else if (dayOfMonthMinus4 == 0) {
                dayOfMonthMinus4 = 28;
                dayOfMonthMinus5 = 27;
                dayOfMonthMinus6 = 26;
                dayOfMonthMinus7 = 25;
                dayOfMonthMinus8 = 24;
                dayOfMonthMinus9 = 23;
                dayOfMonthMinus10 = 22;
                dayOfMonthMinus11 = 21;
                dayOfMonthMinus12 = 20;
                dayOfMonthMinus13 = 19;
            } else if (dayOfMonthMinus5 == 0) {
                dayOfMonthMinus5 = 28;
                dayOfMonthMinus6 = 27;
                dayOfMonthMinus7 = 26;
                dayOfMonthMinus8 = 25;
                dayOfMonthMinus9 = 24;
                dayOfMonthMinus10 = 23;
                dayOfMonthMinus11 = 22;
                dayOfMonthMinus12 = 21;
                dayOfMonthMinus13 = 20;
            } else if (dayOfMonthMinus6 == 0) {
                dayOfMonthMinus6 = 28;
                dayOfMonthMinus7 = 27;
                dayOfMonthMinus8 = 26;
                dayOfMonthMinus9 = 25;
                dayOfMonthMinus10 = 24;
                dayOfMonthMinus11 = 23;
                dayOfMonthMinus12 = 22;
                dayOfMonthMinus13 = 21;
            } else if (dayOfMonthMinus7 == 0) {
                dayOfMonthMinus7 = 28;
                dayOfMonthMinus8 = 27;
                dayOfMonthMinus9 = 26;
                dayOfMonthMinus10 = 25;
                dayOfMonthMinus11 = 24;
                dayOfMonthMinus12 = 23;
                dayOfMonthMinus13 = 22;
            } else if (dayOfMonthMinus8 == 0) {
                dayOfMonthMinus8 = 28;
                dayOfMonthMinus9 = 27;
                dayOfMonthMinus10 = 26;
                dayOfMonthMinus11 = 25;
                dayOfMonthMinus12 = 24;
                dayOfMonthMinus13 = 23;
            } else if (dayOfMonthMinus9 == 0) {
                dayOfMonthMinus9 = 28;
                dayOfMonthMinus10 = 27;
                dayOfMonthMinus11 = 26;
                dayOfMonthMinus12 = 25;
                dayOfMonthMinus13 = 24;
            } else if (dayOfMonthMinus10 == 0) {
                dayOfMonthMinus10 = 28;
                dayOfMonthMinus11 = 27;
                dayOfMonthMinus12 = 26;
                dayOfMonthMinus13 = 25;
            } else if (dayOfMonthMinus11 == 0) {
                dayOfMonthMinus11 = 28;
                dayOfMonthMinus12 = 27;
                dayOfMonthMinus13 = 26;
            } else if (dayOfMonthMinus12 == 0) {
                dayOfMonthMinus12 = 28;
                dayOfMonthMinus13 = 27;
            } else if (dayOfMonthMinus13 == 0) {
                dayOfMonthMinus13 = 28;
            }
        }
        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 56,
                getResources().getDisplayMetrics());
        if (weekOfYear == 2021) {
            Log.d("myLog2","weekOfYearMax = " + weekOfYearMax);
            if (weekOfYearMax == 1 || weekOfYearMax == 3 || weekOfYearMax == 5 || weekOfYearMax == 7 || weekOfYearMax == 9 || weekOfYearMax == 11 || weekOfYearMax == 13 || weekOfYearMax == 15
                    || weekOfYearMax == 17 || weekOfYearMax == 19 || weekOfYearMax == 21 || weekOfYearMax == 23 || weekOfYearMax == 25 || weekOfYearMax == 27 || weekOfYearMax == 29
                    || weekOfYearMax == 31 || weekOfYearMax == 33 || weekOfYearMax == 35 || weekOfYearMax == 37 || weekOfYearMax == 39 || weekOfYearMax == 41 || weekOfYearMax == 43 || weekOfYearMax == 45
                    || weekOfYearMax == 47 || weekOfYearMax == 49 || weekOfYearMax == 51 || weekOfYearMax == 53) {
                buttonWeekOne.setBackgroundResource(R.drawable.form_schedule_btn);
                if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO) {
                    buttonWeekOne.setTextColor(Color.WHITE);
                    buttonWeekTwo.setTextColor(getResources().getColor(R.color.colorBlack));
                } else {
                    buttonWeekOne.setTextColor(getResources().getColor(R.color.colorBlack));
                    buttonWeekTwo.setTextColor(Color.WHITE);
                }
                buttonWeekTwo.setBackgroundResource(R.drawable.form_schedule_lessons);
                groupsButton1.setVisibility(View.VISIBLE);
                groupsButton2.setVisibility(View.INVISIBLE);
                switch (toDay) {
                    case Calendar.MONDAY:
                        btnWeekDay1.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                        linearLayout1.setVisibility(View.VISIBLE);
                        LinearLayout.LayoutParams layoutParams1 = (LinearLayout.LayoutParams) btnWeekDay1.getLayoutParams();

                        layoutParams1.height = height;
                        btnWeekDay1.setLayoutParams(layoutParams1);
                        btnWeekDay1.setText(String.valueOf(dayOfMonth));
                        btnWeekDay2.setText(String.valueOf(dayOfMonthPlus1));
                        btnWeekDay3.setText(String.valueOf(dayOfMonthPlus2));
                        btnWeekDay4.setText(String.valueOf(dayOfMonthPlus3));
                        btnWeekDay5.setText(String.valueOf(dayOfMonthPlus4));
                        btnWeekDay6.setText(String.valueOf(dayOfMonthPlus5));
                        btnWeekDay8.setText(String.valueOf(dayOfMonthPlus7));
                        btnWeekDay9.setText(String.valueOf(dayOfMonthPlus8));
                        btnWeekDay10.setText(String.valueOf(dayOfMonthPlus9));
                        btnWeekDay11.setText(String.valueOf(dayOfMonthPlus10));
                        btnWeekDay12.setText(String.valueOf(dayOfMonthPlus11));
                        btnWeekDay13.setText(String.valueOf(dayOfMonthPlus12));
                        break;
                    case Calendar.TUESDAY:
                        btnWeekDay2.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                        linearLayout2.setVisibility(View.VISIBLE);
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) btnWeekDay2.getLayoutParams();

                        layoutParams2.height = height;
                        btnWeekDay2.setLayoutParams(layoutParams2);
                        btnWeekDay2.setText(String.valueOf(dayOfMonth));
                        btnWeekDay1.setText(String.valueOf(dayOfMonthMinus1));
                        btnWeekDay3.setText(String.valueOf(dayOfMonthPlus1));
                        btnWeekDay4.setText(String.valueOf(dayOfMonthPlus2));
                        btnWeekDay5.setText(String.valueOf(dayOfMonthPlus3));
                        btnWeekDay6.setText(String.valueOf(dayOfMonthPlus4));
                        btnWeekDay8.setText(String.valueOf(dayOfMonthPlus6));
                        btnWeekDay9.setText(String.valueOf(dayOfMonthPlus7));
                        btnWeekDay10.setText(String.valueOf(dayOfMonthPlus8));
                        btnWeekDay11.setText(String.valueOf(dayOfMonthPlus9));
                        btnWeekDay12.setText(String.valueOf(dayOfMonthPlus10));
                        btnWeekDay13.setText(String.valueOf(dayOfMonthPlus11));
                        break;
                    case Calendar.WEDNESDAY:
                        btnWeekDay3.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                        linearLayout3.setVisibility(View.VISIBLE);
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) btnWeekDay3.getLayoutParams();

                        layoutParams3.height = height;
                        btnWeekDay3.setLayoutParams(layoutParams3);
                        btnWeekDay3.setText(String.valueOf(dayOfMonth));
                        btnWeekDay1.setText(String.valueOf(dayOfMonthMinus2));
                        btnWeekDay2.setText(String.valueOf(dayOfMonthMinus1));
                        btnWeekDay4.setText(String.valueOf(dayOfMonthPlus1));
                        btnWeekDay5.setText(String.valueOf(dayOfMonthPlus2));
                        btnWeekDay6.setText(String.valueOf(dayOfMonthPlus3));
                        btnWeekDay8.setText(String.valueOf(dayOfMonthPlus5));
                        btnWeekDay9.setText(String.valueOf(dayOfMonthPlus6));
                        btnWeekDay10.setText(String.valueOf(dayOfMonthPlus7));
                        btnWeekDay11.setText(String.valueOf(dayOfMonthPlus8));
                        btnWeekDay12.setText(String.valueOf(dayOfMonthPlus9));
                        btnWeekDay13.setText(String.valueOf(dayOfMonthPlus10));
                        break;
                    case Calendar.THURSDAY:
                        btnWeekDay4.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                        linearLayout4.setVisibility(View.VISIBLE);
                        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) btnWeekDay4.getLayoutParams();

                        layoutParams4.height = height;
                        btnWeekDay4.setLayoutParams(layoutParams4);
                        btnWeekDay4.setText(String.valueOf(dayOfMonth));
                        btnWeekDay1.setText(String.valueOf(dayOfMonthMinus3));
                        btnWeekDay2.setText(String.valueOf(dayOfMonthMinus2));
                        btnWeekDay3.setText(String.valueOf(dayOfMonthMinus1));
                        btnWeekDay5.setText(String.valueOf(dayOfMonthPlus1));
                        btnWeekDay6.setText(String.valueOf(dayOfMonthPlus2));
                        btnWeekDay8.setText(String.valueOf(dayOfMonthPlus4));
                        btnWeekDay9.setText(String.valueOf(dayOfMonthPlus5));
                        btnWeekDay10.setText(String.valueOf(dayOfMonthPlus6));
                        btnWeekDay11.setText(String.valueOf(dayOfMonthPlus7));
                        btnWeekDay12.setText(String.valueOf(dayOfMonthPlus8));
                        btnWeekDay13.setText(String.valueOf(dayOfMonthPlus9));
                        break;
                    case Calendar.FRIDAY:
                        btnWeekDay5.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                        linearLayout5.setVisibility(View.VISIBLE);
                        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) btnWeekDay5.getLayoutParams();

                        layoutParams5.height = height;
                        btnWeekDay5.setLayoutParams(layoutParams5);
                        btnWeekDay5.setText(String.valueOf(dayOfMonth));
                        btnWeekDay1.setText(String.valueOf(dayOfMonthMinus4));
                        btnWeekDay2.setText(String.valueOf(dayOfMonthMinus3));
                        btnWeekDay3.setText(String.valueOf(dayOfMonthMinus2));
                        btnWeekDay4.setText(String.valueOf(dayOfMonthMinus1));
                        btnWeekDay6.setText(String.valueOf(dayOfMonthPlus1));
                        btnWeekDay8.setText(String.valueOf(dayOfMonthPlus3));
                        btnWeekDay9.setText(String.valueOf(dayOfMonthPlus4));
                        btnWeekDay10.setText(String.valueOf(dayOfMonthPlus5));
                        btnWeekDay11.setText(String.valueOf(dayOfMonthPlus6));
                        btnWeekDay12.setText(String.valueOf(dayOfMonthPlus7));
                        btnWeekDay13.setText(String.valueOf(dayOfMonthPlus8));
                        break;
                    case Calendar.SATURDAY:
                        btnWeekDay6.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                        sundayFormWeek1();
                        onClicDaySunday = true;
                        LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) btnWeekDay6.getLayoutParams();
                        layoutParams6.height = height;
                        btnWeekDay6.setLayoutParams(layoutParams6);
                        btnWeekDay6.setText(String.valueOf(dayOfMonth));
                        btnWeekDay1.setText(String.valueOf(dayOfMonthMinus5));
                        btnWeekDay2.setText(String.valueOf(dayOfMonthMinus4));
                        btnWeekDay3.setText(String.valueOf(dayOfMonthMinus3));
                        btnWeekDay4.setText(String.valueOf(dayOfMonthMinus2));
                        btnWeekDay5.setText(String.valueOf(dayOfMonthMinus1));
                        btnWeekDay8.setText(String.valueOf(dayOfMonthPlus2));
                        btnWeekDay9.setText(String.valueOf(dayOfMonthPlus3));
                        btnWeekDay10.setText(String.valueOf(dayOfMonthPlus4));
                        btnWeekDay11.setText(String.valueOf(dayOfMonthPlus5));
                        btnWeekDay12.setText(String.valueOf(dayOfMonthPlus6));
                        btnWeekDay13.setText(String.valueOf(dayOfMonthPlus7));
                        break;
                    case Calendar.SUNDAY:
                        buttonWeekTwo.setBackgroundResource(R.drawable.form_schedule_btn);
                        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO) {
                            buttonWeekTwo.setTextColor(Color.WHITE);
                            buttonWeekOne.setTextColor(getResources().getColor(R.color.colorBlack));
                        } else {
                            buttonWeekTwo.setTextColor(getResources().getColor(R.color.colorBlack));
                            buttonWeekOne.setTextColor(Color.WHITE);
                        }
                        buttonWeekOne.setBackgroundResource(R.drawable.form_schedule_lessons);
                        groupsButton2.setVisibility(View.VISIBLE);
                        groupsButton1.setVisibility(View.INVISIBLE);
                        btnWeekDay8.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                        btnWeekDay1.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                        linearLayout8.setVisibility(View.VISIBLE);
                        Log.d("myLog2","Зашли");
                        btnWeekDay1.setText(String.valueOf(dayOfMonthMinus6));
                        btnWeekDay2.setText(String.valueOf(dayOfMonthMinus5));
                        btnWeekDay3.setText(String.valueOf(dayOfMonthMinus4));
                        btnWeekDay4.setText(String.valueOf(dayOfMonthMinus3));
                        btnWeekDay5.setText(String.valueOf(dayOfMonthMinus2));
                        btnWeekDay6.setText(String.valueOf(dayOfMonthMinus1));
                        btnWeekDay8.setText(String.valueOf(dayOfMonthPlus1));
                        btnWeekDay9.setText(String.valueOf(dayOfMonthPlus2));
                        btnWeekDay10.setText(String.valueOf(dayOfMonthPlus3));
                        btnWeekDay11.setText(String.valueOf(dayOfMonthPlus4));
                        btnWeekDay12.setText(String.valueOf(dayOfMonthPlus5));
                        btnWeekDay13.setText(String.valueOf(dayOfMonthPlus6));
                        break;
                }
            } else if (weekOfYearMax == 2 || weekOfYearMax == 4 || weekOfYearMax == 6 || weekOfYearMax == 8 || weekOfYearMax == 10 || weekOfYearMax == 12 || weekOfYearMax == 14 || weekOfYearMax == 16
                    || weekOfYearMax == 18 || weekOfYearMax == 20 || weekOfYearMax == 22 || weekOfYearMax == 24 || weekOfYearMax == 26 || weekOfYearMax == 28 || weekOfYearMax == 30 || weekOfYearMax == 32
                    || weekOfYearMax == 34 || weekOfYearMax == 36 || weekOfYearMax == 38 || weekOfYearMax == 40 || weekOfYearMax == 42 || weekOfYearMax == 44 || weekOfYearMax == 46
                    || weekOfYearMax == 48 || weekOfYearMax == 50 || weekOfYearMax == 52) {
                if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO) {
                    buttonWeekTwo.setTextColor(Color.WHITE);
                    buttonWeekOne.setTextColor(getResources().getColor(R.color.colorBlack));
                } else {
                    buttonWeekTwo.setTextColor(getResources().getColor(R.color.colorBlack));
                    buttonWeekOne.setTextColor(Color.WHITE);
                }
                buttonWeekTwo.setBackgroundResource(R.drawable.form_schedule_btn);
                buttonWeekOne.setBackgroundResource(R.drawable.form_schedule_lessons);
                groupsButton2.setVisibility(View.VISIBLE);
                groupsButton1.setVisibility(View.INVISIBLE);
                switch (toDay) {
                    case Calendar.MONDAY:
                        btnWeekDay8.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                        linearLayout8.setVisibility(View.VISIBLE);
                        LinearLayout.LayoutParams layoutParams8 = (LinearLayout.LayoutParams) btnWeekDay8.getLayoutParams();

                        layoutParams8.height = height;
                        btnWeekDay8.setLayoutParams(layoutParams8);
                        btnWeekDay8.setText(String.valueOf(dayOfMonth));
                        btnWeekDay1.setText(String.valueOf(dayOfMonthPlus7));
                        btnWeekDay2.setText(String.valueOf(dayOfMonthPlus8));
                        btnWeekDay3.setText(String.valueOf(dayOfMonthPlus9));
                        btnWeekDay4.setText(String.valueOf(dayOfMonthPlus10));
                        btnWeekDay5.setText(String.valueOf(dayOfMonthPlus11));
                        btnWeekDay6.setText(String.valueOf(dayOfMonthPlus12));
                        btnWeekDay9.setText(String.valueOf(dayOfMonthPlus1));
                        btnWeekDay10.setText(String.valueOf(dayOfMonthPlus2));
                        btnWeekDay11.setText(String.valueOf(dayOfMonthPlus3));
                        btnWeekDay12.setText(String.valueOf(dayOfMonthPlus4));
                        btnWeekDay13.setText(String.valueOf(dayOfMonthPlus5));
                        break;
                    case Calendar.TUESDAY:
                        btnWeekDay9.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                        linearLayout9.setVisibility(View.VISIBLE);
                        LinearLayout.LayoutParams layoutParams9 = (LinearLayout.LayoutParams) btnWeekDay9.getLayoutParams();

                        layoutParams9.height = height;
                        btnWeekDay9.setLayoutParams(layoutParams9);
                        btnWeekDay9.setText(String.valueOf(dayOfMonth));
                        btnWeekDay1.setText(String.valueOf(dayOfMonthPlus6));
                        btnWeekDay2.setText(String.valueOf(dayOfMonthPlus7));
                        btnWeekDay3.setText(String.valueOf(dayOfMonthPlus8));
                        btnWeekDay4.setText(String.valueOf(dayOfMonthPlus9));
                        btnWeekDay5.setText(String.valueOf(dayOfMonthPlus10));
                        btnWeekDay6.setText(String.valueOf(dayOfMonthPlus11));
                        btnWeekDay8.setText(String.valueOf(dayOfMonthMinus1));
                        btnWeekDay10.setText(String.valueOf(dayOfMonthPlus1));
                        btnWeekDay11.setText(String.valueOf(dayOfMonthPlus2));
                        btnWeekDay12.setText(String.valueOf(dayOfMonthPlus3));
                        btnWeekDay13.setText(String.valueOf(dayOfMonthPlus4));
                        break;
                    case Calendar.WEDNESDAY:
                        btnWeekDay10.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                        linearLayout10.setVisibility(View.VISIBLE);
                        LinearLayout.LayoutParams layoutParams10 = (LinearLayout.LayoutParams) btnWeekDay10.getLayoutParams();

                        layoutParams10.height = height;
                        btnWeekDay10.setLayoutParams(layoutParams10);
                        btnWeekDay10.setText(String.valueOf(dayOfMonth));
                        btnWeekDay1.setText(String.valueOf(dayOfMonthPlus5));
                        btnWeekDay2.setText(String.valueOf(dayOfMonthPlus6));
                        btnWeekDay3.setText(String.valueOf(dayOfMonthPlus7));
                        btnWeekDay4.setText(String.valueOf(dayOfMonthPlus8));
                        btnWeekDay5.setText(String.valueOf(dayOfMonthPlus9));
                        btnWeekDay6.setText(String.valueOf(dayOfMonthPlus10));
                        btnWeekDay8.setText(String.valueOf(dayOfMonthMinus2));
                        btnWeekDay9.setText(String.valueOf(dayOfMonthMinus1));
                        btnWeekDay11.setText(String.valueOf(dayOfMonthPlus1));
                        btnWeekDay12.setText(String.valueOf(dayOfMonthPlus2));
                        btnWeekDay13.setText(String.valueOf(dayOfMonthPlus3));
                        break;
                    case Calendar.THURSDAY:
                        btnWeekDay11.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                        linearLayout11.setVisibility(View.VISIBLE);
                        LinearLayout.LayoutParams layoutParams11 = (LinearLayout.LayoutParams) btnWeekDay11.getLayoutParams();

                        layoutParams11.height = height;
                        btnWeekDay11.setLayoutParams(layoutParams11);
                        btnWeekDay11.setText(String.valueOf(dayOfMonth));
                        btnWeekDay1.setText(String.valueOf(dayOfMonthPlus4));
                        btnWeekDay2.setText(String.valueOf(dayOfMonthPlus5));
                        btnWeekDay3.setText(String.valueOf(dayOfMonthPlus6));
                        btnWeekDay4.setText(String.valueOf(dayOfMonthPlus7));
                        btnWeekDay5.setText(String.valueOf(dayOfMonthPlus8));
                        btnWeekDay6.setText(String.valueOf(dayOfMonthPlus9));
                        btnWeekDay8.setText(String.valueOf(dayOfMonthMinus3));
                        btnWeekDay9.setText(String.valueOf(dayOfMonthMinus2));
                        btnWeekDay10.setText(String.valueOf(dayOfMonthMinus1));
                        btnWeekDay12.setText(String.valueOf(dayOfMonthPlus1));
                        btnWeekDay13.setText(String.valueOf(dayOfMonthPlus2));
                        break;
                    case Calendar.FRIDAY:
                        btnWeekDay12.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                        linearLayout12.setVisibility(View.VISIBLE);
                        LinearLayout.LayoutParams layoutParams12 = (LinearLayout.LayoutParams) btnWeekDay12.getLayoutParams();

                        layoutParams12.height = height;
                        btnWeekDay12.setLayoutParams(layoutParams12);
                        btnWeekDay12.setText(String.valueOf(dayOfMonth));
                        btnWeekDay1.setText(String.valueOf(dayOfMonthPlus3));
                        btnWeekDay2.setText(String.valueOf(dayOfMonthPlus4));
                        btnWeekDay3.setText(String.valueOf(dayOfMonthPlus5));
                        btnWeekDay4.setText(String.valueOf(dayOfMonthPlus6));
                        btnWeekDay5.setText(String.valueOf(dayOfMonthPlus7));
                        btnWeekDay6.setText(String.valueOf(dayOfMonthPlus8));
                        btnWeekDay8.setText(String.valueOf(dayOfMonthMinus4));
                        btnWeekDay9.setText(String.valueOf(dayOfMonthMinus3));
                        btnWeekDay10.setText(String.valueOf(dayOfMonthMinus2));
                        btnWeekDay11.setText(String.valueOf(dayOfMonthMinus1));
                        btnWeekDay13.setText(String.valueOf(dayOfMonthPlus1));
                        break;
                    case Calendar.SATURDAY:
                        btnWeekDay13.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                        sundayFormWeek2();
                        onClicDaySunday = true;
                        LinearLayout.LayoutParams layoutParams13 = (LinearLayout.LayoutParams) btnWeekDay13.getLayoutParams();
                        layoutParams13.height = height;
                        btnWeekDay13.setLayoutParams(layoutParams13);
                        btnWeekDay13.setText(String.valueOf(dayOfMonth));
                        btnWeekDay1.setText(String.valueOf(dayOfMonthPlus2));
                        btnWeekDay2.setText(String.valueOf(dayOfMonthPlus3));
                        btnWeekDay3.setText(String.valueOf(dayOfMonthPlus4));
                        btnWeekDay4.setText(String.valueOf(dayOfMonthPlus5));
                        btnWeekDay5.setText(String.valueOf(dayOfMonthPlus6));
                        btnWeekDay6.setText(String.valueOf(dayOfMonthPlus7));
                        btnWeekDay8.setText(String.valueOf(dayOfMonthMinus5));
                        btnWeekDay9.setText(String.valueOf(dayOfMonthMinus4));
                        btnWeekDay10.setText(String.valueOf(dayOfMonthMinus3));
                        btnWeekDay11.setText(String.valueOf(dayOfMonthMinus2));
                        btnWeekDay12.setText(String.valueOf(dayOfMonthMinus1));
                        break;
                    case Calendar.SUNDAY:
                        buttonWeekOne.setBackgroundResource(R.drawable.form_schedule_btn);
                        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO) {
                            buttonWeekOne.setTextColor(Color.WHITE);
                            buttonWeekTwo.setTextColor(getResources().getColor(R.color.colorBlack));
                        } else {
                            buttonWeekOne.setTextColor(getResources().getColor(R.color.colorBlack));
                            buttonWeekTwo.setTextColor(Color.WHITE);
                        }
                        buttonWeekTwo.setBackgroundResource(R.drawable.form_schedule_lessons);
                        groupsButton1.setVisibility(View.VISIBLE);
                        groupsButton2.setVisibility(View.INVISIBLE);
                        btnWeekDay1.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                        btnWeekDay8.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                        linearLayout1.setVisibility(View.VISIBLE);
                        btnWeekDay8.setText(String.valueOf(dayOfMonthMinus6));
                        btnWeekDay1.setText(String.valueOf(dayOfMonthPlus1));
                        btnWeekDay2.setText(String.valueOf(dayOfMonthPlus2));
                        btnWeekDay3.setText(String.valueOf(dayOfMonthPlus3));
                        btnWeekDay4.setText(String.valueOf(dayOfMonthPlus4));
                        btnWeekDay5.setText(String.valueOf(dayOfMonthPlus5));
                        btnWeekDay6.setText(String.valueOf(dayOfMonthPlus6));
                        btnWeekDay9.setText(String.valueOf(dayOfMonthMinus5));
                        btnWeekDay10.setText(String.valueOf(dayOfMonthMinus4));
                        btnWeekDay11.setText(String.valueOf(dayOfMonthMinus3));
                        btnWeekDay12.setText(String.valueOf(dayOfMonthMinus2));
                        btnWeekDay13.setText(String.valueOf(dayOfMonthMinus1));
                        break;
                }
            }
        } else {
            if (weekOfYearMax == 1 || weekOfYearMax == 3 || weekOfYearMax == 5 || weekOfYearMax == 7 || weekOfYearMax == 9 || weekOfYearMax == 11 || weekOfYearMax == 13 || weekOfYearMax == 15
                    || weekOfYearMax == 17 || weekOfYearMax == 19 || weekOfYearMax == 21 || weekOfYearMax == 23 || weekOfYearMax == 25 || weekOfYearMax == 27 || weekOfYearMax == 29
                    || weekOfYearMax == 31 || weekOfYearMax == 33 || weekOfYearMax == 35 || weekOfYearMax == 37 || weekOfYearMax == 39 || weekOfYearMax == 41 || weekOfYearMax == 43 || weekOfYearMax == 45
                    || weekOfYearMax == 47 || weekOfYearMax == 49 || weekOfYearMax == 51) {
                buttonWeekOne.setBackgroundResource(R.drawable.form_schedule_btn);
                if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO) {
                    buttonWeekOne.setTextColor(Color.WHITE);
                    buttonWeekTwo.setTextColor(getResources().getColor(R.color.colorBlack));
                } else {
                    buttonWeekOne.setTextColor(getResources().getColor(R.color.colorBlack));
                    buttonWeekTwo.setTextColor(Color.WHITE);
                }
                buttonWeekTwo.setBackgroundResource(R.drawable.form_schedule_lessons);
                groupsButton1.setVisibility(View.VISIBLE);
                groupsButton2.setVisibility(View.INVISIBLE);
                switch (toDay) {
                    case Calendar.MONDAY:
                        btnWeekDay1.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                        linearLayout1.setVisibility(View.VISIBLE);
                        LinearLayout.LayoutParams layoutParams1 = (LinearLayout.LayoutParams) btnWeekDay1.getLayoutParams();

                        layoutParams1.height = height;
                        btnWeekDay1.setLayoutParams(layoutParams1);
                        btnWeekDay1.setText(String.valueOf(dayOfMonth));
                        btnWeekDay2.setText(String.valueOf(dayOfMonthPlus1));
                        btnWeekDay3.setText(String.valueOf(dayOfMonthPlus2));
                        btnWeekDay4.setText(String.valueOf(dayOfMonthPlus3));
                        btnWeekDay5.setText(String.valueOf(dayOfMonthPlus4));
                        btnWeekDay6.setText(String.valueOf(dayOfMonthPlus5));
                        btnWeekDay8.setText(String.valueOf(dayOfMonthPlus7));
                        btnWeekDay9.setText(String.valueOf(dayOfMonthPlus8));
                        btnWeekDay10.setText(String.valueOf(dayOfMonthPlus9));
                        btnWeekDay11.setText(String.valueOf(dayOfMonthPlus10));
                        btnWeekDay12.setText(String.valueOf(dayOfMonthPlus11));
                        btnWeekDay13.setText(String.valueOf(dayOfMonthPlus12));
                        break;
                    case Calendar.TUESDAY:
                        btnWeekDay2.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                        linearLayout2.setVisibility(View.VISIBLE);
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) btnWeekDay2.getLayoutParams();

                        layoutParams2.height = height;
                        btnWeekDay2.setLayoutParams(layoutParams2);
                        btnWeekDay2.setText(String.valueOf(dayOfMonth));
                        btnWeekDay1.setText(String.valueOf(dayOfMonthMinus1));
                        btnWeekDay3.setText(String.valueOf(dayOfMonthPlus1));
                        btnWeekDay4.setText(String.valueOf(dayOfMonthPlus2));
                        btnWeekDay5.setText(String.valueOf(dayOfMonthPlus3));
                        btnWeekDay6.setText(String.valueOf(dayOfMonthPlus4));
                        btnWeekDay8.setText(String.valueOf(dayOfMonthPlus6));
                        btnWeekDay9.setText(String.valueOf(dayOfMonthPlus7));
                        btnWeekDay10.setText(String.valueOf(dayOfMonthPlus8));
                        btnWeekDay11.setText(String.valueOf(dayOfMonthPlus9));
                        btnWeekDay12.setText(String.valueOf(dayOfMonthPlus10));
                        btnWeekDay13.setText(String.valueOf(dayOfMonthPlus11));
                        break;
                    case Calendar.WEDNESDAY:
                        btnWeekDay3.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                        linearLayout3.setVisibility(View.VISIBLE);
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) btnWeekDay3.getLayoutParams();

                        layoutParams3.height = height;
                        btnWeekDay3.setLayoutParams(layoutParams3);
                        btnWeekDay3.setText(String.valueOf(dayOfMonth));
                        btnWeekDay1.setText(String.valueOf(dayOfMonthMinus2));
                        btnWeekDay2.setText(String.valueOf(dayOfMonthMinus1));
                        btnWeekDay4.setText(String.valueOf(dayOfMonthPlus1));
                        btnWeekDay5.setText(String.valueOf(dayOfMonthPlus2));
                        btnWeekDay6.setText(String.valueOf(dayOfMonthPlus3));
                        btnWeekDay8.setText(String.valueOf(dayOfMonthPlus5));
                        btnWeekDay9.setText(String.valueOf(dayOfMonthPlus6));
                        btnWeekDay10.setText(String.valueOf(dayOfMonthPlus7));
                        btnWeekDay11.setText(String.valueOf(dayOfMonthPlus8));
                        btnWeekDay12.setText(String.valueOf(dayOfMonthPlus9));
                        btnWeekDay13.setText(String.valueOf(dayOfMonthPlus10));
                        break;
                    case Calendar.THURSDAY:
                        btnWeekDay4.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                        linearLayout4.setVisibility(View.VISIBLE);
                        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) btnWeekDay4.getLayoutParams();

                        layoutParams4.height = height;
                        btnWeekDay4.setLayoutParams(layoutParams4);
                        btnWeekDay4.setText(String.valueOf(dayOfMonth));
                        btnWeekDay1.setText(String.valueOf(dayOfMonthMinus3));
                        btnWeekDay2.setText(String.valueOf(dayOfMonthMinus2));
                        btnWeekDay3.setText(String.valueOf(dayOfMonthMinus1));
                        btnWeekDay5.setText(String.valueOf(dayOfMonthPlus1));
                        btnWeekDay6.setText(String.valueOf(dayOfMonthPlus2));
                        btnWeekDay8.setText(String.valueOf(dayOfMonthPlus4));
                        btnWeekDay9.setText(String.valueOf(dayOfMonthPlus5));
                        btnWeekDay10.setText(String.valueOf(dayOfMonthPlus6));
                        btnWeekDay11.setText(String.valueOf(dayOfMonthPlus7));
                        btnWeekDay12.setText(String.valueOf(dayOfMonthPlus8));
                        btnWeekDay13.setText(String.valueOf(dayOfMonthPlus9));
                        break;
                    case Calendar.FRIDAY:
                        btnWeekDay5.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                        linearLayout5.setVisibility(View.VISIBLE);
                        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) btnWeekDay5.getLayoutParams();

                        layoutParams5.height = height;
                        btnWeekDay5.setLayoutParams(layoutParams5);
                        btnWeekDay5.setText(String.valueOf(dayOfMonth));
                        btnWeekDay1.setText(String.valueOf(dayOfMonthMinus4));
                        btnWeekDay2.setText(String.valueOf(dayOfMonthMinus3));
                        btnWeekDay3.setText(String.valueOf(dayOfMonthMinus2));
                        btnWeekDay4.setText(String.valueOf(dayOfMonthMinus1));
                        btnWeekDay6.setText(String.valueOf(dayOfMonthPlus1));
                        btnWeekDay8.setText(String.valueOf(dayOfMonthPlus3));
                        btnWeekDay9.setText(String.valueOf(dayOfMonthPlus4));
                        btnWeekDay10.setText(String.valueOf(dayOfMonthPlus5));
                        btnWeekDay11.setText(String.valueOf(dayOfMonthPlus6));
                        btnWeekDay12.setText(String.valueOf(dayOfMonthPlus7));
                        btnWeekDay13.setText(String.valueOf(dayOfMonthPlus8));
                        break;
                    case Calendar.SATURDAY:
                        btnWeekDay6.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                        sundayFormWeek1();
                        onClicDaySunday = true;
                        LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) btnWeekDay6.getLayoutParams();
                        layoutParams6.height = height;
                        btnWeekDay6.setLayoutParams(layoutParams6);
                        btnWeekDay6.setText(String.valueOf(dayOfMonth));
                        btnWeekDay1.setText(String.valueOf(dayOfMonthMinus5));
                        btnWeekDay2.setText(String.valueOf(dayOfMonthMinus4));
                        btnWeekDay3.setText(String.valueOf(dayOfMonthMinus3));
                        btnWeekDay4.setText(String.valueOf(dayOfMonthMinus2));
                        btnWeekDay5.setText(String.valueOf(dayOfMonthMinus1));
                        btnWeekDay8.setText(String.valueOf(dayOfMonthPlus2));
                        btnWeekDay9.setText(String.valueOf(dayOfMonthPlus3));
                        btnWeekDay10.setText(String.valueOf(dayOfMonthPlus4));
                        btnWeekDay11.setText(String.valueOf(dayOfMonthPlus5));
                        btnWeekDay12.setText(String.valueOf(dayOfMonthPlus6));
                        btnWeekDay13.setText(String.valueOf(dayOfMonthPlus7));
                        break;
                    case Calendar.SUNDAY:
                        buttonWeekTwo.setBackgroundResource(R.drawable.form_schedule_btn);
                        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO) {
                            buttonWeekTwo.setTextColor(Color.WHITE);
                            buttonWeekOne.setTextColor(getResources().getColor(R.color.colorBlack));
                        } else {
                            buttonWeekTwo.setTextColor(getResources().getColor(R.color.colorBlack));
                            buttonWeekOne.setTextColor(Color.WHITE);
                        }
                        buttonWeekOne.setBackgroundResource(R.drawable.form_schedule_lessons);
                        groupsButton2.setVisibility(View.VISIBLE);
                        groupsButton1.setVisibility(View.INVISIBLE);
                        btnWeekDay8.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                        btnWeekDay1.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                        linearLayout8.setVisibility(View.VISIBLE);
                        btnWeekDay1.setText(String.valueOf(dayOfMonthMinus6));
                        btnWeekDay2.setText(String.valueOf(dayOfMonthMinus5));
                        btnWeekDay3.setText(String.valueOf(dayOfMonthMinus4));
                        btnWeekDay4.setText(String.valueOf(dayOfMonthMinus3));
                        btnWeekDay5.setText(String.valueOf(dayOfMonthMinus2));
                        btnWeekDay6.setText(String.valueOf(dayOfMonthMinus1));
                        btnWeekDay8.setText(String.valueOf(dayOfMonthPlus1));
                        btnWeekDay9.setText(String.valueOf(dayOfMonthPlus2));
                        btnWeekDay10.setText(String.valueOf(dayOfMonthPlus3));
                        btnWeekDay11.setText(String.valueOf(dayOfMonthPlus4));
                        btnWeekDay12.setText(String.valueOf(dayOfMonthPlus5));
                        btnWeekDay13.setText(String.valueOf(dayOfMonthPlus6));
                        break;
                }
            } else if (weekOfYearMax == 2 || weekOfYearMax == 4 || weekOfYearMax == 6 || weekOfYearMax == 8 || weekOfYearMax == 10 || weekOfYearMax == 12 || weekOfYearMax == 14 || weekOfYearMax == 16
                    || weekOfYearMax == 18 || weekOfYearMax == 20 || weekOfYearMax == 22 || weekOfYearMax == 24 || weekOfYearMax == 26 || weekOfYearMax == 28 || weekOfYearMax == 30 || weekOfYearMax == 32
                    || weekOfYearMax == 34 || weekOfYearMax == 36 || weekOfYearMax == 38 || weekOfYearMax == 40 || weekOfYearMax == 42 || weekOfYearMax == 44 || weekOfYearMax == 46
                    || weekOfYearMax == 48 || weekOfYearMax == 50 || weekOfYearMax == 52 || weekOfYearMax == 53) {
                if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO) {
                    buttonWeekTwo.setTextColor(Color.WHITE);
                    buttonWeekOne.setTextColor(getResources().getColor(R.color.colorBlack));
                } else {
                    buttonWeekTwo.setTextColor(getResources().getColor(R.color.colorBlack));
                    buttonWeekOne.setTextColor(Color.WHITE);
                }
                buttonWeekTwo.setBackgroundResource(R.drawable.form_schedule_btn);
                buttonWeekOne.setBackgroundResource(R.drawable.form_schedule_lessons);
                groupsButton2.setVisibility(View.VISIBLE);
                groupsButton1.setVisibility(View.INVISIBLE);
                switch (toDay) {
                    case Calendar.MONDAY:
                        btnWeekDay8.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                        linearLayout8.setVisibility(View.VISIBLE);
                        LinearLayout.LayoutParams layoutParams8 = (LinearLayout.LayoutParams) btnWeekDay8.getLayoutParams();

                        layoutParams8.height = height;
                        btnWeekDay8.setLayoutParams(layoutParams8);
                        btnWeekDay8.setText(String.valueOf(dayOfMonth));
                        btnWeekDay1.setText(String.valueOf(dayOfMonthPlus7));
                        btnWeekDay2.setText(String.valueOf(dayOfMonthPlus8));
                        btnWeekDay3.setText(String.valueOf(dayOfMonthPlus9));
                        btnWeekDay4.setText(String.valueOf(dayOfMonthPlus10));
                        btnWeekDay5.setText(String.valueOf(dayOfMonthPlus11));
                        btnWeekDay6.setText(String.valueOf(dayOfMonthPlus12));
                        btnWeekDay9.setText(String.valueOf(dayOfMonthPlus1));
                        btnWeekDay10.setText(String.valueOf(dayOfMonthPlus2));
                        btnWeekDay11.setText(String.valueOf(dayOfMonthPlus3));
                        btnWeekDay12.setText(String.valueOf(dayOfMonthPlus4));
                        btnWeekDay13.setText(String.valueOf(dayOfMonthPlus5));
                        break;
                    case Calendar.TUESDAY:
                        btnWeekDay9.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                        linearLayout9.setVisibility(View.VISIBLE);
                        LinearLayout.LayoutParams layoutParams9 = (LinearLayout.LayoutParams) btnWeekDay9.getLayoutParams();

                        layoutParams9.height = height;
                        btnWeekDay9.setLayoutParams(layoutParams9);
                        btnWeekDay9.setText(String.valueOf(dayOfMonth));
                        btnWeekDay1.setText(String.valueOf(dayOfMonthPlus6));
                        btnWeekDay2.setText(String.valueOf(dayOfMonthPlus7));
                        btnWeekDay3.setText(String.valueOf(dayOfMonthPlus8));
                        btnWeekDay4.setText(String.valueOf(dayOfMonthPlus9));
                        btnWeekDay5.setText(String.valueOf(dayOfMonthPlus10));
                        btnWeekDay6.setText(String.valueOf(dayOfMonthPlus11));
                        btnWeekDay8.setText(String.valueOf(dayOfMonthMinus1));
                        btnWeekDay10.setText(String.valueOf(dayOfMonthPlus1));
                        btnWeekDay11.setText(String.valueOf(dayOfMonthPlus2));
                        btnWeekDay12.setText(String.valueOf(dayOfMonthPlus3));
                        btnWeekDay13.setText(String.valueOf(dayOfMonthPlus4));
                        break;
                    case Calendar.WEDNESDAY:
                        btnWeekDay10.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                        linearLayout10.setVisibility(View.VISIBLE);
                        LinearLayout.LayoutParams layoutParams10 = (LinearLayout.LayoutParams) btnWeekDay10.getLayoutParams();

                        layoutParams10.height = height;
                        btnWeekDay10.setLayoutParams(layoutParams10);
                        btnWeekDay10.setText(String.valueOf(dayOfMonth));
                        btnWeekDay1.setText(String.valueOf(dayOfMonthPlus5));
                        btnWeekDay2.setText(String.valueOf(dayOfMonthPlus6));
                        btnWeekDay3.setText(String.valueOf(dayOfMonthPlus7));
                        btnWeekDay4.setText(String.valueOf(dayOfMonthPlus8));
                        btnWeekDay5.setText(String.valueOf(dayOfMonthPlus9));
                        btnWeekDay6.setText(String.valueOf(dayOfMonthPlus10));
                        btnWeekDay8.setText(String.valueOf(dayOfMonthMinus2));
                        btnWeekDay9.setText(String.valueOf(dayOfMonthMinus1));
                        btnWeekDay11.setText(String.valueOf(dayOfMonthPlus1));
                        btnWeekDay12.setText(String.valueOf(dayOfMonthPlus2));
                        btnWeekDay13.setText(String.valueOf(dayOfMonthPlus3));
                        break;
                    case Calendar.THURSDAY:
                        btnWeekDay11.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                        linearLayout11.setVisibility(View.VISIBLE);
                        LinearLayout.LayoutParams layoutParams11 = (LinearLayout.LayoutParams) btnWeekDay11.getLayoutParams();

                        layoutParams11.height = height;
                        btnWeekDay11.setLayoutParams(layoutParams11);
                        btnWeekDay11.setText(String.valueOf(dayOfMonth));
                        btnWeekDay1.setText(String.valueOf(dayOfMonthPlus4));
                        btnWeekDay2.setText(String.valueOf(dayOfMonthPlus5));
                        btnWeekDay3.setText(String.valueOf(dayOfMonthPlus6));
                        btnWeekDay4.setText(String.valueOf(dayOfMonthPlus7));
                        btnWeekDay5.setText(String.valueOf(dayOfMonthPlus8));
                        btnWeekDay6.setText(String.valueOf(dayOfMonthPlus9));
                        btnWeekDay8.setText(String.valueOf(dayOfMonthMinus3));
                        btnWeekDay9.setText(String.valueOf(dayOfMonthMinus2));
                        btnWeekDay10.setText(String.valueOf(dayOfMonthMinus1));
                        btnWeekDay12.setText(String.valueOf(dayOfMonthPlus1));
                        btnWeekDay13.setText(String.valueOf(dayOfMonthPlus2));
                        break;
                    case Calendar.FRIDAY:
                        btnWeekDay12.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                        linearLayout12.setVisibility(View.VISIBLE);
                        LinearLayout.LayoutParams layoutParams12 = (LinearLayout.LayoutParams) btnWeekDay12.getLayoutParams();

                        layoutParams12.height = height;
                        btnWeekDay12.setLayoutParams(layoutParams12);
                        btnWeekDay12.setText(String.valueOf(dayOfMonth));
                        btnWeekDay1.setText(String.valueOf(dayOfMonthPlus3));
                        btnWeekDay2.setText(String.valueOf(dayOfMonthPlus4));
                        btnWeekDay3.setText(String.valueOf(dayOfMonthPlus5));
                        btnWeekDay4.setText(String.valueOf(dayOfMonthPlus6));
                        btnWeekDay5.setText(String.valueOf(dayOfMonthPlus7));
                        btnWeekDay6.setText(String.valueOf(dayOfMonthPlus8));
                        btnWeekDay8.setText(String.valueOf(dayOfMonthMinus4));
                        btnWeekDay9.setText(String.valueOf(dayOfMonthMinus3));
                        btnWeekDay10.setText(String.valueOf(dayOfMonthMinus2));
                        btnWeekDay11.setText(String.valueOf(dayOfMonthMinus1));
                        btnWeekDay13.setText(String.valueOf(dayOfMonthPlus1));
                        break;
                    case Calendar.SATURDAY:
                        btnWeekDay13.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                        sundayFormWeek2();
                        onClicDaySunday = true;
                        LinearLayout.LayoutParams layoutParams13 = (LinearLayout.LayoutParams) btnWeekDay13.getLayoutParams();
                        layoutParams13.height = height;
                        btnWeekDay13.setLayoutParams(layoutParams13);
                        btnWeekDay13.setText(String.valueOf(dayOfMonth));
                        btnWeekDay1.setText(String.valueOf(dayOfMonthPlus2));
                        btnWeekDay2.setText(String.valueOf(dayOfMonthPlus3));
                        btnWeekDay3.setText(String.valueOf(dayOfMonthPlus4));
                        btnWeekDay4.setText(String.valueOf(dayOfMonthPlus5));
                        btnWeekDay5.setText(String.valueOf(dayOfMonthPlus6));
                        btnWeekDay6.setText(String.valueOf(dayOfMonthPlus7));
                        btnWeekDay8.setText(String.valueOf(dayOfMonthMinus5));
                        btnWeekDay9.setText(String.valueOf(dayOfMonthMinus4));
                        btnWeekDay10.setText(String.valueOf(dayOfMonthMinus3));
                        btnWeekDay11.setText(String.valueOf(dayOfMonthMinus2));
                        btnWeekDay12.setText(String.valueOf(dayOfMonthMinus1));
                        break;
                    case Calendar.SUNDAY:
                        buttonWeekOne.setBackgroundResource(R.drawable.form_schedule_btn);
                        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO) {
                            buttonWeekOne.setTextColor(Color.WHITE);
                            buttonWeekTwo.setTextColor(getResources().getColor(R.color.colorBlack));
                        } else {
                            buttonWeekOne.setTextColor(getResources().getColor(R.color.colorBlack));
                            buttonWeekTwo.setTextColor(Color.WHITE);
                        }
                        buttonWeekTwo.setBackgroundResource(R.drawable.form_schedule_lessons);
                        groupsButton1.setVisibility(View.VISIBLE);
                        groupsButton2.setVisibility(View.INVISIBLE);
                        btnWeekDay1.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                        btnWeekDay8.setBackgroundResource(R.drawable.form_schedule_btn_pink);
                        linearLayout1.setVisibility(View.VISIBLE);
                        btnWeekDay8.setText(String.valueOf(dayOfMonthMinus6));
                        btnWeekDay1.setText(String.valueOf(dayOfMonthPlus1));
                        btnWeekDay2.setText(String.valueOf(dayOfMonthPlus2));
                        btnWeekDay3.setText(String.valueOf(dayOfMonthPlus3));
                        btnWeekDay4.setText(String.valueOf(dayOfMonthPlus4));
                        btnWeekDay5.setText(String.valueOf(dayOfMonthPlus5));
                        btnWeekDay6.setText(String.valueOf(dayOfMonthPlus6));
                        btnWeekDay9.setText(String.valueOf(dayOfMonthMinus5));
                        btnWeekDay10.setText(String.valueOf(dayOfMonthMinus4));
                        btnWeekDay11.setText(String.valueOf(dayOfMonthMinus3));
                        btnWeekDay12.setText(String.valueOf(dayOfMonthMinus2));
                        btnWeekDay13.setText(String.valueOf(dayOfMonthMinus1));
                        break;
                }
            }
        }
    }

    //ДИАЛОГОВОЕ ОКНО
    private void dialogWindow() {
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_window_sunday);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false); //ОКНО НЕЛЬЗЯ ЗАКРЫТЬ КНОПКОЙ НАЗАД
        ImageView dialogClose = (ImageView) dialog.findViewById(R.id.btnClose);
        dialogClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
        dialog.show();
        dialog.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
    }

    //Смотрим есть ли расписание в субботу
    private void sundayFormWeek1() {
        if (!prefs.getBoolean("scheduleInSundayWeek1", true)) {
            btnWeekDay6.setBackgroundResource(R.drawable.form_schedule_btn_pink);
            linearLayout6.setVisibility(View.INVISIBLE);
            scrollView.setVisibility(View.INVISIBLE);
            form_lessons_sunday.setVisibility(View.VISIBLE);
            form_lessons_sunday_text.setVisibility(View.VISIBLE);

        } else {
            btnWeekDay6.setBackgroundResource(R.drawable.form_schedule_btn_pink);
            linearLayout6.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.VISIBLE);
            btnWeekDay6.setBackgroundResource(R.drawable.form_schedule_btn_pink);
            form_lessons_sunday.setVisibility(View.INVISIBLE);
            form_lessons_sunday_text.setVisibility(View.INVISIBLE);
        }
    }

    private void sundayFormWeek2() {
        if (false == prefs.getBoolean("scheduleInSundayWeek2", true)) {
            btnWeekDay13.setBackgroundResource(R.drawable.form_schedule_btn_pink);
            linearLayout13.setVisibility(View.INVISIBLE);
            scrollView.setVisibility(View.INVISIBLE);
            form_lessons_sunday.setVisibility(View.VISIBLE);
            form_lessons_sunday_text.setVisibility(View.VISIBLE);
        } else {
            linearLayout13.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.VISIBLE);
            btnWeekDay13.setBackgroundResource(R.drawable.form_schedule_btn_pink);
            form_lessons_sunday.setVisibility(View.INVISIBLE);
            form_lessons_sunday_text.setVisibility(View.INVISIBLE);
        }

    }

    //УСТОНАВЛИВАЕМ ТЕКСТ
    public void setTextSchedule() {
        SettingSchedule e = new SettingSchedule(Schedule.this, editTextLesson11, editTextLesson12, editTextLesson13, editTextLesson14, editTextLesson15, editTextLesson16,
                editTextAuditores11, editTextAuditores12, editTextAuditores13, editTextAuditores14, editTextAuditores15,
                editTextAuditores16,
                editTextTeacher11, editTextTeacher12, editTextTeacher13, editTextTeacher14, editTextTeacher15, editTextTeacher16,
                editTextLesson21, editTextLesson22, editTextLesson23, editTextLesson24, editTextLesson25, editTextLesson26, editTextAuditores21,
                editTextAuditores22, editTextAuditores23, editTextAuditores24, editTextAuditores25, editTextAuditores26,
                editTextTeacher21, editTextTeacher22, editTextTeacher23, editTextTeacher24, editTextTeacher25, editTextTeacher26, editTextLesson31,
                editTextLesson32, editTextLesson33, editTextLesson34, editTextLesson35, editTextLesson36,
                editTextAuditores31, editTextAuditores32, editTextAuditores33, editTextAuditores34, editTextAuditores35, editTextAuditores36,
                editTextTeacher31, editTextTeacher32,
                editTextTeacher33, editTextTeacher34, editTextTeacher35, editTextTeacher36,
                editTextLesson41, editTextLesson42, editTextLesson43, editTextLesson44, editTextLesson45, editTextLesson46,
                editTextAuditores41, editTextAuditores42, editTextAuditores43,
                editTextAuditores44, editTextAuditores45, editTextAuditores46,
                editTextTeacher41, editTextTeacher42, editTextTeacher43, editTextTeacher44, editTextTeacher45, editTextTeacher46,
                editTextLesson51, editTextLesson52, editTextLesson53, editTextLesson54,
                editTextLesson55, editTextLesson56,
                editTextAuditores51, editTextAuditores52, editTextAuditores53, editTextAuditores54, editTextAuditores55, editTextAuditores56,
                editTextTeacher51, editTextTeacher52, editTextTeacher53, editTextTeacher54, editTextTeacher55, editTextTeacher56,
                editTextLesson61, editTextLesson62,
                editTextLesson63, editTextLesson64, editTextLesson65, editTextLesson66,
                editTextAuditores61, editTextAuditores62, editTextAuditores63, editTextAuditores64, editTextAuditores65, editTextAuditores66,
                editTextTeacher61, editTextTeacher62, editTextTeacher63,
                editTextTeacher64, editTextTeacher65, editTextTeacher66,
                editTextLesson81, editTextLesson82, editTextLesson83, editTextLesson84, editTextLesson85, editTextLesson86,
                editTextAuditores81, editTextAuditores82, editTextAuditores83, editTextAuditores84, editTextAuditores85, editTextAuditores86,
                editTextTeacher81, editTextTeacher82, editTextTeacher83, editTextTeacher84, editTextTeacher85, editTextTeacher86,
                editTextLesson91, editTextLesson92, editTextLesson93, editTextLesson94, editTextLesson95, editTextLesson96, editTextAuditores91,
                editTextAuditores92, editTextAuditores93, editTextAuditores94, editTextAuditores95, editTextAuditores96,
                editTextTeacher91, editTextTeacher92, editTextTeacher93, editTextTeacher94, editTextTeacher95, editTextTeacher96,
                editTextLesson101, editTextLesson102,
                editTextLesson103, editTextLesson104, editTextLesson105, editTextLesson106,
                editTextAuditores101, editTextAuditores102, editTextAuditores103, editTextAuditores104, editTextAuditores105, editTextAuditores106,
                editTextTeacher101, editTextTeacher102, editTextTeacher103,
                editTextTeacher104, editTextTeacher105, editTextTeacher106,
                editTextLesson111, editTextLesson112, editTextLesson113, editTextLesson114, editTextLesson115, editTextLesson116,
                editTextAuditores111, editTextAuditores112, editTextAuditores113, editTextAuditores114,
                editTextAuditores115, editTextAuditores116,
                editTextTeacher111, editTextTeacher112, editTextTeacher113, editTextTeacher114, editTextTeacher115, editTextTeacher116,
                editTextLesson121, editTextLesson122, editTextLesson123, editTextLesson124, editTextLesson125, editTextLesson126,
                editTextAuditores121, editTextAuditores122, editTextAuditores123, editTextAuditores124, editTextAuditores125, editTextAuditores126,
                editTextTeacher121, editTextTeacher122, editTextTeacher123, editTextTeacher124, editTextTeacher125, editTextTeacher126,
                editTextLesson131, editTextLesson132,
                editTextLesson133, editTextLesson134, editTextLesson135, editTextLesson136,
                editTextAuditores131, editTextAuditores132, editTextAuditores133, editTextAuditores134, editTextAuditores135, editTextAuditores136,
                editTextTeacher131, editTextTeacher132,
                editTextTeacher133, editTextTeacher134, editTextTeacher135, editTextTeacher136);
        //1 КУРС ФИИИТ
        if (elementSpinnerDirection.equals("ИСиТ") && setElementSpinnerCource.equals("1")) {
            e.courseOneISiT();
        } else if (elementSpinnerDirection.equals("ИБ") && setElementSpinnerCource.equals("1")) {
            e.courseOneIB();
        } else if (elementSpinnerDirection.equals("ИСиП") && setElementSpinnerCource.equals("1")) {
            e.courseOneISiP();
        } else if (elementSpinnerDirection.equals("ПИЭ") && setElementSpinnerCource.equals("1")) {
            e.courseOnePIE();
        }
        // 2 КУРС ФИИИТ
        else if (elementSpinnerDirection.equals("ИСиТ") && setElementSpinnerCource.equals("2")) {
            e.courseTwoISiT();
        } else if (elementSpinnerDirection.equals("ИБ") && setElementSpinnerCource.equals("2")) {
            e.courseTwoIB();
        } else if (elementSpinnerDirection.equals("ПИЭ") && setElementSpinnerCource.equals("2")) {
            e.courseTwoPIE();
        } else if (elementSpinnerDirection.equals("ПИМ") && setElementSpinnerCource.equals("2")) {
            e.courseTwoPIM();
        }
        //3 КУРС ФИИИТ
        else if (elementSpinnerDirection.equals("ИСиТ") && setElementSpinnerCource.equals("3")) {
            e.courseThreeISiT();
        } else if (elementSpinnerDirection.equals("ИБ") && setElementSpinnerCource.equals("3")) {
            e.courseThreeIB();
        } else if (elementSpinnerDirection.equals("ПИЭ") && setElementSpinnerCource.equals("3")) {
            e.courseThreePIE();
        } else if (elementSpinnerDirection.equals("ПИМ") && setElementSpinnerCource.equals("3")) {
            e.courseThreePIM();
        }
        //4 КУРС ФИИИТ
        else if (elementSpinnerDirection.equals("ИСиТ") && setElementSpinnerCource.equals("4")) {
            e.courseFourISiT();
        } else if (elementSpinnerDirection.equals("ИБ") && setElementSpinnerCource.equals("4")) {
            e.courseFourIB();
        } else if (elementSpinnerDirection.equals("ПИЭ") && setElementSpinnerCource.equals("4")) {
            e.courseFourPIE();
        } else if (elementSpinnerDirection.equals("ПИМ") && setElementSpinnerCource.equals("4")) {
            e.courseFourPIM();
        }
    }

    public void dialogDefault(View view) {
        dialog_default = new Dialog(this);
        dialog_default.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog_default.setContentView(R.layout.dialog_window_default_btn);
        dialog_default.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog_default.setCancelable(false); //ОКНО НЕЛЬЗЯ ЗАКРЫТЬ КНОПКОЙ НАЗАД
        ImageView dialogClose = (ImageView) dialog_default.findViewById(R.id.btnClose);
        dialogClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog_default.dismiss();
            }
        });
        TextView yes = (TextView) dialog_default.findViewById(R.id.yes);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTextSchedule();
                if (onClicKweek == false && onClicDaySunday == true) {
                    sundayFormWeek1();
                } else if (onClicKweek == true && onClicDaySunday == true) {
                    sundayFormWeek2();
                }
                dialog_default.dismiss();
            }
        });
        TextView no = (TextView) dialog_default.findViewById(R.id.no);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog_default.dismiss();
            }
        });
        dialog_default.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
        dialog_default.show();
        dialog_default.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        dialog_default.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);

    }

    //ПЕРЕХОД НА About Me ACTIVITY
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void InBellsOrReady(View view) {
        Animation animDef = AnimationUtils.loadAnimation(this, R.anim.pencil_hide_anim);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.pencil_visible_anim);
        switch (view.getId()) {
            case R.id.imageBell:
                imageReady.setVisibility(View.VISIBLE);
                pencilImage.startAnimation(animation);
                imageEllipse.setVisibility(View.VISIBLE);
                buttonDefault.startAnimation(animDef);
                buttonDefault.setVisibility(View.INVISIBLE);
                imageBell.setVisibility(View.INVISIBLE);
                imageEllipse2.setVisibility(View.INVISIBLE);
                Drawable drawable = imageReady.getDrawable();
                if (drawable instanceof AnimatedVectorDrawableCompat) {
                    avd = (AnimatedVectorDrawableCompat) drawable;
                    avd.start();
                } else if (drawable instanceof AnimatedVectorDrawable) {
                    avd2 = (AnimatedVectorDrawable) drawable;
                    avd2.start();
                }
                //ОТМЕНЯЕМ РЕДАКТИРОВАНИЕ ПОЛЕЙ
                setDontEdit();
                break;
            case R.id.imageEllipse2:
                imageReady.setVisibility(View.VISIBLE);
                pencilImage.startAnimation(animation);
                imageEllipse.setVisibility(View.VISIBLE);
                buttonDefault.startAnimation(animDef);
                buttonDefault.setVisibility(View.INVISIBLE);
                imageBell.setVisibility(View.INVISIBLE);
                imageEllipse2.setVisibility(View.INVISIBLE);
                Drawable drawableEllipse = imageReady.getDrawable();
                if (drawableEllipse instanceof AnimatedVectorDrawableCompat) {
                    avd = (AnimatedVectorDrawableCompat) drawableEllipse;
                    avd.start();
                } else if (drawableEllipse instanceof AnimatedVectorDrawable) {
                    avd2 = (AnimatedVectorDrawable) drawableEllipse;
                    avd2.start();
                }
                //ОТМЕНЯЕМ РЕДАКТИРОВАНИЕ ПОЛЕЙ
                setDontEdit();
                break;
            default:
                Intent intent = new Intent(Schedule.this, Bells.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.alpha_zero_one, R.anim.alpha_one_zero);
                break;
        }
    }

    //УСТАНОВКА ОТМЕНЫ РЕДАКТИРОВАНИЯ
    private void setDontEdit() {
        editTextLesson11.setEnabled(false);
        editTextLesson12.setEnabled(false);
        editTextLesson13.setEnabled(false);
        editTextLesson14.setEnabled(false);
        editTextLesson15.setEnabled(false);
        editTextLesson16.setEnabled(false);

        editTextAuditores11.setEnabled(false);
        editTextAuditores12.setEnabled(false);
        editTextAuditores13.setEnabled(false);
        editTextAuditores14.setEnabled(false);
        editTextAuditores15.setEnabled(false);
        editTextAuditores16.setEnabled(false);

        editTextTeacher11.setEnabled(false);
        editTextTeacher12.setEnabled(false);
        editTextTeacher13.setEnabled(false);
        editTextTeacher14.setEnabled(false);
        editTextTeacher15.setEnabled(false);
        editTextTeacher16.setEnabled(false);

        //2Й ДЕНЬ
        editTextLesson21.setEnabled(false);
        editTextLesson22.setEnabled(false);
        editTextLesson23.setEnabled(false);
        editTextLesson24.setEnabled(false);
        editTextLesson25.setEnabled(false);
        editTextLesson26.setEnabled(false);

        editTextAuditores21.setEnabled(false);
        editTextAuditores22.setEnabled(false);
        editTextAuditores23.setEnabled(false);
        editTextAuditores24.setEnabled(false);
        editTextAuditores25.setEnabled(false);
        editTextAuditores26.setEnabled(false);

        editTextTeacher21.setEnabled(false);
        editTextTeacher22.setEnabled(false);
        editTextTeacher23.setEnabled(false);
        editTextTeacher24.setEnabled(false);
        editTextTeacher25.setEnabled(false);
        editTextTeacher26.setEnabled(false);

        //3Й ДЕНЬ
        editTextLesson31.setEnabled(false);
        editTextLesson32.setEnabled(false);
        editTextLesson33.setEnabled(false);
        editTextLesson34.setEnabled(false);
        editTextLesson35.setEnabled(false);
        editTextLesson36.setEnabled(false);

        editTextAuditores31.setEnabled(false);
        editTextAuditores32.setEnabled(false);
        editTextAuditores33.setEnabled(false);
        editTextAuditores34.setEnabled(false);
        editTextAuditores35.setEnabled(false);
        editTextAuditores36.setEnabled(false);

        editTextTeacher31.setEnabled(false);
        editTextTeacher32.setEnabled(false);
        editTextTeacher33.setEnabled(false);
        editTextTeacher34.setEnabled(false);
        editTextTeacher35.setEnabled(false);
        editTextTeacher36.setEnabled(false);

        //4Й ДЕНЬ
        editTextLesson41.setEnabled(false);
        editTextLesson42.setEnabled(false);
        editTextLesson43.setEnabled(false);
        editTextLesson44.setEnabled(false);
        editTextLesson45.setEnabled(false);
        editTextLesson46.setEnabled(false);

        editTextAuditores41.setEnabled(false);
        editTextAuditores42.setEnabled(false);
        editTextAuditores43.setEnabled(false);
        editTextAuditores44.setEnabled(false);
        editTextAuditores45.setEnabled(false);
        editTextAuditores46.setEnabled(false);

        editTextTeacher41.setEnabled(false);
        editTextTeacher42.setEnabled(false);
        editTextTeacher43.setEnabled(false);
        editTextTeacher44.setEnabled(false);
        editTextTeacher45.setEnabled(false);
        editTextTeacher46.setEnabled(false);

        //5Й ДЕНЬ
        editTextLesson51.setEnabled(false);
        editTextLesson52.setEnabled(false);
        editTextLesson53.setEnabled(false);
        editTextLesson54.setEnabled(false);
        editTextLesson55.setEnabled(false);
        editTextLesson56.setEnabled(false);

        editTextAuditores51.setEnabled(false);
        editTextAuditores52.setEnabled(false);
        editTextAuditores53.setEnabled(false);
        editTextAuditores54.setEnabled(false);
        editTextAuditores55.setEnabled(false);
        editTextAuditores56.setEnabled(false);

        editTextTeacher51.setEnabled(false);
        editTextTeacher52.setEnabled(false);
        editTextTeacher53.setEnabled(false);
        editTextTeacher54.setEnabled(false);
        editTextTeacher55.setEnabled(false);
        editTextTeacher56.setEnabled(false);

        //6Й ДЕНЬ
        editTextLesson61.setEnabled(false);
        editTextLesson62.setEnabled(false);
        editTextLesson63.setEnabled(false);
        editTextLesson64.setEnabled(false);
        editTextLesson65.setEnabled(false);
        editTextLesson66.setEnabled(false);

        editTextAuditores61.setEnabled(false);
        editTextAuditores62.setEnabled(false);
        editTextAuditores63.setEnabled(false);
        editTextAuditores64.setEnabled(false);
        editTextAuditores65.setEnabled(false);
        editTextAuditores66.setEnabled(false);

        editTextTeacher61.setEnabled(false);
        editTextTeacher62.setEnabled(false);
        editTextTeacher63.setEnabled(false);
        editTextTeacher64.setEnabled(false);
        editTextTeacher65.setEnabled(false);
        editTextTeacher66.setEnabled(false);

        //8Й ДЕНЬ
        editTextLesson81.setEnabled(false);
        editTextLesson82.setEnabled(false);
        editTextLesson83.setEnabled(false);
        editTextLesson84.setEnabled(false);
        editTextLesson85.setEnabled(false);
        editTextLesson86.setEnabled(false);

        editTextAuditores81.setEnabled(false);
        editTextAuditores82.setEnabled(false);
        editTextAuditores83.setEnabled(false);
        editTextAuditores84.setEnabled(false);
        editTextAuditores85.setEnabled(false);
        editTextAuditores86.setEnabled(false);

        editTextTeacher81.setEnabled(false);
        editTextTeacher82.setEnabled(false);
        editTextTeacher83.setEnabled(false);
        editTextTeacher84.setEnabled(false);
        editTextTeacher85.setEnabled(false);
        editTextTeacher86.setEnabled(false);

        //9Й ДЕНЬ
        editTextLesson91.setEnabled(false);
        editTextLesson92.setEnabled(false);
        editTextLesson93.setEnabled(false);
        editTextLesson94.setEnabled(false);
        editTextLesson95.setEnabled(false);
        editTextLesson96.setEnabled(false);

        editTextAuditores91.setEnabled(false);
        editTextAuditores92.setEnabled(false);
        editTextAuditores93.setEnabled(false);
        editTextAuditores94.setEnabled(false);
        editTextAuditores95.setEnabled(false);
        editTextAuditores96.setEnabled(false);

        editTextTeacher91.setEnabled(false);
        editTextTeacher92.setEnabled(false);
        editTextTeacher93.setEnabled(false);
        editTextTeacher94.setEnabled(false);
        editTextTeacher95.setEnabled(false);
        editTextTeacher96.setEnabled(false);

        //10Й ДЕНЬ
        editTextLesson101.setEnabled(false);
        editTextLesson102.setEnabled(false);
        editTextLesson103.setEnabled(false);
        editTextLesson104.setEnabled(false);
        editTextLesson105.setEnabled(false);
        editTextLesson106.setEnabled(false);

        editTextAuditores101.setEnabled(false);
        editTextAuditores102.setEnabled(false);
        editTextAuditores103.setEnabled(false);
        editTextAuditores104.setEnabled(false);
        editTextAuditores105.setEnabled(false);
        editTextAuditores106.setEnabled(false);

        editTextTeacher101.setEnabled(false);
        editTextTeacher102.setEnabled(false);
        editTextTeacher103.setEnabled(false);
        editTextTeacher104.setEnabled(false);
        editTextTeacher105.setEnabled(false);
        editTextTeacher106.setEnabled(false);

        //11Й ДЕНЬ
        editTextLesson111.setEnabled(false);
        editTextLesson112.setEnabled(false);
        editTextLesson113.setEnabled(false);
        editTextLesson114.setEnabled(false);
        editTextLesson115.setEnabled(false);
        editTextLesson116.setEnabled(false);

        editTextAuditores111.setEnabled(false);
        editTextAuditores112.setEnabled(false);
        editTextAuditores113.setEnabled(false);
        editTextAuditores114.setEnabled(false);
        editTextAuditores115.setEnabled(false);
        editTextAuditores116.setEnabled(false);

        editTextTeacher111.setEnabled(false);
        editTextTeacher112.setEnabled(false);
        editTextTeacher113.setEnabled(false);
        editTextTeacher114.setEnabled(false);
        editTextTeacher115.setEnabled(false);
        editTextTeacher116.setEnabled(false);

        //12Й ДЕНЬ
        editTextLesson121.setEnabled(false);
        editTextLesson122.setEnabled(false);
        editTextLesson123.setEnabled(false);
        editTextLesson124.setEnabled(false);
        editTextLesson125.setEnabled(false);
        editTextLesson126.setEnabled(false);

        editTextAuditores121.setEnabled(false);
        editTextAuditores122.setEnabled(false);
        editTextAuditores123.setEnabled(false);
        editTextAuditores124.setEnabled(false);
        editTextAuditores125.setEnabled(false);
        editTextAuditores126.setEnabled(false);

        editTextTeacher121.setEnabled(false);
        editTextTeacher122.setEnabled(false);
        editTextTeacher123.setEnabled(false);
        editTextTeacher124.setEnabled(false);
        editTextTeacher125.setEnabled(false);
        editTextTeacher126.setEnabled(false);

        //13Й ДЕНЬ
        editTextLesson131.setEnabled(false);
        editTextLesson132.setEnabled(false);
        editTextLesson133.setEnabled(false);
        editTextLesson134.setEnabled(false);
        editTextLesson135.setEnabled(false);
        editTextLesson136.setEnabled(false);

        editTextAuditores131.setEnabled(false);
        editTextAuditores132.setEnabled(false);
        editTextAuditores133.setEnabled(false);
        editTextAuditores134.setEnabled(false);
        editTextAuditores135.setEnabled(false);
        editTextAuditores136.setEnabled(false);

        editTextTeacher131.setEnabled(false);
        editTextTeacher132.setEnabled(false);
        editTextTeacher133.setEnabled(false);
        editTextTeacher134.setEnabled(false);
        editTextTeacher135.setEnabled(false);
        editTextTeacher136.setEnabled(false);
    }

    //РАЗРЕШЕНИЕ РЕДАКТИРОВАНИЯ РЕДАКТИРОВАНИЯ
    private void setPermissionsEdit() {
        editTextLesson11.setEnabled(true);
        editTextLesson12.setEnabled(true);
        editTextLesson13.setEnabled(true);
        editTextLesson14.setEnabled(true);
        editTextLesson15.setEnabled(true);
        editTextLesson16.setEnabled(true);

        editTextAuditores11.setEnabled(true);
        editTextAuditores12.setEnabled(true);
        editTextAuditores13.setEnabled(true);
        editTextAuditores14.setEnabled(true);
        editTextAuditores15.setEnabled(true);
        editTextAuditores16.setEnabled(true);

        editTextTeacher11.setEnabled(true);
        editTextTeacher12.setEnabled(true);
        editTextTeacher13.setEnabled(true);
        editTextTeacher14.setEnabled(true);
        editTextTeacher15.setEnabled(true);
        editTextTeacher16.setEnabled(true);

        //2Й ДЕНЬ
        editTextLesson21.setEnabled(true);
        editTextLesson22.setEnabled(true);
        editTextLesson23.setEnabled(true);
        editTextLesson24.setEnabled(true);
        editTextLesson25.setEnabled(true);
        editTextLesson26.setEnabled(true);

        editTextAuditores21.setEnabled(true);
        editTextAuditores22.setEnabled(true);
        editTextAuditores23.setEnabled(true);
        editTextAuditores24.setEnabled(true);
        editTextAuditores25.setEnabled(true);
        editTextAuditores26.setEnabled(true);

        editTextTeacher21.setEnabled(true);
        editTextTeacher22.setEnabled(true);
        editTextTeacher23.setEnabled(true);
        editTextTeacher24.setEnabled(true);
        editTextTeacher25.setEnabled(true);
        editTextTeacher26.setEnabled(true);

        //3Й ДЕНЬ
        editTextLesson31.setEnabled(true);
        editTextLesson32.setEnabled(true);
        editTextLesson33.setEnabled(true);
        editTextLesson34.setEnabled(true);
        editTextLesson35.setEnabled(true);
        editTextLesson36.setEnabled(true);

        editTextAuditores31.setEnabled(true);
        editTextAuditores32.setEnabled(true);
        editTextAuditores33.setEnabled(true);
        editTextAuditores34.setEnabled(true);
        editTextAuditores35.setEnabled(true);
        editTextAuditores36.setEnabled(true);

        editTextTeacher31.setEnabled(true);
        editTextTeacher32.setEnabled(true);
        editTextTeacher33.setEnabled(true);
        editTextTeacher34.setEnabled(true);
        editTextTeacher35.setEnabled(true);
        editTextTeacher36.setEnabled(true);

        //4Й ДЕНЬ
        editTextLesson41.setEnabled(true);
        editTextLesson42.setEnabled(true);
        editTextLesson43.setEnabled(true);
        editTextLesson44.setEnabled(true);
        editTextLesson45.setEnabled(true);
        editTextLesson46.setEnabled(true);
        editTextAuditores41.setEnabled(true);
        editTextAuditores42.setEnabled(true);
        editTextAuditores43.setEnabled(true);
        editTextAuditores44.setEnabled(true);
        editTextAuditores45.setEnabled(true);
        editTextAuditores46.setEnabled(true);

        editTextTeacher41.setEnabled(true);
        editTextTeacher42.setEnabled(true);
        editTextTeacher43.setEnabled(true);
        editTextTeacher44.setEnabled(true);
        editTextTeacher45.setEnabled(true);
        editTextTeacher46.setEnabled(true);

        //5Й ДЕНЬ
        editTextLesson51.setEnabled(true);
        editTextLesson52.setEnabled(true);
        editTextLesson53.setEnabled(true);
        editTextLesson54.setEnabled(true);
        editTextLesson55.setEnabled(true);
        editTextLesson56.setEnabled(true);

        editTextAuditores51.setEnabled(true);
        editTextAuditores52.setEnabled(true);
        editTextAuditores53.setEnabled(true);
        editTextAuditores54.setEnabled(true);
        editTextAuditores55.setEnabled(true);
        editTextAuditores56.setEnabled(true);

        editTextTeacher51.setEnabled(true);
        editTextTeacher52.setEnabled(true);
        editTextTeacher53.setEnabled(true);
        editTextTeacher54.setEnabled(true);
        editTextTeacher55.setEnabled(true);
        editTextTeacher56.setEnabled(true);

        //6Й ДЕНЬ
        editTextLesson61.setEnabled(true);
        editTextLesson62.setEnabled(true);
        editTextLesson63.setEnabled(true);
        editTextLesson64.setEnabled(true);
        editTextLesson65.setEnabled(true);
        editTextLesson66.setEnabled(true);

        editTextAuditores61.setEnabled(true);
        editTextAuditores62.setEnabled(true);
        editTextAuditores63.setEnabled(true);
        editTextAuditores64.setEnabled(true);
        editTextAuditores65.setEnabled(true);
        editTextAuditores66.setEnabled(true);

        editTextTeacher61.setEnabled(true);
        editTextTeacher62.setEnabled(true);
        editTextTeacher63.setEnabled(true);
        editTextTeacher64.setEnabled(true);
        editTextTeacher65.setEnabled(true);
        editTextTeacher66.setEnabled(true);

        //8Й ДЕНЬ
        editTextLesson81.setEnabled(true);
        editTextLesson82.setEnabled(true);
        editTextLesson83.setEnabled(true);
        editTextLesson84.setEnabled(true);
        editTextLesson85.setEnabled(true);
        editTextLesson86.setEnabled(true);

        editTextAuditores81.setEnabled(true);
        editTextAuditores82.setEnabled(true);
        editTextAuditores83.setEnabled(true);
        editTextAuditores84.setEnabled(true);
        editTextAuditores85.setEnabled(true);
        editTextAuditores86.setEnabled(true);

        editTextTeacher81.setEnabled(true);
        editTextTeacher82.setEnabled(true);
        editTextTeacher83.setEnabled(true);
        editTextTeacher84.setEnabled(true);
        editTextTeacher85.setEnabled(true);
        editTextTeacher86.setEnabled(true);

        //9Й ДЕНЬ
        editTextLesson91.setEnabled(true);
        editTextLesson92.setEnabled(true);
        editTextLesson93.setEnabled(true);
        editTextLesson94.setEnabled(true);
        editTextLesson95.setEnabled(true);
        editTextLesson96.setEnabled(true);

        editTextAuditores91.setEnabled(true);
        editTextAuditores92.setEnabled(true);
        editTextAuditores93.setEnabled(true);
        editTextAuditores94.setEnabled(true);
        editTextAuditores95.setEnabled(true);
        editTextAuditores96.setEnabled(true);

        editTextTeacher91.setEnabled(true);
        editTextTeacher92.setEnabled(true);
        editTextTeacher93.setEnabled(true);
        editTextTeacher94.setEnabled(true);
        editTextTeacher95.setEnabled(true);
        editTextTeacher96.setEnabled(true);

        //10Й ДЕНЬ
        editTextLesson101.setEnabled(true);
        editTextLesson102.setEnabled(true);
        editTextLesson103.setEnabled(true);
        editTextLesson104.setEnabled(true);
        editTextLesson105.setEnabled(true);
        editTextLesson106.setEnabled(true);

        editTextAuditores101.setEnabled(true);
        editTextAuditores102.setEnabled(true);
        editTextAuditores103.setEnabled(true);
        editTextAuditores104.setEnabled(true);
        editTextAuditores105.setEnabled(true);
        editTextAuditores106.setEnabled(true);

        editTextTeacher101.setEnabled(true);
        editTextTeacher102.setEnabled(true);
        editTextTeacher103.setEnabled(true);
        editTextTeacher104.setEnabled(true);
        editTextTeacher105.setEnabled(true);
        editTextTeacher106.setEnabled(true);

        //11Й ДЕНЬ
        editTextLesson111.setEnabled(true);
        editTextLesson112.setEnabled(true);
        editTextLesson113.setEnabled(true);
        editTextLesson114.setEnabled(true);
        editTextLesson115.setEnabled(true);
        editTextLesson116.setEnabled(true);

        editTextAuditores111.setEnabled(true);
        editTextAuditores112.setEnabled(true);
        editTextAuditores113.setEnabled(true);
        editTextAuditores114.setEnabled(true);
        editTextAuditores115.setEnabled(true);
        editTextAuditores116.setEnabled(true);

        editTextTeacher111.setEnabled(true);
        editTextTeacher112.setEnabled(true);
        editTextTeacher113.setEnabled(true);
        editTextTeacher114.setEnabled(true);
        editTextTeacher115.setEnabled(true);
        editTextTeacher116.setEnabled(true);

        //12Й ДЕНЬ
        editTextLesson121.setEnabled(true);
        editTextLesson122.setEnabled(true);
        editTextLesson123.setEnabled(true);
        editTextLesson124.setEnabled(true);
        editTextLesson125.setEnabled(true);
        editTextLesson126.setEnabled(true);

        editTextAuditores121.setEnabled(true);
        editTextAuditores122.setEnabled(true);
        editTextAuditores123.setEnabled(true);
        editTextAuditores124.setEnabled(true);
        editTextAuditores125.setEnabled(true);
        editTextAuditores126.setEnabled(true);

        editTextTeacher121.setEnabled(true);
        editTextTeacher122.setEnabled(true);
        editTextTeacher123.setEnabled(true);
        editTextTeacher124.setEnabled(true);
        editTextTeacher125.setEnabled(true);
        editTextTeacher126.setEnabled(true);

        //13Й ДЕНЬ
        editTextLesson131.setEnabled(true);
        editTextLesson132.setEnabled(true);
        editTextLesson133.setEnabled(true);
        editTextLesson134.setEnabled(true);
        editTextLesson135.setEnabled(true);
        editTextLesson136.setEnabled(true);

        editTextAuditores131.setEnabled(true);
        editTextAuditores132.setEnabled(true);
        editTextAuditores133.setEnabled(true);
        editTextAuditores134.setEnabled(true);
        editTextAuditores135.setEnabled(true);
        editTextAuditores136.setEnabled(true);

        editTextTeacher131.setEnabled(true);
        editTextTeacher132.setEnabled(true);
        editTextTeacher133.setEnabled(true);
        editTextTeacher134.setEnabled(true);
        editTextTeacher135.setEnabled(true);
        editTextTeacher136.setEnabled(true);
    }

    //Скрываем Navigation Bar (кнопки)
    @Override
    protected void onStart() {
        super.onStart();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }
}