package com.olayg.shibeonline.repo.remote

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {

    private val retrofit: Retrofit = Retrofit.Builder() // Retrofit
        .baseUrl("http://shibe.online") // Retrofit
        .addConverterFactory( // Retrofit

            MoshiConverterFactory.create() // Moshi

        ).build() // Retrofit


    val shibeService: ShibeService = retrofit.create( // Retrofit

        ShibeService::class.java // A Java Class Reference

    )
}