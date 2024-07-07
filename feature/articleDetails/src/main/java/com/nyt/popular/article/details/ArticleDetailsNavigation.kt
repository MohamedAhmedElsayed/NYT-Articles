package com.nyt.popular.article.details


import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.nyt.article.details.presentation.ui.ArticleDetailsRoute
import com.nyt.articles.core.common.entity.NYTArticle
import com.nyt.articles.presentation.navigation.NYTArticleNavType
import kotlinx.serialization.Serializable
import kotlin.reflect.typeOf


@Serializable
data class ArticleDetails(val nytArticle: NYTArticle)

fun NavController.navigateToArticleDetails(nytArticle: NYTArticle, navOptions: NavOptions? = null) {
    navigate(ArticleDetails(nytArticle), navOptions)
}

fun NavGraphBuilder.articleDetailsScreen() {
    composable<ArticleDetails>(
        typeMap = mapOf(typeOf<NYTArticle>() to NYTArticleNavType)
    ) {
        val nytArticle = it.toRoute<ArticleDetails>().nytArticle
        ArticleDetailsRoute(nytArticle)
    }
}

