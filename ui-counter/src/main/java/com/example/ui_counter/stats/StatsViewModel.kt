package com.example.ui_counter.stats

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.base_ui.viewmodel.MVIViewModel
import com.example.data.repository.usercounterrepository.UserCounterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class StatsViewModel @Inject constructor(
    private val userCounterRepository: UserCounterRepository,
    savedStateHandle: SavedStateHandle
): MVIViewModel<StatsState, StatsEvent, StatsEffect>() {


    private val userId = savedStateHandle.get<String>("userId")!!
    private val initialState = StatsState.Default
    //Flow isnt needed here
    private val _state = userCounterRepository.getUserCounter(userId).map { list ->
        StatsState(
            firstName = list.get(0)?.user_first_name ?: "",
            lastName = list.get(0)?.user_last_name ?: "",
            count = list.get(0)?.count ?: -999
        )
    }.stateIn(viewModelScope, SharingStarted.Lazily, initialState)
    override val state: StateFlow<StatsState> = _state

    override fun handleEvent(event: StatsEvent) {
        TODO("Not yet implemented")
    }
}