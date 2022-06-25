package com.example.base_ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

abstract class MVIViewModel<State, Event, Effect>: ViewModel() {

    abstract val state : StateFlow<State>

    private val _events : MutableSharedFlow<Event> = MutableSharedFlow()
    private val event = _events.asSharedFlow()

    private val _effects : Channel<Effect> = Channel()
    val effects = _effects.receiveAsFlow()

    init {
        viewModelScope.launch {
            event.collect {
                handleEvent(it)
            }
        }
    }
    protected abstract fun handleEvent(event: Event)

    fun postEvent(event: Event) {
        viewModelScope.launch {
            _events.emit(event)
        }
    }
    fun postEffect(effect: Effect) {
        viewModelScope.launch {
            _effects.send(effect)
        }
    }
}