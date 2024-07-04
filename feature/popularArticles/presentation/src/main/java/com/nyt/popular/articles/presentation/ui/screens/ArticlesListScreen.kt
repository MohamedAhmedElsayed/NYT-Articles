package com.nyt.popular.articles.presentation.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nyt.popular.articles.presentation.model.popularArticlesPeriods
import com.nyt.popular.articles.presentation.ui.components.PeriodsHeader

//todos
//TODO collapse header and toolbar
@Composable
fun PopularArticlesRoute() {
    ArticlesListScreen()
}

@Composable
fun ArticlesListScreen() {
    var state by remember {
        mutableIntStateOf(1)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp), contentAlignment = Alignment.Center
    ) {
        PeriodsHeader(periodList = popularArticlesPeriods, state) {
            state = it

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArticlesListPreview() {
    ArticlesListScreen()
} 
