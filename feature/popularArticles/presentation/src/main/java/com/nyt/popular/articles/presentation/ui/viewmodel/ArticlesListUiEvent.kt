package com.nyt.popular.articles.presentation.ui.viewmodel

import com.example.core.presentation.UiEvent

sealed interface ArticlesListUiEvent : UiEvent {
    data class OnPeriodSelected(val periodId: Int) : ArticlesListUiEvent
    data object LoadData : ArticlesListUiEvent
}