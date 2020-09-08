package com.gemidroid.gaads.data.datasource.network

import com.gemidroid.gaads.data.model.leader.Learning
import com.gemidroid.gaads.data.model.leader.SkillIQ
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface LeadersAPI {

    @GET("/api/hours")
    fun getLearningLeaders() : Single<List<Learning>>

    @GET("/api/skilliq")
    fun getSkillIQLeaders() : Single<List<SkillIQ>>

}