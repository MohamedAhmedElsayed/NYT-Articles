package com.nyt.articles.core.common.extentions

fun String?.emptyIfNull() = if (this.isNullOrBlank()) "" else this