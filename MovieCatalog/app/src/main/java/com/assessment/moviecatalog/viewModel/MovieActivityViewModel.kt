package com.assessment.moviecatalog.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.assessment.moviecatalog.model.Movie
import com.assessment.moviecatalog.repository.MovieActivityRepository

class MovieActivityViewModel (application : Application) : AndroidViewModel(application){

    private val repository = MovieActivityRepository()

    val showProgress : LiveData<Boolean>
    val movieList : LiveData<ArrayList<Movie>>

    init{
        this.showProgress = repository.showProgress
        this.movieList = repository.movieList
    }


    fun getMovieList(id: String?) {
        id?.let { repository.getMovieList(it) }
    }

}