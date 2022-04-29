package com.example.demoappv1.ui.models.auth


sealed interface AuthEffect { //why is it sealed?

    data class NavigateToDashboard(val name: String): AuthEffect
}