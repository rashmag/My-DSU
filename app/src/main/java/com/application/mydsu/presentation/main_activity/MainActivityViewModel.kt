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
import com.application.mydsu.domain.main_activity.usecases.load.LoadCourceUseCase
import com.application.mydsu.domain.main_activity.usecases.load.LoadThemeSharedUseCase
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val getNameUseCase: LoadNameUseCase,
    private val getSurNameUseCase: LoadSurNameUseCase,
    private val getDirectionUseCase: LoadDirectionUseCase,
    private val getSubGroupUseCase: LoadCourceUseCase,
    private val getFirstRunSwipeUseCase: LoadFirstRunSwipeUseCase,
    private val getFirstRunUseCase: LoadFirstRunUseCase,
    private val saveFirstRunUseCase: SaveFirstRunUseCase,
    private val saveFirstRunSwipeUseCase: SaveFirstRunSwipeUseCase,
    private val loadThemeSharedUseCase: LoadThemeSharedUseCase
) : ViewModel() {


    private val _getNameList = MutableLiveData<String>()
    val getNameList: LiveData<String>
        get() = _getNameList

    private val _getSurNameList = MutableLiveData<String>()
    val getSurNameList: LiveData<String>
        get() = _getSurNameList

    private val _getDirectionList = MutableLiveData<String>()
    val getDirectionList: LiveData<String>
        get() = _getDirectionList

    private val _getCourceList = MutableLiveData<String>()
    val getCourceList: LiveData<String>
        get() = _getCourceList

    init {
        getUserData()
    }

    private fun getUserData() {
        getName()
        getSurName()
        getDirection()
        getCource()
        getFirstRunSwipe()
    }

    fun getFirstRun(): Boolean {
        if (getFirstRunUseCase.invoke()) {
            saveFirstRunUseCase.invoke()
            return getFirstRunUseCase.invoke()
        }
        return false
    }

    fun saveFirstRunSwipe(value: Int) {
        saveFirstRunSwipeUseCase.invoke(value)
    }

    fun getFirstRunSwipe(): Int {
        return getFirstRunSwipeUseCase.invoke()
    }

    private fun getName() {
        _getNameList.postValue(getNameUseCase.invoke())
    }

    private fun getSurName() {
        _getSurNameList.postValue(getSurNameUseCase.invoke())
    }

    private fun getDirection() {
        _getDirectionList.postValue(getDirectionUseCase.invoke())
    }

    private fun getCource() {
        _getCourceList.postValue(getSubGroupUseCase.invoke())
    }

    fun getTheme(): Boolean {
        return loadThemeSharedUseCase.invoke()
    }
}