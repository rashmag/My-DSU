package com.application.mydsu.di.main_activity

import androidx.lifecycle.ViewModel
import com.application.mydsu.presentation.main_activity.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
interface ViewModelModule {
    @IntoMap
    @StringKey("MainActivityViewModel")
    @Binds
    fun bindViewModel(mainActivityViewModel: MainActivityViewModel):ViewModel
}