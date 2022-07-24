package com.example.domain

object CurrentUser {

    lateinit var currentUser: CurrentUser
    private set

    fun setCurrentUser(newCurrentUser: CurrentUser) {
        currentUser = newCurrentUser
    }

    data class CurrentUser(
        val firstName: String,
        val lastName: String,
        val count: Int
    )
}