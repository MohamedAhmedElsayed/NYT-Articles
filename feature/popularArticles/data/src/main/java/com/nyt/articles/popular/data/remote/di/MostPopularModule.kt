package com.nyt.articles.popular.data.remote.di

import com.nyt.articles.popular.data.remote.service.PopularArticlesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class MostPopularModule {

    @Provides
    @Singleton
    fun provideArticlesService(retrofit: Retrofit): PopularArticlesService =
        retrofit.create(PopularArticlesService::class.java)

}

