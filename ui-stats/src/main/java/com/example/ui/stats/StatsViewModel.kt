package com.example.ui.stats

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.base_ui.viewmodel.MVIViewModel
import com.example.domain.model.UserCounter
import com.example.domain.repository.UserCounterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StatsViewModel @Inject constructor(
    private val userCounterRepository: UserCounterRepository,
    savedStateHandle: SavedStateHandle
): MVIViewModel<StatsState, StatsEvent, StatsEffect>() {

    private val userEmail = savedStateHandle.get<String>("email")!!

    private val _state: MutableStateFlow<StatsState> = MutableStateFlow(StatsState.Default)
    override val state: StateFlow<StatsState> = _state

    init {
        viewModelScope.launch {
            updateUserCounterInState(userCounterRepository.getUserNameANdCount(email = userEmail))
        }
    }

    override fun handleEvent(event: StatsEvent) {
        TODO("Not yet implemented")
    }

    private fun updateUserCounterInState(userCounter: UserCounter) {
        _state.value = state.value.copy(
            firstName = userCounter.firstName,
            count = userCounter.count
        )
    }
}