package com.example.gadsleaderboard.network

import com.example.gadsleaderboard.model.TopLearningLeaderModel
import com.example.gadsleaderboard.model.TopSkillIqModel
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.*

interface TopLearnersAPi {

    @GET("api/hours")
    fun getTopLearningLeadersAsync(): Deferred<List<TopLearningLeaderModel>>

    @GET("api/skilliq")
    fun getTopSkillIqAsync(): Deferred<List<TopSkillIqModel>>


    @POST
    @FormUrlEncoded
    fun submitProject(
        @Url url: String,
        @Field("entry.1877115667") firstName: String,
        @Field("entry.2006916086") lastName: String,
        @Field("entry.1824927963") email: String,
        @Field("entry.284483984") link: String
    ): Call<Void>


}
