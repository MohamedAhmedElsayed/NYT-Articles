package com.nyt.popular.articles.presentation.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.nyt.popular.articles.presentation.model.popularArticlesPeriods
import com.nyt.popular.articles.presentation.ui.components.ArticleListItem
import com.nyt.popular.articles.presentation.ui.components.PeriodsHeader
import com.nyt.popular.articles.presentation.ui.viewmodel.ArticlesListUiEvent
import com.nyt.popular.articles.presentation.ui.viewmodel.NYTArticlesViewModel

@Composable
fun PopularArticlesRoute() {

    ArticlesListScreen()
}

@Composable
fun ArticlesListScreen(viewModel: NYTArticlesViewModel = hiltViewModel()) {
    val currentState by viewModel.uiState.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp), contentAlignment = Alignment.TopCenter
    ) {
        Column {
            PeriodsHeader(periodList = popularArticlesPeriods, currentState.selectedPeriodId) {
                viewModel dispatch ArticlesListUiEvent.OnPeriodSelected(it)
            }
//            ErrorScreen()
            LazyColumn {
                items(currentState.articles) { article ->
                    ArticleListItem(article = article) {}
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArticlesListPreview() {
    ArticlesListScreen()
} 
