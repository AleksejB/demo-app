package com.example.ui_auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AuthScreen(
    navigateToDashboard: (name: String) -> Unit
) {
    val viewModel = hiltViewModel<AuthViewModel>()
    val state by viewModel.state.collectAsState()
    
    LaunchedEffect(key1 = viewModel.effects) {
        viewModel.effects.collect { effect ->
            when (effect) {
                is AuthEffect.NavigateToDashboard -> {
                    navigateToDashboard(effect.userId)
                }
            }
        }
    }

    AuthScreen(
        state = state,
        eventHandler = viewModel::postEvent
    )
}

@Composable
private fun AuthScreen(
    state: AuthState,
    eventHandler: (AuthEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        TextField(
            value = state.firstName,
            onValueChange = { eventHandler(AuthEvent.FirstNameChanged(it)) },
            label = { Text(text = "Enter your first name") }
        )

        TextField(
            value = state.lastName,
            onValueChange = { eventHandler(AuthEvent.LastNameChanged(it)) },
            label = { Text(text = "Enter your last name") }
        )

        Button(
            onClick = { eventHandler(AuthEvent.NextPressed) },
        ) {
            Text(
                text = "NEXT",
                color = Color.Black
            )
        }
    }
}

@Preview
@Composable
fun AuthScreenPreview() {
    AuthScreen(
        state = AuthState.Default,
        eventHandler = {}
    )
}


