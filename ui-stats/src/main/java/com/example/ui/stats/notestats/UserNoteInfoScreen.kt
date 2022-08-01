package com.example.ui.stats.notestats

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun UserNoteInfoScreen() {
    val viewModel = hiltViewModel<UserNoteInfoViewModel>()
    val state by viewModel.state.collectAsState()

    DisposableEffect(key1 = viewModel) {
        viewModel.onStart()
        onDispose {  }
    }

    UserNoteInfoScreen(
        state = state,
        eventHandler = viewModel::postEvent
    )
}

@Composable
internal fun UserNoteInfoScreen(
    state: UserNoteInfoState,
    eventHandler: (UserNoteInfoEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(vertical = 8.dp),
            text = "Author's email: ${state.email}"
        )
        Text(
            modifier = Modifier.padding(vertical = 8.dp),
            text = "Author's count: ${state.count}"
        )
        Text(
            modifier = Modifier.padding(vertical = 8.dp),
            text = "Author's note: ${state.noteText}"
        )
    }
}