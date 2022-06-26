package com.example.demoappv1.ui.navigation.screen

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.ui_counter.stats.StatsScreen

@ExperimentalComposeUiApi
fun NavGraphBuilder.addStatsScreen() {
    composable(
    "dashboard/counter/stats/{userId}",
        arguments = listOf(
            navArgument("userId") {
                type = NavType.StringType
            }
        )
    ) {
        StatsScreen()
    }
}