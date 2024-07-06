package com.nyt.articles.popular.data.remote.di

import com.nyt.articles.popular.data.remote.datasource.NYTPopularRemoteArticlesDataSource
import com.nyt.articles.popular.data.remote.datasource.NYTPopularRemoteArticlesDataSourceImp
import com.nyt.articles.popular.data.remote.repository.PopularArticlesRepoImp
import com.nyt.articles.popular.data.remote.service.PopularArticlesService
import com.nyt.articles.popular.domain.repo.PopularArticlesRepo
import dagger.Binds
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

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun providePopularArticlesDataSource(nytPopularArticlesDataSourceImp: NYTPopularRemoteArticlesDataSourceImp): NYTPopularRemoteArticlesDataSource

    @Binds
    abstract fun bindUserRepository(repoImp: PopularArticlesRepoImp): PopularArticlesRepo

}