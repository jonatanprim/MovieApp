package com.assessment.moviecatalog.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.assessment.moviecatalog.api.GenreResponse
import com.assessment.moviecatalog.model.Genre
import com.assessment.moviecatalog.network.ConfigNetwork
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GenreActivityRepository {

    val showProgress = MutableLiveData<Boolean>()
    val genreList = MutableLiveData<ArrayList<Genre>>()


    fun getGenreList(){

        showProgress.value = true
        ConfigNetwork.instance.getMovieGenre().enqueue(object : Callback<GenreResponse> {
            override fun onFailure(call: Call<GenreResponse>?, t: Throwable?) {
                Log.d("Error Server", t?.message.toString())
            }

            override fun onResponse(
                call: Call<GenreResponse>?,
                response: Response<GenreResponse>?
            ) {

                Log.d("Response Server", response?.message().toString())

                if(response?.isSuccessful!!){

                    genreList.value = response.body().genres
                    showProgress.value = false
                }
            }

        })
    }

}