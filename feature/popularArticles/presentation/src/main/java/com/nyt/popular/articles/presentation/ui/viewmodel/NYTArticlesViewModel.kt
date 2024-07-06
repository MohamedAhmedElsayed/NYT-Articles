package com.nyt.popular.articles.presentation.ui.viewmodel

import com.nyt.articles.popular.domain.model.PopularArticlesResponse
import com.nyt.articles.popular.domain.usecase.FetchMostPopularArticlesUseCase
import com.nyt.articles.presentation.viewmodel.BaseViewModel
import com.nyt.popular.articles.presentation.mapper.toPresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import javax.inject.Inject

@HiltViewModel
class NYTArticlesViewModel @Inject constructor(private val fetchMostPopularArticlesUseCase: FetchMostPopularArticlesUseCase) :
    BaseViewModel<ArticlesListUiEvent, ArticlesListUiState, ArticlesListUiEffect>() {
    init {
        dispatch(ArticlesListUiEvent.LoadData)
    }

    private var currentJob: Job? = null
    override suspend fun handleEvent(event: ArticlesListUiEvent) {
        when (event) {
            is ArticlesListUiEvent.OnPeriodSelected -> {
                setState { copy(selectedPeriodId = event.periodId) }
                dispatch(ArticlesListUiEvent.LoadData)
            }

            ArticlesListUiEvent.LoadData -> {
                currentJob?.cancel()
                setState { copy(isLoading = true, errorMessage = null, articles = emptyList()) }
                when (val dataResult =
                    fetchMostPopularArticlesUseCase(currentState.selectedPeriodId)) {
                    is PopularArticlesResponse.Error -> setState {
                        copy(
                            isLoading = false,
                            errorMessage = dataResult.errorMessage, articles = emptyList()
                        )
                    }

                    is PopularArticlesResponse.Success -> setState {
                        copy(
                            isLoading = false,
                            errorMessage = null,
                            articles = dataResult.data.articles.map { it.toPresentation() }
                        )
                    }
                }

            }
        }

    }

    override fun createInitialState() = ArticlesListUiState()
}