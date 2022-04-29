package com.example.demoappv1.data

import com.example.demoappv1.User
import kotlinx.coroutines.flow.Flow

interface UserDataSource {

    fun getUserByUsername(userName: String): Flow<User?>

    suspend fun updateUserCountByUsername(newCount: Int, userName: String)

    suspend fun insertNewUser(userName: String, count: Int = 0)

}