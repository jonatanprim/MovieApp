package com.assessment.moviecatalog.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.assessment.moviecatalog.R
import com.assessment.moviecatalog.adapter.MovieAdapter
import com.assessment.moviecatalog.viewModel.MovieActivityViewModel
import kotlinx.android.synthetic.main.activity_movie.*

class MovieActivity : AppCompatActivity() {

    private lateinit var viewModel : MovieActivityViewModel
    private lateinit var mMovieAdapter : MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        val id = intent.getStringExtra("genre_id")
        recycler_movie.setHasFixedSize(true)
        recycler_movie.layoutManager = GridLayoutManager(this,2)

        viewModel = ViewModelProvider(this).get(MovieActivityViewModel::class.java)

        viewModel.getMovieList(id)

        viewModel.showProgress.observe(this, Observer {
            if(it)
                movie_progress.visibility = View.VISIBLE
            else
                movie_progress.visibility = View.GONE
        })

        viewModel.movieList.observe(this, Observer{
            mMovieAdapter.setMovieList(it)
        })

        mMovieAdapter = MovieAdapter(this)
        recycler_movie.adapter = mMovieAdapter

    }
}