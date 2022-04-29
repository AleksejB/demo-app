package com.example.demoappv1.ui.navigation.screen

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.demoappv1.ui.Graph
import com.example.demoappv1.ui.Screen
import com.example.demoappv1.ui.navigation.screenui.AuthScreen

@ExperimentalComposeUiApi
fun NavGraphBuilder.addAuthScreen(
    navController: NavController,
    graph: Graph
) {
    composable(
        Screen.Auth.createRoute(graph),
        arguments = listOf(navArgument("name") { type = NavType.StringType})
    ) {
        AuthScreen(
            navigateToDashboard = { name ->
//                navController.navigate(Screen.Counter.createRoute(Graph.Dashboard, name))
                navController.navigate("dashboard/counter/$name")
            }
        )
    }
}