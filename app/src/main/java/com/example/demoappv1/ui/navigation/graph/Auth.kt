package com.example.demoappv1.ui.navigation.graph

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.example.demoappv1.ui.Graph
import com.example.demoappv1.ui.Screen
import com.example.demoappv1.ui.navigation.screen.addAuthScreen

@ExperimentalComposeUiApi
fun NavGraphBuilder.addAuthGraph(
    navController: NavController
) {
    navigation(
        route = "auth",
        startDestination = "auth/auth"
    ) {
        addAuthScreen(navController, Graph.Auth)
    }
}