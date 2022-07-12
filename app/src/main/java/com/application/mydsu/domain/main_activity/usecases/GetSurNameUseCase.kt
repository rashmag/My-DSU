package com.application.mydsu.domain.main_activity.usecases

import com.application.mydsu.domain.main_activity.repository.MainActivityRep
import javax.inject.Inject

class GetSurNameUseCase @Inject constructor(private val mainActivityRep: MainActivityRep) {
    fun getSurNameUseCase(): String? {
        return mainActivityRep.getSurName()
    }
}