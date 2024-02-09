package com.example.lab2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lab2.model.Movies

class MovieAdapter(private val movieList: MutableList<Movies>):
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    var count = 0
    inner class MovieViewHolder(view: View) : ViewHolder(view){
        var movieName: TextView
        var movieGenre: TextView

        init {
            movieName = view.findViewById(R.id.movieNameText)
            movieGenre = view.findViewById(R.id.movieGenreText)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_layout, parent, false
        )
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movieList.count()
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.movieName.text = movieList[position].name
        holder.movieGenre.text = movieList[position].genre
    }
}


