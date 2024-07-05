package com.nyt.popular.articles.presentation.ui.viewmodel

import com.example.core.presentation.UiEvent

sealed class ArticlesListUiEvent : UiEvent {
    data class OnPeriodSelected(val periodId: Int) : ArticlesListUiEvent()

}