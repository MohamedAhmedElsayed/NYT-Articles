package com.nyt.articles.popular.data.remote.datasource

import com.nyt.articles.popular.data.remote.entity.NYTArticleResponse

interface NYTPopularRemoteArticlesDataSource {
    suspend fun getPopularArticles(periodId: Int): NYTArticleResponse

}