package com.example.demoappv1.ui.navigation.screen

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.demoappv1.ui.Graph
import com.example.demoappv1.ui.Screen
import com.example.ui.stats.notestats.UserNoteInfoScreen

fun NavGraphBuilder.addUserNoteInfo() {
    composable(
        route = Screen.UserNoteInfo.createRoute(Graph.Dashboard),
        arguments = listOf(
            navArgument(name = "email") {
                type = NavType.StringType
            }
        )
    ) {
        UserNoteInfoScreen()
    }
}