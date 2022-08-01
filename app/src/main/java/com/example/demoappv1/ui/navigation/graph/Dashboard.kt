package com.example.demoappv1.ui.navigation.graph

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.example.demoappv1.ui.Graph
import com.example.demoappv1.ui.navigation.screen.*

@ExperimentalComposeUiApi
fun NavGraphBuilder.addDashboardGraph(
    navController: NavHostController
) {
    navigation(
        route = "dashboard",
        startDestination = "dashboard/counter"
    ) {
        addCounterScreen(navController, Graph.Dashboard)
        addStatsScreen()
        addWriteNotesScreen(navController)
        addSeeNotesScreen(navController)
        addUserNoteInfo()
    }
}