package br.com.fabio.junior.zupflix.presentation.genres.adventure.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fabio.junior.zupflix.data.response.GenresResponse
import br.com.fabio.junior.zupflix.data.response.GenresResults
import br.com.fabio.junior.zupflix.presentation.genres.respository.GenresRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AdventureFragmentViewModel: ViewModel() {

    val genreLiveData: MutableLiveData<List<GenresResults>> = MutableLiveData()
    val repository = GenresRepository()

    fun getMovieByGenre(apiKey: String, language: String, includeAdult: Boolean, withGenres: Int) {

        repository.getMoviesByGenres(apiKey, language, includeAdult, withGenres).enqueue(object : Callback<GenresResponse>{

            override fun onResponse(call: Call<GenresResponse>, response: Response<GenresResponse>){
                when{
                    response.isSuccessful ->{
                        response.body()?.let {
                            genreLiveData.value = it.genresResults
                        }
                    }
                }
            }

            override fun onFailure(call: Call<GenresResponse>, t: Throwable) {
                Log.d(AdventureFragmentViewModel::class.java.simpleName, "ERROR ${t.message}")
            }
        })
    }

}