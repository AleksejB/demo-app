package com.example.ui_auth


sealed interface AuthEffect {

    data class NavigateToDashboard(val userId: String): AuthEffect
}