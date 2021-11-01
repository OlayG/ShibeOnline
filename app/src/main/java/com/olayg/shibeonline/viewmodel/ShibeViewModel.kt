package com.olayg.shibeonline.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olayg.shibeonline.repo.ShibeRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShibeViewModel : ViewModel() {

    private val _shibes = MutableLiveData<List<String>>()
    val shibes: LiveData<List<String>> get() = _shibes


    fun getImages(count: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = ShibeRepo.getImages(count)
            val list = if (response.isSuccessful && !response.body().isNullOrEmpty())
                response.body()
            else listOf("ERROR")
            _shibes.postValue(list)
        }
    }
}