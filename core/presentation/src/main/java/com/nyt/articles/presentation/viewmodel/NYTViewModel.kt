package com.nyt.articles.presentation.viewmodel

import com.example.core.presentation.UiEffect
import com.example.core.presentation.UiEvent
import com.example.core.presentation.UiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

interface NYTViewModel<Event : UiEvent, State : UiState, Effect : UiEffect> {

    val currentState: State
    val uiState: StateFlow<State>
    val effect: Flow<Effect>
    val coroutineScope: CoroutineScope

    fun setEffect(builder: () -> Effect)
    fun setState(reduce: State.() -> State)
    infix fun dispatch(newEvent: Event)
    fun subscribeEvents(eventHandler: suspend (event: Event) -> Unit)
}

class NYTViewModelDelegate<Event : UiEvent, State : UiState, Effect : UiEffect>(
    initialUiState: State
) : NYTViewModel<Event, State, Effect> {
    private val _uiState: MutableStateFlow<State> = MutableStateFlow(initialUiState)
    private val _event: Channel<Event> = Channel<Event>()
    private val _effect: Channel<Effect> = Channel()

    override val currentState: State
        get() = _uiState.value

    override val uiState: StateFlow<State> = _uiState.asStateFlow()
    override val effect: Flow<Effect>
        get() = _effect.receiveAsFlow()


    override val coroutineScope = CoroutineScope(Dispatchers.IO)


    private val mutex by lazy { Mutex() }

    /**
     * Start listening to Event
     */
    override fun subscribeEvents(eventHandler: suspend (event: Event) -> Unit) {
        coroutineScope.launch {
            _event.consumeEach {
                mutex.withLock {
                    eventHandler(it)
                }
            }
        }
    }

    /**
     * Set new Event
     */
    override infix fun dispatch(newEvent: Event) {
        coroutineScope.launch {
            _event.send(newEvent)
        }
    }


    /**
     * Set new Ui State
     */
    override fun setState(reduce: State.() -> State) {
        val newState = currentState.reduce()
        _uiState.value = newState
    }

    /**
     * Set new Effect
     */
    override fun setEffect(builder: () -> Effect) {
        val effectValue = builder()
        coroutineScope.launch { _effect.send(effectValue) }
    }

}