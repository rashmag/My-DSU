package com.application.mydsu.HomeWork;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    public long addUser(UserEntity userEntity);
    @Update
    public void updateUser(UserEntity userEntity);
    @Delete
    public void deleteUser(UserEntity userEntity);

    @Query("SELECT * FROM User")
    public List<UserEntity> getAllUser();

    @Query("SELECT * FROM User WHERE user_id ==:textId")
    public UserEntity getUser(long textId);
}
