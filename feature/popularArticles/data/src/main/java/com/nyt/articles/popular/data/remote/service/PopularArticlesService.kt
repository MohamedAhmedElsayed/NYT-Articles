package com.nyt.articles.popular.data.remote.service

import com.nyt.articles.core.data.BuildConfig
import com.nyt.articles.popular.data.remote.MOST_POPULAR_ARTICLES
import com.nyt.articles.popular.data.remote.entity.NYTArticleResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PopularArticlesService {
    @GET(MOST_POPULAR_ARTICLES)
    suspend fun getMostPopularArticles(
        @Path("period") period: Int,
        @Query("api-key") apiKey: String = BuildConfig.API_KEY
    ): NYTArticleResponse
}