package com.application.mydsu.HomeWork;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.application.mydsu.InformationAboutTheApp;
import com.application.mydsu.MainActivity;
import com.application.mydsu.R;
import com.application.mydsu.Schedule;
import com.application.mydsu.Utils.Swipe;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.util.ArrayList;
import java.util.Collections;

public class HomeWork extends AppCompatActivity {
    private RecyclerView recyclerView;
    ArrayList<UserEntity> arrayList = new ArrayList<>();
    UserDataBase userDB;
    UserEntity UE = new UserEntity();
    RecyclerViewAdapter recyclerViewAdapter;
    private ImageView imageViewAdd;
    private ConstraintLayout home_work;
    private Dialog dialog;
    boolean flagTheme;
    private SharedPreferences prefsTheme = null;
    private InterstitialAd mInterstitialAd;
    private static final String TAG = "myLog1";
    int i = 0;
    private ImageView imageViewGreen, imageViewYellow, imageViewRed;
    private String strBackPressed;
    boolean imageGreen = false,imageYellow = false,imageRed = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_work);

        //ПРОВЕРЯЕМ КАКАЯ ТЕМА ВЫБРАНА
        prefsTheme = getSharedPreferences("Theme", MODE_PRIVATE);
        flagTheme = prefsTheme.getBoolean("lightAndDarkTheme", false);
        if(flagTheme){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
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

        imageViewAdd = findViewById(R.id.floatingActionButton);
        home_work = findViewById(R.id.home_work);
        home_work.setOnTouchListener(new Swipe(HomeWork.this) {
            @Override
            public void onSwipeRight() {
                stepBack();
            }
        });
        userDB = Room.databaseBuilder(this, UserDataBase.class,"UserDB").allowMainThreadQueries().build();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerViewAdapter = new RecyclerViewAdapter(arrayList, HomeWork.this);
        recyclerViewAdapter.setArrayList(arrayList);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setHasFixedSize(true);
        queryAllUserAsyncTask();

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT,0) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView,
                                  @NonNull RecyclerView.ViewHolder viewHolder,
                                  @NonNull RecyclerView.ViewHolder target) {
                int fromPosition = viewHolder.getAdapterPosition();
                int toPosition = target.getAdapterPosition();
                Collections.swap(arrayList,fromPosition,toPosition);
                recyclerView.getAdapter().notifyItemMoved(fromPosition,toPosition);
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                UserEntity entity = arrayList.get(viewHolder.getAdapterPosition());
                deleteUser(entity);
            }
        }).attachToRecyclerView(recyclerView);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView,
                                  @NonNull RecyclerView.ViewHolder viewHolder,
                                  @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                UserEntity entity = arrayList.get(viewHolder.getAdapterPosition());
                deleteUser(entity);
            }
        }).attachToRecyclerView(recyclerView);

        imageViewAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addUserAlertDialog(false,null,-1);
            }
        });

        Intent i = getIntent();
        strBackPressed = i.getStringExtra("backPressed");
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

//НАЖАТИЕ НА КНОПКУ НАЗАД
    @Override
    public void onBackPressed() {
        stepBack();
    }

    private void stepBack(){
        if(strBackPressed.equals("MainActivity")){
            try {
                Intent intentBack = new Intent(HomeWork.this, MainActivity.class);
                startActivity(intentBack);
                finish();
            } catch (Exception e) {

            }
        }else if(strBackPressed.equals("Schedule")){
            try {
                Intent intentBack = new Intent(HomeWork.this, Schedule.class);
                startActivity(intentBack);
                finish();
            } catch (Exception e) {

            }
        }else{
            try {
                Intent intentBack = new Intent(HomeWork.this, MainActivity.class);
                startActivity(intentBack);
                finish();
            } catch (Exception e) {

            }
        }
        overridePendingTransition(R.anim.diagonaltranslateleft, R.anim.alpha_one_zero);
        if(mInterstitialAd != null){
            mInterstitialAd.show(HomeWork.this);
        }else{
        }
    }

    public void addUserAlertDialog(final boolean isUpdate, final UserEntity userEntity, final int position) {
        dialog = new Dialog(HomeWork.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.add_user);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false); //ОКНО НЕЛЬЗЯ ЗАКРЫТЬ КНОПКОЙ НАЗАД
        final EditText userName = dialog.findViewById(R.id.task);
        final EditText surName = dialog.findViewById(R.id.description);
        imageGreen = false;
        imageYellow = false;
        imageRed = false;


        ImageView buttonGreen = dialog.findViewById(R.id.greeenSelectedImpotence);
        ImageView buttonYellow = dialog.findViewById(R.id.yellowSelectedImpotence);
        ImageView buttonRed = dialog.findViewById(R.id.redSelectedImpotence);
        imageViewGreen = dialog.findViewById(R.id.selectedGreen);
        imageViewYellow = dialog.findViewById(R.id.selectedYellow);
        imageViewRed = dialog.findViewById(R.id.selectedRed);
        buttonGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!imageGreen){
                    imageViewGreen.setVisibility(View.VISIBLE);
                    imageViewYellow.setVisibility(View.INVISIBLE);
                    imageViewRed.setVisibility(View.INVISIBLE);
                    i = 1;
                    imageGreen = true;
                }else{
                    imageViewGreen.setVisibility(View.INVISIBLE);
                    imageViewYellow.setVisibility(View.INVISIBLE);
                    imageViewRed.setVisibility(View.INVISIBLE);
                    i = 4;
                    imageGreen = false;
                }
            }
        });
        buttonYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!imageYellow){
                    imageViewYellow.setVisibility(View.VISIBLE);
                    imageViewGreen.setVisibility(View.INVISIBLE);
                    imageViewRed.setVisibility(View.INVISIBLE);
                    i = 2;
                    imageYellow = true;
                }else{
                    imageViewYellow.setVisibility(View.INVISIBLE);
                    imageViewGreen.setVisibility(View.INVISIBLE);
                    imageViewRed.setVisibility(View.INVISIBLE);
                    i = 4;
                    imageYellow = false;
                }
            }
        });
        buttonRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!imageRed){
                    imageViewRed.setVisibility(View.VISIBLE);
                    imageViewGreen.setVisibility(View.INVISIBLE);
                    imageViewYellow.setVisibility(View.INVISIBLE);
                    i = 3;
                    imageRed = true;
                }else{
                    imageViewRed.setVisibility(View.INVISIBLE);
                    imageViewGreen.setVisibility(View.INVISIBLE);
                    imageViewYellow.setVisibility(View.INVISIBLE);
                    i = 4;
                    imageRed = false;
                }
            }
        });

        ImageView imageView = dialog.findViewById(R.id.saveOrUpdateBtn);
        if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_add_task_dark));
        }
        if(isUpdate && userEntity != null){
            userName.setText(userEntity.getuserName());
            surName.setText(userEntity.getUserSurName());
            if(userEntity.getSelectedImpotance() == 1){
                imageViewGreen.setVisibility(View.VISIBLE);
            }else if(userEntity.getSelectedImpotance() ==2){
                imageViewYellow.setVisibility(View.VISIBLE);
            }else if(userEntity.getSelectedImpotance() ==3){
                imageViewRed.setVisibility(View.VISIBLE);
            }
        }
        ImageView dialogClose = (ImageView) dialog.findViewById(R.id.btnClose);
        dialogClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(userName.getText().toString()) && TextUtils.isEmpty(surName.getText().toString())){
                    userName.setError("Заполните поле");
                    surName.setError("Заполните поле");
                }else if(TextUtils.isEmpty(userName.getText().toString())){
                    userName.setError("Заполните поле");
                }else if(TextUtils.isEmpty(surName.getText().toString())){
                    surName.setError("Заполните поле");
                }else{
                    if(isUpdate && userEntity != null){
                        updateUser(
                                userName.getText().toString(),
                                surName.getText().toString(),i,
                                position);
                    }else{
                        addUserAsyncTask(userName.getText().toString(),
                                surName.getText().toString(),i);
                    }
                    dialog.dismiss();
                }
            }
        });

        dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
        dialog.show();
        dialog.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
    }
    private void addUserAsyncTask(String userName, String surName,int selectedImpotance){
        UserEntity userEntity = new UserEntity(UE.getId(),userName,surName,selectedImpotance);
        new addUser().execute(userEntity);
    }

    private class addUser extends AsyncTask<UserEntity,Void,Void> {
        @Override
        protected Void doInBackground(UserEntity... userEntities) {
            userDB.getUserDao().addUser(userEntities[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            queryAllUserAsyncTask();
        }
    }

    private void queryAllUserAsyncTask(){
        new queryAllUser().execute();
    }
    private class queryAllUser extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            arrayList = (ArrayList<UserEntity>) userDB.getUserDao().getAllUser();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            recyclerViewAdapter.setArrayList(arrayList);
        }
    }

    public void deleteUser(UserEntity entity){
        new deleteUser().execute(entity);
    }
    private class deleteUser extends AsyncTask<UserEntity,Void,Void>{

        @Override
        protected Void doInBackground(UserEntity... userEntities) {
            userDB.getUserDao().deleteUser(userEntities[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            queryAllUserAsyncTask();
        }
    }

    public void updateUser(String userName, String surName,int impotance,int position){
        UserEntity userEntity = arrayList.get(position);
        userEntity.setUserName(userName);
        userEntity.setUserSurName(surName);
        userEntity.setSelectedImpotance(impotance);
        new UpdateUser().execute(userEntity);
        arrayList.set(position,userEntity);
    }

    private class UpdateUser extends AsyncTask<UserEntity,Void,Void>{

        @Override
        protected Void doInBackground(UserEntity... userEntities) {
            userDB.getUserDao().updateUser(userEntities[0]);
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            queryAllUserAsyncTask();
        }
    }
}
