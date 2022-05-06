package com.example.demoappv1.ui.models.auth

import com.example.demoappv1.repository.UserRepository
import com.example.demoappv1.ui.models.MVIViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repo: UserRepository
): MVIViewModel<AuthState, AuthEvent, AuthEffect>() {

    private val _state = MutableStateFlow(AuthState.Default)
    override val state: StateFlow<AuthState> = _state


    override fun handleEvent(event: AuthEvent) {
        when (event) {
            is AuthEvent.NameChanged -> {
                _state.value = state.value.copy(
                    name = event.name
                )
            }
            is AuthEvent.NextPressed -> {
                postEffect(AuthEffect.NavigateToDashboard(name = state.value.name))
            }
        }
    }
}