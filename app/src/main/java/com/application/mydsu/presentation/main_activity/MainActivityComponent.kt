package com.application.mydsu.presentation.main_activity

import dagger.Component

@Component
interface MainActivityComponent {
    fun inject(mainActivityViewModel: MainActivityViewModel)
}