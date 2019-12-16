package com.android4dev.recyclerview.callback

import com.android4dev.recyclerview.model.MovieModel

/***
 * @author Lokesh Desai (Android4Dev)
 */

//Interface to manage RecyclerView Clicks
interface RecyclerViewCallback {
    fun onRecycleViewItemClick(movieModel: MovieModel, position: Int)
    fun onRecycleViewLongPress(movieModel: MovieModel, position: Int)
}