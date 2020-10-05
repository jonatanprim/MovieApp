package com.assessment.moviecatalog.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.assessment.moviecatalog.api.MovieResponse
import com.assessment.moviecatalog.model.Movie
import com.assessment.moviecatalog.network.ConfigNetwork
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieActivityRepository {

    val showProgress = MutableLiveData<Boolean>()
    val movieList = MutableLiveData<ArrayList<Movie>>()


    fun getMovieList(id : String){

        showProgress.value = true
        ConfigNetwork.instance.getMovieList(id).enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>?, t: Throwable?) {
                Log.d("Get Movie Error Server", t?.message.toString())
            }

            override fun onResponse(
                call: Call<MovieResponse>?,
                response: Response<MovieResponse>?
            ) {

                Log.d("Movie Response Server", response?.message().toString())

                if(response?.isSuccessful!!){

                    movieList.value = response.body().movies
                    showProgress.value = false
                }
            }

        })
    }

}