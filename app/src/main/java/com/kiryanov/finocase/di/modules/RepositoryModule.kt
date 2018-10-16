package com.kiryanov.finocase.di.modules

import android.content.Context
import com.kiryanov.finocase.data.Repository
import com.kiryanov.finocase.data.Api
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    internal fun provideRepository(api: Api, context: Context): Repository {
        return Repository(api, context)
    }
}