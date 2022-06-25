package com.example.data.repository.userrepository

import com.example.demoappv1.User
import kotlinx.coroutines.flow.Flow


interface UserRepository {

    fun getUserByUserNameAsFlow(userName: String): Flow<User?>

    suspend fun getUserByUsername(userName: String): User?

    suspend fun updateUserCountByUsername(newCount: Int, userName: String)

    suspend fun insertNewUser(userName: String)
}