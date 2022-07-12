package com.application.mydsu.presentation.main_activity

import android.app.Application
import android.content.Intent
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.application.mydsu.Tutorial.ActivityStart
import com.application.mydsu.data.main_activity.MainActivityRepImpl
import com.application.mydsu.domain.main_activity.usecases.*

class MainActivityViewModel (application: Application): ViewModel(){
    private val mainActivityRep = MainActivityRepImpl(application)
    private val getNameUseCase = GetNameUseCase(mainActivityRep)
    private val getSurNameUseCase = GetSurNameUseCase(mainActivityRep)
    private val getDirectionUseCase = GetDirectionUseCase(mainActivityRep)
    private val getSubGroupUseCase = GetSubGroupUseCase(mainActivityRep)
    private val getFirstRunSwipeUseCase = GetFirstRunSwipeUseCase(mainActivityRep)
    private val getFirstRunUseCase = GetFirstRunUseCase(mainActivityRep)
    private val saveFirstRunUseCase = SaveFirstRunUseCase(mainActivityRep)
    private val saveFirstRunSwipeUseCase = SaveFirstRunSwipeUseCase(mainActivityRep)

    private val _getNameList = MutableLiveData<String>()
    val getNameList: LiveData<String>
        get() = _getNameList

    private val _getSurNameList = MutableLiveData<String>()
    val getSurNameList: LiveData<String>
        get() = _getSurNameList

    private val _getDirectionList = MutableLiveData<String>()
    val getDirectionList: LiveData<String>
        get() = _getDirectionList

    private val _getSubGroupList = MutableLiveData<String>()
    val getSubGroupList: LiveData<String>
        get() = _getSubGroupList

    private val _getFirstRunSwipeList = MutableLiveData<Int>()
    val getFirstRunSwipeList: LiveData<Int>
        get() = _getFirstRunSwipeList

    private val _getFirstRunList = MutableLiveData<Boolean>()
    val getFirstRunList: LiveData<Boolean>
        get() = _getFirstRunList

    init {
        getUserData()
    }

    private fun getUserData() {
        getName()
        getSurName()
        getDirection()
        getSubGroup()
        getFirstRunSwipe()
        getFirstRun()
    }


    private fun getFirstRun(){
        if(getFirstRunUseCase.getFirstRunUseCase()){
            _getFirstRunList.postValue(getFirstRunUseCase.getFirstRunUseCase())
            saveFirstRunUseCase.saveFirstRunUseCase()
        }
        if (getFirstRunSwipeUseCase.getFirstRunSwipeUseCase() != 0) {
            _getFirstRunSwipeList.postValue(getFirstRunSwipeUseCase.getFirstRunSwipeUseCase())
        }
    }
    fun saveFirstRunSwipe(value:Int){
        saveFirstRunSwipeUseCase.saveFirstRunSwipeUseCase(value)
    }
    fun getFirstRunSwipe():Int{
        return getFirstRunSwipeUseCase.getFirstRunSwipeUseCase()
    }

    private fun getName(){
        _getNameList.postValue(getNameUseCase.getNameUseCase())
    }
    private fun getSurName(){
        _getSurNameList.postValue(getSurNameUseCase.getSurNameUseCase())
    }
    private fun getDirection(){
        _getDirectionList.postValue(getDirectionUseCase.getDirectionUseCase())
    }
    private fun getSubGroup(){
        _getSubGroupList.postValue(getSubGroupUseCase.getSubGroupUseCase())
    }
}