package com.example.demoappv1.ui.navigation.screen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.demoappv1.ui.Graph
import com.example.demoappv1.ui.Screen
import com.example.ui.seenotes.SeeNotesScreen

fun NavGraphBuilder.addSeeNotesScreen(navController: NavHostController) {
    composable(
        route = Screen.SeeNotes.createRoute(Graph.Dashboard)
    ) {
        SeeNotesScreen(
            navigateToUserNoteInfo = { email ->
                navController.navigate(
                    "dashboard/user_note_info/$email"
                )
            }
        )
    }
}