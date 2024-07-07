package com.nyt.articles.popular.data.remote.di

import com.nyt.articles.popular.data.remote.datasource.NYTPopularRemoteArticlesDataSource
import com.nyt.articles.popular.data.remote.datasource.NYTPopularRemoteArticlesDataSourceImp
import com.nyt.articles.popular.data.remote.repository.PopularArticlesRepoImp
import com.nyt.articles.popular.domain.repo.PopularArticlesRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindsPopularArticlesDataSource(nytPopularArticlesDataSourceImp: NYTPopularRemoteArticlesDataSourceImp): NYTPopularRemoteArticlesDataSource

    @Binds
    abstract fun bindUserRepository(repoImp: PopularArticlesRepoImp): PopularArticlesRepo

}