package com.example.ui.seenotes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect

@Composable
fun SeeNotesScreen(
    navigateToUserNoteInfo: (email: String) -> Unit
) {
    val viewModel = hiltViewModel<SeeNotesViewModel>()
    val state by viewModel.state.collectAsState()

    LaunchedEffect(key1 = viewModel) {
        viewModel.effects.collect { effect ->
            when (effect) {
                is SeeNotesEffect.NavigateToUserNoteInfo -> {
                    navigateToUserNoteInfo(effect.email)
                }
            }
        }
    }

    DisposableEffect(key1 = viewModel) {
        viewModel.onStart()
        onDispose {  }
    }

    SeeNotesScreen(
        state = state,
        eventHandler = viewModel::postEvent
    )
}

@Composable
internal fun SeeNotesScreen(
    state: SeeNotesState,
    eventHandler: (SeeNotesEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn() {
            items(state.notes) { userNote ->
                NoteItem(email = userNote.email, noteText = userNote.noteText, eventHandler)
            }
        }
    }
}

@Composable
private fun NoteItem(
    email: String,
    noteText: String,
    eventHandler: (SeeNotesEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clickable {
                eventHandler(SeeNotesEvent.NoteItemClicked(email))
            }
    ) {
        Text(
            modifier = Modifier.padding(vertical = 8.dp),
            text = "Author's email: $email"
        )
        Text(
            modifier = Modifier
                .padding(vertical = 8.dp),
            text = noteText
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
        )
    }
}