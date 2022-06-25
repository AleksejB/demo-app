package com.example.demoappv1.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.example.base_ui.theme.DarkColorPalette
import com.example.base_ui.theme.LightColorPalette
import com.example.base_ui.theme.Shapes
import com.example.base_ui.theme.Typography
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalMaterialApi::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainApplication()
        }
    }
}

