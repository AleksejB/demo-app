package com.example.demoappv1.ui.navigation.graph

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.example.demoappv1.ui.Graph
import com.example.demoappv1.ui.navigation.screen.addStatsScreen
import com.example.demoappv1.ui.navigation.screen.addCounterScreen

@ExperimentalComposeUiApi
fun NavGraphBuilder.addDashboardGraph(
    navController: NavController
) {
    navigation(
        route = "dashboard",
        startDestination = "dashboard/counter"
    ) {
        addCounterScreen(navController, Graph.Dashboard)
        addStatsScreen()
    }
}