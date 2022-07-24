package com.example.ui.auth

sealed interface AuthEvent {
    data class FirstNameChanged(val firstName: String): AuthEvent
    data class EmailChanged(val email: String): AuthEvent
    object NextPressed: AuthEvent
}