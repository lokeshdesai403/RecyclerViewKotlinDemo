package com.android4dev.recyclerview.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.android4dev.recyclerview.R
import com.android4dev.recyclerview.model.MovieModel

class MovieListHeaderAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var listOfMovies = listOf<MovieModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            CellType.HEADER.ordinal -> HeaderViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_recycler_header, parent, false))
            CellType.CONTENT.ordinal -> MovieListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_movie, parent, false))
            CellType.FOOTER.ordinal -> FooterViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_recycler_header, parent, false))
            else -> MovieListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_movie, parent, false))
        }
    }


    override fun getItemCount(): Int = listOfMovies.size + 2
    //add 2 size in itemcount because we are going to add header and footer cell in list

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            CellType.HEADER.ordinal -> {
                val headerViewHolder = holder as HeaderViewHolder
                headerViewHolder.bindView()
            }
            CellType.CONTENT.ordinal -> {
                val headerViewHolder = holder as MovieListViewHolder
                headerViewHolder.bindView(listOfMovies[position - 1])
            }
            CellType.FOOTER.ordinal -> {
                val footerViewHolder = holder as FooterViewHolder
                footerViewHolder.bindView()
            }
        }
    }


    /***
     * This method will return cell type base on position
     */
    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> CellType.HEADER.ordinal
            listOfMovies.size + 1 -> CellType.FOOTER.ordinal
            else -> CellType.CONTENT.ordinal
        }
    }

    /***
     * Enum class for recyclerview Cell type
     */
    enum class CellType(viewType: Int) {
        HEADER(0),
        FOOTER(1),
        CONTENT(2)
    }

    fun setMovieList(listOfMovies: List<MovieModel>) {
        this.listOfMovies = listOfMovies
        notifyDataSetChanged()
    }
}