package com.example.demoappv1.ui.navigation.screen

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.demoappv1.ui.Graph
import com.example.ui_counter.counter.CounterScreen

@ExperimentalComposeUiApi
fun NavGraphBuilder.addCounterScreen(
    navController: NavController,
    graph: Graph
) {
    composable(
        route = "dashboard/counter/{userId}",
        arguments = listOf(
            navArgument("userId") {
                type = NavType.StringType
            }
        )
    ) {
        CounterScreen(
            navigateToStatsScreen = { userId ->
                navController.navigate("dashboard/counter/stats/{$userId}")
            }
        )
    }
}