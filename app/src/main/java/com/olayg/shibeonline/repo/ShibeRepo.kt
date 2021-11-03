package com.olayg.shibeonline.repo

import com.olayg.shibeonline.repo.remote.RetrofitInstance
import retrofit2.Response

/**
 * Singleton that implements methods defined by Retrofit Services
 * @property getImages Get image urls from the API
 */
object ShibeRepo {

    /**
     * Get images from the Shibe API
     * @param count Number of urls to get
     * @return HTTP Response < List < String > >
     */
    suspend fun getImages(count: Int): Response<List<String>> {
        return RetrofitInstance.shibeService.getImages(count, urls = true, httpsUrls = true)
    }

}