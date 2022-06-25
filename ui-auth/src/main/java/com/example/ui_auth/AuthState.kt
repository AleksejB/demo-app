package com.example.ui_auth

data class AuthState(
    val name: String
) {
    companion object {
        val Default = AuthState("")
    }
}