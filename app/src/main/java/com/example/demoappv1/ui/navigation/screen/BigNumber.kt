package com.example.demoappv1.ui.navigation.screen

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.ui_counter.bignumber.BigNumberScreen

@ExperimentalComposeUiApi
fun NavGraphBuilder.addBigNumberScreen() {
    composable(
//        Screen.BigNumber.createRoute(graph)
    "dashboard/counter/big_number/{number}"
    ) {
        BigNumberScreen()
    }
}