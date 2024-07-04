package com.nyt.popular.articles.presentation.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.nyt.popular.articles.presentation.ui.screens.PopularArticlesRoute
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
