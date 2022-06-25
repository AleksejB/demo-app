package com.example.demoappv1.ui.main

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.rememberNavController
import com.example.base_ui.theme.*
import com.example.demoappv1.ui.AppNavigation

@OptIn(ExperimentalComposeUiApi::class)
@ExperimentalMaterialApi
@Composable
fun MainApplication() {

//    DemoAppV1Theme {
//
//
//    }
    val navController = rememberNavController()

    DemoAppV1Theme() {
        Scaffold() {

            AppNavigation(navController = navController)

        }
    }

}

@Composable
fun DemoAppV1Theme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

