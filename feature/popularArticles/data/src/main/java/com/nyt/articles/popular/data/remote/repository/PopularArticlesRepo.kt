package com.nyt.articles.popular.data.remote.repository

import com.nyt.articles.core.data.remote.model.RemoteError.GeneralError.toErrorMessage
import com.nyt.articles.core.data.remote.model.Resource
import com.nyt.articles.core.data.remote.service.NetworkRemoteServiceCall
import com.nyt.articles.popular.data.remote.datasource.NYTPopularRemoteArticlesDataSource
import com.nyt.articles.popular.data.remote.mapper.mapToDomain
import com.nyt.articles.popular.domain.model.PopularArticlesResponse
import com.nyt.articles.popular.domain.repo.PopularArticlesRepo
import javax.inject.Inject

class PopularArticlesRepoImp @Inject constructor(private val remoteDataSource: NYTPopularRemoteArticlesDataSource) :
    PopularArticlesRepo, NetworkRemoteServiceCall {
    override suspend fun getMostPopularArticles(periodId: Int): PopularArticlesResponse {
        return when (val result =
            safeRemoteCall { remoteDataSource.getPopularArticles(periodId) }) {
            is Resource.Error -> PopularArticlesResponse.Error(result.remoteError.toErrorMessage())
            is Resource.Success -> PopularArticlesResponse.Success(result.data.mapToDomain())
        }
    }


}