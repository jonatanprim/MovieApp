package com.assessment.moviecatalog.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.assessment.moviecatalog.model.Movie
import com.assessment.moviecatalog.model.MovieDetail
import com.assessment.moviecatalog.repository.MovieActivityRepository
import com.assessment.moviecatalog.repository.MovieDetailActivityRepository

class MovieDetailActivityViewModel (application : Application) : AndroidViewModel(application){

    private val repository = MovieDetailActivityRepository()

    val showProgress : LiveData<Boolean>
    val movieDetail : LiveData<MovieDetail>

    init{
        this.showProgress = repository.showProgress
        this.movieDetail = repository.movieDetail
    }


    fun getMovieDetail(id: String?) {
        id?.let { repository.getMovieDetail(it) }
    }

}