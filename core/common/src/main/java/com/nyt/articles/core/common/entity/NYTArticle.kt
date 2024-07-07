package com.nyt.articles.core.common.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable


@Serializable
@Parcelize
data class NYTArticle(
    val id: Long?,
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

) : Parcelable

@Serializable
@Parcelize
data class NYTMedia(
    val caption: String,
    val copyright: String,
    val mediaMetadata: List<NYTMediaMetadata>,
    val subtype: String,
    val type: String
) : Parcelable

@Serializable
@Parcelize
data class NYTMediaMetadata(
    val format: String?,
    val height: Int?,
    val url: String?,
    val width: Int?
) : Parcelable
