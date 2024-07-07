package com.nyt.articles.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.nyt.articles.presentation.R
import kotlinx.coroutines.Dispatchers

@Composable
fun NYTImage(
    modifier: Modifier = Modifier,
    imageUrl: String?,
    placeholder: Int = R.drawable.placeholder_image
) {
    val context = LocalContext.current
    val imageRequest = remember {
        ImageRequest.Builder(context)
            .data(imageUrl)
            .dispatcher(Dispatchers.IO)
            .memoryCacheKey(imageUrl)
            .diskCacheKey(imageUrl)
            .placeholder(placeholder)
            .error(placeholder)
            .fallback(placeholder)
            .diskCachePolicy(CachePolicy.ENABLED)
            .memoryCachePolicy(CachePolicy.ENABLED)
            .build()
    }
    AsyncImage(
        model = imageRequest,
        contentDescription = "Image Description",
        modifier = modifier,
        contentScale = ContentScale.Crop,
    )
}
