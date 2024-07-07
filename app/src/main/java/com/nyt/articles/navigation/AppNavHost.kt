package com.nyt.articles.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.nyt.articles.popular.navigation.PopularArticles
import com.nyt.articles.popular.navigation.popularArticlesScreen
import com.nyt.popular.article.details.articleDetailsScreen
import com.nyt.popular.article.details.navigateToArticleDetails
import kotlin.reflect.KClass

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    startDestination: KClass<*> = PopularArticles::class,
) {
    val navController = rememberNavController()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        popularArticlesScreen { article ->
            navController.navigateToArticleDetails(article)
        }
        articleDetailsScreen()
    }
}
