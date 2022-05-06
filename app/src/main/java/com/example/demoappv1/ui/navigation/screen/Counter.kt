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
import com.example.demoappv1.ui.navigation.screenui.CounterScreen

@ExperimentalComposeUiApi
fun NavGraphBuilder.addCounterScreen(
    navController: NavController,
    graph: Graph
) {
    composable(
//        Screen.Counter.createRoute(graph)
        "dashboard/counter"
    ) {
        CounterScreen(
            navigateToBigNumberScreen = { number ->
                navController.navigate(
//                    Screen.BigNumber.createRoute(Graph.Dashboard)
                "dashboard/counter/big_number/${number}"
                ) }
        )
    }
}