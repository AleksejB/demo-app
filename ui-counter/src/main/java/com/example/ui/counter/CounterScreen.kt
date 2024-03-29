package com.example.ui.counter

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CounterScreen(
    navigateToStatsScreen: (email: String) -> Unit,
    navigateToWriteNoteScreen: () -> Unit,
    navigateToSeeNotesScreen: () -> Unit
) {

    val viewModel = hiltViewModel<CounterViewModel>()
    val state by viewModel.state.collectAsState()

    LaunchedEffect(key1 = viewModel.effects) {
        viewModel.effects.collect { effect ->
            when (effect) {
                is CounterEffect.NavigateToStats -> {
                    navigateToStatsScreen(effect.email)
                }
                is CounterEffect.NavigateToSeeNotes -> {
                    navigateToSeeNotesScreen()
                }
                is CounterEffect.NavigateToWriteNote -> {
                    navigateToWriteNoteScreen()
                }
            }
        }
    }

    DisposableEffect(key1 = viewModel) {
        viewModel.onStart()
        onDispose {  }
    }

    CounterScreen(
        state = state,
        eventHandler = viewModel::postEvent
    )
}

@Composable
private fun CounterScreen(
    state: CounterState,
    eventHandler: (CounterEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = state.count.toString(),
            modifier = Modifier.clickable(enabled = true) {
                eventHandler(CounterEvent.NumberPressed)
            }
        )
        FloatingActionButton(onClick = { eventHandler(CounterEvent.IncrementPressed) }) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowUp,
                contentDescription = "Add one to the counter"
            )
        }
        FloatingActionButton(onClick = { eventHandler(CounterEvent.DecrementPressed) }) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = "Minus one to the counter"
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(onClick = { eventHandler(CounterEvent.SeeNotesClicked) }) {
                Text(text = "See notes")
            }

            Button(onClick = { eventHandler(CounterEvent.WriteNoteClicked) }) {
                Text(text = "Write new note")
            }
        }
    }
}





@Preview
@Composable
fun CounterScreenPreview() {
    CounterScreen(
        state = CounterState.Default,
        eventHandler = {}
    )
}