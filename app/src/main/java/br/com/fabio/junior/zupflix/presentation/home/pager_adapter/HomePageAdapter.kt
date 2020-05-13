package br.com.fabio.junior.zupflix.presentation.home.pager_adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import br.com.fabio.junior.zupflix.presentation.genres.adventure.adventurefragment.AdventureFragment
import br.com.fabio.junior.zupflix.presentation.genres.animation.animationFragement.AnimationFragment
import br.com.fabio.junior.zupflix.presentation.home.HomeFragment
import br.com.fabio.junior.zupflix.presentation.movies.searchfragment.SearchFragment

class HomePageAdapter(fm: FragmentManager): FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> AdventureFragment()
            2 -> AnimationFragment()
            else -> HomeFragment()
        }
    }

    override fun getCount(): Int {
      return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "+Populares"
            1 -> "Aventura"
            2 -> "Animação"
            else -> null
        }
    }
}