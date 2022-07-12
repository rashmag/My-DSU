package com.application.mydsu.data.main_activity

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.application.mydsu.domain.main_activity.repository.MainActivityRep

class MainActivityRepImpl(private val application: Application) : MainActivityRep {
    private var sharedPreferences: SharedPreferences? = null
    private var prefs: SharedPreferences? = null
    init {
        sharedPreferences = application.getSharedPreferences("userdata", Context.MODE_PRIVATE)
        prefs = application.getSharedPreferences("FirstRunMainActivity", Context.MODE_PRIVATE);
    }

    override fun saveFirstRunSwipe(value: Int) {
        prefs?.edit()?.putInt("FirstRunSwipeMainAcitivity", value)?.apply()
    }

    override fun saveFirstRun() {
        prefs?.edit()?.putBoolean("FirstRunMainActivity", false)?.apply()
    }

    override fun getFirstRun(): Boolean {
        return prefs?.getBoolean("FirstRunMainActivity", true) ?: true
    }

    override fun getFirstRunSwipe(): Int {
        return prefs?.getInt("FirstRunSwipeMainAcitivity", 1) ?: 1
    }

    override fun getDirection(): String? {
        return sharedPreferences?.getString("elementSpinnerDirection", "")
    }

    override fun getSubGroup(): String? {
        return sharedPreferences?.getString("elementSpinnerSubgroupCource", "")
    }

    override fun getName(): String? {
        return sharedPreferences?.getString("setUserName", "")
    }

    override fun getSurName(): String? {
        return sharedPreferences?.getString("setUserSurName", "")
    }
}