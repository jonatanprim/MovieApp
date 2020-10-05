package com.assessment.moviecatalog.network
import com.assessment.moviecatalog.BuildConfig
import com.assessment.moviecatalog.api.MovieDbApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class ConfigNetwork {

    companion object {


        val instance : MovieDbApi by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            retrofit.create(MovieDbApi::class.java)
        }
    }

}