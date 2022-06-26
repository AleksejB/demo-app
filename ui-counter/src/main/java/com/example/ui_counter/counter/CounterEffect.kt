package com.example.ui_counter.counter

sealed interface CounterEffect {
    data class NavigateToStats(val userId: String): CounterEffect
}