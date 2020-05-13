package br.com.fabio.junior.zupflix.presentation.home.homefragmentviewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fabio.junior.zupflix.data.response.MovieResponse
import br.com.fabio.junior.zupflix.data.response.MovieResults
import br.com.fabio.junior.zupflix.presentation.home.repository.MovieRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragmentViewModel: ViewModel() {

    val movieLiveData: MutableLiveData<List<MovieResults>> = MutableLiveData()
    //val isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val repository = MovieRepository()

    fun getMovie(apiKey: String, language: String) {

        repository.getMovies(apiKey, language).enqueue(object : Callback<MovieResponse>{

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                when{
                    response.isSuccessful ->{
                        response.body()?.let {movieResponse ->
                            movieLiveData.value = movieResponse.movieResults
                        }
                    }
                }
            }

            override fun onFailure(call: Call<MovieResponse>, error: Throwable) {
                Log.d(HomeFragmentViewModel::class.java.simpleName, "ERROR: ${error.message}")
            }


        })
    }
}