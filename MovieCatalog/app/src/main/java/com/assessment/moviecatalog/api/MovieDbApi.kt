package com.assessment.moviecatalog.api

import com.assessment.moviecatalog.BuildConfig
import com.assessment.moviecatalog.model.MovieDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface MovieDbApi {

    @GET("genre/movie/list?api_key="+BuildConfig.TMDB_API_KEY+"&language=en-US")
    fun getMovieGenre():Call<GenreResponse>

    @GET("discover/movie?api_key="+BuildConfig.TMDB_API_KEY+"&")
    fun getMovieList(@Query("with_genres") genreString : String ) : Call<MovieResponse>

    @GET("movie/{movie_id}?api_key="+BuildConfig.TMDB_API_KEY+"&language=en-US")
    fun getMovieDetails(@Path("movie_id") id: String): Call<MovieDetail>

    @GET("movie/{movie_id}/reviews?api_key="+BuildConfig.TMDB_API_KEY+"&language=en-US")
    fun getMovieReview(@Path("movie_id") id: String) : Call<ReviewResponse>


}