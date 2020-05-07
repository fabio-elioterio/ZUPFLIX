package br.com.fabio.junior.zupflix.presentation.movies.view

import android.os.Bundle
import br.com.fabio.junior.zupflix.R
import br.com.fabio.junior.zupflix.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.toolbar.*

class MovieActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

    }
}
