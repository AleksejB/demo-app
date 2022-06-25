package com.example.ui_counter.counter

import androidx.lifecycle.viewModelScope
import com.example.data.repository.userrepository.UserRepository
import com.example.base_ui.viewmodel.MVIViewModel
import com.example.domain.CurrentUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CounterViewModel @Inject constructor(
    private val repo: UserRepository
): MVIViewModel<CounterState, CounterEvent, CounterEffect>() {

    private val initialState = CounterState("USER", 0)
    private val _state: StateFlow<CounterState> = repo.getUserByUserNameAsFlow(CurrentUser.userName).map { user ->
        if (user == null) {
            repo.insertNewUser(CurrentUser.userName)
            CounterState("UserName", 0) //this is janky, change this
        } else {
            CounterState(user.user_name, user.count)
        }
    }.stateIn(viewModelScope, SharingStarted.Lazily, initialState)
    override val state: StateFlow<CounterState> = _state




    override fun handleEvent(event: CounterEvent) {
        when (event) {
            is CounterEvent.NumberPressed -> {
                postEffect(CounterEffect.NavigateToBigNumber)
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
            repo.updateUserCountByUsername(_state.value.number + 1, CurrentUser.userName)
        }
    }

    private fun decrementCountInDB() {
        viewModelScope.launch {
            repo.updateUserCountByUsername(_state.value.number - 1, CurrentUser.userName)
        }
    }
}