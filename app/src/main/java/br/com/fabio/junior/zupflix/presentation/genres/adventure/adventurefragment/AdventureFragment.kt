package br.com.fabio.junior.zupflix.presentation.genres.adventure.adventurefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import br.com.fabio.junior.zupflix.BuildConfig
import br.com.fabio.junior.zupflix.R
import br.com.fabio.junior.zupflix.presentation.genres.adventure.adapter.AdventureFragmentAdapter
import br.com.fabio.junior.zupflix.presentation.genres.adventure.viewmodel.AdventureFragmentViewModel
import kotlinx.android.synthetic.main.fragment_adventure.*


class AdventureFragment: Fragment() {

    private val viewModel: AdventureFragmentViewModel by lazy { ViewModelProvider(this).get(AdventureFragmentViewModel::class.java) }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_adventure, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        activity?.let { fragmentActivity ->
            viewModel.genreLiveData.observe(fragmentActivity, Observer {
                it?.let {genresList ->
                    with(recyclerViewAdventureFragment){
                        layoutManager = GridLayoutManager(fragmentActivity, 2)
                        setHasFixedSize(true)
                        adapter = AdventureFragmentAdapter(genresList)
                    }
                }
            })
        }

        viewModel.getMovieByGenre(BuildConfig.API_KEY, "pt-BR", false, 28)
    }

}