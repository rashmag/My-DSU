package com.application.mydsu.domain.main_activity.usecases

import com.application.mydsu.domain.main_activity.repository.MainActivityRep
import javax.inject.Inject

class SaveFirstRunUseCase @Inject constructor(private val mainActivityRep: MainActivityRep) {
    fun saveFirstRunUseCase(){
        mainActivityRep.saveFirstRun()
    }
}