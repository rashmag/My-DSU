package com.application.mydsu.domain.main_activity.usecases

import com.application.mydsu.domain.main_activity.repository.MainActivityRep
import javax.inject.Inject

class LoadDirectionUseCase @Inject constructor(private val mainActivityRep: MainActivityRep) {
    operator fun invoke(): String {
        return mainActivityRep.loadDirection()
    }
}