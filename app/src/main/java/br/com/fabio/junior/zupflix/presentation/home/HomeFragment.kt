package br.com.fabio.junior.zupflix.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import br.com.fabio.junior.zupflix.BuildConfig
import br.com.fabio.junior.zupflix.R
import br.com.fabio.junior.zupflix.presentation.home.adapter.HomeFragmentAdapter
import br.com.fabio.junior.zupflix.presentation.home.homefragmentviewmodel.HomeFragmentViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment: Fragment() {

    private val viewModel: HomeFragmentViewModel by lazy { ViewModelProvider(this).get(HomeFragmentViewModel::class.java) }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        activity?.let {fragmentActivity ->
            viewModel.movieLiveData.observe(fragmentActivity, Observer {
                it?.let {movieList ->
                    with(recyclerViewHome) {
                        layoutManager = GridLayoutManager(fragmentActivity, 2)
                        setHasFixedSize(true)
                        adapter = HomeFragmentAdapter(movieList) {movie ->
                            Toast.makeText(
                                fragmentActivity,
                                "Detalhe do filme ${movie.originalTitle}",
                                Toast.LENGTH_SHORT
                            ).show()

                        }
                    }
                }
            })
        }

        viewModel.getMovie(BuildConfig.API_KEY, language = "pt-BR")

    }

}