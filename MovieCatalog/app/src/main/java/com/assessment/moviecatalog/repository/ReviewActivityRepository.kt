package com.assessment.moviecatalog.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.assessment.moviecatalog.api.ReviewResponse
import com.assessment.moviecatalog.model.Review
import com.assessment.moviecatalog.network.ConfigNetwork
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReviewActivityRepository {

    val showProgress = MutableLiveData<Boolean>()
    val reviewList = MutableLiveData<ArrayList<Review>>()


    fun getReviewList(id : String){

        showProgress.value = true
        ConfigNetwork.instance.getMovieReview(id).enqueue(object : Callback<ReviewResponse> {
            override fun onFailure(call: Call<ReviewResponse>?, t: Throwable?) {
                Log.d("Error Server", t?.message.toString())
            }

            override fun onResponse(
                call: Call<ReviewResponse>?,
                response: Response<ReviewResponse>?
            ) {

                Log.d("Review Response Server", response?.message().toString())

                if(response?.isSuccessful!!){

                    reviewList.value = response.body().reviews
                    showProgress.value = false
                }
            }

        })
    }

}