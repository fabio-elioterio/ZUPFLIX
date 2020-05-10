package br.com.fabio.junior.zupflix.data.response

import br.com.fabio.junior.zupflix.data.model.Genres
import com.google.gson.annotations.SerializedName

data class MovieGenres (

    @SerializedName("name")
    val name: String
){
    fun getGenresModel() = Genres (
        name = this.name
    )
}