package br.com.fabio.junior.zupflix.presentation.movies.homefragment.homefragmentviewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fabio.junior.zupflix.data.response.MovieResponse
import br.com.fabio.junior.zupflix.data.response.MovieResults
import br.com.fabio.junior.zupflix.presentation.movies.homefragment.repository.MovieRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragmentViewModel: ViewModel() {

    val movieLiveData: MutableLiveData<List<MovieResults>> = MutableLiveData()
    //val isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val repository = MovieRepository()

    fun getMovie(apiKey: String) {

        repository.getMovies(apiKey).enqueue(object : Callback<MovieResponse>{

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
            when{
                response.isSuccessful ->{
                    response.body()?.let {
                        movieLiveData.value = it.movieResults
                    }
                }
            }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e(HomeFragmentViewModel::class.java.simpleName, "ERROR: ${t.message}")
            }


        })
    }
}