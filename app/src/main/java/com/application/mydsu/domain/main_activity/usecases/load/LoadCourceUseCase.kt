package com.application.mydsu.domain.main_activity.usecases.load

import com.application.mydsu.domain.main_activity.repository.MainActivityRep
import javax.inject.Inject

class LoadCourceUseCase @Inject constructor(private val mainActivityRep: MainActivityRep) {
    operator fun invoke(): String{
        return mainActivityRep.loadCource()
    }
}