package com.example.lab2

import android.graphics.Movie
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lab2.model.Movies


class MainActivityViewModel: ViewModel() {
    val movie1 = Movies("Avatar", "Action")
    val movieLiveData = MutableLiveData<Movies>()

    init {
        movieLiveData.value = movie1
    }

    fun addToMovieList(){

    }
}