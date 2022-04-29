package com.example.demoappv1.ui.models.auth

sealed interface AuthEvent {
    data class NameChanged(val name: String): AuthEvent
    object NextPressed: AuthEvent
}