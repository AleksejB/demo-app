package com.example.ui_auth

sealed interface AuthEvent {
    data class FirstNameChanged(val firstName: String): AuthEvent
    data class LastNameChanged(val lastName: String): AuthEvent
    object NextPressed: AuthEvent
}