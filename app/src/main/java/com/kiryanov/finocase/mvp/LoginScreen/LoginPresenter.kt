package com.kiryanov.finocase.mvp.LoginScreen

import android.content.Context
import android.os.Handler
import com.arellomobile.mvp.InjectViewState
import com.kiryanov.finocase.App
import com.kiryanov.finocase.R
import com.kiryanov.finocase.data.MockData
import com.kiryanov.finocase.data.Repository
import com.kiryanov.finocase.mvp.BasePresenter
import javax.inject.Inject

@InjectViewState
class LoginPresenter : BasePresenter<LoginView>() {

    @Inject
    lateinit var repository: Repository

    @Inject
    lateinit var context: Context

    init {
        App.component.inject(this)
    }

    fun login(login: String, passwordHash: Int) {
        if (login.isEmpty() || passwordHash == 0) {
            viewState.showMessage(R.string.empty_fields)
            return
        }

        viewState.setLoadingProgressVisibility(true)
        Thread(Runnable {

            Thread.sleep(3000)

            Handler(context.mainLooper).post({
                if (MockData.getUser(login, passwordHash)) {
                    viewState.loginSuccessful()
                } else {
                    viewState.showMessage(R.string.login_failed)
                }

                viewState.setLoadingProgressVisibility(false)
            })
        }).start()
    }
}