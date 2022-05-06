package com.example.demoappv1.ui.models.counter

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.demoappv1.User
import com.example.demoappv1.application.CurrentUser
import com.example.demoappv1.repository.UserRepository
import com.example.demoappv1.ui.models.MVIViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CounterViewModel @Inject constructor(
    private val repo: UserRepository
): MVIViewModel<CounterState, CounterEvent, CounterEffect>() {

    private val initalState = CounterState("USER", 0)
    private val _state: StateFlow<CounterState> = repo.getUserByUserNameAsFlow(CurrentUser.userName).map { user ->
        if (user == null) {
            repo.insertNewUser(CurrentUser.userName)
            CounterState("UserName", 0) //this is janky, change this
        } else {
            CounterState(user.user_name, user.count)
        }
    }.stateIn(viewModelScope, SharingStarted.Lazily, initalState)
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