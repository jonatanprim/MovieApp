package com.assessment.moviecatalog.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.assessment.moviecatalog.model.MovieDetail
import com.assessment.moviecatalog.network.ConfigNetwork
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDetailActivityRepository {

    val showProgress = MutableLiveData<Boolean>()
    val movieDetail = MutableLiveData<MovieDetail>()


    fun getMovieDetail(id : String){

        showProgress.value = true
        ConfigNetwork.instance.getMovieDetails(id).enqueue(object : Callback<MovieDetail> {
            override fun onFailure(call: Call<MovieDetail>?, t: Throwable?) {
                Log.d("Get Movie Error Server", t?.message.toString())
            }

            override fun onResponse(
                call: Call<MovieDetail>?,
                response: Response<MovieDetail>?
            ) {

                Log.d("Detail Response Server", response?.message().toString())

                if(response?.isSuccessful!!){

                    movieDetail.value = response.body()
                    showProgress.value = false
                }
            }

        })
    }

}