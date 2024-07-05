package com.nyt.popular.articles.presentation.ui.viewmodel

import com.example.core.presentation.UiState
import com.nyt.popular.articles.presentation.model.Article
import com.nyt.popular.articles.presentation.model.Period
import com.nyt.popular.articles.presentation.model.popularArticlesPeriods

data class ArticlesListUiState(
    val periods: List<Period> = popularArticlesPeriods,
    val selectedPeriodId: Int = popularArticlesPeriods.first().id,
    val articles: List<Article> = listOf(Article(title = "imageUrl")),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
) : UiState