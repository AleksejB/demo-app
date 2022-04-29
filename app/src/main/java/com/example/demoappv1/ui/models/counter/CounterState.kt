package com.example.demoappv1.ui.models.counter

data class CounterState(
    val name: String,
    val number: Int
) {
    companion object {
        val DefaultName = "YourName"
        //for Preview
        val Default = CounterState("YourName", 0)
    }
}