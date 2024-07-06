package com.nyt.popular.articles.presentation.model


data class NYTArticle(
    val id: Long?,
    val media: List<NYTMedia>?,
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
    val imageUrl: String?

)

data class NYTMedia(
    val caption: String,
    val copyright: String,
    val mediaMetadata: List<NYTMediaMetadata>,
    val subtype: String,
    val type: String
)

data class NYTMediaMetadata(
    val format: String?,
    val height: Int?,
    val url: String?,
    val width: Int?
)
