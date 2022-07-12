package com.application.mydsu.presentation.main_activity

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.application.mydsu.domain.main_activity.usecases.*
import com.application.mydsu.domain.main_activity.usecases.load.LoadCourceUseCase
import com.application.mydsu.domain.main_activity.usecases.load.LoadThemeSharedUseCase
import javax.inject.Inject

class MainActivityViewModelFactory @Inject constructor(
    private val viewModels: @JvmSuppressWildcards Map<String,ViewModel>,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return viewModels[modelClass.simpleName] as T
    }
}