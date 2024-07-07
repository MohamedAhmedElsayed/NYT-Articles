package com.nyt.popular.articles.presentation.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.nyt.articles.core.common.entity.NYTArticle
import com.nyt.articles.core.common.extentions.emptyIfNull
import com.nyt.articles.presentation.components.NYTImage
import com.nyt.popular.articles.presentation.R


@Composable
fun ArticleListItem(
    modifier: Modifier = Modifier,
    article: NYTArticle,
    onItemClick: (NYTArticle) -> Unit
) {

    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onItemClick(article) }
    ) {

        Column {
            NYTImage(
                modifier = Modifier
                    .fillMaxSize(),
                imageUrl = article.imageUrl,
                placeholder = R.drawable.placeholder_image
            )
            Text(
                text = article.title.emptyIfNull(),
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.bodyLarge.copy(color = Color.Black),
            )
        }

    }
}
