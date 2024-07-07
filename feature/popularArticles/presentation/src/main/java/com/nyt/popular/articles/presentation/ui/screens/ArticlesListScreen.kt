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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.nyt.articles.core.common.entity.NYTArticle
import com.nyt.articles.core.common.extentions.emptyIfNull
import com.nyt.articles.presentation.components.ErrorScreen
import com.nyt.popular.articles.presentation.R
import com.nyt.popular.articles.presentation.model.popularArticlesPeriods
import com.nyt.popular.articles.presentation.ui.components.ArticleListItem
import com.nyt.popular.articles.presentation.ui.components.Loading
import com.nyt.popular.articles.presentation.ui.components.NYTMessageComponent
import com.nyt.popular.articles.presentation.ui.components.PeriodsHeader
import com.nyt.popular.articles.presentation.ui.viewmodel.ArticlesListUiEvent
import com.nyt.popular.articles.presentation.ui.viewmodel.ArticlesListUiState
import com.nyt.popular.articles.presentation.ui.viewmodel.NYTArticlesViewModel

@Composable
fun PopularArticlesRoute(
    onArticleClicked: (nytArticle: NYTArticle) -> Unit,
    viewModel: NYTArticlesViewModel = hiltViewModel()
) {
    val articlesListUiState by viewModel.uiState.collectAsStateWithLifecycle()

    ArticlesListScreen(articlesListUiState, onArticleClicked = onArticleClicked) {
        viewModel dispatch ArticlesListUiEvent.OnPeriodSelected(it)
    }
}

@Composable
fun ArticlesListScreen(
    articlesListUiState: ArticlesListUiState,
    onArticleClicked: (nytArticle: NYTArticle) -> Unit,
    onPeriodSelected: (Int) -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp), contentAlignment = Alignment.TopCenter
    ) {
        Column {
            PeriodsHeader(
                periodList = popularArticlesPeriods,
                articlesListUiState.selectedPeriodId, onPeriodSelected = onPeriodSelected
            )
            when {
                articlesListUiState.errorMessage != null -> {
                    ErrorScreen(
                        errorTitle = stringResource(id = R.string.error),
                        errorDescription = articlesListUiState.errorMessage.emptyIfNull()
                    )
                }

                articlesListUiState.isLoading -> {
                    Loading()
                }

                articlesListUiState.articles.isEmpty() -> {
                    NYTMessageComponent(message = stringResource(id = R.string.empty_list))
                }

                else -> {
                    LazyColumn {
                        items(articlesListUiState.articles) { article ->
                            ArticleListItem(article = article, onItemClick = onArticleClicked)
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArticlesListPreview() {
    ArticlesListScreen(ArticlesListUiState(), onArticleClicked = {}, onPeriodSelected = {})
}
