package com.example.demoappv1.ui.navigation.screen

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.ui.stats.StatsScreen

@ExperimentalComposeUiApi
fun NavGraphBuilder.addStatsScreen() {
    composable(
    "dashboard/counter/stats/{email}",
        arguments = listOf(
            navArgument("email") {
                type = NavType.StringType
            }
        )
    ) {
        StatsScreen()
    }
}