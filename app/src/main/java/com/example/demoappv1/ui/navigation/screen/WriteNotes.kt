package com.example.demoappv1.ui.navigation.screen

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.demoappv1.ui.Graph
import com.example.demoappv1.ui.Screen
import com.example.ui.writenotes.WriteNotesScreen

fun NavGraphBuilder.addWriteNotesScreen(
    navController: NavHostController
) {
    composable(Screen.WriteNotes.createRoute(Graph.Dashboard)) {
        WriteNotesScreen(
            navigateBack = {
                navController.navigateUp()
            }
        )
    }

}