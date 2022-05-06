package com.example.demoappv1.application

object CurrentUser {

    var userName: String = "??????"
    var count: Int = 0
    var exists: Boolean = false //not used yet. Was planning to use it for refactoring of how
    //CounterState works.

    data class User(
        val name: String,
        val count: Int
    )
}