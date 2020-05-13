package br.com.fabio.junior.zupflix.data.response

import com.google.gson.annotations.SerializedName

data class GenresResponse (

   @SerializedName("results")
   val genresResults: List<GenresResults>
)