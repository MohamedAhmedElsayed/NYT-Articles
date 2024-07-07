package com.nyt.articles.popular.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.nyt.articles.core.common.entity.NYTArticle
import com.nyt.popular.articles.presentation.ui.screens.PopularArticlesRoute
import kotlinx.serialization.Serializable

@Serializable
object PopularArticles

fun NavController.navigateToPopularArticles(navOptions: NavOptions? = null) {
    navigate(PopularArticles, navOptions)
}

fun NavGraphBuilder.popularArticlesScreen(onArticleClicked: (nytArticle: NYTArticle) -> Unit) {
    composable<PopularArticles> {
        PopularArticlesRoute(onArticleClicked)
    }
}
