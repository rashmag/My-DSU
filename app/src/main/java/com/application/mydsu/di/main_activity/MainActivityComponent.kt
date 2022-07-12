package com.application.mydsu.di.main_activity

import com.application.mydsu.presentation.main_activity.MainActivity2
import dagger.Component

@Component(modules = [MainActivityModule::class, ViewModelModule::class])
interface MainActivityComponent {
    fun inject(mainActivity2: MainActivity2)
}