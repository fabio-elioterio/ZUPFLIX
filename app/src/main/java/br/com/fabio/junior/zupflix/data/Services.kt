package br.com.fabio.junior.zupflix.data

import br.com.fabio.junior.zupflix.data.response.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Services {

    @GET("movie/popular")
    fun getMovies(@Query("api_key") apiKey: String): Call<MovieResponse>

    @GET("movie/{movie_id}/images")
    fun getImages(@Query("api_key") apiKey: String): Call<MovieResponse>

    @GET("genre/movie/list")
    fun getGenres(@Query("api_key") apiKey: String): Call<MovieResponse>
}