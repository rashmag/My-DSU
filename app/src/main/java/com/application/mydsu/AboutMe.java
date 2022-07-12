package com.application.mydsu;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.application.mydsu.CustomSpinner.CustomAdapter;
import com.application.mydsu.EditSchdule.EditSchduleActivity;
import com.application.mydsu.EditSchdule.LoginEditSchduleActivity;
import com.application.mydsu.Utils.CircularTransformation;
import com.application.mydsu.Utils.Swipe;
import com.application.mydsu.presentation.main_activity.MainActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.google.android.play.core.tasks.OnCompleteListener;
import com.google.android.play.core.tasks.OnSuccessListener;
import com.google.android.play.core.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class AboutMe extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinnerFacultet, spinnerDirection, spinnerCource, spinnerSubgroupCource;
    private EditText userName, surName, email;
    private CustomAdapter adapterDirection,adapterFacultet,adapterCource,adapterSubgroupCource;
    private SharedPreferences prefs,prefsTheme = null;
    public SharedPreferences sharedPreferences;
    private InterstitialAd mInterstitialAd;
    static final int GALLERY_REQUEST = 1;
    Button editBtn;
    //ПЕРЕМЕННЫЕ ДЛЯ ПОЛУЧЕНИЯ ВЫБРАННОГО ЭЛЕМЕНТА - НАЧАЛО
    String elementSpinnerFacultet, elementSpinnerDirection, elementSpinnerCource, elementSpinnerSubgroupCource;
    //ПЕРЕМЕННЫЕ ДЛЯ ПОЛУЧЕНИЯ ПОЗИЦИИ ВЫБРАННОГО ЭЛЕМЕНТА - НАЧАЛО
    private Integer elementSpinnerFacultetInt = 0, elementSpinnerDirectionInt = 0, elementSpinnerCourceInt = 0, elementSpinnerSubgroupCourceInt = 0;
    private ImageView img,userPhoto;
    private File f;
    private TextView aboutMeText;
    private String pathPhoto = "/data/user/0/com.application.mydsu/app_imageDir/phone.jpg";
    private boolean test = false;
    private final int CAMERA_REQUEST = 200;
    private final int PERMISSION = 300;
    private static final String TAG = "myLog1";
    private ConstraintLayout main_layout;
    private Button lightAndDarkTheme;
    private Uri uri;
    private ReviewManager reviewManager;
    private ReviewInfo reviewInfo;
    boolean flagTheme;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
        //Реклама
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this,"ca-app-pub-6029526207746824/8092402385", adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
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
        prefs = getSharedPreferences("FirstRun", MODE_PRIVATE);
        prefsTheme = getSharedPreferences("Theme", MODE_PRIVATE);
        flagTheme = prefsTheme.getBoolean("lightAndDarkTheme", false);
        lightAndDarkTheme = findViewById(R.id.lightAndDarkTheme);
        userName = findViewById(R.id.userName);
        surName = findViewById(R.id.userSurName);
        editBtn = findViewById(R.id.editBtn);

        if(flagTheme){
            lightAndDarkTheme.setText("Темная тема");
        }
        if(flagTheme){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            lightAndDarkTheme.setText("Светлая тема");
        }else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            lightAndDarkTheme.setText("Темная тема");
        }
        aboutMeText = findViewById(R.id.aboutMeText);
        aboutMeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                reviewManager = ReviewManagerFactory.create(AboutMe.this);
                Task<ReviewInfo> request = reviewManager.requestReviewFlow();
                request.addOnCompleteListener(new OnCompleteListener<ReviewInfo>() {
                    @Override
                    public void onComplete(@NonNull Task<ReviewInfo> task) {
                        if(task.isSuccessful()){
                            reviewInfo = task.getResult();
                            Task<Void> flow = reviewManager.launchReviewFlow(AboutMe.this,reviewInfo);
                            flow.addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void result) {

                                }
                            });
                        }else{
                            Toast.makeText(AboutMe.this, "error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        spinnerFacultet = findViewById(R.id.spinnerFacultet);
        spinnerDirection = findViewById(R.id.spinnerDirection);
        spinnerCource = findViewById(R.id.spinnerCource);
        spinnerSubgroupCource = findViewById(R.id.subgroupCource);
        //Первый запуск
        firstrun();
        //находим UserPhoto
        img = (ImageView) findViewById(R.id.userPhoto);
        userPhoto = (ImageView)findViewById(R.id.userPhoto);
        userPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int permissionStatus = ContextCompat.checkSelfPermission(AboutMe.this, Manifest.permission.READ_EXTERNAL_STORAGE);
                if (permissionStatus == PackageManager.PERMISSION_GRANTED){
                    CropImage.activity()
                            .setGuidelines(CropImageView.Guidelines.ON)
                            .start(AboutMe.this);
                }else{
                    ActivityCompat.requestPermissions(AboutMe.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                            PERMISSION);
                }
            }
        });
        //УСТАНОВКА USERPHOTO ИЗ ФАЙЛА
        loadImageFromStorage();
        //Обробатываем свайп
        main_layout = (ConstraintLayout) findViewById(R.id.main_layout);
        main_layout.setOnTouchListener(new Swipe(AboutMe.this) {
            @Override
            public void onSwipeRight() {
                if (TextUtils.isEmpty(userName.getText().toString().trim())){
                    userName.setError("Введите имя!");
                }else if(TextUtils.isEmpty(surName.getText().toString().trim())){
                    surName.setError("Введите фамилию!");
                }else {
                    Intent intent = new Intent(AboutMe.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(R.anim.diagonaltranslateleft,R.anim.alpha_one_zero);
                    if(mInterstitialAd != null){
                        mInterstitialAd.show(AboutMe.this);
                    }else{
                    }
                }
            }
        });

        sharedPreferences = this.getSharedPreferences("userdata", Context.MODE_PRIVATE);
        elementSpinnerDirection = sharedPreferences.getString("elementSpinnerDirection", "ИСиТ");
        elementSpinnerDirectionInt = sharedPreferences.getInt("elementSpinnerDirectionInt", 0);
        userName.setFilters(new InputFilter[]{new InputFilter.LengthFilter(12)});

        surName.setFilters(new InputFilter[]{new InputFilter.LengthFilter(12)});

        SpinnerItem();

        setData();

        //Кнопка для редактирования расписания
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                Intent intentBack;
                if (user != null) {
                    intentBack = new Intent(AboutMe.this,
                            EditSchduleActivity.class);
                }else{
                    intentBack = new Intent(AboutMe.this,
                            LoginEditSchduleActivity.class);
                }
                startActivity(intentBack);
                finish();
                overridePendingTransition(R.anim.alpha_zero_one, R.anim.alpha_one_zero);
            }
        });
    }
    private void firstrun() {
        if (prefs.getBoolean("firstrunAboutMe", true)) {
            elementSpinnerDirection = "ИСиТ";
            prefs.edit().putBoolean("firstrunAboutMe", false).apply();
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

    @Override
    protected void onStart() {
        super.onStart();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    private void loadImageFromStorage() {
        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        // path to /data/data/yourapp/app_data/imageDir
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        String path = directory.toString() + "/";
        try {
            f = new File(path, "phone.jpg");
            Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
            Picasso.with(AboutMe.this).load(f).transform(new CircularTransformation(150)).noPlaceholder().centerCrop().fit()
                    .into(img);
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
    }

    //МЕТОД ONPAUSE - НАЧАЛО
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("themey","onPause");
        saveData();
    }

    private void IntentInGallery(){
        CropImage.activity().start(AboutMe.this);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case PERMISSION:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    IntentInGallery();
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case CropImage.PICK_IMAGE_CHOOSER_REQUEST_CODE:
                if (resultCode == RESULT_OK) {
                    Uri selectedImage = CropImage.getPickImageResultUri(AboutMe.this, data);
                    if (CropImage.isReadExternalStoragePermissionsRequired(AboutMe.this, selectedImage)) {
                        uri = selectedImage;
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 0);
                        }
                    } else {
                        startCrop(selectedImage);
                    }
                }
                break;
            case CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE:
                CropImage.ActivityResult result = CropImage.getActivityResult(data);
                if (resultCode == RESULT_OK) {
                    Uri selectedImage = data.getData();
                    try {
                        InputStream imageStream = AboutMe.this.getContentResolver().openInputStream(result.getUri());
                        Bitmap bitmap = BitmapFactory.decodeStream(imageStream);
                        saveToInternalStorage(bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    Picasso.with(AboutMe.this).load(result.getUri()).transform(new CircularTransformation(150)).
                            noPlaceholder().centerCrop().fit()
                            .into((ImageView) findViewById(R.id.userPhoto));
                }
                break;
//            case GALLERY_REQUEST:
//                if (resultCode == RESULT_OK) {
//                    Uri selectedImage = imageReturnedIntent.getData();
//                    try {
//                        InputStream imageStream = getContentResolver().openInputStream(selectedImage);
//                        Bitmap bitmap = BitmapFactory.decodeStream(imageStream);
//                        saveToInternalStorage(bitmap);
//                    } catch (FileNotFoundException e) {
//                        e.printStackTrace();
//                    }
//                    Picasso.with(AboutMe.this).load(selectedImage).transform(new CircularTransformation(150)).noPlaceholder().centerCrop().fit()
//                            .into((ImageView) findViewById(R.id.userPhoto));
//                }
//                break;
        }
    }


    private void startCrop(Uri selectedImage) {
        CropImage.activity(selectedImage)
                .setAspectRatio(150, 150)
                .setCropShape(CropImageView.CropShape.OVAL)
                .setGuidelines(CropImageView.Guidelines.ON)
                .setMultiTouchEnabled(true)
                .start(AboutMe.this);
    }

    private String saveToInternalStorage(Bitmap bitmap) {
        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        // path to /data/data/yourapp/app_data/imageDir
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        // Create imageDir
        File mypath = new File(directory, "phone.jpg");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(mypath);
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmap.compress(Bitmap.CompressFormat.JPEG, 50, fos);
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("bitmap", "e = " + e);
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return directory.getAbsolutePath();
    }

    //ВЫБОРКА СПИННЕР ЭЛЕМЕНТОВ - НАЧАЛО
    public void SpinnerItem() {
        //SPINNER FACULTET
        final List<String> listFacultet = new ArrayList<String>() {{
            add("Магистерской подготовки");
        }};
        adapterFacultet = new CustomAdapter(this, R.layout.item_spinner_title, R.layout.item_spinner_dropdown, listFacultet);
        spinnerFacultet.setAdapter(adapterFacultet);
        spinnerFacultet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition, long selectedId) {
                elementSpinnerFacultet = spinnerFacultet.getSelectedItem().toString();
                elementSpinnerFacultetInt = selectedItemPosition;
                if (elementSpinnerFacultet.contentEquals("Магистерской подготовки")) {
                    List<String> listDirection = new ArrayList<String>() {{
                        add("Пр инф в упр фин");
                        add("Пр инф в дизайне");
                        add("Пр инф в юриспр");
                    }};
                    adapterDirection = new CustomAdapter(AboutMe.this, R.layout.item_spinner_title, R.layout.item_spinner_dropdown, listDirection);
                    spinnerDirection.setAdapter(adapterDirection);
                }
            }



            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //SPINNER DIRECTION
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
        final List<String> listCource = new ArrayList<String>() {{
            add("1");
            add("2");
            add("3");
            add("4");
        }};
        adapterCource = new CustomAdapter(this, R.layout.item_spinner_title, R.layout.item_spinner_dropdown, listCource);
        spinnerCource.setAdapter(adapterCource);

        spinnerCource.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition, long selectedId) {
                elementSpinnerCource = spinnerCource.getSelectedItem().toString();
                elementSpinnerCourceInt = selectedItemPosition;
//                if(elementSpinnerCource.contentEquals("1") && elementSpinnerFacultet.contentEquals("Информатики и Информационных Технологий")){
//                    List<String> listDirection = new ArrayList<String>() {{
//                        add("ИСиТ");
//                        add("ИБ");
//                        add("ИСиП");
//                        add("ПИЭ");
//                    }};
//                    adapterDirection = new CustomAdapter(AboutMe.this, R.layout.item_spinner_title, R.layout.item_spinner_dropdown, listDirection);
//                    spinnerDirection.setAdapter(adapterDirection);
//                    spinnerDirection.setSelection(elementSpinnerDirectionInt);
//                }else if(elementSpinnerFacultet.contentEquals("Информатики и Информационных Технологий")){
//                    List<String> listDirection = new ArrayList<String>() {{
//                        add("ИСиТ");
//                        add("ИБ");
//                        add("ПИМ");
//                        add("ПИЭ");
//                    }};
//                    adapterDirection = new CustomAdapter(AboutMe.this, R.layout.item_spinner_title, R.layout.item_spinner_dropdown, listDirection);
//                    spinnerDirection.setAdapter(adapterDirection);
//                    spinnerDirection.setSelection(elementSpinnerDirectionInt);
//                }
                if(!test){
                    Integer elementSpinnerDirectionInt2 = sharedPreferences.getInt("elementSpinnerDirectionInt", 0);
                    spinnerDirection.setSelection(elementSpinnerDirectionInt2);
                    test = true;
                }
            }



            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //SPINNER SUBGROUPCOURCE - НАЧАЛО
        final List<String> listSubgroupCource = new ArrayList<String>() {{
            add("И141");
            add("Т142");
            add("П141");
        }};
        adapterSubgroupCource = new CustomAdapter(this, R.layout.item_spinner_title, R.layout.item_spinner_dropdown, listSubgroupCource);
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
        if (TextUtils.isEmpty(userName.getText().toString().trim())){
            userName.setError("Введите имя!");
        }else if(TextUtils.isEmpty(surName.getText().toString().trim())){
            surName.setError("Введите фамилию!");
        }else {
            Intent intentBack = new Intent(this, MainActivity.class);
            startActivity(intentBack);
            finish();
            overridePendingTransition(R.anim.alpha_zero_one,R.anim.alpha_one_zero);
            if(mInterstitialAd != null){
                mInterstitialAd.show(AboutMe.this);
            }else{
            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view,
                               int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    //СОХРАНЯЕМ ДАННЫЕ С ПОМОЩЬЮ SHARED PREFERENCES - НАЧАЛО
    private void saveData() {
        userName = findViewById(R.id.userName);
        surName = findViewById(R.id.userSurName);
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
        Integer elementSpinnerDirectionInt = sharedPreferences.getInt("elementSpinnerDirectionInt", 0);

        spinnerFacultet.setSelection(elementSpinnerFacultetInt);
        spinnerDirection.setSelection(elementSpinnerDirectionInt);
        spinnerCource.setSelection(elementSpinnerCourceInt);
        spinnerSubgroupCource.setSelection(elementSpinnerSubgroupCourceInt);
        userName = findViewById(R.id.userName);
        userName.setText(setUserName);
        surName = findViewById(R.id.userSurName);
        surName.setText(setUserSurName);
        email = findViewById(R.id.Email);
        email.setText(getEmail);
    }

    public void LightAndDarkTheme(View view) {
        if(flagTheme){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            prefsTheme.edit().putBoolean("lightAndDarkTheme", false).apply();
            lightAndDarkTheme.setText("Светлая тема");
        }else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            prefsTheme.edit().putBoolean("lightAndDarkTheme", true).apply();
            lightAndDarkTheme.setText("Темная тема");
        }
    }
}
