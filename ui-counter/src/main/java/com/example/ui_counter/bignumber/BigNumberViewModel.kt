package com.example.ui_counter.bignumber

import androidx.lifecycle.SavedStateHandle
import com.example.base_ui.viewmodel.MVIViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class BigNumberViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
): MVIViewModel<BigNumberState, BigNumberEvent, BigNumberEffect>() {


    private val number = savedStateHandle.get<String>("number")
    private val _state = MutableStateFlow(
        BigNumberState(
            number = number.toString()
        )
    )
    override val state: StateFlow<BigNumberState> = _state

    override fun handleEvent(event: BigNumberEvent) {
        TODO("Not yet implemented")
    }
}