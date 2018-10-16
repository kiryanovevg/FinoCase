package com.kiryanov.finocase

import android.app.Application
import com.evgeniy.royality.DI.AppComponent
import com.evgeniy.royality.DI.DaggerAppComponent
import com.kiryanov.finocase.di.modules.AndroidModule
import com.kiryanov.finocase.di.modules.NetModule
import com.kiryanov.finocase.di.modules.RepositoryModule

class App : Application() {

    companion object {
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        component = initDaggerComponent()
        component.inject(this)
    }

    private fun initDaggerComponent(): AppComponent {
        return DaggerAppComponent.builder()
                .netModule(NetModule(getString(R.string.base_url)))
                .androidModule(AndroidModule(this))
                .repositoryModule(RepositoryModule())
                .build()
    }
}