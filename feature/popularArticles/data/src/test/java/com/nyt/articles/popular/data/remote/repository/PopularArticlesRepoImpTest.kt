package com.nyt.articles.popular.data.remote.repository

import com.nyt.articles.core.data.remote.model.RemoteError
import com.nyt.articles.core.data.remote.model.RemoteError.ConnectionError.toErrorMessage
import com.nyt.articles.popular.data.remote.datasource.NYTPopularRemoteArticlesDataSource
import com.nyt.articles.popular.data.remote.entity.ArticleEntity
import com.nyt.articles.popular.data.remote.entity.NYTArticleResponse
import com.nyt.articles.popular.data.remote.mapper.mapToDomainEntity
import com.nyt.articles.popular.domain.model.PopularArticlesResponse
import com.nyt.articles.popular.domain.repo.PopularArticlesRepo
import junit.framework.TestCase
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
class PopularArticlesRepoImpTest {
    private lateinit var repo: PopularArticlesRepo

    @Mock
    lateinit var remoteDataSource: NYTPopularRemoteArticlesDataSource

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        repo = PopularArticlesRepoImp(remoteDataSource)
    }

    @After
    fun tearDown() {
        Mockito.clearAllCaches()
    }

    @Test
    fun `load articles successfully`() = runBlocking {
        val response = NYTArticleResponse(
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

        `when`(remoteDataSource.getPopularArticlesByPeriod(30)).thenReturn(response)
        val actual = repo.getMostPopularArticles(30)
        val expected = PopularArticlesResponse.Success(response.mapToDomainEntity())
        assertEquals(expected, actual)
    }

    @Test
    fun `load articles failed due to a general failure`() = runBlocking {
        `when`(remoteDataSource.getPopularArticlesByPeriod(30)).thenThrow(NullPointerException())
        val actual = repo.getMostPopularArticles(30)
        val expected =
            PopularArticlesResponse.Error(RemoteError.GeneralError.toErrorMessage())
        assertEquals(expected, actual)

    }


}