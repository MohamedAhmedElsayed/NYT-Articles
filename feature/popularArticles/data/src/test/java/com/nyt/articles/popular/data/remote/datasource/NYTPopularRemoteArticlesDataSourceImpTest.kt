package com.nyt.articles.popular.data.remote.datasource

import com.nyt.articles.popular.data.remote.entity.ArticleEntity
import com.nyt.articles.popular.data.remote.entity.NYTArticleResponse
import com.nyt.articles.popular.data.remote.service.PopularArticlesService
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import kotlin.test.Test


@RunWith(MockitoJUnitRunner::class)
class NYTPopularRemoteArticlesDataSourceImpTest {
    private lateinit var remoteArticlesDataSource: NYTPopularRemoteArticlesDataSource

    @Mock
    lateinit var mostPopularArticlesService: PopularArticlesService

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        remoteArticlesDataSource = NYTPopularRemoteArticlesDataSourceImp(mostPopularArticlesService)
    }

    @After
    fun tearDown() {
        Mockito.clearAllCaches()
    }

    @Test
    fun `load articles successfully`() = runBlocking {
        val expected = NYTArticleResponse(
            numResults = 1,
            articles = listOf(
                ArticleEntity(
                    id = 1,
                    publishedDate = "text",
                    section = "text",
                    subsection = "text",
                    source = "text",
                    title = "title",
                    type = "text",
                    updated = "text",
                    url = "text",
                    uri = "text",
                    byline = "text",
                    media = listOf(
                    )

                )
            ),
            status = "some text"
        )

        `when`(remoteArticlesDataSource.getPopularArticlesByPeriod(30)).thenReturn(expected)
        val actual = remoteArticlesDataSource.getPopularArticlesByPeriod(30)
        assertEquals(expected, actual)
    }
}