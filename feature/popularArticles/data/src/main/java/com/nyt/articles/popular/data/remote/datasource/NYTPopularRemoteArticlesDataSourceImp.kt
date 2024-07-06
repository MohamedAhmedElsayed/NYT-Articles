package com.nyt.articles.popular.data.remote.datasource

import com.nyt.articles.popular.data.remote.service.PopularArticlesService
import javax.inject.Inject

class NYTPopularRemoteArticlesDataSourceImp @Inject constructor(private val popularService: PopularArticlesService) :
    NYTPopularRemoteArticlesDataSource {
    override suspend fun getPopularArticles(periodId: Int) =
        popularService.getMostPopularArticles(periodId)
}