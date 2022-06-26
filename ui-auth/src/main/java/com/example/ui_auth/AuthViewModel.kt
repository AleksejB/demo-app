package com.example.ui_auth

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.data.repository.userrepository.UserRepository
import com.example.base_ui.viewmodel.MVIViewModel
import com.example.data.repository.counterrepository.CounterRepository
import com.example.domain.CurrentUser
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
            is AuthEvent.LastNameChanged -> {
                updateLastNameInState(event.lastName)
            }
            is AuthEvent.NextPressed -> {
                viewModelScope.launch {
                    userRepository.doesUserExist(state.value.firstName, state.value.lastName).fold(
                        onSuccess = { user ->
                            postEffect(AuthEffect.NavigateToDashboard(user!!.user_uuid))
                        },
                        onFailure = {
                            val userId = UUID.randomUUID().toString()
                            userRepository.insertUser(
                                userId = userId,
                                firstName = state.value.firstName,
                                lastName = state.value.lastName
                            )
                            counterRepository.insertNewCount(
                                userId = userId,
                                count = 0
                            )
                            postEffect(AuthEffect.NavigateToDashboard(userId))
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

    private fun updateLastNameInState(input: String) {
        _state.value = state.value.copy(
            lastName = input
        )
    }
}