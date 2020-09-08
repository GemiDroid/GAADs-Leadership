package com.gemidroid.gaads.data.repository.leader

import com.gemidroid.gaads.data.model.leader.Learning
import com.gemidroid.gaads.data.model.leader.SkillIQ
import io.reactivex.rxjava3.core.Single

interface LeaderRepository {
    fun getLearningLeaders(): Single<List<Learning>>
    fun getSkillIQLeaders(): Single<List<SkillIQ>>
}