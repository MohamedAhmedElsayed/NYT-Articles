package com.nyt.articles.popular.domain.repo

import com.nyt.articles.popular.domain.model.PopularArticlesResponse

interface PopularArticlesRepo {
    suspend fun getMostPopularArticles(periodId: Int): PopularArticlesResponse
}