package com.nyt.popular.articles.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nyt.articles.presentation.viewmodel.NYTViewModel
import com.nyt.articles.presentation.viewmodel.NYTViewModelDelegate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

@HiltViewModel
class NYTArticlesViewModel @Inject constructor() : ViewModel(),
    NYTViewModel<ArticlesListUiEvent, ArticlesListUiState, ArticlesListUiEffect> by NYTViewModelDelegate(
        ArticlesListUiState()
    ) {
    override val coroutineScope: CoroutineScope = viewModelScope

    init {
        subscribeEvents(::handleEvent)
    }

    private suspend fun handleEvent(event: ArticlesListUiEvent) {
        when (event) {
            is ArticlesListUiEvent.OnPeriodSelected -> setState { copy(selectedPeriodId = event.periodId) }
        }

    }
}