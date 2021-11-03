package com.olayg.shibeonline.repo.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Service Interface for Retrofit
 * @property getImages Get images from API
 */
interface ShibeService {

    @GET("api/shibes")
    /**
     * Method for retrieving image urls (Retrofit)
     * @return HTTP Response < List < String > >
     */
    suspend fun getImages(

        @Query("count") count: Int,
        @Query("urls") urls: Boolean,
        @Query("httpsUrls") httpsUrls: Boolean,

    ): Response<List<String>>

}