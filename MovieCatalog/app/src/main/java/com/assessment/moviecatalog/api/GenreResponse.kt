package com.assessment.moviecatalog.api

import com.assessment.moviecatalog.model.Genre

data class GenreResponse(
    var genres: ArrayList<Genre>
)