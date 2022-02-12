package com.application.mydsu.EditSchdule;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.application.mydsu.AboutMe;
import com.application.mydsu.CustomSpinner.CustomAdapter;
import com.application.mydsu.R;
import com.application.mydsu.Utils.Swipe;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class LoginEditSchduleActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private String dirText,textSpinDirection;
    private ConstraintLayout main_layout;
    private Integer elementSpinnerCourceInt, elementSpinnerDirectionInt;
    private SharedPreferences sharedPreferences;
    private EditText passwordET;
    private String elementSpinnerDirection, elementSpinnerCource;
    private Spinner spinnerDirection, spinnerCource;
    private CustomAdapter adapterDirection, adapterCource;
    private Button btnEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_schdule_btn);
        init();
        //Добавляем данные в спинер
        setDataInSpinner();
        getDataInSharedPrefForSpinner();
        mAuth = FirebaseAuth.getInstance();
        //Свайп
        main_layout = (ConstraintLayout) findViewById(R.id.main_layout);
        main_layout.setOnTouchListener(new Swipe(LoginEditSchduleActivity.this) {
            public void onSwipeRight() {
                Intent intent = new Intent(LoginEditSchduleActivity.this,
                        AboutMe.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.diagonaltranslateleft, R.anim.alpha_one_zero);
            }
        });

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginEditSchedule();
            }
        });

    }

    private void getDataInSharedPrefForSpinner() {
        sharedPreferences = this.getSharedPreferences("userdata", Context.MODE_PRIVATE);
        elementSpinnerDirection = sharedPreferences.getString("elementSpinnerDirection",
                "ИСиТ");
        elementSpinnerDirectionInt = sharedPreferences.getInt("elementSpinnerDirectionInt", 0);
        elementSpinnerCourceInt = sharedPreferences.getInt("elementSpinnerCourceInt", 0);
        spinnerCource.setSelection(elementSpinnerCourceInt);
        spinnerDirection.setSelection(elementSpinnerDirectionInt);

        spinnerCource.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition, long selectedId) {
                elementSpinnerCource = spinnerCource.getSelectedItem().toString();
                elementSpinnerCourceInt = selectedItemPosition;
                if (elementSpinnerCource.contentEquals("1")) {
                    List<String> listDirection = new ArrayList<String>() {{
                        add("ИСиТ");
                        add("ИБ");
                        add("ИСиП");
                        add("ПИЭ");
                    }};
                    adapterDirection = new CustomAdapter(LoginEditSchduleActivity
                            .this, R.layout.item_spinner_title,
                            R.layout.item_spinner_dropdown, listDirection);
                    spinnerDirection.setAdapter(adapterDirection);
                    spinnerDirection.setSelection(elementSpinnerDirectionInt);
                } else {
                    List<String> listDirection = new ArrayList<String>() {{
                        add("ИСиТ");
                        add("ИБ");
                        add("ПИМ");
                        add("ПИЭ");
                    }};
                    adapterDirection = new CustomAdapter
                            (LoginEditSchduleActivity.this, R.layout.item_spinner_title, R.layout.item_spinner_dropdown, listDirection);
                    spinnerDirection.setAdapter(adapterDirection);
                    spinnerDirection.setSelection(elementSpinnerDirectionInt);
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void setDataInSpinner() {
        //Спинер Направлений
//        List<String> listDirection = new ArrayList<String>() {{
//            add("ИСиТ");
//            add("ПИЭ");
//            add("ИБ");
//            add("ПИМ");
//        }};
//        adapterDirection = new CustomAdapter(LoginEditSchduleActivity.
//                this, R.layout.item_spinner_title,
//                R.layout.item_spinner_dropdown, listDirection);
//        spinnerDirection.setAdapter(adapterDirection);

        //Спинер курсов
        final List<String> listCource = new ArrayList<String>() {
            {
                add("1");
                add("2");
                add("3");
                add("4");
            }
        };
        adapterCource = new CustomAdapter(this, R.layout.item_spinner_title, R.layout.item_spinner_dropdown, listCource);
        spinnerCource.setAdapter(adapterCource);
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
//        updateUI(currentUser);
    }


    private void init() {
        spinnerCource = findViewById(R.id.spinnerCource);
        spinnerDirection = findViewById(R.id.spinnerDirection);
        btnEnter = findViewById(R.id.btnEnter);
        passwordET = findViewById(R.id.passwordET);
    }

    private void LoginEditSchedule() {
        String password = passwordET.getText().toString();
        if (TextUtils.isEmpty(elementSpinnerDirection)) {
            Toast.makeText(LoginEditSchduleActivity.this,
                    "Выберите напрпаление и курс", Toast.LENGTH_SHORT).show();
            ;
        } else if (TextUtils.isEmpty(password)) {
            passwordET.setError("Запоните поле");
        } else {
            textSpinDirection = spinnerDirection.getSelectedItem().toString();
            textDirectionInEnglish();
            String email = dirText + elementSpinnerCource + "@mail.ru";
            Toast.makeText(LoginEditSchduleActivity.this,
                    "1 = " + email, Toast.LENGTH_SHORT).show();
            signIn(email, password);
        }
    }

    private void textDirectionInEnglish() {
        if (textSpinDirection.equals("ИСиТ")) {
            dirText = "isit";
        } else if (textSpinDirection.equals("ИБ")) {
            dirText = "ib";
        } else if (textSpinDirection.equals("ИСиП")) {
            dirText = "isip";
        } else if (textSpinDirection.equals("ПИМ")) {
            dirText = "pim";
        } else if (textSpinDirection.equals("ПИЭ")) {
            dirText = "pie";
        }else {
            dirText = "isit";
        }
    }

    private void signIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent intentBack = new Intent(LoginEditSchduleActivity.this,
                                    EditSchduleActivity.class);
                            startActivity(intentBack);
                            finish();
                            overridePendingTransition(R.anim.alpha_zero_one, R.anim.alpha_one_zero);
//                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "signInWithEmail:failure", task.getException());
//                              updateUI(null);
                        }

                        // ...
                    }
                });
    }
}