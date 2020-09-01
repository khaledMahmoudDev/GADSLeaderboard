package com.example.gadsleaderboard.network

import com.example.gadsleaderboard.utils.TOP_LEARNERS_BASE_URL
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

val retrofit: Retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(TOP_LEARNERS_BASE_URL)
    .build()

object TopLearnersClient {
    val topLearnersService: TopLearnersAPi by lazy {
        retrofit.create(TopLearnersAPi::class.java)
    }
}

