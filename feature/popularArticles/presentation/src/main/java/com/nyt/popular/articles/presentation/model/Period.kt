package com.nyt.popular.articles.presentation.model

import androidx.annotation.StringRes
import androidx.compose.runtime.Stable
import com.nyt.popular.articles.presentation.R
import okhttp3.internal.immutableListOf

@Stable
data class Period(val id: Int, @StringRes val name: Int)

val popularArticlesPeriods =
    immutableListOf(
        Period(1, R.string.last_day),
        Period(7, R.string.last_week),
        Period(30, R.string.last_month)
    )

