package com.example.ui_counter.counter

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.data.repository.userrepository.UserRepository
import com.example.base_ui.viewmodel.MVIViewModel
import com.example.data.repository.counterrepository.CounterRepository
import com.example.domain.CurrentUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CounterViewModel @Inject constructor(
    private val counterRepository: CounterRepository,
    savedStateHandle: SavedStateHandle
): MVIViewModel<CounterState, CounterEvent, CounterEffect>() {

    private val userId = savedStateHandle.get<String>("userId")!!

    private val initialState = CounterState.Default
    private val _state: StateFlow<CounterState> = counterRepository.getCount(userId).map { count ->
        if (count != null) {
            CounterState(count = count)
        } else {
            CounterState(count = -999)
        }
    }.stateIn(viewModelScope, SharingStarted.Lazily, initialState)
    override val state: StateFlow<CounterState> = _state

    override fun handleEvent(event: CounterEvent) {
        when (event) {
            is CounterEvent.NumberPressed -> {
                postEffect(CounterEffect.NavigateToStats(userId))
            }
            is CounterEvent.IncrementPressed -> {
                incrementCountInDB()
            }
            is CounterEvent.DecrementPressed -> {
                decrementCountInDB()
            }
        }
    }

    private fun incrementCountInDB() {
        viewModelScope.launch {
            counterRepository.updateCount(
                userId = userId,
                newCount = state.value.count + 1
            )
        }
    }

    private fun decrementCountInDB() {
        viewModelScope.launch {
            counterRepository.updateCount(
                userId = userId,
                newCount = state.value.count
            )
        }
    }
}