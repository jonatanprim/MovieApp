package com.assessment.moviecatalog.api

import com.assessment.moviecatalog.model.Movie
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("results")
    var movies: ArrayList<Movie>
)