package com.example.ui.auth


sealed interface AuthEffect {

    data class NavigateToDashboard(val email: String): AuthEffect
}