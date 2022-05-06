package com.example.demoappv1.ui.models.counter

data class CounterState(
    val name: String,
    val number: Int
) {
    companion object {
        //for @Preview
        val Default = CounterState("YourName", 0)
    }
}