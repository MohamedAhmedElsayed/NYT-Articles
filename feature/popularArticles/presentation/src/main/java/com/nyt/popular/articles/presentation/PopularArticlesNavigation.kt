package com.nyt.popular.articles.presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
object PopularArticles

fun NavController.navigateToPopularArticles(navOptions: NavOptions? = null) {
    navigate(PopularArticles, navOptions)
}

fun NavGraphBuilder.popularArticlesScreen() {
    composable<PopularArticles> {
        PopularArticlesRoute()
    }
}
