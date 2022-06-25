package com.example.data.datasource.userdatasource

import com.example.demoappv1.User
import kotlinx.coroutines.flow.Flow

interface UserDataSource {

    fun getUserByUsernameAsFlow(userName: String): Flow<User?>

    suspend fun getUserByUsername(userName: String): User?

    suspend fun updateUserCountByUsername(newCount: Int, userName: String)

    suspend fun insertNewUser(userName: String, count: Int = 0)

}