package br.com.fabio.junior.zupflix.presentation.home.view

import android.os.Bundle
import br.com.fabio.junior.zupflix.R
import br.com.fabio.junior.zupflix.presentation.base.BaseActivity
import br.com.fabio.junior.zupflix.presentation.home.pager_adapter.HomePageAdapter
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity() {

    val fragmentAdapter = HomePageAdapter(supportFragmentManager)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        viewPagerMain.adapter = fragmentAdapter
        tabsMain.setupWithViewPager(viewPagerMain)


    }

}