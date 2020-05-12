package br.com.fabio.junior.zupflix.presentation.base

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

open class BaseActivity: AppCompatActivity() {

    protected fun setupToolbar(toolbar: Toolbar, titleIdRes: Int, showBackButton: Boolean = false) {
        toolbar.title = getString(titleIdRes)
        toolbar.setTitleTextColor(Color.WHITE)
        setSupportActionBar(toolbar)
    }

}