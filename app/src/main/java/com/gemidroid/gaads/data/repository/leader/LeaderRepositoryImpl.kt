package com.gemidroid.gaads.data.repository.leader

import com.gemidroid.gaads.data.datasource.network.LeadersAPI
import com.gemidroid.gaads.data.model.leader.Learning
import com.gemidroid.gaads.data.model.leader.SkillIQ
import com.gemidroid.gaads.data.repository.leader.LeaderRepository
import io.reactivex.rxjava3.core.Single

class LeaderRepositoryImpl(private val leadersAPI: LeadersAPI) :
    LeaderRepository {
    override fun getLearningLeaders(): Single<List<Learning>> {
        return leadersAPI.getLearningLeaders()
    }

    override fun getSkillIQLeaders(): Single<List<SkillIQ>> {
        return leadersAPI.getSkillIQLeaders()
    }
}