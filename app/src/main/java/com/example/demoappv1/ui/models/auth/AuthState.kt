package com.example.demoappv1.ui.models.auth

data class AuthState(
    val name: String
) {
    companion object {
        val Default = AuthState("")
    }
}