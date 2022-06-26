package com.example.ui_auth

data class AuthState(
    val firstName: String,
    val lastName: String
) {
    companion object {
        val Default = AuthState(
            firstName = "",
            lastName = ""
        )
    }
}