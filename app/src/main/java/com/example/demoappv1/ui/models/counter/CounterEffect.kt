package com.example.demoappv1.ui.models.counter

sealed interface CounterEffect {
    object NavigateToBigNumber: CounterEffect
}