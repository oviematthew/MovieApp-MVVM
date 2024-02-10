package com.example.lab2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab2.databinding.ActivityMainBinding
import com.example.lab2.model.Movies

class MainActivity : AppCompatActivity() {

    private val movieList = mutableListOf<Movies>()
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainActivityViewModel: MainActivityViewModel


    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //using binding to set the layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // initializing the movie adapter to "movielist" which is also a mutable list of movies in the adapter
        val movieAdapter = MovieAdapter(movieList)

        //initialize the ViewModel
        mainActivityViewModel = ViewModelProvider(this)
            .get(MainActivityViewModel::class.java)

        //listen to liveData
        mainActivityViewModel.movieLiveData.observe(this){movies ->
            //fetch all movies from view-model and notify changes made
            movieList.addAll(movies)
            movieAdapter.notifyDataSetChanged()
        }


        //To specify the vertical layout
        binding.rvMovies.layoutManager = LinearLayoutManager(this)
        binding.rvMovies.adapter = movieAdapter

        //on button click check for empty text and add movies
        handleButtonClick()
    }


    private fun handleButtonClick() {
        binding.saveBtn.setOnClickListener {
            val movieName = binding.nameText.text.toString().trim()
            val genre = binding.genreText.text.toString().trim()

            if (movieName.isNotEmpty() && genre.isNotEmpty()) {
                // Add a new movie with values from text fields
                val newMovie = Movies("Movie - $movieName", "Genre - $genre")

                // Add that movie to the ViewModel
                mainActivityViewModel.addToMovieList(newMovie)
            } else {
                // Show a message or handle the case when fields are empty
                showToast("Please enter both movie name and genre.")
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
