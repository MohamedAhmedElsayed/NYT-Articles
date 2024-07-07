package com.nyt.article.details.presentation.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun NYTHorizontalDivider() {
    Box(modifier = Modifier.fillMaxWidth()) {
        HorizontalDivider(
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f),
            thickness = 1.dp,
            modifier = Modifier
                .fillMaxWidth(.75f)
                .padding(8.dp)
                .align(Alignment.Center)

        )
    }
}

@Composable
fun RowWithDivider(modifier: Modifier = Modifier, key: String, value: String) {
    DetailsRow(
        modifier = modifier,
        key = key,
        value = value
    )
    NYTHorizontalDivider()
}

@Composable
fun DetailsRow(modifier: Modifier = Modifier, key: String, value: String) {
    Row(modifier = modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
        Text(text = key, style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = value, style = MaterialTheme.typography.bodyMedium)
    }
}
