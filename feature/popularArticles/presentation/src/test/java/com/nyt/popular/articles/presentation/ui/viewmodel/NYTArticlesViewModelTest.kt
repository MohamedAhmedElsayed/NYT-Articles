package com.nyt.popular.articles.presentation.ui.viewmodel

import com.nyt.articles.popular.domain.model.Article
import com.nyt.articles.popular.domain.model.PopularArticlesData
import com.nyt.articles.popular.domain.model.PopularArticlesResponse
import com.nyt.articles.popular.domain.usecase.FetchMostPopularArticlesUseCase
import com.nyt.popular.articles.presentation.mapper.toPresentationModel
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.whenever
import kotlin.time.ExperimentalTime

class NYTArticlesViewModelTest {
    private val testDispatcher = StandardTestDispatcher()
    private val testCoroutineScope = TestScope(testDispatcher)

    @Mock
    private lateinit var useCase: FetchMostPopularArticlesUseCase
    lateinit var viewModel: NYTArticlesViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
        viewModel = NYTArticlesViewModel(useCase)
    }

    @Test
    fun `feach data successfully`() {
        testCoroutineScope.runTest {
            val result = PopularArticlesResponse.Success(
                PopularArticlesData(
                    listOf(
                        Article(
                            id = 123,
                            publishedDate = "2024-05-30",
                            section = "dummy",
                            source = "dummy",
                            media = emptyList(),
                            subsection = "dummy",
                            title = "title",
                            type = "v",
                            updated = "dummy",
                            uri = "v",
                            url = "url",
                            byline = "byline",
                        ),
                    ), ""
                )
            )
            whenever(useCase(1)).thenReturn(result)
            viewModel.handleEvent(ArticlesListUiEvent.LoadData)
            assert(viewModel.currentState.articles.isNotEmpty())
            assert(viewModel.currentState.isLoading.not())
            assert(viewModel.currentState.errorMessage == null)
            assertEquals(
                result.data.articles.map { it.toPresentationModel() },
                viewModel.currentState.articles
            )
        }
    }

    @ExperimentalTime
    @Test
    fun `fetchPopularArticles empty articles list`() = testCoroutineScope.runTest {
        val result = PopularArticlesResponse.Success(
            PopularArticlesData(
                emptyList(), ""
            )
        )
        whenever(useCase(1)).thenReturn(result)

        viewModel.handleEvent(ArticlesListUiEvent.LoadData)

        assertEquals(false, viewModel.currentState.isLoading)
        assert(viewModel.currentState.errorMessage == null)
        assert(viewModel.currentState.articles.isEmpty())
    }

    @Test
    fun `test initial state`() {
        assertEquals(false, viewModel.currentState.isLoading)
        assert(viewModel.currentState.errorMessage == null)
        assert(viewModel.currentState.articles.isEmpty())
        assertEquals(1, viewModel.currentState.selectedPeriodId)

    }

    @Test
    fun `change the selected period`() {
        testCoroutineScope.runTest {
            viewModel.handleEvent(ArticlesListUiEvent.OnPeriodSelected(30))
            assertEquals(30, viewModel.currentState.selectedPeriodId)
            assertEquals(false, viewModel.currentState.isLoading)
            assert(viewModel.currentState.errorMessage == null)
            assert(viewModel.currentState.articles.isEmpty())
        }
    }
}