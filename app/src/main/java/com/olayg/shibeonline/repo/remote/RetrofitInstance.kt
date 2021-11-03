package com.olayg.shibeonline.repo.remote

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Singleton that holds services created by Retrofit
 * @property shibeService ShibeService Instance
 */
object RetrofitInstance {

    /**
     * Instance of Retrofit
     */
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("http://shibe.online")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    /**
     * Instance of ShibeService created by Retrofit
     */
    val shibeService: ShibeService = retrofit.create(ShibeService::class.java)

}