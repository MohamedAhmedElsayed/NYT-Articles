package com.nyt.articles.popular.data.remote.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MediaEntity(
    val caption: String,
    val copyright: String,
    @Json(name = "media-metadata") val mediaMetadata: List<MediaMetadataEntity>,
    val subtype: String,
    val type: String
)

@JsonClass(generateAdapter = true)
data class MediaMetadataEntity(
    val format: String?,
    val height: Int?,
    val url: String?,
    val width: Int?
)