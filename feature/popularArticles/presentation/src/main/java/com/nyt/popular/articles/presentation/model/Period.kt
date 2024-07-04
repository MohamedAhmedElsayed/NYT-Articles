package com.nyt.popular.articles.presentation.model

import androidx.annotation.StringRes
import com.nyt.popular.articles.presentation.R

data class Period(val id: Int, @StringRes val name: Int)

val popularArticlesPeriods =
    listOf(
        Period(1, R.string.last_day),
        Period(7, R.string.last_week),
        Period(30, R.string.last_month)
    )
