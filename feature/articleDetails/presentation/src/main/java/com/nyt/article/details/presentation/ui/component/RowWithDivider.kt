package com.nyt.article.details.presentation.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun RowWithDivider(modifier: Modifier = Modifier, key: String, value: String) {
    DetailsRow(
        modifier = modifier,
        key = key,
        value = value
    )
    NYTHorizontalDivider()
}
