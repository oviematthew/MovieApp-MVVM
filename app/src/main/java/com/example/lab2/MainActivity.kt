package com.example.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.lab2.model.Movies

class MainActivity : AppCompatActivity() {

    private val movieList = mutableListOf<Movies>()
    private lateinit var rvMovieList: RecyclerView
    private lateinit var movieName: EditText
    private lateinit var movieGenre: EditText
    private lateinit var saveBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}