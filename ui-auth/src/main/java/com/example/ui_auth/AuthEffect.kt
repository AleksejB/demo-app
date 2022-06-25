package com.example.ui_auth


sealed interface AuthEffect { //why is it sealed?

    data class NavigateToDashboard(val name: String): AuthEffect
}