package com.nyt.popular.articles.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PopularArticlesRoute() {
    ArticlesListScreen()
}

@Composable
fun ArticlesListScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

    }
}

@Preview(showBackground = true)
@Composable
fun ArticlesListPreview() {
    ArticlesListScreen()
} 
