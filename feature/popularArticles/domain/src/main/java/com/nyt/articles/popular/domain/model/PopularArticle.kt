package com.nyt.articles.popular.domain.model

sealed interface PopularArticlesResponse {
    data class Success(val data: PopularArticlesData) : PopularArticlesResponse
    data class Error(val errorMessage: String) : PopularArticlesResponse
}

data class PopularArticlesData(
    val articles: List<Article>,
    val status: String?
)

data class Article(
    val id: Long?,
    val media: List<Media>?,
    val publishedDate: String?,
    val section: String?,
    val source: String?,
    val subsection: String?,
    val title: String?,
    val type: String?,
    val updated: String?,
    val uri: String?,
    val url: String?,
    val byline: String?,
)

data class Media(
    val caption: String,
    val copyright: String,
    val mediaMetadata: List<MediaMetadata>,
    val subtype: String,
    val type: String
)

data class MediaMetadata(
    val format: String?,
    val height: Int?,
    val url: String?,
    val width: Int?
)
