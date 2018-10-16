package com.evgeniy.royality.DI

import com.kiryanov.finocase.App
import com.kiryanov.finocase.di.modules.AndroidModule
import com.kiryanov.finocase.di.modules.NetModule
import com.kiryanov.finocase.di.modules.RepositoryModule
import com.kiryanov.finocase.mvp.LoginScreen.LoginPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidModule::class, NetModule::class, RepositoryModule::class])
interface AppComponent {
    //Injects
    fun inject(app: App)
    fun inject(app: LoginPresenter)
}