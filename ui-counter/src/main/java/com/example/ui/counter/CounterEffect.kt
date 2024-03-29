package com.example.ui.counter

sealed interface CounterEffect {
    data class NavigateToStats(val email: String): CounterEffect
    object NavigateToWriteNote: CounterEffect
    object NavigateToSeeNotes: CounterEffect
}