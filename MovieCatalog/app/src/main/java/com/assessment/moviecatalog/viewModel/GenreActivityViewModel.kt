package com.assessment.moviecatalog.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.assessment.moviecatalog.model.Genre
import com.assessment.moviecatalog.repository.GenreActivityRepository

class GenreActivityViewModel (application : Application) :AndroidViewModel(application) {

    private val repository = GenreActivityRepository()
    val showProgress : LiveData<Boolean>
    val genreList : LiveData<ArrayList<Genre>>

    init{
        this.showProgress = repository.showProgress
        this.genreList = repository.genreList
    }

    fun getGenreList(){
        repository.getGenreList()
    }

}