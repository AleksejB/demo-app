package com.example.demoappv1.ui.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.demoappv1.ui.AppNavigation
import com.example.demoappv1.ui.theme.DemoAppV1Theme

@ExperimentalMaterialApi
//@ExperimentalPagerApi
@ExperimentalComposeUiApi
@Composable
fun MainApplication() {

    DemoAppV1Theme {
        
        val navController = rememberNavController()

        Scaffold() {
            AppNavigation(navController = navController)

        }
    }
}