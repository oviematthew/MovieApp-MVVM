package com.example.lab2

import android.graphics.Movie
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lab2.model.Movies


class MainActivityViewModel: ViewModel() {
    private val movieList = mutableListOf<Movies>()
    val movieLiveData = MutableLiveData<List<Movies>>()


    //value of liveData is set to the movielist which will keep updating
    init {
        movieLiveData.value = movieList
    }

    //function to add movie to list
    fun addToMovieList(movie: Movies){
        movieList.add(movie)
        movieLiveData.value = movieList
    }
}