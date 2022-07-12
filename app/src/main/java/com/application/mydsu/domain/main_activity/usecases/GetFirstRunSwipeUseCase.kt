package com.application.mydsu.domain.main_activity.usecases

import com.application.mydsu.domain.main_activity.repository.MainActivityRep
import javax.inject.Inject

class GetFirstRunSwipeUseCase @Inject constructor(private val mainActivityRep: MainActivityRep) {
    fun getFirstRunSwipeUseCase():Int{
        return mainActivityRep.getFirstRunSwipe()
    }
}