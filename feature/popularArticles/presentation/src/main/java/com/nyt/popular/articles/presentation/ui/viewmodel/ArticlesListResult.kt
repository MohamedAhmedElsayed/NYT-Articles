package com.nyt.popular.articles.presentation.ui.viewmodel

import com.nyt.popular.articles.presentation.model.NYTArticle

sealed class ArticlesListResult {
    data class Success(val data: List<NYTArticle>) : ArticlesListResult()
    data class Error(val errorMessage: String) : ArticlesListResult()
}