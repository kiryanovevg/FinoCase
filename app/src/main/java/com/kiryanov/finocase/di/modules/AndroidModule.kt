package com.kiryanov.finocase.di.modules

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.kiryanov.finocase.USER_DATA
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AndroidModule(private val application: Application) {

    @Provides
    @Singleton
    internal fun provideApplicationContext(): Context {
        return application
    }

    @Provides
    @Singleton
    internal fun provideSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(USER_DATA, Context.MODE_PRIVATE)
    }
}