package com.application.mydsu.HomeWork;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "User")
public class UserEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    Integer id;
    @ColumnInfo(name = "userName")
    String userName;
    @ColumnInfo(name = "userSurName")
    String userSurName;
    @ColumnInfo(name = "selectedImpotence")
    int selectedImpotance;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserSurName(String userSurName) {
        this.userSurName = userSurName;
    }

    @Ignore
    public UserEntity() {
    }

    public UserEntity(Integer id, String userName, String userSurName,int selectedImpotance) {
        this.id = id;
        this.userName = userName;
        this.userSurName = userSurName;
        this.selectedImpotance = selectedImpotance;
    }

    public Integer getId() {
        return id;
    }

    public String getuserName() {
        return userName;
    }

    public int getSelectedImpotance() {
        return selectedImpotance;
    }

    public void setSelectedImpotance(int selectedImpotance) {
        this.selectedImpotance = selectedImpotance;
    }

    public String getUserSurName() {
        return userSurName;
    }
}
