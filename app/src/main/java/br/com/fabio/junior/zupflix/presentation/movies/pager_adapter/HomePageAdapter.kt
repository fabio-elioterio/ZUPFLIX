package br.com.fabio.junior.zupflix.presentation.movies.pager_adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import br.com.fabio.junior.zupflix.presentation.movies.homefragment.HomeFragment
import br.com.fabio.junior.zupflix.presentation.movies.searchfragment.SearchFragment

class HomePageAdapter(fm: FragmentManager): FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> SearchFragment()
            else -> HomeFragment()
        }
    }

    override fun getCount(): Int {
      return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "+Populares"
            1 -> "Pesquisa"
            else -> "+Populares"
        }
    }
}