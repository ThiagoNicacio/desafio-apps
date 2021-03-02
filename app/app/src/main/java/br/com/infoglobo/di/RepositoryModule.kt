package br.com.infoglobo.di

import br.com.infoglobo.data.api.ApiService
import br.com.infoglobo.data.repository.NewsRepositoryImpl
import br.com.infoglobo.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideNewsRepository(apiService: ApiService): NewsRepository {
        return NewsRepositoryImpl(apiService)
    }
}