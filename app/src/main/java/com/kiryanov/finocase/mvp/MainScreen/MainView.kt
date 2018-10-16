package com.kiryanov.finocase.mvp.MainScreen

import android.support.v4.app.Fragment
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView : MvpView {

    @StateStrategyType(SkipStrategy::class)
    fun setFragment(fragment: Fragment)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun setToolbarTitle(title: Int)
}