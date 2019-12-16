package com.android4dev.recyclerview.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.android4dev.recyclerview.model.MovieModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_item_movie.view.*
import java.util.*

class MovieListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var itemClick: ((String) -> Unit)? = null
    var onItemLongPress: ((MovieModel) -> Unit)? = null

    fun bindView(movieModel: MovieModel) {
        itemView.textMovieTitle.text = movieModel.movieTitle
        itemView.textMovieViews.text = "Views: " + movieModel.movieViews
        itemView.textReleaseDate.text = "Release Date: " + movieModel.releaseDate

        Glide.with(itemView.context).load(movieModel.moviePicture!!).into(itemView.imageMovie)

//        //For Handling RecyclerView Item Click
        itemView?.setOnClickListener {

            //invoke() function will pass the value to receiver function.
            itemClick?.invoke(movieModel.movieTitle)
        }

        //For handling RecyclerView Item Long Click
        itemView?.setOnLongClickListener {
            onItemLongPress?.invoke(movieModel)
            return@setOnLongClickListener true
        }
    }

}