package com.application.mydsu.domain.main_activity.repository

interface MainActivityRep {
    fun loadDirection(): String
    fun loadCource(): String
    fun loadName(): String
    fun loadSurName(): String
    fun loadFirstRun(): Boolean
    fun loadFirstRunSwipe(): Int
    fun saveFirstRun()
    fun saveFirstRunSwipe(value:Int)
    fun loadThemeShared():Boolean
}