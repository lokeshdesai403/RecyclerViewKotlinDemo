package com.android4dev.recyclerview.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.android4dev.recyclerview.model.MovieModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_item_movie.view.*
import java.util.*

class MovieListStaggeredViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val mRandom = Random()
    fun bindView(movieModel: MovieModel) {
        itemView.textMovieTitle.text = movieModel.movieTitle
        itemView.textMovieViews.text = "Views: " + movieModel.movieViews
        itemView.textReleaseDate.text = "Release Date: " + movieModel.releaseDate
        itemView.imageMovie.layoutParams.height = getRandomIntInRange(250, 150)
        Glide.with(itemView.context).load(movieModel.moviePicture!!).into(itemView.imageMovie)
    }

    private fun getRandomIntInRange(max: Int, min: Int): Int {
        return mRandom.nextInt(max - min + min) + min
    }
}