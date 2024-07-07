package com.nyt.popular.articles.presentation.mapper

import com.nyt.articles.core.common.entity.NYTArticle
import com.nyt.articles.popular.domain.model.Article


fun Article.toPresentation(): NYTArticle {
    return NYTArticle(
        byline = byline,
        id = id,
        publishedDate = publishedDate,
        section = section,
        source = source,
        subsection = subsection,
        title = title,
        type = type,
        updated = updated,
        uri = uri,
        url = url,
        imageUrl = media?.lastOrNull()?.mediaMetadata?.lastOrNull()?.url
    )
}
