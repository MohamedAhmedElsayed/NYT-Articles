package com.nyt.articles.popular.data.remote.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NYTArticleResponse(
    @Json(name = "numResults") val numResults: Int?,
    @Json(name = "results") val articles: List<ArticleEntity>,
    @Json(name = "status") val status: String?
)

@JsonClass(generateAdapter = true)
data class ArticleEntity(
    val id: Long?,
    val media: List<MediaEntity>?,
    @Json(name = "published_date") val publishedDate: String?,
    val section: String?,
    val source: String?,
    val subsection: String?,
    val title: String?,
    val type: String?,
    val updated: String?,
    val uri: String?,
    val url: String?,
    @Json(name = "byline") val byline: String?,
)
