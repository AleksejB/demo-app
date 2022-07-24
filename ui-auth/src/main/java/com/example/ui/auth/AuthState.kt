package com.example.ui.auth

data class AuthState(
    val email: String,
    val firstName: String,
) {
    companion object {
        val Default = AuthState(
            email = "",
            firstName = "",
        )
    }
}