package com.application.mydsu.presentation.main_activity

import com.application.mydsu.domain.main_activity.repository.MainActivityRep
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {
    @Provides
    fun provideMainActivityRep():MainActivityRep{
        return MainActivityRep
    }
}