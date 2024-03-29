package com.example.ui.stats

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ui.stats.counterstats.StatsState
import com.example.ui.stats.counterstats.StatsViewModel

@Composable
fun StatsScreen() {
    val viewModel = hiltViewModel<StatsViewModel>()
    val state by viewModel.state.collectAsState()

    StatsScreen(
        state = state
    )
}

@Composable
private fun StatsScreen(
    state: StatsState
) {
   Column(
       modifier = Modifier
           .padding(8.dp)
           .fillMaxSize(),
       verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally
   ) {
       Text(
           text = state.firstName
       )
       Text(
           text = state.count.toString()
       )

   }
}


