package com.olayg.shibeonline.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olayg.shibeonline.repo.ShibeRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShibeViewModel:

    ViewModel() // Lifecyle

{

    // Lifecycle
    private val _shibes = MutableLiveData<Array<String>>()

    // Lifecycle
    val shibes: LiveData<Array<String>> get() = _shibes


    fun getImages(count: Int) {

        viewModelScope // Lifecycle
            .launch(

                Dispatchers.IO // CoroutineScope

            ) {

                // Gets Data From Repo
                val response = ShibeRepo.getImages(count)

                // HTTP Response body
                val list = if (response.isSuccessful && !response.body().isNullOrEmpty()) response.body() else arrayOf("ERROR")

                _shibes.postValue(list!!)

            }
    }
}