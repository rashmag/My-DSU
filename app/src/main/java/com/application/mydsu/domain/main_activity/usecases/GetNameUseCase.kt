package com.application.mydsu.domain.main_activity.usecases

import com.application.mydsu.domain.main_activity.repository.MainActivityRep
import javax.inject.Inject

class GetNameUseCase @Inject constructor(private val mainActivityRep: MainActivityRep) {
    fun getNameUseCase(): String? {
        return mainActivityRep.getName()
    }
}