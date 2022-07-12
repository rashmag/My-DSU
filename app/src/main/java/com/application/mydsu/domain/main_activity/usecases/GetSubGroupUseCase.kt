package com.application.mydsu.domain.main_activity.usecases

import com.application.mydsu.domain.main_activity.repository.MainActivityRep
import javax.inject.Inject

class GetSubGroupUseCase @Inject constructor(private val mainActivityRep: MainActivityRep) {
    fun getSubGroupUseCase(): String? {
        return mainActivityRep.getSubGroup()
    }
}