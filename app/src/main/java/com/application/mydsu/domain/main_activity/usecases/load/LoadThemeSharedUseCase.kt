package com.application.mydsu.domain.main_activity.usecases.load

import com.application.mydsu.domain.main_activity.repository.MainActivityRep
import javax.inject.Inject

class LoadThemeSharedUseCase @Inject constructor(private val mainActivityRep: MainActivityRep){
    operator fun invoke():Boolean{
        return mainActivityRep.loadThemeShared()
    }
}