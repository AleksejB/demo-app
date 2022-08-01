package com.example.ui.counter

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.base_ui.viewmodel.MVIViewModel
import com.example.ui.counter.CounterEffect
import com.example.ui.counter.CounterEvent
import com.example.ui.counter.CounterState
import com.example.domain.repository.CounterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CounterViewModel @Inject constructor(
    private val counterRepository: CounterRepository,
    savedStateHandle: SavedStateHandle
): MVIViewModel<CounterState, CounterEvent, CounterEffect>() {

    private val userEmail = savedStateHandle.get<String>("email")!!

    fun onStart() {
        viewModelScope.launch {
            counterRepository.getCount(email = userEmail).collect { count ->
                count?.let {
                    updateCountInState(it)
                }
            }
        }
    }

    private val _state: MutableStateFlow<CounterState> = MutableStateFlow(CounterState.Default)
    override val state: StateFlow<CounterState> = _state

    override fun handleEvent(event: CounterEvent) {
        when (event) {
            is CounterEvent.NumberPressed -> {
                postEffect(CounterEffect.NavigateToStats(userEmail))
            }
            is CounterEvent.IncrementPressed -> {
                incrementCountInDB()
            }
            is CounterEvent.DecrementPressed -> {
                decrementCountInDB()
            }
            is CounterEvent.SeeNotesClicked -> {
                postEffect(CounterEffect.NavigateToSeeNotes)
            }
            is CounterEvent.WriteNoteClicked -> {
                postEffect(CounterEffect.NavigateToWriteNote)
            }
        }
    }

    private fun updateCountInState(newCount: Int) {
        _state.value = state.value.copy(
            count = newCount
        )
    }

    private fun incrementCountInDB() {
        viewModelScope.launch {
            counterRepository.updateCount(
                email = userEmail,
                newCount = state.value.count + 1
            )
        }
    }

    private fun decrementCountInDB() {
        viewModelScope.launch {
            counterRepository.updateCount(
                email = userEmail,
                newCount = state.value.count - 1
            )
        }
    }
}