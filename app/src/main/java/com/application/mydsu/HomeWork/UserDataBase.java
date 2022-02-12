package com.application.mydsu.HomeWork;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {UserEntity.class},version = 1)
public abstract class UserDataBase extends RoomDatabase {
    public abstract UserDao getUserDao();
}
