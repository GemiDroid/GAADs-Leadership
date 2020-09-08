package com.gemidroid.gaads.data.model.leader

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SkillIQ(
    @SerializedName("name")
    val name: String,
    @SerializedName("score")
    val scores: Long,
    @SerializedName("country")
    val country: String,
    @SerializedName("badgeUrl")
    val badgeUrl: String
) : Serializable



