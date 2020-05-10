package br.com.fabio.junior.zupflix.data.response

import br.com.fabio.junior.zupflix.data.model.Movie
import com.google.gson.annotations.SerializedName

data class MovieResults (

    @SerializedName("title")
    val title: String,
    @SerializedName("vote_average")
    val voteAverage: Float,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("popularity")
    val popularity: Double

){
    fun getMovieModel() = Movie (
        title = this.title,
        voteAverage = this.voteAverage,
        overview = this.overview,
        releaseDate = this.releaseDate,
        popularity = this.popularity
    )
}
