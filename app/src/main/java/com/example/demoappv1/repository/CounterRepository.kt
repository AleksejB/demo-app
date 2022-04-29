package com.example.demoappv1.repository

import com.example.demoappv1.User
import kotlinx.coroutines.flow.Flow


interface CounterRepository {

    fun getUserByUserName(userName: String): Flow<User?>

    suspend fun updateUserCountByUsername(newCount: Int, userName: String)

    suspend fun insertNewUser(userName: String)
}