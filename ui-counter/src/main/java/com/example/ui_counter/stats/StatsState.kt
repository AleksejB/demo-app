package com.example.ui_counter.stats

data class StatsState(
    val firstName: String,
    val lastName: String,
    val count: Int
) {
    companion object {
        val Default = StatsState(
            firstName = "",
            lastName = "",
            count = 0
        )
    }
}