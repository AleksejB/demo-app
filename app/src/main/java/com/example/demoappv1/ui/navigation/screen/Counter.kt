package com.example.demoappv1.ui.navigation.screen

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.demoappv1.ui.Graph
import com.example.ui_counter.counter.CounterScreen

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