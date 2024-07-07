package com.nyt.articles.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.presentation.UiEffect
import com.example.core.presentation.UiEvent
import com.example.core.presentation.UiState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

abstract class BaseViewModel<Event : UiEvent, State : UiState, Effect : UiEffect> : ViewModel() {

    private val initialState: State by lazy { createInitialState() }
    abstract fun createInitialState(): State

    val currentState: State
        get() = uiState.value

    private val _uiState: MutableStateFlow<State> = MutableStateFlow(initialState)
    val uiState = _uiState.asStateFlow()

    private val _event: Channel<Event> = Channel()

    private val _effect: Channel<Effect> = Channel()
    val effect = _effect.receiveAsFlow()

    //to handle if multiple calls occurred at the same time to ensure each state is reflected
    private val mutex by lazy { Mutex() }

    init {
        subscribeEvents()
    }

    /**
     * Start listening to Event
     */
    private fun subscribeEvents() {
        viewModelScope.launch {
            _event.consumeEach {
                mutex.withLock {
                    handleEvent(it)
                }
            }
        }
    }

    /**
     * Handle each event
     */
    abstract suspend fun handleEvent(event: Event)


    /**
     * Set new Event
     */
    infix fun dispatch(newEvent: Event) {
        viewModelScope.launch {
            _event.send(newEvent)
        }
    }


    /**
     * Set new Ui State
     */
    protected fun setState(reduce: State.() -> State) {
        val newState = currentState.reduce()
        _uiState.value = newState
    }

    /**
     * Set new Effect
     */
    protected fun setEffect(builder: () -> Effect) {
        val effectValue = builder()
        viewModelScope.launch { _effect.send(effectValue) }
    }
}