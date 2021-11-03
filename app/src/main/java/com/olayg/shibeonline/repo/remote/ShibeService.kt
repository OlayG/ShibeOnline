package com.olayg.shibeonline.repo.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ShibeService {

    @GET("api/shibes")
    suspend fun getImages(
        @Query("count") count: Int,
        @Query("urls") urls: Boolean,
        @Query("httpsUrls") httpsUrls: Boolean,
    ): Response<List<String>>
}