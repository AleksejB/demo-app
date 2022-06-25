package com.example.ui_counter.counter

sealed interface CounterEffect {
    object NavigateToBigNumber: CounterEffect
}