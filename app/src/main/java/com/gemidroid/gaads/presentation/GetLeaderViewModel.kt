package com.gemidroid.gaads.presentation

import androidx.lifecycle.ViewModel
import com.gemidroid.gaads.domain.GetLeadersUseCase

class GetLeaderViewModel(leadersUseCase: GetLeadersUseCase) : ViewModel() {

    init { leadersUseCase.execute(null) }

    val getLearningLeader = leadersUseCase.getLearningLeaders

    val getSkillIQLeader = leadersUseCase.getSkillIQLeaders

    val error = leadersUseCase.getError

    val status = leadersUseCase.getStatus

}