package com.nyt.popular.articles.presentation.mapper

import com.nyt.articles.popular.domain.model.Article
import com.nyt.articles.popular.domain.model.Media
import com.nyt.articles.popular.domain.model.MediaMetadata
import com.nyt.popular.articles.presentation.model.NYTArticle
import com.nyt.popular.articles.presentation.model.NYTMedia
import com.nyt.popular.articles.presentation.model.NYTMediaMetadata


fun Article.toPresentation(): NYTArticle {
    return NYTArticle(
        byline = byline,
        id = id,
        media = media?.map { it.toPresentation() },
        publishedDate = publishedDate,
        section = section,
        source = source,
        subsection = subsection,
        title = title,
        type = type,
        updated = updated,
        uri = uri,
        url = url,
        imageUrl = media?.lastOrNull()?.mediaMetadata?.lastOrNull()?.url

    )
}

fun Media.toPresentation() = NYTMedia(
    caption = caption,
    copyright = copyright,
    mediaMetadata = mediaMetadata.map { it.toPresentation() },
    subtype = subtype,
    type = type
)

fun MediaMetadata.toPresentation() = NYTMediaMetadata(
    format = format, height = height, url = url, width = width
)