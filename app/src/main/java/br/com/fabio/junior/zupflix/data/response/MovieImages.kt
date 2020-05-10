package br.com.fabio.junior.zupflix.data.response

import br.com.fabio.junior.zupflix.data.model.Image
import com.google.gson.annotations.SerializedName

data class MovieImages (

    @SerializedName("file_path")
    val filePath: String
){
    fun getImageModel() = Image (

        filePath = this.filePath
    )
}