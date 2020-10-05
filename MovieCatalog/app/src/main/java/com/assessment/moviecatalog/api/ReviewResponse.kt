package com.assessment.moviecatalog.api

import com.assessment.moviecatalog.model.Review
import com.google.gson.annotations.SerializedName

data class ReviewResponse(
    @SerializedName("results")
    var reviews: ArrayList<Review>
)