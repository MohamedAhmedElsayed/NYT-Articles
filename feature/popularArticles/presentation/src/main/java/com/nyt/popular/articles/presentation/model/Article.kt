package com.nyt.popular.articles.presentation.model

val DUMMY_YRL_FOR_TESTING =
    "https://static01.nyt.com/images/2024/06/14/opinion/13brooks/13brooks-mediumThreeByTwo440.jpg"

data class Article(val imageUrl: String? = DUMMY_YRL_FOR_TESTING, val title: String?)