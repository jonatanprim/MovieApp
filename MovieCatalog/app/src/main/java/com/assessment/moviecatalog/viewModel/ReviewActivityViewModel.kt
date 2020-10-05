package com.assessment.moviecatalog.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.assessment.moviecatalog.model.Genre
import com.assessment.moviecatalog.model.Review
import com.assessment.moviecatalog.repository.GenreActivityRepository
import com.assessment.moviecatalog.repository.ReviewActivityRepository

class ReviewActivityViewModel (application : Application) :AndroidViewModel(application) {

    private val repository = ReviewActivityRepository()

    val showProgress : LiveData<Boolean>
    val reviewList : LiveData<ArrayList<Review>>

    init{
        this.showProgress = repository.showProgress
        this.reviewList = repository.reviewList
    }

    fun getReviewList(id : String?){
        id?.let { repository.getReviewList(it) }
    }

}