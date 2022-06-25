package com.example.ui_counter.counter

data class CounterState(
    val name: String,
    val number: Int
) {
    companion object {
        //for @Preview
        val Default = CounterState("YourName", 0)
    }
}