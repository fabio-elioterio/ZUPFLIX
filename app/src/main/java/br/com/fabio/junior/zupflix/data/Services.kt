package br.com.fabio.junior.zupflix.data

import br.com.fabio.junior.zupflix.data.response.GenresResponse
import br.com.fabio.junior.zupflix.data.response.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Services {

    @GET("movie/popular")
    fun getMovies(@Query("api_key") apiKey: String, @Query("language") language: String): Call<MovieResponse>

    @GET("discover/movie")
    fun getMoviesByGenres(@Query("api_key") apiKey: String,
                          @Query("language") language: String,
                          @Query("include_adult") includeAdult: Boolean,
                          @Query("with_genres") withGenres: Int): Call<GenresResponse>
}

//https://api.themoviedb.org/3/discover/movie?api_key=75bfbbe0b3a304d4f5c247668c0566f4&language=pt-BR&include_adult=false&with_genres=28