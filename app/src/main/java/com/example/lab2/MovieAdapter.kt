package com.example.lab2

import android.annotation.SuppressLint
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
            // find the textview's from the created xml to be used
            movieName = view.findViewById(R.id.movieNameText)
            movieGenre = view.findViewById(R.id.movieGenreText)
        }
    }

    //set view to xml file created, and inflate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_layout, parent, false
        )
        return MovieViewHolder(view)
    }

    //return a the count of all items in the list (a mandatory method)
    override fun getItemCount(): Int {
        return movieList.count()
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        //binding the xml to the movielist parameters
        holder.movieName.text = movieList[position].name
        holder.movieGenre.text = movieList[position].genre
    }

}


