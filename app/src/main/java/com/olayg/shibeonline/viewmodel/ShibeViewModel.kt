package com.olayg.shibeonline.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olayg.shibeonline.repo.ShibeRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Class that executes methods in coroutines and stores LiveData
 * @property shibes Getter for list of image urls
 * @property getImages Get a number of image urls
 */
class ShibeViewModel : ViewModel() {

    private val _shibes = MutableLiveData<List<String>>()

    /**
     * Getter for list of image urls
     */
    val shibes: LiveData<List<String>> get() = _shibes

    /**
     * Get a number of image urls
     * @param count Number of images to get
     */
    fun getImages(count: Int) {

        // ViewModel / Coroutine Scope
        viewModelScope.launch(Dispatchers.IO) {

            // Response from repo
            val response = ShibeRepo.getImages(count)

            // Store response body or error
            val list = if (response.isSuccessful && !response.body().isNullOrEmpty())
                response.body()
                else listOf("ERROR")

            // If list is not null, post list to LiveData
            list?.let { urls -> _shibes.postValue(urls) }

        }

    }

}