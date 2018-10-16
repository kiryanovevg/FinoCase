package com.kiryanov.finocase.mvp.MainScreen

import android.support.v4.app.Fragment
import com.arellomobile.mvp.InjectViewState
import com.kiryanov.finocase.R
import com.kiryanov.finocase.mvp.BasePresenter
import com.kiryanov.finocase.mvp.InfoScreen.InfoFragment

@InjectViewState
class MainPresenter : BasePresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        setFragment(InfoFragment(), R.string.main)
    }

    fun setFragment(fragment: Fragment, title: Int) {
        viewState.setFragment(fragment)
        viewState.setToolbarTitle(title)
    }
}