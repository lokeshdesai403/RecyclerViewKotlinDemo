package com.android4dev.recyclerview.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.android4dev.recyclerview.R
import com.android4dev.recyclerview.model.MovieModel

class MovieListGridRecyclerAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var listOfMovies = listOf<MovieModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MovieListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_grid_movie, parent, false))
    }

    override fun getItemCount(): Int = listOfMovies.size

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val movieViewHolder = viewHolder as MovieListViewHolder
        movieViewHolder.bindView(listOfMovies[position])
    }

    fun setMovieList(listOfMovies: List<MovieModel>) {
        this.listOfMovies = listOfMovies
        notifyDataSetChanged()
    }
}