package com.example.ui_auth

sealed interface AuthEvent {
    data class NameChanged(val name: String): AuthEvent
    object NextPressed: AuthEvent
}