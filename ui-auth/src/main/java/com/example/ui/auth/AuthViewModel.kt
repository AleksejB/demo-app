package com.example.ui.auth

import androidx.lifecycle.viewModelScope
import com.example.domain.repository.UserRepository
import com.example.base_ui.viewmodel.MVIViewModel
import com.example.domain.repository.CounterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val counterRepository: CounterRepository
): MVIViewModel<AuthState, AuthEvent, AuthEffect>() {

    companion object {
        private const val TAG = "AuthViewModel"
    }

    private val _state = MutableStateFlow(AuthState.Default)
    override val state: StateFlow<AuthState> = _state

    override fun handleEvent(event: AuthEvent) {
        when (event) {
            is AuthEvent.FirstNameChanged -> {
                updateFirstNameInState(event.firstName)
            }
            is AuthEvent.EmailChanged -> {
                updateEmailInState(event.email)
            }
            is AuthEvent.NextPressed -> {
                viewModelScope.launch {
                    userRepository.doesUserExist(state.value.email).fold(
                        onSuccess = {
                            postEffect(AuthEffect.NavigateToDashboard(email = state.value.email))
                        },
                        onFailure = {
                            userRepository.insertUser(
                                email = state.value.email,
                                firstName = state.value.firstName
                            )
                            counterRepository.insertNewCount(
                                email = state.value.email,
                                count = 0
                            )
                            postEffect(AuthEffect.NavigateToDashboard(email = state.value.email))
                        }
                    )
                }
            }
        }
    }

    private fun updateFirstNameInState(input: String) {
        _state.value = state.value.copy(
            firstName = input
        )
    }

    private fun updateEmailInState(input: String) {
        _state.value = state.value.copy(
            email = input
        )
    }
}