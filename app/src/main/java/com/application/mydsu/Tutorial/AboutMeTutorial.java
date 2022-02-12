package com.application.mydsu.Tutorial;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.application.mydsu.AboutMe;
import com.application.mydsu.CustomSpinner.CustomAdapter;
import com.application.mydsu.MainActivity;
import com.application.mydsu.R;

import java.util.ArrayList;
import java.util.List;

public class AboutMeTutorial extends AppCompatActivity {
    private Spinner spinnerFacultet, spinnerDirection, spinnerCource, spinnerSubgroupCource;
    private EditText userName, surName, email;
    private CustomAdapter adapterDirection;
    public SharedPreferences sharedPreferences;
    static final int GALLERY_REQUEST = 1;
    //ПЕРЕМЕННЫЕ ДЛЯ ПОЛУЧЕНИЯ ВЫБРАННОГО ЭЛЕМЕНТА - НАЧАЛО
    String elementSpinnerFacultet, elementSpinnerDirection, elementSpinnerCource, elementSpinnerSubgroupCource;
    //ПЕРЕМЕННЫЕ ДЛЯ ПОЛУЧЕНИЯ ПОЗИЦИИ ВЫБРАННОГО ЭЛЕМЕНТА - НАЧАЛО
    Integer elementSpinnerFacultetInt = 0, elementSpinnerDirectionInt = 0, elementSpinnerCourceInt = 0, elementSpinnerSubgroupCourceInt = 0;
    ImageView img;
    Button buttonResume;
    Drawable btnEnabledFalse, btnEnabledTrue;
    private boolean test = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me_tutorial);
        sharedPreferences = this.getSharedPreferences("userdata", Context.MODE_PRIVATE);
        sharedPreferences = this.getSharedPreferences("userdata", Context.MODE_PRIVATE);
        elementSpinnerDirection = sharedPreferences.getString("elementSpinnerDirection", "ИСиТ");
        elementSpinnerDirectionInt = sharedPreferences.getInt("elementSpinnerDirectionInt", 0);
        img = (ImageView) findViewById(R.id.userPhoto);
        buttonResume = (Button) findViewById(R.id.buttonResume);
        userName = findViewById(R.id.userName);
        surName = findViewById(R.id.userSurName);
        userName.setFilters(new InputFilter[]{new InputFilter.LengthFilter(12)});
        btnEnabledFalse = ContextCompat.getDrawable(AboutMeTutorial.this, R.drawable.btn_enabled_resume);
        btnEnabledTrue = ContextCompat.getDrawable(AboutMeTutorial.this, R.drawable.email_form);

        userName.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                if (userName.getText().toString().length() == 0 || surName.getText().toString().length() == 0) {
                    buttonResume.setEnabled(false);
                    buttonResume.setBackground(btnEnabledFalse);
                } else {
                    buttonResume.setEnabled(true);
                    buttonResume.setBackground(btnEnabledTrue);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
            }

        });

        surName.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                if (userName.getText().toString().length() == 0 || surName.getText().toString().length() == 0) {
                    buttonResume.setEnabled(false);
                    buttonResume.setBackground(btnEnabledFalse);
                } else {
                    buttonResume.setEnabled(true);
                    buttonResume.setBackground(btnEnabledTrue);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
            }

        });

        if (userName.getText().toString().length() == 0 || surName.getText().toString().length() == 0) {
            buttonResume.setEnabled(false);
            buttonResume.setBackground(btnEnabledFalse);
        }

        surName = findViewById(R.id.userSurName);
        surName.setFilters(new InputFilter[]{new InputFilter.LengthFilter(12)});

        SpinnerItem();

        setData();
    }

    //МЕТОД ONPAUSE - НАЧАЛО
    @Override
    protected void onPause() {
        super.onPause();
        saveData();
    }

    //ВЫБОРКА СПИННЕР ЭЛЕМЕНТОВ - НАЧАЛО
    public void SpinnerItem() {
        //SPINNER FACULTET
        spinnerFacultet = findViewById(R.id.spinnerFacultet);
        final List<String> listFacultet = new ArrayList<String>() {{
            add("Информатики и Информационных Технологий");
        }};
        CustomAdapter adapterFacultet = new CustomAdapter(this, R.layout.item_spinner_title_tutorial, R.layout.item_spinner_dropdown_tutorial, listFacultet);
        spinnerFacultet.setAdapter(adapterFacultet);
        spinnerFacultet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition, long selectedId) {
                elementSpinnerFacultet = spinnerFacultet.getSelectedItem().toString();
                elementSpinnerFacultetInt = selectedItemPosition;
                if (elementSpinnerFacultet.contentEquals("Информатики и Информационных Технологий")) {
                    List<String> listDirection = new ArrayList<String>() {{
                        add("ИСиТ");
                        add("ПИЭ");
                        add("ИБ");
                        add("ПИМ");
                    }};
                    adapterDirection = new CustomAdapter(AboutMeTutorial.this, R.layout.item_spinner_title_tutorial, R.layout.item_spinner_dropdown_tutorial, listDirection);
                    spinnerDirection.setAdapter(adapterDirection);
                }
            }

            ;

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //SPINNER DIRECTION
        spinnerDirection = findViewById(R.id.spinnerDirection);
        spinnerDirection.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition, long selectedId) {
                elementSpinnerDirection = spinnerDirection.getSelectedItem().toString();
                elementSpinnerDirectionInt = selectedItemPosition;
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //SPINNER COURCE
        spinnerCource = findViewById(R.id.spinnerCource);
        final List<String> listCource = new ArrayList<String>() {{
            add("1");
            add("2");
            add("3");
            add("4");
        }};
        CustomAdapter adapterCource = new CustomAdapter(this, R.layout.item_spinner_title_tutorial, R.layout.item_spinner_dropdown_tutorial, listCource);
        spinnerCource.setAdapter(adapterCource);

        spinnerCource.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition, long selectedId) {
                elementSpinnerCource = spinnerCource.getSelectedItem().toString();
                elementSpinnerCourceInt = selectedItemPosition;
                if(elementSpinnerCource.contentEquals("1") && elementSpinnerFacultet.contentEquals("Информатики и Информационных Технологий")){
                    List<String> listDirection = new ArrayList<String>() {{
                        add("ИСиТ");
                        add("ИБ");
                        add("ИСиП");
                        add("ПИЭ");
                    }};
                    adapterDirection = new CustomAdapter(AboutMeTutorial.this, R.layout.item_spinner_title_tutorial, R.layout.item_spinner_dropdown_tutorial, listDirection);
                    spinnerDirection.setAdapter(adapterDirection);
                    spinnerDirection.setSelection(elementSpinnerDirectionInt);
                }else if(elementSpinnerFacultet.contentEquals("Информатики и Информационных Технологий")){
                    List<String> listDirection = new ArrayList<String>() {{
                        add("ИСиТ");
                        add("ИБ");
                        add("ПИМ");
                        add("ПИЭ");
                    }};
                    adapterDirection = new CustomAdapter(AboutMeTutorial.this, R.layout.item_spinner_title_tutorial, R.layout.item_spinner_dropdown_tutorial, listDirection);
                    spinnerDirection.setAdapter(adapterDirection);
                    spinnerDirection.setSelection(elementSpinnerDirectionInt);
                }
                if(!test){
                    Integer elementSpinnerDirectionInt2 = sharedPreferences.getInt("elementSpinnerDirectionInt", 0);
                    spinnerDirection.setSelection(elementSpinnerDirectionInt2);
                    test = true;
                }
            }

            ;

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //SPINNER SUBGROUPCOURCE - НАЧАЛО
        spinnerSubgroupCource = findViewById(R.id.subgroupCource);
        final List<String> listSubgroupCource = new ArrayList<String>() {{
            add("1");
            add("2");
        }};
        CustomAdapter adapterSubgroupCource = new CustomAdapter(this, R.layout.item_spinner_title_tutorial, R.layout.item_spinner_dropdown_tutorial, listSubgroupCource);
        spinnerSubgroupCource.setAdapter(adapterSubgroupCource);
        spinnerSubgroupCource.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition, long selectedId) {
                elementSpinnerSubgroupCource = spinnerSubgroupCource.getSelectedItem().toString();
                elementSpinnerSubgroupCourceInt = selectedItemPosition;
            }

            ;

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //SPINNER SUBGROUPCOURCE - КОНЕЦ

    }

    ;

    //СИСТЕМНАЯ КНОПКА НАЗАД - НАЧАЛО
    @Override
    public void onBackPressed() {
        try {
            Intent intentBack = new Intent(AboutMeTutorial.this, MainActivity.class);
            startActivity(intentBack);
            finish();
        } catch (Exception e) {

        }
    }


    //СОХРАНЯЕМ ДАННЫЕ С ПОМОЩЬЮ SHARED PREFERENCES - НАЧАЛО
    public void saveData() {
        email = findViewById(R.id.Email);
        String getEmail = email.getText().toString();
        String getUserName = userName.getText().toString();
        String getSurUserName = surName.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("setElementSpinnerFacultet", elementSpinnerFacultet);
        editor.putString("setElementSpinnerCource", elementSpinnerCource);
        editor.putString("elementSpinnerSubgroupCource", elementSpinnerSubgroupCource);
        editor.putString("elementSpinnerDirection", elementSpinnerDirection);

        editor.putInt("elementSpinnerFacultetInt", elementSpinnerFacultetInt);
        editor.putInt("elementSpinnerCourceInt", elementSpinnerCourceInt);
        editor.putInt("elementSpinnerSubgroupCourceInt", elementSpinnerSubgroupCourceInt);
        editor.putInt("elementSpinnerDirectionInt", elementSpinnerDirectionInt);
        editor.putString("setUserName", getUserName);
        editor.putString("setUserSurName", getSurUserName);
        editor.putString("getEmail", getEmail);
        editor.apply();
    }

    //УСТАНОВКА ВЫБРАННЫХ ЭЛЕМЕНТОВ В SPINNER
    public void setData() {
        String setUserName = sharedPreferences.getString("setUserName", "");
        String setUserSurName = sharedPreferences.getString("setUserSurName", "");
        String getEmail = sharedPreferences.getString("getEmail", "");
        Integer elementSpinnerFacultetInt = sharedPreferences.getInt("elementSpinnerFacultetInt", 0);
        Integer elementSpinnerCourceInt = sharedPreferences.getInt("elementSpinnerCourceInt", 0);
        Integer elementSpinnerSubgroupCourceInt = sharedPreferences.getInt("elementSpinnerSubgroupCourceInt", 0);

        spinnerFacultet.setSelection(elementSpinnerFacultetInt);
        spinnerCource.setSelection(elementSpinnerCourceInt);
        spinnerSubgroupCource.setSelection(elementSpinnerSubgroupCourceInt);
        userName = findViewById(R.id.userName);
        userName.setText(setUserName);
        surName = findViewById(R.id.userSurName);
        surName.setText(setUserSurName);
        email = findViewById(R.id.Email);
        email.setText(getEmail);
    }

    public void InMainActivity(View view) {
        Intent intentMainActivity = new Intent(AboutMeTutorial.this, MainActivity.class);
        startActivity(intentMainActivity);
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

    public void Tutorial(View view) {
        Intent intentFragment = new Intent(AboutMeTutorial.this, ActivityStart.class);
        startActivity(intentFragment);
    }
}