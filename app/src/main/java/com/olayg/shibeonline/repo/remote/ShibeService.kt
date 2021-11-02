package com.olayg.shibeonline.repo.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ShibeService {

    @GET("api/shibes") // Retrofit
    suspend fun getImages(

        @Query("count") // Retrofit
        count: Int,

        @Query("urls") // Retrofit
        urls: Boolean,

        @Query("httpsUrls") // Retrofit
        httpsUrls: Boolean,

    ): Response // HTTP Response Object
        <Array<String>>

}