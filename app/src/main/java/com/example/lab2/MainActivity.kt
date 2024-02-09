package com.example.lab2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab2.databinding.ActivityMainBinding
import com.example.lab2.model.Movies

class MainActivity : AppCompatActivity() {

    private val movieList = mutableListOf<Movies>()

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainActivityViewModel: MainActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //initialize the ViewModel
        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        //listen to liveData
        mainActivityViewModel.movieLiveData.observe(this){movie ->

        }

        val movieAdapter = MovieAdapter(movieList, this)

        //To specify the vertical layout
        binding.rvMovies.layoutManager = LinearLayoutManager(this)
        binding.rvMovies.adapter = movieAdapter
        handleButtonClick()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun handleButtonClick() {
        binding.saveBtn.setOnClickListener{
            movieList.add(0, Movies(binding.nameText.text.toString(), binding.genreText.text.toString()))
            binding.rvMovies.adapter?.notifyDataSetChanged()
        }
    }

    private fun initMovies(){
        movieList.add(Movies("James Bond", "Action Comedy"))
    }
}
