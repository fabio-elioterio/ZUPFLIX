package br.com.fabio.junior.zupflix.data.response

import com.google.gson.annotations.SerializedName

data class MovieResponse (

    @SerializedName("results")
    val movieResults: List<MovieResults>
)