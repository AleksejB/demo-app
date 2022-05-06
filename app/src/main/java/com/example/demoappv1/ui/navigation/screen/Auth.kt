package com.example.demoappv1.ui.navigation.screen

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.demoappv1.application.CurrentUser
import com.example.demoappv1.ui.Graph
import com.example.demoappv1.ui.Screen
import com.example.demoappv1.ui.navigation.screenui.AuthScreen

@ExperimentalComposeUiApi
fun NavGraphBuilder.addAuthScreen(
    navController: NavController,
    graph: Graph
) {
    composable(
        route = "auth/auth",
    ) {
        AuthScreen(
            navigateToDashboard = { name ->
                CurrentUser.userName = name
                navController.navigate("dashboard/counter")
            }
        )
    }
}