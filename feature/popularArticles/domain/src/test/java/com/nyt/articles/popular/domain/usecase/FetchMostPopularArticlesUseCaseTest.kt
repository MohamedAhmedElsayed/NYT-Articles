package com.nyt.articles.popular.domain.usecase

import com.nyt.articles.popular.domain.model.PopularArticlesData
import com.nyt.articles.popular.domain.model.PopularArticlesResponse
import com.nyt.articles.popular.domain.repo.PopularArticlesRepo
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import kotlin.test.assertEquals

@RunWith(MockitoJUnitRunner::class)
class FetchMostPopularArticlesUseCaseTest {

    @Mock
    lateinit var repo: PopularArticlesRepo

    lateinit var useCase: FetchMostPopularArticlesUseCase

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        useCase = FetchMostPopularArticlesUseCase(repo)
    }

    @After
    fun tearDown() {
        Mockito.clearAllCaches()
    }

    @Test
    fun `load data successfully`() {
        runBlocking {
            val response = PopularArticlesData(
                emptyList(), ""
            )
            `when`(repo.getMostPopularArticles(1)).thenReturn(
                PopularArticlesResponse.Success(
                    response
                )
            )
            val expected = PopularArticlesResponse.Success(
                response
            )
            val actual = useCase(1)
            assertEquals(actual, expected)
        }
    }
}