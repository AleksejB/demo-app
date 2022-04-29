package com.example.demoappv1.ui.models.counter

import androidx.lifecycle.SavedStateHandle
import com.example.demoappv1.repository.CounterRepository
import com.example.demoappv1.ui.models.MVIViewModel
import dagger.hilt.InstallIn
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import javax.inject.Singleton

@HiltViewModel
class CounterViewModel @Inject constructor(
    private val repo: CounterRepository,
    savedStateHandle: SavedStateHandle
): MVIViewModel<CounterState, CounterEvent, CounterEffect>() {

    //all od this is going to be changed to use CurrentUserSingleton and db
    val name = savedStateHandle.get<String>("name")
    private val _state = MutableStateFlow(CounterState(
        name = name ?: CounterState.DefaultName,
        number = 0 //retrieve user associated number from db
    ))
    override val state: StateFlow<CounterState> = _state




    override fun handleEvent(event: CounterEvent) {
        when (event) {
            is CounterEvent.NumberPressed -> {
                postEffect(CounterEffect.NavigateToBigNumber)
            }
            is CounterEvent.IncrementPressed -> {
                _state.value = state.value.copy(
                    number = state.value.number + 1
                )
            }
            is CounterEvent.DecrementPressed -> {
                _state.value = state.value.copy(
                    number = state.value.number - 1
                )
            }
        }
    }

}