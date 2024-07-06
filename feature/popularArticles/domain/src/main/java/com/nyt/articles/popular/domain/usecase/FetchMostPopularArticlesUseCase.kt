package com.nyt.articles.popular.domain.usecase

import com.nyt.articles.domain.SuspendableUseCase
import com.nyt.articles.popular.domain.model.PopularArticlesResponse
import com.nyt.articles.popular.domain.repo.PopularArticlesRepo
import javax.inject.Inject

class FetchMostPopularArticlesUseCase @Inject constructor(private val articlesRepo: PopularArticlesRepo) :
    SuspendableUseCase<Int, PopularArticlesResponse> {
    override suspend fun invoke(input: Int) =
        articlesRepo.getMostPopularArticles(input)


}