package com.nyt.articles.popular.data.remote.mapper

import com.nyt.articles.popular.data.remote.entity.ArticleEntity
import com.nyt.articles.popular.data.remote.entity.MediaEntity
import com.nyt.articles.popular.data.remote.entity.MediaMetadataEntity
import com.nyt.articles.popular.data.remote.entity.NYTArticleResponse
import com.nyt.articles.popular.domain.model.Article
import com.nyt.articles.popular.domain.model.Media
import com.nyt.articles.popular.domain.model.MediaMetadata
import com.nyt.articles.popular.domain.model.PopularArticlesData

fun NYTArticleResponse.mapToDomainEntity(): PopularArticlesData {
    val domainArticles = articles.map { it.mapToDomainEntity() }
    return PopularArticlesData(domainArticles, status)
}

fun ArticleEntity.mapToDomainEntity(): Article {
    return Article(
        byline = byline,
        id = id,
        media = media?.map { it.mapToDomainEntity() },
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

fun MediaEntity.mapToDomainEntity() = Media(
    caption = caption,
    copyright = copyright,
    mediaMetadata = mediaMetadata.map { it.mapToDomainEntity() },
    subtype = subtype,
    type = type
)

fun MediaMetadataEntity.mapToDomainEntity() = MediaMetadata(
    format = format, height = height, url = url, width = width
)