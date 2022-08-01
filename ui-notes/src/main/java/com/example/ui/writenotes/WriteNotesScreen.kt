package com.example.ui.writenotes

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun WriteNotesScreen(
    navigateBack: () -> Unit
) {
    val viewModel = hiltViewModel<WriteNotesViewModel>()
    val state by viewModel.state.collectAsState()

    LaunchedEffect(key1 = viewModel) {
        viewModel.effects.collect { effect ->
            when (effect) {
                is WriteNotesEffect.NavigateBack -> {
                    navigateBack()
                }
            }
        }
    }

    WriteNotesScreen(
        state = state,
        eventHandler = viewModel::postEvent
    )
}

@Composable
internal fun WriteNotesScreen(
    state: WriteNotesState,
    eventHandler: (WriteNotesEvent) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.currentNoteTextValue,
            onValueChange = { eventHandler(WriteNotesEvent.NoteTextValueChanged(it)) },
            maxLines = 10
        )

        Button(
            onClick = { eventHandler(WriteNotesEvent.SaveClicked) }
        ) {
            Text(text = "Save")
        }
    }
}