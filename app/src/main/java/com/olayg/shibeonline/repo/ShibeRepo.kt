package com.olayg.shibeonline.repo

import com.olayg.shibeonline.repo.remote.RetrofitInstance
import retrofit2.Response

object ShibeRepo {

    suspend fun getImages(count: Int): Response<List<String>> {
        return RetrofitInstance.shibeService.getImages(count, urls = true, httpsUrls = true)
    }

}