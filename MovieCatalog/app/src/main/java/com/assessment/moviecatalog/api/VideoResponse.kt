package com.assessment.moviecatalog.api

import com.assessment.moviecatalog.model.Videos
import com.google.gson.annotations.SerializedName

data class VideoResponse(
    @SerializedName("results")
    var videos : List<Videos>
)