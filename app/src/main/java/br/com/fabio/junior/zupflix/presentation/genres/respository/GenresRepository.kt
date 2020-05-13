package br.com.fabio.junior.zupflix.presentation.genres.respository

import br.com.fabio.junior.zupflix.data.ApiService
import br.com.fabio.junior.zupflix.data.response.GenresResponse
import retrofit2.Call

class GenresRepository {

    fun getMoviesByGenres(apiKey: String, language: String, includeAdult: Boolean, withGenres: Int): Call<GenresResponse> {
        return ApiService.services.getMoviesByGenres(apiKey, language, includeAdult, withGenres)
    }
}