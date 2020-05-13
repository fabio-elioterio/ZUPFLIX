package br.com.fabio.junior.zupflix.presentation.genres.animation.animationFragement

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
import br.com.fabio.junior.zupflix.presentation.genres.animation.adapter.AnimationFragmentAdapter
import br.com.fabio.junior.zupflix.presentation.genres.animation.viewModel.AnimationFragmentViewModel
import kotlinx.android.synthetic.main.fragment_animation.*

class AnimationFragment: Fragment() {

    private val viewModel: AnimationFragmentViewModel by lazy { ViewModelProvider(this).get(AnimationFragmentViewModel::class.java) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_animation, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        activity?.let {fragmentActivity ->
            viewModel.genreLiveData.observe(fragmentActivity, Observer {
                it?.let { genreList ->
                    with(recyclerViewAnimationFragment){
                        layoutManager = GridLayoutManager(fragmentActivity, 2)
                        setHasFixedSize(true)
                        adapter = AnimationFragmentAdapter(genreList)
                    }
                }
            })
        }

        viewModel.getMovieByGenre(BuildConfig.API_KEY, "pt-BR", false, 16)
    }
}