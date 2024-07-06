package com.nyt.articles.popular.data.remote.mapper

import com.nyt.articles.popular.data.remote.entity.ArticleEntity
import com.nyt.articles.popular.data.remote.entity.MediaEntity
import com.nyt.articles.popular.data.remote.entity.MediaMetadataEntity
import com.nyt.articles.popular.data.remote.entity.NYTArticleResponse
import com.nyt.articles.popular.domain.model.Article
import com.nyt.articles.popular.domain.model.Media
import com.nyt.articles.popular.domain.model.MediaMetadata
import com.nyt.articles.popular.domain.model.PopularArticlesData

fun NYTArticleResponse.mapToDomain(): PopularArticlesData {
    val domainArticles = articles.map { it.toDomain() }
    return PopularArticlesData(domainArticles, status)
}

fun ArticleEntity.toDomain(): Article {
    return Article(
        byline = byline,
        id = id,
        media = media?.map { it.toDomain() },
        publishedDate = publishedDate,
        section = section,
        source = source,
        subsection = subsection,
        title = title,
        type = type,
        updated = updated,
        uri = uri,
        url = url

    )
}

fun MediaEntity.toDomain() = Media(
    caption = caption,
    copyright = copyright,
    mediaMetadata = mediaMetadata.map { it.toDomain() },
    subtype = subtype,
    type = type
)

fun MediaMetadataEntity.toDomain() = MediaMetadata(
    format = format, height = height, url = url, width = width
)