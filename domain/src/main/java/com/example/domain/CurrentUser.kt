package com.example.domain

object CurrentUser {

    var currentUser: CurrentUser = CurrentUser.Empty
    private set

    fun setCurrentUser(newCurrentUser: CurrentUser) {
        currentUser = newCurrentUser
    }

    data class CurrentUser(
        val email: String,
        val firstName: String
    ) {
        companion object {
            val Empty = CurrentUser(
                email = "",
                firstName = ""
            )
        }
    }
}