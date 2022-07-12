package com.application.mydsu.domain.main_activity.repository

interface MainActivityRep {
    fun getDirection(): String?
    fun getSubGroup(): String?
    fun getName(): String?
    fun getSurName(): String?
    fun getFirstRun(): Boolean
    fun getFirstRunSwipe(): Int
    fun saveFirstRun()
    fun saveFirstRunSwipe(value:Int)
}