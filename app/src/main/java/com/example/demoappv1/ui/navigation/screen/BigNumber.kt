package com.example.demoappv1.ui.navigation.screen

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.demoappv1.ui.Graph
import com.example.demoappv1.ui.Screen
import com.example.demoappv1.ui.navigation.screenui.AuthScreen
import com.example.demoappv1.ui.navigation.screenui.BigNumberScreen

@ExperimentalComposeUiApi
fun NavGraphBuilder.addBigNumberScreen() {
    composable(
//        Screen.BigNumber.createRoute(graph)
    "dashboard/counter/big_number/{number}"
    ) {
        BigNumberScreen()
    }
}