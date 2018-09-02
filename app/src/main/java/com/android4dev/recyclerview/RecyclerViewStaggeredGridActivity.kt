package com.android4dev.recyclerview

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import com.android4dev.recyclerview.adapter.MovieListGridRecyclerAdapter
import com.android4dev.recyclerview.adapter.MovieListStaggeredAdapter
import com.android4dev.recyclerview.base.BaseActivity
import com.android4dev.recyclerview.model.MovieModel
import com.android4dev.recyclerview.recyclerview_helper.GridItemDecoration
import com.android4dev.recyclerview.recyclerview_helper.VerticalSpaceItemDecoration
import kotlinx.android.synthetic.main.activity_main.*

class RecyclerViewStaggeredGridActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }


    private fun initView() {
        recyclerViewMovies.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        //This will for default android divider
        recyclerViewMovies.addItemDecoration(GridItemDecoration(10, 2))

        val movieListAdapter = MovieListStaggeredAdapter()
        recyclerViewMovies.adapter = movieListAdapter
        movieListAdapter.setMovieList(generateDummyData())
    }

    private fun generateDummyData(): List<MovieModel> {
        val listOfMovie = mutableListOf<MovieModel>()

        var movieModel = MovieModel(1, "Avengers", 500, "16 Feb 2018", R.drawable.ic_avengers)
        listOfMovie.add(movieModel)

        movieModel = MovieModel(2, "Avengers: Age of Ultron", 400, "17 March 2018", R.drawable.ic_avengers_2)
        listOfMovie.add(movieModel)

        movieModel = MovieModel(3, "Iron Man 3", 550, "17 April 2018", R.drawable.ic_ironman_3)
        listOfMovie.add(movieModel)

        movieModel = MovieModel(4, "Avengers: Infinity War", 1500, "15 Jan 2018", R.drawable.ic_avenger_five)
        listOfMovie.add(movieModel)

        movieModel = MovieModel(5, "Thor: Ragnarok", 200, "17 March 2018", R.drawable.ic_thor)
        listOfMovie.add(movieModel)

        movieModel = MovieModel(6, "Black Panther", 250, "17 May 2018", R.drawable.ic_panther)
        listOfMovie.add(movieModel)

        movieModel = MovieModel(7, "Logan", 320, "17 Dec 2018", R.drawable.ic_logan)
        listOfMovie.add(movieModel)

        return listOfMovie
    }
}