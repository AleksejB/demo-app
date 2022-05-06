package com.example.demoappv1.ui

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.demoappv1.ui.navigation.graph.addAuthGraph
import com.example.demoappv1.ui.navigation.graph.addDashboardGraph

sealed class Graph(val route: String) {
    object Auth: Graph("auth")
    object Dashboard: Graph("dashboard")
}

sealed class Screen(val route: String) {

    fun createRoute(
        graph: Graph,
        vararg args: String
    ) = "${graph.route}/$route/${args.joinToString("/")}"

    object Auth: Screen("auth")
    object Counter: Screen("counter") //declare where the argument is meant to go to
    object BigNumber: Screen("counter/big_number")
    object Stats: Screen("stats")
}


@ExperimentalMaterialApi
//@ExperimentalPagerApi
@ExperimentalComposeUiApi
@Composable
fun AppNavigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Graph.Auth.route
    ) {
        addAuthGraph(navController)
        addDashboardGraph(navController)
    }
}