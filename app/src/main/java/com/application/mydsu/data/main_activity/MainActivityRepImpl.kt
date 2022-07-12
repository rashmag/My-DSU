package com.application.mydsu.data.main_activity

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.application.mydsu.R
import com.application.mydsu.domain.main_activity.repository.MainActivityRep

class MainActivityRepImpl(private val application: Application) : MainActivityRep {
    private var sharedPreferences: SharedPreferences? = null
    private var prefs: SharedPreferences? = null
    private var prefsTheme: SharedPreferences? = null
    init {
        sharedPreferences = application.getSharedPreferences("userdata", Context.MODE_PRIVATE)
        prefs = application.getSharedPreferences("FirstRunMainActivity", Context.MODE_PRIVATE);
        prefsTheme = application.getSharedPreferences("Theme", Context.MODE_PRIVATE)
    }

    override fun loadThemeShared(): Boolean {
        return prefsTheme?.getBoolean("lightAndDarkTheme", false) ?: false
    }

    override fun saveFirstRunSwipe(value: Int) {
        prefs?.edit()?.putInt("FirstRunSwipeMainAcitivity", value)?.apply()
    }

    override fun saveFirstRun() {
        prefs?.edit()?.putBoolean("FirstRunMainActivity", false)?.apply()
    }

    override fun loadFirstRun(): Boolean {
        return prefs?.getBoolean("FirstRunMainActivity", true) ?: true
    }

    override fun loadFirstRunSwipe(): Int {
        return prefs?.getInt("FirstRunSwipeMainAcitivity", 1) ?: 1
    }

    override fun loadDirection(): String {
        return sharedPreferences?.getString("elementSpinnerDirection", "") + ", " +
                sharedPreferences?.getString("setElementSpinnerCource", "") + " " + application.getString(R.string.course)
    }

    override fun loadCource(): String {
        return sharedPreferences?.getString("setElementSpinnerCource", "") + " " +application.getString(R.string.plugOneCource)
    }

    override fun loadName(): String {
        return sharedPreferences?.getString("setUserName", "") ?: application.getString(R.string.plugName)
    }

    override fun loadSurName(): String {
        return sharedPreferences?.getString("setUserSurName", "") ?: application.getString(R.string.plugSurName)
    }
}