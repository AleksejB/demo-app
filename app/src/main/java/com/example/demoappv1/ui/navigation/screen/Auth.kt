package com.example.demoappv1.ui.navigation.screen

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.demoappv1.ui.Graph
import com.example.ui.auth.AuthScreen

@ExperimentalComposeUiApi
fun NavGraphBuilder.addAuthScreen(
    navController: NavController,
    graph: Graph
) {
    composable(
        route = "auth/auth",
    ) {

        AuthScreen(
            navigateToDashboard = { userEmail ->
                navController.navigate("dashboard/counter/$userEmail")
            }
        )
    }
}