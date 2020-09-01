package com.example.gadsleaderboard.network

import com.example.gadsleaderboard.model.TopLearningLeaderModel
import com.example.gadsleaderboard.model.TopSkillIqModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface TopLearnersAPi {

    @GET("api/hours")
    fun getTopLearningLeadersAsync(): Deferred<List<TopLearningLeaderModel>>

    @GET("api/skilliq")
    fun getTopSkillIqAsync(): Deferred<List<TopSkillIqModel>>


}
