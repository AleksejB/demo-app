package com.example.ui.counter

data class CounterState(
    val count: Int
) {
    companion object {
        val Default = CounterState(count = 0)
    }
}