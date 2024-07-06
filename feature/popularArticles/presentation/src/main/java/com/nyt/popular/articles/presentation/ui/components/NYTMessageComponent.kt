package com.nyt.popular.articles.presentation.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.nyt.articles.core.common.extentions.emptyIfNull

@Composable
fun NYTMessageComponent(modifier: Modifier = Modifier, message: String?) {
    Box(modifier = modifier.fillMaxSize()) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = message.emptyIfNull(),
            style = MaterialTheme.typography.labelLarge
        )
    }

}