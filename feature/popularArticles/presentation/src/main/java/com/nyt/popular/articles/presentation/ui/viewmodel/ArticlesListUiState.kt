package com.nyt.popular.articles.presentation.ui.viewmodel

import com.example.core.presentation.UiState
import com.nyt.articles.core.common.entity.NYTArticle
import com.nyt.popular.articles.presentation.model.Period
import com.nyt.popular.articles.presentation.model.popularArticlesPeriods

data class ArticlesListUiState(
    val periods: List<Period> = popularArticlesPeriods,
    val selectedPeriodId: Int = popularArticlesPeriods.first().id,
    val articles: List<NYTArticle> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
) : UiState