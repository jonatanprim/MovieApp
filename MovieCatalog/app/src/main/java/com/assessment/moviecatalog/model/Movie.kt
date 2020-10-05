package com.assessment.moviecatalog.model

import com.google.gson.annotations.SerializedName


data class Movie
    (@SerializedName("poster_path")val posterPath: String,
     val id: String,
     val title: String
    )