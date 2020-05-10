package br.com.fabio.junior.zupflix.presentation.movies.repository

import br.com.fabio.junior.zupflix.data.ApiService
import br.com.fabio.junior.zupflix.data.response.MovieResponse
import retrofit2.Call

class MovieRepository {

    fun getMovies(apiKey: String): Call<MovieResponse> {
        return ApiService.services.getMovies(apiKey)
    }

    fun getImages(apiKey: String): Call<MovieResponse> {
        return ApiService.services.getImages(apiKey)
    }

    fun getGenres(apiKey: String): Call<MovieResponse> {
        return ApiService.services.getGenres(apiKey)
    }
}