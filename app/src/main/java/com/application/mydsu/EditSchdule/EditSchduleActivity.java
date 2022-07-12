package com.application.mydsu.EditSchdule;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.application.mydsu.AboutMe;
import com.application.mydsu.R;
import com.application.mydsu.Utils.Swipe;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class EditSchduleActivity extends AppCompatActivity {
    private Dialog dialog;
    private HashMap<String,TextView> hashMap;
    private ModelSchedule modelSchedule;
    private View v;
    private List<String> scheduleKey,scheduleValue;
    //    private ConnectivityManager connectivityManager;
//    private ConnectivityManager.NetworkCallback callback;
    //1 ДЕНЬ
    EditText editTextLesson11, editTextAuditores11, editTextTeacher11,
            editTextLesson12, editTextAuditores12, editTextTeacher12,
            editTextLesson13, editTextAuditores13, editTextTeacher13,
            editTextLesson14, editTextAuditores14, editTextTeacher14,
            editTextLesson15, editTextAuditores15, editTextTeacher15,
            editTextLesson16, editTextAuditores16, editTextTeacher16;
//            editTextLesson17, editTextAuditores17, editTextTeacher17;

    String editTextLessonDB11, editTextAuditoresDB11, editTextTeacherDB11,
            editTextLessonDB12, editTextAuditoresDB12, editTextTeacherDB12,
            editTextLessonDB13, editTextAuditoresDB13, editTextTeacherDB13,
            editTextLessonDB14, editTextAuditoresDB14, editTextTeacherDB14,
            editTextLessonDB15, editTextAuditoresDB15, editTextTeacherDB15,
            editTextLessonDB16, editTextAuditoresDB16, editTextTeacherDB16;
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
    ArrayList<EditText> editTextsMas = new ArrayList<>();
    private FirebaseUser user;
    private Button outUserTV;
    private TextView tochka, tochka2;
    private SharedPreferences prefsTheme = null;
    boolean onClicKweek = false, onClicDaySunday = false;
    private ConstraintLayout main_layout;
    private TextView form_lessons_sunday,
            form_lessons_sunday_text, course, sobgroup;
    boolean flagTheme;
    private String  elementCource,
            elementSubGroup, elementDirection,elementFacultet;
    private SharedPreferences sharedPreferences,prefs;
    private ScrollView scrollView;


    private int dayOfMonth, dayOfMonthMax, dayOfMonthMinus1, dayOfMonthMinus2, dayOfMonthMinus3, dayOfMonthMinus4, dayOfMonthMinus5,
            dayOfMonthMinus6, dayOfMonthMinus7, dayOfMonthMinus8, dayOfMonthMinus9, dayOfMonthMinus10,
            dayOfMonthMinus11, dayOfMonthMinus12, dayOfMonthMinus13, dayOfMonthPlus1, dayOfMonthPlus2, dayOfMonthPlus3, dayOfMonthPlus4, dayOfMonthPlus5,
            dayOfMonthPlus6, dayOfMonthPlus7, dayOfMonthPlus8, dayOfMonthPlus9, dayOfMonthPlus10,
            dayOfMonthPlus11, dayOfMonthPlus12, dayOfMonthPlus13;
    private Calendar calendar,maxDayOfMonth;
    private Button makeChangesBtn;
    private boolean flag = false;
    private LinearLayout linearLayout1, linearLayout2, linearLayout3, linearLayout4, linearLayout5,
            linearLayout6, linearLayout8, linearLayout9, linearLayout10, linearLayout11,
            linearLayout12, linearLayout13, groupsButton1, groupsButton2;
    private Button buttonDefault, btnWeekDay1, btnWeekDay2, btnWeekDay3, btnWeekDay4, btnWeekDay5, btnWeekDay6,
            btnWeekDay8, btnWeekDay9, btnWeekDay10, btnWeekDay11, btnWeekDay12, btnWeekDay13,
            buttonWeekOne, buttonWeekTwo;
    private int weeekOfMonth, toDay, max, weekOfYearMax, weekOfYear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_schdule);
        //ПРОВЕРЯЕМ КАКАЯ ТЕМА ВЫБРАНА
        prefsTheme = getSharedPreferences("Theme", MODE_PRIVATE);
        prefs = getSharedPreferences("FirstRun", MODE_PRIVATE);
        flagTheme = prefsTheme.getBoolean("lightAndDarkTheme", false);
        if (flagTheme) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url
            String name = user.getDisplayName();
            String email = user.getEmail();
            Uri photoUrl = user.getPhotoUrl();
            Log.d("AUTH","name = " + name + " email = " + email
                    + " photoUrl = " + photoUrl);
        }
        //Свайп
        main_layout = (ConstraintLayout) findViewById(R.id.main_layout);
        main_layout.setOnTouchListener(new Swipe(EditSchduleActivity.this) {
            public void onSwipeRight() {
                backStep();
            }
        });
        //Dialog Download
        v = LayoutInflater.from(EditSchduleActivity.this).
                inflate(R.layout.dialog_download, null);

        dialog = new Dialog(EditSchduleActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(v);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        hasConnection(EditSchduleActivity.this,1);
        //Инициализвация
        init();
        //Работа с Календарем
        calendar();
        //УСТОНАВЛИВАЕМ СЕГОДНЯШНИЙ ДЕНЬ
        new ChooseDay().execute();
        //УСТАНОВКА TEXTVIEW В HASHMAP
        new AsyncSetInHashMap().execute();
        //УСТАНОВКА ДАННЫХ ИЗ SHARED PREFERENCES
        setData();
        //УСТОНАВЛИВАЕМ ТОЧКУ НЕДЕЛИ
        setTochka();
        //Проверяем выход в интернет
//        hasConnection(EditSchduleActivity.this);
//        checkingInternet();
        //Получение расписания из firebase
        getData();
        makeChangesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickBtnMakeChanges();
            }
        });

        outUserTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signOut();
            }
        });

    }

    private class AsyncSetInHashMap extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            setInHashMap();
            return null;
        }

    }

    private void setInHashMap() {

        hashMap = new HashMap<>();
        //1
        hashMap.put("lesson11",editTextLesson11);
        hashMap.put("lesson12",editTextLesson12);
        hashMap.put("lesson13",editTextLesson13);
        hashMap.put("lesson14",editTextLesson14);
        hashMap.put("lesson15",editTextLesson15);
        hashMap.put("lesson16",editTextLesson16);

        hashMap.put("auditores11",editTextAuditores11);
        hashMap.put("auditores12",editTextAuditores12);
        hashMap.put("auditores13",editTextAuditores13);
        hashMap.put("auditores14",editTextAuditores14);
        hashMap.put("auditores15",editTextAuditores15);
        hashMap.put("auditores16",editTextAuditores16);

        hashMap.put("teacher11",editTextTeacher11);
        hashMap.put("teacher12",editTextTeacher12);
        hashMap.put("teacher13",editTextTeacher13);
        hashMap.put("teacher14",editTextTeacher14);
        hashMap.put("teacher15",editTextTeacher15);
        hashMap.put("teacher16",editTextTeacher16);
        //2
        hashMap.put("lesson21",editTextLesson21);
        hashMap.put("lesson22",editTextLesson22);
        hashMap.put("lesson23",editTextLesson23);
        hashMap.put("lesson24",editTextLesson24);
        hashMap.put("lesson25",editTextLesson25);
        hashMap.put("lesson26",editTextLesson26);

        hashMap.put("auditores21",editTextAuditores21);
        hashMap.put("auditores22",editTextAuditores22);
        hashMap.put("auditores23",editTextAuditores23);
        hashMap.put("auditores24",editTextAuditores24);
        hashMap.put("auditores25",editTextAuditores25);
        hashMap.put("auditores26",editTextAuditores26);

        hashMap.put("teacher21",editTextTeacher21);
        hashMap.put("teacher22",editTextTeacher22);
        hashMap.put("teacher23",editTextTeacher23);
        hashMap.put("teacher24",editTextTeacher24);
        hashMap.put("teacher25",editTextTeacher25);
        hashMap.put("teacher26",editTextTeacher26);
        //3
        hashMap.put("lesson31",editTextLesson31);
        hashMap.put("lesson32",editTextLesson32);
        hashMap.put("lesson33",editTextLesson33);
        hashMap.put("lesson34",editTextLesson34);
        hashMap.put("lesson35",editTextLesson35);
        hashMap.put("lesson36",editTextLesson36);

        hashMap.put("auditores31",editTextAuditores31);
        hashMap.put("auditores32",editTextAuditores32);
        hashMap.put("auditores33",editTextAuditores33);
        hashMap.put("auditores34",editTextAuditores34);
        hashMap.put("auditores35",editTextAuditores35);
        hashMap.put("auditores36",editTextAuditores36);

        hashMap.put("teacher31",editTextTeacher31);
        hashMap.put("teacher32",editTextTeacher32);
        hashMap.put("teacher33",editTextTeacher33);
        hashMap.put("teacher34",editTextTeacher34);
        hashMap.put("teacher35",editTextTeacher35);
        hashMap.put("teacher36",editTextTeacher36);
        //4
        hashMap.put("lesson41",editTextLesson41);
        hashMap.put("lesson42",editTextLesson42);
        hashMap.put("lesson43",editTextLesson43);
        hashMap.put("lesson44",editTextLesson44);
        hashMap.put("lesson45",editTextLesson45);
        hashMap.put("lesson46",editTextLesson46);

        hashMap.put("auditores41",editTextAuditores41);
        hashMap.put("auditores42",editTextAuditores42);
        hashMap.put("auditores43",editTextAuditores43);
        hashMap.put("auditores44",editTextAuditores44);
        hashMap.put("auditores45",editTextAuditores45);
        hashMap.put("auditores46",editTextAuditores46);

        hashMap.put("teacher41",editTextTeacher41);
        hashMap.put("teacher42",editTextTeacher42);
        hashMap.put("teacher43",editTextTeacher43);
        hashMap.put("teacher44",editTextTeacher44);
        hashMap.put("teacher45",editTextTeacher45);
        hashMap.put("teacher46",editTextTeacher46);
        //5
        hashMap.put("lesson51",editTextLesson51);
        hashMap.put("lesson52",editTextLesson52);
        hashMap.put("lesson53",editTextLesson53);
        hashMap.put("lesson54",editTextLesson54);
        hashMap.put("lesson55",editTextLesson55);
        hashMap.put("lesson56",editTextLesson56);

        hashMap.put("auditores51",editTextAuditores51);
        hashMap.put("auditores52",editTextAuditores52);
        hashMap.put("auditores53",editTextAuditores53);
        hashMap.put("auditores54",editTextAuditores54);
        hashMap.put("auditores55",editTextAuditores55);
        hashMap.put("auditores56",editTextAuditores56);

        hashMap.put("teacher51",editTextTeacher51);
        hashMap.put("teacher52",editTextTeacher52);
        hashMap.put("teacher53",editTextTeacher53);
        hashMap.put("teacher54",editTextTeacher54);
        hashMap.put("teacher55",editTextTeacher55);
        hashMap.put("teacher56",editTextTeacher56);
        //6
        hashMap.put("lesson61",editTextLesson61);
        hashMap.put("lesson62",editTextLesson62);
        hashMap.put("lesson63",editTextLesson63);
        hashMap.put("lesson64",editTextLesson64);
        hashMap.put("lesson65",editTextLesson65);
        hashMap.put("lesson66",editTextLesson66);

        hashMap.put("auditores61",editTextAuditores61);
        hashMap.put("auditores62",editTextAuditores62);
        hashMap.put("auditores63",editTextAuditores63);
        hashMap.put("auditores64",editTextAuditores64);
        hashMap.put("auditores65",editTextAuditores65);
        hashMap.put("auditores66",editTextAuditores66);

        hashMap.put("teacher61",editTextTeacher61);
        hashMap.put("teacher62",editTextTeacher62);
        hashMap.put("teacher63",editTextTeacher63);
        hashMap.put("teacher64",editTextTeacher64);
        hashMap.put("teacher65",editTextTeacher65);
        hashMap.put("teacher66",editTextTeacher66);
        //8
        hashMap.put("lesson81",editTextLesson81);
        hashMap.put("lesson82",editTextLesson82);
        hashMap.put("lesson83",editTextLesson83);
        hashMap.put("lesson84",editTextLesson84);
        hashMap.put("lesson85",editTextLesson85);
        hashMap.put("lesson86",editTextLesson86);

        hashMap.put("auditores81",editTextAuditores81);
        hashMap.put("auditores82",editTextAuditores82);
        hashMap.put("auditores83",editTextAuditores83);
        hashMap.put("auditores84",editTextAuditores84);
        hashMap.put("auditores85",editTextAuditores85);
        hashMap.put("auditores86",editTextAuditores86);

        hashMap.put("teacher81",editTextTeacher81);
        hashMap.put("teacher82",editTextTeacher82);
        hashMap.put("teacher83",editTextTeacher83);
        hashMap.put("teacher84",editTextTeacher84);
        hashMap.put("teacher85",editTextTeacher85);
        hashMap.put("teacher86",editTextTeacher86);
        //9
        hashMap.put("lesson91",editTextLesson91);
        hashMap.put("lesson92",editTextLesson92);
        hashMap.put("lesson93",editTextLesson93);
        hashMap.put("lesson94",editTextLesson94);
        hashMap.put("lesson95",editTextLesson95);
        hashMap.put("lesson96",editTextLesson96);

        hashMap.put("auditores91",editTextAuditores91);
        hashMap.put("auditores92",editTextAuditores92);
        hashMap.put("auditores93",editTextAuditores93);
        hashMap.put("auditores94",editTextAuditores94);
        hashMap.put("auditores95",editTextAuditores95);
        hashMap.put("auditores96",editTextAuditores96);

        hashMap.put("teacher91",editTextTeacher91);
        hashMap.put("teacher92",editTextTeacher92);
        hashMap.put("teacher93",editTextTeacher93);
        hashMap.put("teacher94",editTextTeacher94);
        hashMap.put("teacher95",editTextTeacher95);
        hashMap.put("teacher96",editTextTeacher96);
        //10
        hashMap.put("lesson101",editTextLesson101);
        hashMap.put("lesson102",editTextLesson102);
        hashMap.put("lesson103",editTextLesson103);
        hashMap.put("lesson104",editTextLesson104);
        hashMap.put("lesson105",editTextLesson105);
        hashMap.put("lesson106",editTextLesson106);

        hashMap.put("auditores101",editTextAuditores101);
        hashMap.put("auditores102",editTextAuditores102);
        hashMap.put("auditores103",editTextAuditores103);
        hashMap.put("auditores104",editTextAuditores104);
        hashMap.put("auditores105",editTextAuditores105);
        hashMap.put("auditores106",editTextAuditores106);

        hashMap.put("teacher101",editTextTeacher101);
        hashMap.put("teacher102",editTextTeacher102);
        hashMap.put("teacher103",editTextTeacher103);
        hashMap.put("teacher104",editTextTeacher104);
        hashMap.put("teacher105",editTextTeacher105);
        hashMap.put("teacher106",editTextTeacher106);
        //11
        hashMap.put("lesson111",editTextLesson111);
        hashMap.put("lesson112",editTextLesson112);
        hashMap.put("lesson113",editTextLesson113);
        hashMap.put("lesson114",editTextLesson114);
        hashMap.put("lesson115",editTextLesson115);
        hashMap.put("lesson116",editTextLesson116);

        hashMap.put("auditores111",editTextAuditores111);
        hashMap.put("auditores112",editTextAuditores112);
        hashMap.put("auditores113",editTextAuditores113);
        hashMap.put("auditores114",editTextAuditores114);
        hashMap.put("auditores115",editTextAuditores115);
        hashMap.put("auditores116",editTextAuditores116);

        hashMap.put("teacher111",editTextTeacher111);
        hashMap.put("teacher112",editTextTeacher112);
        hashMap.put("teacher113",editTextTeacher113);
        hashMap.put("teacher114",editTextTeacher114);
        hashMap.put("teacher115",editTextTeacher115);
        hashMap.put("teacher116",editTextTeacher116);
        //12
        hashMap.put("lesson121",editTextLesson121);
        hashMap.put("lesson122",editTextLesson122);
        hashMap.put("lesson123",editTextLesson123);
        hashMap.put("lesson124",editTextLesson124);
        hashMap.put("lesson125",editTextLesson125);
        hashMap.put("lesson126",editTextLesson126);

        hashMap.put("auditores121",editTextAuditores121);
        hashMap.put("auditores122",editTextAuditores122);
        hashMap.put("auditores123",editTextAuditores123);
        hashMap.put("auditores124",editTextAuditores124);
        hashMap.put("auditores125",editTextAuditores125);
        hashMap.put("auditores126",editTextAuditores126);

        hashMap.put("teacher121",editTextTeacher121);
        hashMap.put("teacher122",editTextTeacher122);
        hashMap.put("teacher123",editTextTeacher123);
        hashMap.put("teacher124",editTextTeacher124);
        hashMap.put("teacher125",editTextTeacher125);
        hashMap.put("teacher126",editTextTeacher126);
        //13
        hashMap.put("lesson131",editTextLesson131);
        hashMap.put("lesson132",editTextLesson132);
        hashMap.put("lesson133",editTextLesson133);
        hashMap.put("lesson134",editTextLesson134);
        hashMap.put("lesson135",editTextLesson135);
        hashMap.put("lesson136",editTextLesson136);

        hashMap.put("auditores131",editTextAuditores131);
        hashMap.put("auditores132",editTextAuditores132);
        hashMap.put("auditores133",editTextAuditores133);
        hashMap.put("auditores134",editTextAuditores134);
        hashMap.put("auditores135",editTextAuditores135);
        hashMap.put("auditores136",editTextAuditores136);

        hashMap.put("teacher131",editTextTeacher131);
        hashMap.put("teacher132",editTextTeacher132);
        hashMap.put("teacher133",editTextTeacher133);
        hashMap.put("teacher134",editTextTeacher134);
        hashMap.put("teacher135",editTextTeacher135);
        hashMap.put("teacher136",editTextTeacher136);
    }

    //Выбираем сегодняшний день с помощью запуска функции в AsyncTask
    private class ChooseDay extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            choosedDay();
            return null;
        }
    }
    //Получение расписания из firebase
    private void getData(){
        scheduleKey = new ArrayList<>();
        scheduleValue = new ArrayList<>();
        // Read from the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(elementFacultet)
                .child(elementDirection).child(elementCource).child(elementSubGroup);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                scheduleKey.clear();
                scheduleValue.clear();
                for(DataSnapshot snapshot1 : snapshot.getChildren()){
                    scheduleKey.add(snapshot1.getKey());
                    scheduleValue.add(snapshot1.getValue().toString());
                    Log.d("TAG123", "Value is: " + snapshot1.getValue());
                    Log.d("TAG123", "Key is: " + snapshot1.getKey());
                }
                setDataOnTextView();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void setDataOnTextView() {
        for (int i=0; i<scheduleKey.size();i++){
            hashMap.get(scheduleKey.get(i)).setText(scheduleValue.get(i));
        }
        if(dialog.isShowing()) {
            dialog.dismiss();
        }
    }
    private class SetETInMasAsync extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            setETInMas();
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            startCycle();
        }
    }
    private void setETInMas(){
        editTextsMas.add(editTextLesson11);
        editTextsMas.add(editTextAuditores11);
        editTextsMas.add(editTextTeacher11);

        editTextsMas.add(editTextLesson12);
        editTextsMas.add(editTextAuditores12);
        editTextsMas.add(editTextTeacher12);

        editTextsMas.add(editTextLesson13);
        editTextsMas.add(editTextAuditores13);
        editTextsMas.add(editTextTeacher13);

        editTextsMas.add(editTextLesson14);
        editTextsMas.add(editTextAuditores14);
        editTextsMas.add(editTextTeacher14);

        editTextsMas.add(editTextLesson15);
        editTextsMas.add(editTextAuditores15);
        editTextsMas.add(editTextTeacher15);

        editTextsMas.add(editTextLesson16);
        editTextsMas.add(editTextAuditores16);
        editTextsMas.add(editTextTeacher16);

        editTextsMas.add(editTextLesson21);
        editTextsMas.add(editTextAuditores21);
        editTextsMas.add(editTextTeacher21);

        editTextsMas.add(editTextLesson22);
        editTextsMas.add(editTextAuditores22);
        editTextsMas.add(editTextTeacher22);

        editTextsMas.add(editTextLesson23);
        editTextsMas.add(editTextAuditores23);
        editTextsMas.add(editTextTeacher23);

        editTextsMas.add(editTextLesson24);
        editTextsMas.add(editTextAuditores24);
        editTextsMas.add(editTextTeacher24);

        editTextsMas.add(editTextLesson25);
        editTextsMas.add(editTextAuditores25);
        editTextsMas.add(editTextTeacher25);

        editTextsMas.add(editTextLesson26);
        editTextsMas.add(editTextAuditores26);
        editTextsMas.add(editTextTeacher26);

        editTextsMas.add(editTextLesson31);
        editTextsMas.add(editTextAuditores31);
        editTextsMas.add(editTextTeacher31);

        editTextsMas.add(editTextLesson32);
        editTextsMas.add(editTextAuditores32);
        editTextsMas.add(editTextTeacher32);

        editTextsMas.add(editTextLesson33);
        editTextsMas.add(editTextAuditores33);
        editTextsMas.add(editTextTeacher33);

        editTextsMas.add(editTextLesson34);
        editTextsMas.add(editTextAuditores34);
        editTextsMas.add(editTextTeacher34);

        editTextsMas.add(editTextLesson35);
        editTextsMas.add(editTextAuditores35);
        editTextsMas.add(editTextTeacher35);

        editTextsMas.add(editTextLesson36);
        editTextsMas.add(editTextAuditores36);
        editTextsMas.add(editTextTeacher36);

        editTextsMas.add(editTextLesson41);
        editTextsMas.add(editTextAuditores41);
        editTextsMas.add(editTextTeacher41);

        editTextsMas.add(editTextLesson42);
        editTextsMas.add(editTextAuditores42);
        editTextsMas.add(editTextTeacher42);

        editTextsMas.add(editTextLesson43);
        editTextsMas.add(editTextAuditores43);
        editTextsMas.add(editTextTeacher43);

        editTextsMas.add(editTextLesson44);
        editTextsMas.add(editTextAuditores44);
        editTextsMas.add(editTextTeacher44);

        editTextsMas.add(editTextLesson45);
        editTextsMas.add(editTextAuditores45);
        editTextsMas.add(editTextTeacher45);

        editTextsMas.add(editTextLesson46);
        editTextsMas.add(editTextAuditores46);
        editTextsMas.add(editTextTeacher46);

        editTextsMas.add(editTextLesson51);
        editTextsMas.add(editTextAuditores51);
        editTextsMas.add(editTextTeacher51);

        editTextsMas.add(editTextLesson52);
        editTextsMas.add(editTextAuditores52);
        editTextsMas.add(editTextTeacher52);

        editTextsMas.add(editTextLesson53);
        editTextsMas.add(editTextAuditores53);
        editTextsMas.add(editTextTeacher53);

        editTextsMas.add(editTextLesson54);
        editTextsMas.add(editTextAuditores54);
        editTextsMas.add(editTextTeacher54);

        editTextsMas.add(editTextLesson55);
        editTextsMas.add(editTextAuditores55);
        editTextsMas.add(editTextTeacher55);

        editTextsMas.add(editTextLesson56);
        editTextsMas.add(editTextAuditores56);
        editTextsMas.add(editTextTeacher56);

        editTextsMas.add(editTextLesson61);
        editTextsMas.add(editTextAuditores61);
        editTextsMas.add(editTextTeacher61);

        editTextsMas.add(editTextLesson62);
        editTextsMas.add(editTextAuditores62);
        editTextsMas.add(editTextTeacher62);

        editTextsMas.add(editTextLesson63);
        editTextsMas.add(editTextAuditores63);
        editTextsMas.add(editTextTeacher63);

        editTextsMas.add(editTextLesson64);
        editTextsMas.add(editTextAuditores64);
        editTextsMas.add(editTextTeacher64);

        editTextsMas.add(editTextLesson65);
        editTextsMas.add(editTextAuditores65);
        editTextsMas.add(editTextTeacher65);

        editTextsMas.add(editTextLesson66);
        editTextsMas.add(editTextAuditores66);
        editTextsMas.add(editTextTeacher66);


        editTextsMas.add(editTextLesson81);
        editTextsMas.add(editTextAuditores81);
        editTextsMas.add(editTextTeacher81);

        editTextsMas.add(editTextLesson82);
        editTextsMas.add(editTextAuditores82);
        editTextsMas.add(editTextTeacher82);

        editTextsMas.add(editTextLesson83);
        editTextsMas.add(editTextAuditores83);
        editTextsMas.add(editTextTeacher83);

        editTextsMas.add(editTextLesson84);
        editTextsMas.add(editTextAuditores84);
        editTextsMas.add(editTextTeacher84);

        editTextsMas.add(editTextLesson85);
        editTextsMas.add(editTextAuditores85);
        editTextsMas.add(editTextTeacher85);

        editTextsMas.add(editTextLesson86);
        editTextsMas.add(editTextAuditores86);
        editTextsMas.add(editTextTeacher86);

        editTextsMas.add(editTextLesson91);
        editTextsMas.add(editTextAuditores91);
        editTextsMas.add(editTextTeacher91);

        editTextsMas.add(editTextLesson92);
        editTextsMas.add(editTextAuditores92);
        editTextsMas.add(editTextTeacher92);

        editTextsMas.add(editTextLesson93);
        editTextsMas.add(editTextAuditores93);
        editTextsMas.add(editTextTeacher93);

        editTextsMas.add(editTextLesson94);
        editTextsMas.add(editTextAuditores94);
        editTextsMas.add(editTextTeacher94);

        editTextsMas.add(editTextLesson95);
        editTextsMas.add(editTextAuditores95);
        editTextsMas.add(editTextTeacher95);

        editTextsMas.add(editTextLesson96);
        editTextsMas.add(editTextAuditores96);
        editTextsMas.add(editTextTeacher96);

        editTextsMas.add(editTextLesson101);
        editTextsMas.add(editTextAuditores101);
        editTextsMas.add(editTextTeacher101);

        editTextsMas.add(editTextLesson102);
        editTextsMas.add(editTextAuditores102);
        editTextsMas.add(editTextTeacher102);

        editTextsMas.add(editTextLesson103);
        editTextsMas.add(editTextAuditores103);
        editTextsMas.add(editTextTeacher103);

        editTextsMas.add(editTextLesson104);
        editTextsMas.add(editTextAuditores104);
        editTextsMas.add(editTextTeacher104);

        editTextsMas.add(editTextLesson105);
        editTextsMas.add(editTextAuditores105);
        editTextsMas.add(editTextTeacher105);

        editTextsMas.add(editTextLesson106);
        editTextsMas.add(editTextAuditores106);
        editTextsMas.add(editTextTeacher106);

        editTextsMas.add(editTextLesson111);
        editTextsMas.add(editTextAuditores111);
        editTextsMas.add(editTextTeacher111);

        editTextsMas.add(editTextLesson112);
        editTextsMas.add(editTextAuditores112);
        editTextsMas.add(editTextTeacher112);

        editTextsMas.add(editTextLesson113);
        editTextsMas.add(editTextAuditores113);
        editTextsMas.add(editTextTeacher113);

        editTextsMas.add(editTextLesson114);
        editTextsMas.add(editTextAuditores114);
        editTextsMas.add(editTextTeacher114);

        editTextsMas.add(editTextLesson115);
        editTextsMas.add(editTextAuditores115);
        editTextsMas.add(editTextTeacher115);

        editTextsMas.add(editTextLesson116);
        editTextsMas.add(editTextAuditores116);
        editTextsMas.add(editTextTeacher116);

        editTextsMas.add(editTextLesson121);
        editTextsMas.add(editTextAuditores121);
        editTextsMas.add(editTextTeacher121);

        editTextsMas.add(editTextLesson122);
        editTextsMas.add(editTextAuditores122);
        editTextsMas.add(editTextTeacher122);

        editTextsMas.add(editTextLesson123);
        editTextsMas.add(editTextAuditores123);
        editTextsMas.add(editTextTeacher123);

        editTextsMas.add(editTextLesson124);
        editTextsMas.add(editTextAuditores124);
        editTextsMas.add(editTextTeacher124);

        editTextsMas.add(editTextLesson125);
        editTextsMas.add(editTextAuditores125);
        editTextsMas.add(editTextTeacher125);

        editTextsMas.add(editTextLesson126);
        editTextsMas.add(editTextAuditores126);
        editTextsMas.add(editTextTeacher126);

        editTextsMas.add(editTextLesson131);
        editTextsMas.add(editTextAuditores131);
        editTextsMas.add(editTextTeacher131);

        editTextsMas.add(editTextLesson132);
        editTextsMas.add(editTextAuditores132);
        editTextsMas.add(editTextTeacher132);

        editTextsMas.add(editTextLesson133);
        editTextsMas.add(editTextAuditores133);
        editTextsMas.add(editTextTeacher133);

        editTextsMas.add(editTextLesson134);
        editTextsMas.add(editTextAuditores134);
        editTextsMas.add(editTextTeacher134);

        editTextsMas.add(editTextLesson135);
        editTextsMas.add(editTextAuditores135);
        editTextsMas.add(editTextTeacher135);

        editTextsMas.add(editTextLesson136);
        editTextsMas.add(editTextAuditores136);
        editTextsMas.add(editTextTeacher136);
    }
    private void startCycle(){
        for(int i=0; i<editTextsMas.size();i++){
            editTextsMas.get(i).addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(flag){
                        makeChangesBtn.setBackgroundDrawable(
                                getDrawable(R.drawable.form_for_enter_blue));
                        makeChangesBtn.setText("Внести изменения");
                        flag = false;
                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {
                }
            });
        }
    }
    //Intent назад
    private void backStep() {
        Intent intentBack;
        intentBack = new Intent(EditSchduleActivity.this,
                AboutMe.class);
        startActivity(intentBack);
        finish();
        overridePendingTransition(R.anim.diagonaltranslateleft, R.anim.alpha_one_zero);
    }

    private void calendar() {
        //ПОЛУЧАЕМ ДАТУ
        calendar = Calendar.getInstance();
        maxDayOfMonth = Calendar.getInstance();
        maxDayOfMonth.add(Calendar.MONTH, -1);
        max =
//                31
                maxDayOfMonth.getActualMaximum(Calendar.DAY_OF_MONTH)
        ;
        Log.d("MAXIMUMo", "max = " + max);
        dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        dayOfMonthMax = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        weeekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH);
        toDay = calendar.get(Calendar.DAY_OF_WEEK);
        max = calendar.get(Calendar.MONTH);
        weekOfYearMax = calendar.get(Calendar.WEEK_OF_YEAR);
        weekOfYear = calendar.get(Calendar.YEAR);
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
    //ПОЛУЧАЕМ И ПОКАЗЫВАЕМ СЕГОДНЯШНИЙ ДЕНЬ
    private void choosedDay() {
        linInvisible();

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
    //Выходим из аккаунта
    private void signOut() {
        //Declaration and defination
        FirebaseAuth firebaseAuth;
        FirebaseAuth.AuthStateListener authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() == null){
                    //Do anything here which needs to be done after signout is complete
                    signOutComplete();
                }
            }
        };

//Init and attach
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.addAuthStateListener(authStateListener);

//Call signOut()
        firebaseAuth.signOut();
    }

    //УСТОНАВЛИВАЕМ ДАННЫЕ О ПОЛЬЗОВАТЕЛЕ ПОЛУЧЕННЫЕ С AboutMe
    @SuppressLint("SetTextI18n")
    private void setData() {
        sharedPreferences = getSharedPreferences("userdata", Context.MODE_PRIVATE);

        elementCource = sharedPreferences.getString("setElementSpinnerCource", "");
        Log.d("test1","elementCource = " + elementCource);
        elementSubGroup = sharedPreferences.getString("elementSpinnerSubgroupCource", "");
        elementDirection = sharedPreferences.getString("elementSpinnerDirection", "");
        elementFacultet = sharedPreferences.getString("setElementSpinnerFacultet", "");

        course = findViewById(R.id.course);
        sobgroup = findViewById(R.id.sobgroup);

        course.setText(elementCource + " курс, ");
        sobgroup.setText(elementSubGroup + " группа");
    }

    //Intent для выхода из аккаунта
    private void signOutComplete() {
        Intent intentBack = new Intent(EditSchduleActivity.this,
                LoginEditSchduleActivity.class);
        startActivity(intentBack);
        finish();
        overridePendingTransition(R.anim.alpha_zero_one, R.anim.alpha_one_zero);
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
    //Инициализация компонентов
    private void init() {
        makeChangesBtn = findViewById(R.id.makeChangesBtn);
        groupsButton1 = findViewById(R.id.groupButtons1);
        groupsButton2 = findViewById(R.id.groupButtons2);
        outUserTV = findViewById(R.id.outUserTV);
        //СВЯЗЫВАЕМ ВСЕ EditText'ы и ScrollView
        findViewEditText();
        scrollView = findViewById(R.id.scrollView);
        //форма когда в субботу нету пар
        form_lessons_sunday = findViewById(R.id.form_lessons_sunday);
        form_lessons_sunday.setVisibility(View.INVISIBLE);
        form_lessons_sunday_text = findViewById(R.id.form_lessons_sunday_text);

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
        //кнопки недель
        buttonWeekOne = findViewById(R.id.buttonWeekOne);
        buttonWeekTwo = findViewById(R.id.buttonWeekTwo);
        //кнопки дней
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        backStep();
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

    //ПОЛУЧАЕМ ДАННЫЕ ИЗ ВСЕХ EditText'ов
    private void getText() {
        //1 ДЕНЬ
        String lesson11 = editTextLesson11.getText().toString();
        String lesson12 = editTextLesson12.getText().toString();
        String lesson13 = editTextLesson13.getText().toString();
        String lesson14 = editTextLesson14.getText().toString();
        String lesson15 = editTextLesson15.getText().toString();
        String lesson16 = editTextLesson16.getText().toString();

        String auditores11 = editTextAuditores11.getText().toString();
        String auditores12 = editTextAuditores12.getText().toString();
        String auditores13 = editTextAuditores13.getText().toString();
        String auditores14 = editTextAuditores14.getText().toString();
        String auditores15 = editTextAuditores15.getText().toString();
        String auditores16 = editTextAuditores16.getText().toString();

        String teacher11 = editTextTeacher11.getText().toString();
        String teacher12 = editTextTeacher12.getText().toString();
        String teacher13 = editTextTeacher13.getText().toString();
        String teacher14 = editTextTeacher14.getText().toString();
        String teacher15 = editTextTeacher15.getText().toString();
        String teacher16 = editTextTeacher16.getText().toString();
        //2 ДЕНЬ
        String lesson21 = editTextLesson21.getText().toString();
        String lesson22 = editTextLesson22.getText().toString();
        String lesson23 = editTextLesson23.getText().toString();
        String lesson24 = editTextLesson24.getText().toString();
        String lesson25 = editTextLesson25.getText().toString();
        String lesson26 = editTextLesson26.getText().toString();
        Log.d("YYY","auditores22 = " +
                editTextAuditoresDB22);

        String auditores21 = editTextAuditores21.getText().toString();
        String auditores22 = editTextAuditores22.getText().toString();
        String auditores23 = editTextAuditores23.getText().toString();
        String auditores24 = editTextAuditores24.getText().toString();
        String auditores25 = editTextAuditores25.getText().toString();
        String auditores26 = editTextAuditores26.getText().toString();

        String teacher21 = editTextTeacher21.getText().toString();
        String teacher22 = editTextTeacher22.getText().toString();
        String teacher23 = editTextTeacher23.getText().toString();
        String teacher24 = editTextTeacher24.getText().toString();
        String teacher25 = editTextTeacher25.getText().toString();
        String teacher26 = editTextTeacher26.getText().toString();
        //3 ДЕНЬ
        String lesson31 = editTextLesson31.getText().toString();
        String lesson32 = editTextLesson32.getText().toString();
        String lesson33 = editTextLesson33.getText().toString();
        String lesson34 = editTextLesson34.getText().toString();
        String lesson35 = editTextLesson35.getText().toString();
        String lesson36 = editTextLesson36.getText().toString();

        String auditores31 = editTextAuditores31.getText().toString();
        String auditores32 = editTextAuditores32.getText().toString();
        String auditores33 = editTextAuditores33.getText().toString();
        String auditores34 = editTextAuditores34.getText().toString();
        String auditores35 = editTextAuditores35.getText().toString();
        String auditores36 = editTextAuditores36.getText().toString();

        String teacher31 = editTextTeacher31.getText().toString();
        String teacher32 = editTextTeacher32.getText().toString();
        String teacher33 = editTextTeacher33.getText().toString();
        String teacher34 = editTextTeacher34.getText().toString();
        String teacher35 = editTextTeacher35.getText().toString();
        String teacher36 = editTextTeacher36.getText().toString();
        //4 ДЕНЬ
        String lesson41 = editTextLesson41.getText().toString();
        String lesson42 = editTextLesson42.getText().toString();
        String lesson43 = editTextLesson43.getText().toString();
        String lesson44 = editTextLesson44.getText().toString();
        String lesson45 = editTextLesson45.getText().toString();
        String lesson46 = editTextLesson46.getText().toString();

        String auditores41 = editTextAuditores41.getText().toString();
        String auditores42 = editTextAuditores42.getText().toString();
        String auditores43 = editTextAuditores43.getText().toString();
        String auditores44 = editTextAuditores44.getText().toString();
        String auditores45 = editTextAuditores45.getText().toString();
        String auditores46 = editTextAuditores46.getText().toString();

        String teacher41 = editTextTeacher41.getText().toString();
        String teacher42 = editTextTeacher42.getText().toString();
        String teacher43 = editTextTeacher43.getText().toString();
        String teacher44 = editTextTeacher44.getText().toString();
        String teacher45 = editTextTeacher45.getText().toString();
        String teacher46 = editTextTeacher46.getText().toString();
        //5 ДЕНЬ
        String lesson51 = editTextLesson51.getText().toString();
        String lesson52 = editTextLesson52.getText().toString();
        String lesson53 = editTextLesson53.getText().toString();
        String lesson54 = editTextLesson54.getText().toString();
        String lesson55 = editTextLesson55.getText().toString();
        String lesson56 = editTextLesson56.getText().toString();

        String auditores51 = editTextAuditores51.getText().toString();
        String auditores52 = editTextAuditores52.getText().toString();
        String auditores53 = editTextAuditores53.getText().toString();
        String auditores54 = editTextAuditores54.getText().toString();
        String auditores55 = editTextAuditores55.getText().toString();
        String auditores56 = editTextAuditores56.getText().toString();

        String teacher51 = editTextTeacher51.getText().toString();
        String teacher52 = editTextTeacher52.getText().toString();
        String teacher53 = editTextTeacher53.getText().toString();
        String teacher54 = editTextTeacher54.getText().toString();
        String teacher55 = editTextTeacher55.getText().toString();
        String teacher56 = editTextTeacher56.getText().toString();
        //6 ДЕНЬ
        String lesson61 = editTextLesson61.getText().toString();
        String lesson62 = editTextLesson62.getText().toString();
        String lesson63 = editTextLesson63.getText().toString();
        String lesson64 = editTextLesson64.getText().toString();
        String lesson65 = editTextLesson65.getText().toString();
        String lesson66 = editTextLesson66.getText().toString();

        String auditores61 = editTextAuditores61.getText().toString();
        String auditores62 = editTextAuditores62.getText().toString();
        String auditores63 = editTextAuditores63.getText().toString();
        String auditores64 = editTextAuditores64.getText().toString();
        String auditores65 = editTextAuditores65.getText().toString();
        String auditores66 = editTextAuditores66.getText().toString();

        String teacher61 = editTextTeacher61.getText().toString();
        String teacher62 = editTextTeacher62.getText().toString();
        String teacher63 = editTextTeacher63.getText().toString();
        String teacher64 = editTextTeacher64.getText().toString();
        String teacher65 = editTextTeacher65.getText().toString();
        String teacher66 = editTextTeacher66.getText().toString();
        //8 ДЕНЬ
        String lesson81 = editTextLesson81.getText().toString();
        String lesson82 = editTextLesson82.getText().toString();
        String lesson83 = editTextLesson83.getText().toString();
        String lesson84 = editTextLesson84.getText().toString();
        String lesson85 = editTextLesson85.getText().toString();
        String lesson86 = editTextLesson86.getText().toString();

        String auditores81 = editTextAuditores81.getText().toString();
        String auditores82 = editTextAuditores82.getText().toString();
        String auditores83 = editTextAuditores83.getText().toString();
        String auditores84 = editTextAuditores84.getText().toString();
        String auditores85 = editTextAuditores85.getText().toString();
        String auditores86 = editTextAuditores86.getText().toString();

        String teacher81 = editTextTeacher81.getText().toString();
        String teacher82 = editTextTeacher82.getText().toString();
        String teacher83 = editTextTeacher83.getText().toString();
        String teacher84 = editTextTeacher84.getText().toString();
        String teacher85 = editTextTeacher85.getText().toString();
        String teacher86 = editTextTeacher86.getText().toString();
        //9 ДЕНЬ
        String lesson91 = editTextLesson91.getText().toString();
        String lesson92 = editTextLesson92.getText().toString();
        String lesson93 = editTextLesson93.getText().toString();
        String lesson94 = editTextLesson94.getText().toString();
        String lesson95 = editTextLesson95.getText().toString();
        String lesson96 = editTextLesson96.getText().toString();

        String auditores91 = editTextAuditores91.getText().toString();
        String auditores92 = editTextAuditores92.getText().toString();
        String auditores93 = editTextAuditores93.getText().toString();
        String auditores94 = editTextAuditores94.getText().toString();
        String auditores95 = editTextAuditores95.getText().toString();
        String auditores96 = editTextAuditores96.getText().toString();

        String teacher91 = editTextTeacher91.getText().toString();
        String teacher92 = editTextTeacher92.getText().toString();
        String teacher93 = editTextTeacher93.getText().toString();
        String teacher94 = editTextTeacher94.getText().toString();
        String teacher95 = editTextTeacher95.getText().toString();
        String teacher96 = editTextTeacher96.getText().toString();
        //10 ДЕНЬ
        String lesson101 = editTextLesson101.getText().toString();
        String lesson102 = editTextLesson102.getText().toString();
        String lesson103 = editTextLesson103.getText().toString();
        String lesson104 = editTextLesson104.getText().toString();
        String lesson105 = editTextLesson105.getText().toString();
        String lesson106 = editTextLesson106.getText().toString();

        String auditores101 = editTextAuditores101.getText().toString();
        String auditores102 = editTextAuditores102.getText().toString();
        String auditores103 = editTextAuditores103.getText().toString();
        String auditores104 = editTextAuditores104.getText().toString();
        String auditores105 = editTextAuditores105.getText().toString();
        String auditores106 = editTextAuditores106.getText().toString();

        String teacher101 = editTextTeacher101.getText().toString();
        String teacher102 = editTextTeacher102.getText().toString();
        String teacher103 = editTextTeacher103.getText().toString();
        String teacher104 = editTextTeacher104.getText().toString();
        String teacher105 = editTextTeacher105.getText().toString();
        String teacher106 = editTextTeacher106.getText().toString();
        //11 ДЕНЬ
        String lesson111 = editTextLesson111.getText().toString();
        String lesson112 = editTextLesson112.getText().toString();
        String lesson113 = editTextLesson113.getText().toString();
        String lesson114 = editTextLesson114.getText().toString();
        String lesson115 = editTextLesson115.getText().toString();
        String lesson116 = editTextLesson116.getText().toString();

        String auditores111 = editTextAuditores111.getText().toString();
        String auditores112 = editTextAuditores112.getText().toString();
        String auditores113 = editTextAuditores113.getText().toString();
        String auditores114 = editTextAuditores114.getText().toString();
        String auditores115 = editTextAuditores115.getText().toString();
        String auditores116 = editTextAuditores116.getText().toString();

        String teacher111 = editTextTeacher111.getText().toString();
        String teacher112 = editTextTeacher112.getText().toString();
        String teacher113 = editTextTeacher113.getText().toString();
        String teacher114 = editTextTeacher114.getText().toString();
        String teacher115 = editTextTeacher115.getText().toString();
        String teacher116 = editTextTeacher116.getText().toString();
        //12 ДЕНЬ
        String lesson121 = editTextLesson121.getText().toString();
        String lesson122 = editTextLesson122.getText().toString();
        String lesson123 = editTextLesson123.getText().toString();
        String lesson124 = editTextLesson124.getText().toString();
        String lesson125 = editTextLesson125.getText().toString();
        String lesson126 = editTextLesson126.getText().toString();

        String auditores121 = editTextAuditores121.getText().toString();
        String auditores122 = editTextAuditores122.getText().toString();
        String auditores123 = editTextAuditores123.getText().toString();
        String auditores124 = editTextAuditores124.getText().toString();
        String auditores125 = editTextAuditores125.getText().toString();
        String auditores126 = editTextAuditores126.getText().toString();

        String teacher121 = editTextTeacher121.getText().toString();
        String teacher122 = editTextTeacher122.getText().toString();
        String teacher123 = editTextTeacher123.getText().toString();
        String teacher124 = editTextTeacher124.getText().toString();
        String teacher125 = editTextTeacher125.getText().toString();
        String teacher126 = editTextTeacher126.getText().toString();
        //13 ДЕНЬ
        String lesson131 = editTextLesson131.getText().toString();
        String lesson132 = editTextLesson132.getText().toString();
        String lesson133 = editTextLesson133.getText().toString();
        String lesson134 = editTextLesson134.getText().toString();
        String lesson135 = editTextLesson135.getText().toString();
        String lesson136 = editTextLesson136.getText().toString();

        String auditores131 = editTextAuditores131.getText().toString();
        String auditores132 = editTextAuditores132.getText().toString();
        String auditores133 = editTextAuditores133.getText().toString();
        String auditores134 = editTextAuditores134.getText().toString();
        String auditores135 = editTextAuditores135.getText().toString();
        String auditores136 = editTextAuditores136.getText().toString();

        String teacher131 = editTextTeacher131.getText().toString();
        String teacher132 = editTextTeacher132.getText().toString();
        String teacher133 = editTextTeacher133.getText().toString();
        String teacher134 = editTextTeacher134.getText().toString();
        String teacher135 = editTextTeacher135.getText().toString();
        String teacher136 = editTextTeacher136.getText().toString();
        //1 ДЕНЬ
        editTextLessonDB11 = (!TextUtils.isEmpty(lesson11))? lesson11:null;
        editTextLessonDB12 = (!TextUtils.isEmpty(lesson12))? lesson12:null;
        editTextLessonDB13 = (!TextUtils.isEmpty(lesson13))? lesson13:null;
        editTextLessonDB14 = (!TextUtils.isEmpty(lesson14))? lesson14:null;
        editTextLessonDB15 = (!TextUtils.isEmpty(lesson15))? lesson15:null;
        editTextLessonDB16 = (!TextUtils.isEmpty(lesson16))? lesson16:null;

        editTextAuditoresDB11 = (!TextUtils.isEmpty(auditores11))? lesson11:null;
        editTextAuditoresDB12 = (!TextUtils.isEmpty(auditores12))? lesson12:null;
        editTextAuditoresDB13 = (!TextUtils.isEmpty(auditores13))? lesson13:null;
        editTextAuditoresDB14 = (!TextUtils.isEmpty(auditores14))? lesson14:null;
        editTextAuditoresDB15 = (!TextUtils.isEmpty(auditores15))? lesson15:null;
        editTextAuditoresDB16 = (!TextUtils.isEmpty(auditores16))? lesson16:null;

        editTextTeacherDB11 = (!TextUtils.isEmpty(teacher11))? lesson11:null;
        editTextTeacherDB12 = (!TextUtils.isEmpty(teacher12))? lesson12:null;
        editTextTeacherDB13 = (!TextUtils.isEmpty(teacher13))? lesson13:null;
        editTextTeacherDB14 = (!TextUtils.isEmpty(teacher14))? lesson14:null;
        editTextTeacherDB15 = (!TextUtils.isEmpty(teacher15))? lesson15:null;
        editTextTeacherDB16 = (!TextUtils.isEmpty(teacher16))? lesson16:null;
        //2 ДЕНЬ
        editTextLessonDB21 = (!TextUtils.isEmpty(lesson21))? lesson21:null;
        editTextLessonDB22 = (!TextUtils.isEmpty(lesson22))? lesson22:null;
        editTextLessonDB23 = (!TextUtils.isEmpty(lesson23))? lesson23:null;
        editTextLessonDB24 = (!TextUtils.isEmpty(lesson24))? lesson24:null;
        editTextLessonDB25 = (!TextUtils.isEmpty(lesson25))? lesson25:null;
        editTextLessonDB26 = (!TextUtils.isEmpty(lesson26))? lesson26:null;

        editTextAuditoresDB21 = (!TextUtils.isEmpty(auditores21))? auditores21:null;
        editTextAuditoresDB22 = (!TextUtils.isEmpty(auditores22))? auditores22:null;
        editTextAuditoresDB23 = (!TextUtils.isEmpty(auditores23))? auditores23:null;
        editTextAuditoresDB24 = (!TextUtils.isEmpty(auditores24))? auditores24:null;
        editTextAuditoresDB25 = (!TextUtils.isEmpty(auditores25))? auditores25:null;
        editTextAuditoresDB26 = (!TextUtils.isEmpty(auditores26))? auditores26:null;

        editTextTeacherDB21 = (!TextUtils.isEmpty(teacher21))? teacher21:null;
        editTextTeacherDB22 = (!TextUtils.isEmpty(teacher22))? teacher22:null;
        editTextTeacherDB23 = (!TextUtils.isEmpty(teacher23))? teacher23:null;
        editTextTeacherDB24 = (!TextUtils.isEmpty(teacher24))? teacher24:null;
        editTextTeacherDB25 = (!TextUtils.isEmpty(teacher25))? teacher25:null;
        editTextTeacherDB26 = (!TextUtils.isEmpty(teacher26))? teacher26:null;
        //3 ДЕНЬ
        editTextLessonDB31 = (!TextUtils.isEmpty(lesson31))? lesson31:null;
        editTextLessonDB32 = (!TextUtils.isEmpty(lesson32))? lesson32:null;
        editTextLessonDB33 = (!TextUtils.isEmpty(lesson33))? lesson33:null;
        editTextLessonDB34 = (!TextUtils.isEmpty(lesson34))? lesson34:null;
        editTextLessonDB35 = (!TextUtils.isEmpty(lesson35))? lesson35:null;
        editTextLessonDB36 = (!TextUtils.isEmpty(lesson36))? lesson36:null;

        editTextAuditoresDB31 = (!TextUtils.isEmpty(auditores31))? auditores31:null;
        editTextAuditoresDB32 = (!TextUtils.isEmpty(auditores32))? auditores32:null;
        editTextAuditoresDB33 = (!TextUtils.isEmpty(auditores33))? auditores33:null;
        editTextAuditoresDB34 = (!TextUtils.isEmpty(auditores34))? auditores34:null;
        editTextAuditoresDB35 = (!TextUtils.isEmpty(auditores35))? auditores35:null;
        editTextAuditoresDB36 = (!TextUtils.isEmpty(auditores36))? auditores36:null;

        editTextTeacherDB31 = (!TextUtils.isEmpty(teacher31))? teacher31:null;
        editTextTeacherDB32 = (!TextUtils.isEmpty(teacher32))? teacher32:null;
        editTextTeacherDB33 = (!TextUtils.isEmpty(teacher33))? teacher33:null;
        editTextTeacherDB34 = (!TextUtils.isEmpty(teacher34))? teacher34:null;
        editTextTeacherDB35 = (!TextUtils.isEmpty(teacher35))? teacher35:null;
        editTextTeacherDB36 = (!TextUtils.isEmpty(teacher36))? teacher36:null;
        //4 ДЕНЬ
        editTextLessonDB41 = (!TextUtils.isEmpty(lesson41))? lesson41:null;
        editTextLessonDB42 = (!TextUtils.isEmpty(lesson42))? lesson42:null;
        editTextLessonDB43 = (!TextUtils.isEmpty(lesson43))? lesson43:null;
        editTextLessonDB44 = (!TextUtils.isEmpty(lesson44))? lesson44:null;
        editTextLessonDB45 = (!TextUtils.isEmpty(lesson45))? lesson45:null;
        editTextLessonDB46 = (!TextUtils.isEmpty(lesson46))? lesson46:null;

        editTextAuditoresDB41 = (!TextUtils.isEmpty(auditores41))? auditores41:null;
        editTextAuditoresDB42 = (!TextUtils.isEmpty(auditores42))? auditores42:null;
        editTextAuditoresDB43 = (!TextUtils.isEmpty(auditores43))? auditores43:null;
        editTextAuditoresDB44 = (!TextUtils.isEmpty(auditores44))? auditores44:null;
        editTextAuditoresDB45 = (!TextUtils.isEmpty(auditores45))? auditores45:null;
        editTextAuditoresDB46 = (!TextUtils.isEmpty(auditores46))? auditores46:null;

        editTextTeacherDB41 = (!TextUtils.isEmpty(teacher41))? teacher41:null;
        editTextTeacherDB42 = (!TextUtils.isEmpty(teacher42))? teacher42:null;
        editTextTeacherDB43 = (!TextUtils.isEmpty(teacher43))? teacher43:null;
        editTextTeacherDB44 = (!TextUtils.isEmpty(teacher44))? teacher44:null;
        editTextTeacherDB45 = (!TextUtils.isEmpty(teacher45))? teacher45:null;
        editTextTeacherDB46 = (!TextUtils.isEmpty(teacher46))? teacher46:null;
        //5 ДЕНЬ
        editTextLessonDB51 = (!TextUtils.isEmpty(lesson51))? lesson51:null;
        editTextLessonDB52 = (!TextUtils.isEmpty(lesson52))? lesson52:null;
        editTextLessonDB53 = (!TextUtils.isEmpty(lesson53))? lesson53:null;
        editTextLessonDB54 = (!TextUtils.isEmpty(lesson54))? lesson54:null;
        editTextLessonDB55 = (!TextUtils.isEmpty(lesson55))? lesson55:null;
        editTextLessonDB56 = (!TextUtils.isEmpty(lesson56))? lesson56:null;

        editTextAuditoresDB51 = (!TextUtils.isEmpty(auditores51))? auditores51:null;
        editTextAuditoresDB52 = (!TextUtils.isEmpty(auditores52))? auditores52:null;
        editTextAuditoresDB53 = (!TextUtils.isEmpty(auditores53))? auditores53:null;
        editTextAuditoresDB54 = (!TextUtils.isEmpty(auditores54))? auditores54:null;
        editTextAuditoresDB55 = (!TextUtils.isEmpty(auditores55))? auditores55:null;
        editTextAuditoresDB56 = (!TextUtils.isEmpty(auditores56))? auditores56:null;

        editTextTeacherDB51 = (!TextUtils.isEmpty(teacher51))? teacher51:null;
        editTextTeacherDB52 = (!TextUtils.isEmpty(teacher52))? teacher52:null;
        editTextTeacherDB53 = (!TextUtils.isEmpty(teacher53))? teacher53:null;
        editTextTeacherDB54 = (!TextUtils.isEmpty(teacher54))? teacher54:null;
        editTextTeacherDB55 = (!TextUtils.isEmpty(teacher55))? teacher55:null;
        editTextTeacherDB56 = (!TextUtils.isEmpty(teacher56))? teacher56:null;
        //6 ДЕНЬ
        editTextLessonDB61 = (!TextUtils.isEmpty(lesson61))? lesson61:null;
        editTextLessonDB62 = (!TextUtils.isEmpty(lesson62))? lesson62:null;
        editTextLessonDB63 = (!TextUtils.isEmpty(lesson63))? lesson63:null;
        editTextLessonDB64 = (!TextUtils.isEmpty(lesson64))? lesson64:null;
        editTextLessonDB65 = (!TextUtils.isEmpty(lesson65))? lesson65:null;
        editTextLessonDB66 = (!TextUtils.isEmpty(lesson66))? lesson66:null;

        editTextAuditoresDB61 = (!TextUtils.isEmpty(auditores61))? auditores61:null;
        editTextAuditoresDB62 = (!TextUtils.isEmpty(auditores62))? auditores62:null;
        editTextAuditoresDB63 = (!TextUtils.isEmpty(auditores63))? auditores63:null;
        editTextAuditoresDB64 = (!TextUtils.isEmpty(auditores64))? auditores64:null;
        editTextAuditoresDB65 = (!TextUtils.isEmpty(auditores65))? auditores65:null;
        editTextAuditoresDB66 = (!TextUtils.isEmpty(auditores66))? auditores66:null;

        editTextTeacherDB61 = (!TextUtils.isEmpty(teacher61))? teacher61:null;
        editTextTeacherDB62 = (!TextUtils.isEmpty(teacher62))? teacher62:null;
        editTextTeacherDB63 = (!TextUtils.isEmpty(teacher63))? teacher63:null;
        editTextTeacherDB64 = (!TextUtils.isEmpty(teacher64))? teacher64:null;
        editTextTeacherDB65 = (!TextUtils.isEmpty(teacher65))? teacher65:null;
        editTextTeacherDB66 = (!TextUtils.isEmpty(teacher66))? teacher66:null;
        //8 ДЕНЬ
        editTextLessonDB81 = (!TextUtils.isEmpty(lesson81))? lesson81:null;
        editTextLessonDB82 = (!TextUtils.isEmpty(lesson82))? lesson82:null;
        editTextLessonDB83 = (!TextUtils.isEmpty(lesson83))? lesson83:null;
        editTextLessonDB84 = (!TextUtils.isEmpty(lesson84))? lesson84:null;
        editTextLessonDB85 = (!TextUtils.isEmpty(lesson85))? lesson85:null;
        editTextLessonDB86 = (!TextUtils.isEmpty(lesson86))? lesson86:null;

        editTextAuditoresDB81 = (!TextUtils.isEmpty(auditores81))? auditores81:null;
        editTextAuditoresDB82 = (!TextUtils.isEmpty(auditores82))? auditores82:null;
        editTextAuditoresDB83 = (!TextUtils.isEmpty(auditores83))? auditores83:null;
        editTextAuditoresDB84 = (!TextUtils.isEmpty(auditores84))? auditores84:null;
        editTextAuditoresDB85 = (!TextUtils.isEmpty(auditores85))? auditores85:null;
        editTextAuditoresDB86 = (!TextUtils.isEmpty(auditores86))? auditores86:null;

        editTextTeacherDB81 = (!TextUtils.isEmpty(teacher81))? teacher81:null;
        editTextTeacherDB82 = (!TextUtils.isEmpty(teacher82))? teacher82:null;
        editTextTeacherDB83 = (!TextUtils.isEmpty(teacher83))? teacher83:null;
        editTextTeacherDB84 = (!TextUtils.isEmpty(teacher84))? teacher84:null;
        editTextTeacherDB85 = (!TextUtils.isEmpty(teacher85))? teacher85:null;
        editTextTeacherDB86 = (!TextUtils.isEmpty(teacher86))? teacher86:null;
        //9 ДЕНЬ
        editTextLessonDB91 = (!TextUtils.isEmpty(lesson91))? lesson91:null;
        editTextLessonDB92 = (!TextUtils.isEmpty(lesson92))? lesson92:null;
        editTextLessonDB93 = (!TextUtils.isEmpty(lesson93))? lesson93:null;
        editTextLessonDB94 = (!TextUtils.isEmpty(lesson94))? lesson94:null;
        editTextLessonDB95 = (!TextUtils.isEmpty(lesson95))? lesson95:null;
        editTextLessonDB96 = (!TextUtils.isEmpty(lesson96))? lesson96:null;

        editTextAuditoresDB91 = (!TextUtils.isEmpty(auditores91))? auditores91:null;
        editTextAuditoresDB92 = (!TextUtils.isEmpty(auditores92))? auditores92:null;
        editTextAuditoresDB93 = (!TextUtils.isEmpty(auditores93))? auditores93:null;
        editTextAuditoresDB94 = (!TextUtils.isEmpty(auditores94))? auditores94:null;
        editTextAuditoresDB95 = (!TextUtils.isEmpty(auditores95))? auditores95:null;
        editTextAuditoresDB96 = (!TextUtils.isEmpty(auditores96))? auditores96:null;

        editTextTeacherDB91 = (!TextUtils.isEmpty(teacher91))? teacher91:null;
        editTextTeacherDB92 = (!TextUtils.isEmpty(teacher92))? teacher92:null;
        editTextTeacherDB93 = (!TextUtils.isEmpty(teacher93))? teacher93:null;
        editTextTeacherDB94 = (!TextUtils.isEmpty(teacher94))? teacher94:null;
        editTextTeacherDB95 = (!TextUtils.isEmpty(teacher95))? teacher95:null;
        editTextTeacherDB96 = (!TextUtils.isEmpty(teacher96))? teacher96:null;
        //10 ДЕНЬ
        editTextLessonDB101 = (!TextUtils.isEmpty(lesson101))? lesson101:null;
        editTextLessonDB102 = (!TextUtils.isEmpty(lesson102))? lesson102:null;
        editTextLessonDB103 = (!TextUtils.isEmpty(lesson103))? lesson103:null;
        editTextLessonDB104 = (!TextUtils.isEmpty(lesson104))? lesson104:null;
        editTextLessonDB105 = (!TextUtils.isEmpty(lesson105))? lesson105:null;
        editTextLessonDB106 = (!TextUtils.isEmpty(lesson106))? lesson106:null;

        editTextAuditoresDB101 = (!TextUtils.isEmpty(auditores101))? auditores101:null;
        editTextAuditoresDB102 = (!TextUtils.isEmpty(auditores102))? auditores102:null;
        editTextAuditoresDB103 = (!TextUtils.isEmpty(auditores103))? auditores103:null;
        editTextAuditoresDB104 = (!TextUtils.isEmpty(auditores104))? auditores104:null;
        editTextAuditoresDB105 = (!TextUtils.isEmpty(auditores105))? auditores105:null;
        editTextAuditoresDB106 = (!TextUtils.isEmpty(auditores106))? auditores106:null;

        editTextTeacherDB101 = (!TextUtils.isEmpty(teacher101))? teacher101:null;
        editTextTeacherDB102 = (!TextUtils.isEmpty(teacher102))? teacher102:null;
        editTextTeacherDB103 = (!TextUtils.isEmpty(teacher103))? teacher103:null;
        editTextTeacherDB104 = (!TextUtils.isEmpty(teacher104))? teacher104:null;
        editTextTeacherDB105 = (!TextUtils.isEmpty(teacher105))? teacher105:null;
        editTextTeacherDB106 = (!TextUtils.isEmpty(teacher106))? teacher106:null;
        //11 ДЕНЬ
        editTextLessonDB111 = (!TextUtils.isEmpty(lesson111))? lesson111:null;
        editTextLessonDB112 = (!TextUtils.isEmpty(lesson112))? lesson112:null;
        editTextLessonDB113 = (!TextUtils.isEmpty(lesson113))? lesson113:null;
        editTextLessonDB114 = (!TextUtils.isEmpty(lesson114))? lesson114:null;
        editTextLessonDB115 = (!TextUtils.isEmpty(lesson115))? lesson115:null;
        editTextLessonDB116 = (!TextUtils.isEmpty(lesson116))? lesson116:null;

        editTextAuditoresDB111 = (!TextUtils.isEmpty(auditores111))? auditores111:null;
        editTextAuditoresDB112 = (!TextUtils.isEmpty(auditores112))? auditores112:null;
        editTextAuditoresDB113 = (!TextUtils.isEmpty(auditores113))? auditores113:null;
        editTextAuditoresDB114 = (!TextUtils.isEmpty(auditores114))? auditores114:null;
        editTextAuditoresDB115 = (!TextUtils.isEmpty(auditores115))? auditores115:null;
        editTextAuditoresDB116 = (!TextUtils.isEmpty(auditores116))? auditores116:null;

        editTextTeacherDB111 = (!TextUtils.isEmpty(teacher111))? teacher111:null;
        editTextTeacherDB112 = (!TextUtils.isEmpty(teacher112))? teacher112:null;
        editTextTeacherDB113 = (!TextUtils.isEmpty(teacher113))? teacher113:null;
        editTextTeacherDB114 = (!TextUtils.isEmpty(teacher114))? teacher114:null;
        editTextTeacherDB115 = (!TextUtils.isEmpty(teacher115))? teacher115:null;
        editTextTeacherDB116 = (!TextUtils.isEmpty(teacher116))? teacher116:null;
        //12 ДЕНЬ
        editTextLessonDB121 = (!TextUtils.isEmpty(lesson121))? lesson121:null;
        editTextLessonDB122 = (!TextUtils.isEmpty(lesson122))? lesson122:null;
        editTextLessonDB123 = (!TextUtils.isEmpty(lesson123))? lesson123:null;
        editTextLessonDB124 = (!TextUtils.isEmpty(lesson124))? lesson124:null;
        editTextLessonDB125 = (!TextUtils.isEmpty(lesson125))? lesson125:null;
        editTextLessonDB126 = (!TextUtils.isEmpty(lesson126))? lesson126:null;

        editTextAuditoresDB121 = (!TextUtils.isEmpty(auditores121))? auditores121:null;
        editTextAuditoresDB122 = (!TextUtils.isEmpty(auditores122))? auditores122:null;
        editTextAuditoresDB123 = (!TextUtils.isEmpty(auditores123))? auditores123:null;
        editTextAuditoresDB124 = (!TextUtils.isEmpty(auditores124))? auditores124:null;
        editTextAuditoresDB125 = (!TextUtils.isEmpty(auditores125))? auditores125:null;
        editTextAuditoresDB126 = (!TextUtils.isEmpty(auditores126))? auditores126:null;

        editTextTeacherDB121 = (!TextUtils.isEmpty(teacher121))? teacher121:null;
        editTextTeacherDB122 = (!TextUtils.isEmpty(teacher122))? teacher122:null;
        editTextTeacherDB123 = (!TextUtils.isEmpty(teacher123))? teacher123:null;
        editTextTeacherDB124 = (!TextUtils.isEmpty(teacher124))? teacher124:null;
        editTextTeacherDB125 = (!TextUtils.isEmpty(teacher125))? teacher125:null;
        editTextTeacherDB126 = (!TextUtils.isEmpty(teacher126))? teacher126:null;
        //13 ДЕНЬ
        editTextLessonDB131 = (!TextUtils.isEmpty(lesson131))? lesson131:null;
        editTextLessonDB132 = (!TextUtils.isEmpty(lesson132))? lesson132:null;
        editTextLessonDB133 = (!TextUtils.isEmpty(lesson133))? lesson133:null;
        editTextLessonDB134 = (!TextUtils.isEmpty(lesson134))? lesson134:null;
        editTextLessonDB135 = (!TextUtils.isEmpty(lesson135))? lesson135:null;
        editTextLessonDB136 = (!TextUtils.isEmpty(lesson136))? lesson136:null;

        editTextAuditoresDB131 = (!TextUtils.isEmpty(auditores131))? auditores131:null;
        editTextAuditoresDB132 = (!TextUtils.isEmpty(auditores132))? auditores132:null;
        editTextAuditoresDB133 = (!TextUtils.isEmpty(auditores133))? auditores133:null;
        editTextAuditoresDB134 = (!TextUtils.isEmpty(auditores134))? auditores134:null;
        editTextAuditoresDB135 = (!TextUtils.isEmpty(auditores135))? auditores135:null;
        editTextAuditoresDB136 = (!TextUtils.isEmpty(auditores136))? auditores136:null;

        editTextTeacherDB131 = (!TextUtils.isEmpty(teacher131))? teacher131:null;
        editTextTeacherDB132 = (!TextUtils.isEmpty(teacher132))? teacher132:null;
        editTextTeacherDB133 = (!TextUtils.isEmpty(teacher133))? teacher133:null;
        editTextTeacherDB134 = (!TextUtils.isEmpty(teacher134))? teacher134:null;
        editTextTeacherDB135 = (!TextUtils.isEmpty(teacher135))? teacher135:null;
        editTextTeacherDB136 = (!TextUtils.isEmpty(teacher136))? teacher136:null;
        modelSchedule();
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


    public void dialogDefault(View view) {
    }

    //Нажатие на кнопку ручки
    private void clickBtnMakeChanges() {
        hasConnection(EditSchduleActivity.this,2);
//        checkingInternet();
    }

    private class AsyncModelSchedule extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog.show();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            getText();
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            sendData();
        }
    }
    private void sendData(){
        Log.d("test1","elementSubgroupCource = " + elementSubGroup);
        Log.d("test1","setElementCource = " + elementCource);
        HashMap<String, Object> params = new HashMap<>();
        params.put(elementSubGroup, modelSchedule);
        FirebaseDatabase.getInstance().
                getReference(elementFacultet).child(elementDirection).child(elementCource)
                .updateChildren(params)
                .addOnSuccessListener(new com.google.android.gms.tasks
                        .OnSuccessListener<Void>() {
                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void onSuccess(Void unused) {
                        dialog.dismiss();
                        makeChangesBtn.setBackgroundDrawable(
                                getDrawable(R.drawable.form_for_enter_purple));
                        makeChangesBtn.setText("Изменения сохранены");
                        flag = true;
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        dialog.dismiss();
                    }
                });
    }
    //Устонавливаем данные в ModelSchedule
    private ModelSchedule modelSchedule(){
        modelSchedule = new ModelSchedule();
        //1 день
        modelSchedule.setLesson11(editTextLessonDB11);
        modelSchedule.setLesson12(editTextLessonDB12);
        modelSchedule.setLesson13(editTextLessonDB13);
        modelSchedule.setLesson14(editTextLessonDB14);
        modelSchedule.setLesson15(editTextLessonDB15);
        modelSchedule.setLesson16(editTextLessonDB16);

        modelSchedule.setAuditores11(editTextAuditoresDB11);
        modelSchedule.setAuditores12(editTextAuditoresDB12);
        modelSchedule.setAuditores13(editTextAuditoresDB13);
        modelSchedule.setAuditores14(editTextAuditoresDB14);
        modelSchedule.setAuditores15(editTextAuditoresDB15);
        modelSchedule.setAuditores16(editTextAuditoresDB16);

        modelSchedule.setTeacher11(editTextTeacherDB11);
        modelSchedule.setTeacher12(editTextTeacherDB12);
        modelSchedule.setTeacher13(editTextTeacherDB13);
        modelSchedule.setTeacher14(editTextTeacherDB14);
        modelSchedule.setTeacher15(editTextTeacherDB15);
        modelSchedule.setTeacher16(editTextTeacherDB16);
        //2 день
        modelSchedule.setLesson21(editTextLessonDB21);
        modelSchedule.setLesson22(editTextLessonDB22);
        modelSchedule.setLesson23(editTextLessonDB23);
        modelSchedule.setLesson24(editTextLessonDB24);
        modelSchedule.setLesson25(editTextLessonDB25);
        modelSchedule.setLesson26(editTextLessonDB26);

        modelSchedule.setAuditores21(editTextAuditoresDB21);
        modelSchedule.setAuditores22(editTextAuditoresDB22);
        modelSchedule.setAuditores23(editTextAuditoresDB23);
        modelSchedule.setAuditores24(editTextAuditoresDB24);
        modelSchedule.setAuditores25(editTextAuditoresDB25);
        modelSchedule.setAuditores26(editTextAuditoresDB26);

        modelSchedule.setTeacher21(editTextTeacherDB21);
        modelSchedule.setTeacher22(editTextTeacherDB22);
        modelSchedule.setTeacher23(editTextTeacherDB23);
        modelSchedule.setTeacher24(editTextTeacherDB24);
        modelSchedule.setTeacher25(editTextTeacherDB25);
        modelSchedule.setTeacher26(editTextTeacherDB26);
        //3 день
        modelSchedule.setLesson31(editTextLessonDB31);
        modelSchedule.setLesson32(editTextLessonDB32);
        modelSchedule.setLesson33(editTextLessonDB33);
        modelSchedule.setLesson34(editTextLessonDB34);
        modelSchedule.setLesson35(editTextLessonDB35);
        modelSchedule.setLesson36(editTextLessonDB36);

        modelSchedule.setAuditores31(editTextAuditoresDB31);
        modelSchedule.setAuditores32(editTextAuditoresDB32);
        modelSchedule.setAuditores33(editTextAuditoresDB33);
        modelSchedule.setAuditores34(editTextAuditoresDB34);
        modelSchedule.setAuditores35(editTextAuditoresDB35);
        modelSchedule.setAuditores36(editTextAuditoresDB36);

        modelSchedule.setTeacher31(editTextTeacherDB31);
        modelSchedule.setTeacher32(editTextTeacherDB32);
        modelSchedule.setTeacher33(editTextTeacherDB33);
        modelSchedule.setTeacher34(editTextTeacherDB34);
        modelSchedule.setTeacher35(editTextTeacherDB35);
        modelSchedule.setTeacher36(editTextTeacherDB36);
        //4 день
        modelSchedule.setLesson41(editTextLessonDB41);
        modelSchedule.setLesson42(editTextLessonDB42);
        modelSchedule.setLesson43(editTextLessonDB43);
        modelSchedule.setLesson44(editTextLessonDB44);
        modelSchedule.setLesson45(editTextLessonDB45);
        modelSchedule.setLesson46(editTextLessonDB46);

        modelSchedule.setAuditores41(editTextAuditoresDB41);
        modelSchedule.setAuditores42(editTextAuditoresDB42);
        modelSchedule.setAuditores43(editTextAuditoresDB43);
        modelSchedule.setAuditores44(editTextAuditoresDB44);
        modelSchedule.setAuditores45(editTextAuditoresDB45);
        modelSchedule.setAuditores46(editTextAuditoresDB46);

        modelSchedule.setTeacher41(editTextTeacherDB41);
        modelSchedule.setTeacher42(editTextTeacherDB42);
        modelSchedule.setTeacher43(editTextTeacherDB43);
        modelSchedule.setTeacher44(editTextTeacherDB44);
        modelSchedule.setTeacher45(editTextTeacherDB45);
        modelSchedule.setTeacher46(editTextTeacherDB46);
        //5 день
        modelSchedule.setLesson51(editTextLessonDB51);
        modelSchedule.setLesson52(editTextLessonDB52);
        modelSchedule.setLesson53(editTextLessonDB53);
        modelSchedule.setLesson54(editTextLessonDB54);
        modelSchedule.setLesson55(editTextLessonDB55);
        modelSchedule.setLesson56(editTextLessonDB56);

        modelSchedule.setAuditores51(editTextAuditoresDB51);
        modelSchedule.setAuditores52(editTextAuditoresDB52);
        modelSchedule.setAuditores53(editTextAuditoresDB53);
        modelSchedule.setAuditores54(editTextAuditoresDB54);
        modelSchedule.setAuditores55(editTextAuditoresDB55);
        modelSchedule.setAuditores56(editTextAuditoresDB56);

        modelSchedule.setTeacher51(editTextTeacherDB51);
        modelSchedule.setTeacher52(editTextTeacherDB52);
        modelSchedule.setTeacher53(editTextTeacherDB53);
        modelSchedule.setTeacher54(editTextTeacherDB54);
        modelSchedule.setTeacher55(editTextTeacherDB55);
        modelSchedule.setTeacher56(editTextTeacherDB56);
        //6 день
        modelSchedule.setLesson61(editTextLessonDB61);
        modelSchedule.setLesson62(editTextLessonDB62);
        modelSchedule.setLesson63(editTextLessonDB63);
        modelSchedule.setLesson64(editTextLessonDB64);
        modelSchedule.setLesson65(editTextLessonDB65);
        modelSchedule.setLesson66(editTextLessonDB66);

        modelSchedule.setAuditores61(editTextAuditoresDB61);
        modelSchedule.setAuditores62(editTextAuditoresDB62);
        modelSchedule.setAuditores63(editTextAuditoresDB63);
        modelSchedule.setAuditores64(editTextAuditoresDB64);
        modelSchedule.setAuditores65(editTextAuditoresDB65);
        modelSchedule.setAuditores66(editTextAuditoresDB66);

        modelSchedule.setTeacher61(editTextTeacherDB61);
        modelSchedule.setTeacher62(editTextTeacherDB62);
        modelSchedule.setTeacher63(editTextTeacherDB63);
        modelSchedule.setTeacher64(editTextTeacherDB64);
        modelSchedule.setTeacher65(editTextTeacherDB65);
        modelSchedule.setTeacher66(editTextTeacherDB66);
        //8 день
        modelSchedule.setLesson81(editTextLessonDB81);
        modelSchedule.setLesson82(editTextLessonDB82);
        modelSchedule.setLesson83(editTextLessonDB83);
        modelSchedule.setLesson84(editTextLessonDB84);
        modelSchedule.setLesson85(editTextLessonDB85);
        modelSchedule.setLesson86(editTextLessonDB86);

        modelSchedule.setAuditores81(editTextAuditoresDB81);
        modelSchedule.setAuditores82(editTextAuditoresDB82);
        modelSchedule.setAuditores83(editTextAuditoresDB83);
        modelSchedule.setAuditores84(editTextAuditoresDB84);
        modelSchedule.setAuditores85(editTextAuditoresDB85);
        modelSchedule.setAuditores86(editTextAuditoresDB86);

        modelSchedule.setTeacher81(editTextTeacherDB81);
        modelSchedule.setTeacher82(editTextTeacherDB82);
        modelSchedule.setTeacher83(editTextTeacherDB83);
        modelSchedule.setTeacher84(editTextTeacherDB84);
        modelSchedule.setTeacher85(editTextTeacherDB85);
        modelSchedule.setTeacher86(editTextTeacherDB86);
        //9 день
        modelSchedule.setLesson91(editTextLessonDB91);
        modelSchedule.setLesson92(editTextLessonDB92);
        modelSchedule.setLesson93(editTextLessonDB93);
        modelSchedule.setLesson94(editTextLessonDB94);
        modelSchedule.setLesson95(editTextLessonDB95);
        modelSchedule.setLesson96(editTextLessonDB96);

        modelSchedule.setAuditores91(editTextAuditoresDB91);
        modelSchedule.setAuditores92(editTextAuditoresDB92);
        modelSchedule.setAuditores93(editTextAuditoresDB93);
        modelSchedule.setAuditores94(editTextAuditoresDB94);
        modelSchedule.setAuditores95(editTextAuditoresDB95);
        modelSchedule.setAuditores96(editTextAuditoresDB96);

        modelSchedule.setTeacher91(editTextTeacherDB91);
        modelSchedule.setTeacher92(editTextTeacherDB92);
        modelSchedule.setTeacher93(editTextTeacherDB93);
        modelSchedule.setTeacher94(editTextTeacherDB94);
        modelSchedule.setTeacher95(editTextTeacherDB95);
        modelSchedule.setTeacher96(editTextTeacherDB96);
        //10 день
        modelSchedule.setLesson101(editTextLessonDB101);
        modelSchedule.setLesson102(editTextLessonDB102);
        modelSchedule.setLesson103(editTextLessonDB103);
        modelSchedule.setLesson104(editTextLessonDB104);
        modelSchedule.setLesson105(editTextLessonDB105);
        modelSchedule.setLesson106(editTextLessonDB106);

        modelSchedule.setAuditores101(editTextAuditoresDB101);
        modelSchedule.setAuditores102(editTextAuditoresDB102);
        modelSchedule.setAuditores103(editTextAuditoresDB103);
        modelSchedule.setAuditores104(editTextAuditoresDB104);
        modelSchedule.setAuditores105(editTextAuditoresDB105);
        modelSchedule.setAuditores106(editTextAuditoresDB106);

        modelSchedule.setTeacher101(editTextTeacherDB101);
        modelSchedule.setTeacher102(editTextTeacherDB102);
        modelSchedule.setTeacher103(editTextTeacherDB103);
        modelSchedule.setTeacher104(editTextTeacherDB104);
        modelSchedule.setTeacher105(editTextTeacherDB105);
        modelSchedule.setTeacher106(editTextTeacherDB106);
        //11 день
        modelSchedule.setLesson111(editTextLessonDB111);
        modelSchedule.setLesson112(editTextLessonDB112);
        modelSchedule.setLesson113(editTextLessonDB113);
        modelSchedule.setLesson114(editTextLessonDB114);
        modelSchedule.setLesson115(editTextLessonDB115);
        modelSchedule.setLesson116(editTextLessonDB116);

        modelSchedule.setAuditores111(editTextAuditoresDB111);
        modelSchedule.setAuditores112(editTextAuditoresDB112);
        modelSchedule.setAuditores113(editTextAuditoresDB113);
        modelSchedule.setAuditores114(editTextAuditoresDB114);
        modelSchedule.setAuditores115(editTextAuditoresDB115);
        modelSchedule.setAuditores116(editTextAuditoresDB116);

        modelSchedule.setTeacher111(editTextTeacherDB111);
        modelSchedule.setTeacher112(editTextTeacherDB112);
        modelSchedule.setTeacher113(editTextTeacherDB113);
        modelSchedule.setTeacher114(editTextTeacherDB114);
        modelSchedule.setTeacher115(editTextTeacherDB115);
        modelSchedule.setTeacher116(editTextTeacherDB116);
        //12 день
        modelSchedule.setLesson121(editTextLessonDB121);
        modelSchedule.setLesson122(editTextLessonDB122);
        modelSchedule.setLesson123(editTextLessonDB123);
        modelSchedule.setLesson124(editTextLessonDB124);
        modelSchedule.setLesson125(editTextLessonDB125);
        modelSchedule.setLesson126(editTextLessonDB126);

        modelSchedule.setAuditores121(editTextAuditoresDB121);
        modelSchedule.setAuditores122(editTextAuditoresDB122);
        modelSchedule.setAuditores123(editTextAuditoresDB123);
        modelSchedule.setAuditores124(editTextAuditoresDB124);
        modelSchedule.setAuditores125(editTextAuditoresDB125);
        modelSchedule.setAuditores126(editTextAuditoresDB126);

        modelSchedule.setTeacher121(editTextTeacherDB121);
        modelSchedule.setTeacher122(editTextTeacherDB122);
        modelSchedule.setTeacher123(editTextTeacherDB123);
        modelSchedule.setTeacher124(editTextTeacherDB124);
        modelSchedule.setTeacher125(editTextTeacherDB125);
        modelSchedule.setTeacher126(editTextTeacherDB126);
        //13 день
        modelSchedule.setLesson131(editTextLessonDB131);
        modelSchedule.setLesson132(editTextLessonDB132);
        modelSchedule.setLesson133(editTextLessonDB133);
        modelSchedule.setLesson134(editTextLessonDB134);
        modelSchedule.setLesson135(editTextLessonDB135);
        modelSchedule.setLesson136(editTextLessonDB136);

        modelSchedule.setAuditores131(editTextAuditoresDB131);
        modelSchedule.setAuditores132(editTextAuditoresDB132);
        modelSchedule.setAuditores133(editTextAuditoresDB133);
        modelSchedule.setAuditores134(editTextAuditoresDB134);
        modelSchedule.setAuditores135(editTextAuditoresDB135);
        modelSchedule.setAuditores136(editTextAuditoresDB136);

        modelSchedule.setTeacher131(editTextTeacherDB131);
        modelSchedule.setTeacher132(editTextTeacherDB132);
        modelSchedule.setTeacher133(editTextTeacherDB133);
        modelSchedule.setTeacher134(editTextTeacherDB134);
        modelSchedule.setTeacher135(editTextTeacherDB135);
        modelSchedule.setTeacher136(editTextTeacherDB136);
        return modelSchedule;
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
        new SetETInMasAsync().execute();
    }
    @Override
    public void onStop() {
        super.onStop();
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            connectivityManager.unregisterNetworkCallback(callback);
//        }
    }
    //Проверка на выход в интернет (Этот метод реагирует на подключение и отключение инета сама)
//    private void checkingInternet() {
////        connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
//
//        NetworkRequest networkRequest = null;
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
//            networkRequest = new NetworkRequest.Builder().build();
//        }
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            callback = new ConnectivityManager.NetworkCallback() {
//                @Override
//                public void onLost(Network network) {
//                    Log.d("inet"," Инета нет!");
//                     }
//
//                @Override
//                public void onAvailable(Network network) {
//                    Log.d("inet"," Инет есть!");
//
////                    new checkingInternetAsyncTask().execute();
//                }
//
//            };
//        }
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            connectivityManager.registerNetworkCallback(networkRequest, callback);
//        }
//    }
    //Проверка на выход в интернет (Сама не реагирует на подкл/откл инета)
    public void hasConnection(final Context context,int i) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (wifiInfo != null && wifiInfo.isConnected()) {
            //Когда доступ к вайфаю есть
            if(i == 1){
                dialog.show();
            }else{
                new AsyncModelSchedule().execute();
            }
        } else if (mobileInfo != null && mobileInfo.isConnected()) {
            //Когда доступ к мобильному инету есть
            if(i == 1){
                dialog.show();
            }else{
                new AsyncModelSchedule().execute();
            }
        } else {
            //Если инета нет
            Toast.makeText(EditSchduleActivity.this, "инета нет, расписание " +
                    "не может быть обновленно", Toast.LENGTH_SHORT).show();
        }
    }
}