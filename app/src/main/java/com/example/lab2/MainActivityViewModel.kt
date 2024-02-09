package com.example.lab2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lab2.model.Movies


class MainActivityViewModel: ViewModel() {

    val movieLiveData = MutableLiveData<Movies>()

    init {
        movieLiveData.value =
    }

    fun addToMovieList(){

    }
}