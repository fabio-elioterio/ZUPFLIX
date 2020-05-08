package br.com.fabio.junior.zupflix.presentation.movies.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import br.com.fabio.junior.zupflix.R
import br.com.fabio.junior.zupflix.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_movie.*

class MovieActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        val thirdFragment = ThirdFragment()

        setCurrentFragment(firstFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.miHome -> setCurrentFragment(firstFragment)
                R.id.miFavorite -> setCurrentFragment(secondFragment)
                R.id.miSearch -> setCurrentFragment(thirdFragment)
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) = supportFragmentManager.beginTransaction()
        .apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
}
