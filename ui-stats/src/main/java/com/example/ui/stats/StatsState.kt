package com.example.ui.stats

data class StatsState(
    val firstName: String,
    val count: Int
) {
    companion object {
        val Default = StatsState(
            firstName = "",
            count = 0
        )
    }
}