package com.kiryanov.finocase.mvp.LoginScreen

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.kiryanov.finocase.R
import com.kiryanov.finocase.mvp.MainScreen.MainActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : MvpAppCompatActivity(), LoginView {

    @InjectPresenter
    lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.setTitle(R.string.activity_login_title)

        sign_in.setOnClickListener {
            presenter.login(et_login.text.toString(), et_password.text.toString().hashCode())
        }
    }

    override fun setLoadingProgressVisibility(visibility: Boolean) {
        loading.visibility = if (visibility) View.VISIBLE else View.GONE
        root.visibility = if (visibility) View.GONE else View.VISIBLE
    }

    override fun loginSuccessful() {
        val intent = Intent(this, MainActivity::class.java)

        startActivity(intent)
        finish()
    }

    override fun showMessage(msg: Int) {
        Snackbar.make(coordinator_layout, msg, Snackbar.LENGTH_LONG).show()
    }
}