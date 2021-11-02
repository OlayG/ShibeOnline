package com.olayg.shibeonline.repo.remote

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("http://shibe.online")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val shibeService: ShibeService = retrofit.create(ShibeService::class.java)
}