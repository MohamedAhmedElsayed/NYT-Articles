package com.nyt.article.details.presentation.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.nyt.article.details.presentation.R
import com.nyt.article.details.presentation.ui.component.DetailsRow
import com.nyt.article.details.presentation.ui.component.RowWithDivider
import com.nyt.articles.core.common.entity.NYTArticle
import com.nyt.articles.core.common.extentions.emptyIfNull
import com.nyt.articles.presentation.components.NYTImage

@Composable
fun ArticleDetailsRoute(nytArticle: NYTArticle) {
    ArticleDetailsScreen(nytArticle)

}

@Composable
fun ArticleDetailsScreen(nytArticle: NYTArticle) {
    val context = LocalContext.current
    Column(modifier = Modifier.fillMaxSize()) {
        NYTImage(
            imageUrl = nytArticle.imageUrl.emptyIfNull(),
            modifier = Modifier.aspectRatio(1.4f)
        )
        Spacer(modifier = Modifier.height(16.dp))
        RowWithDivider(
            key = stringResource(id = R.string.title),
            value = nytArticle.title.emptyIfNull()
        )
        RowWithDivider(
            key = stringResource(id = R.string.byline),
            value = nytArticle.byline.emptyIfNull()
        )
        RowWithDivider(
            key = stringResource(id = R.string.type),
            value = nytArticle.type.emptyIfNull()
        )
        RowWithDivider(
            key = stringResource(id = R.string.published_date),
            value = nytArticle.publishedDate.emptyIfNull()
        )
        DetailsRow(
            key = stringResource(id = R.string.updated_date),
            value = nytArticle.updated.emptyIfNull()
        )
        OutlinedButton(
            onClick = { openInBrowser(nytArticle.url.emptyIfNull(), context) }, modifier = Modifier
                .fillMaxWidth(.9f)
                .padding(top = 32.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = stringResource(id = R.string.open_in_browser))
        }
    }

}

fun openInBrowser(url: String, context: Context) {
    runCatching {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(intent)
    }.onFailure {
        Log.e("Error", "openInBrowser: $it")
    }
}
