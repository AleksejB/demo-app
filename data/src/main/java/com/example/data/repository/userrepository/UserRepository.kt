package com.example.data.repository.userrepository

import com.example.demoappv1.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
//    suspend fun getUserById(userId: String): User?
    suspend fun doesUserExist(firstName: String, lastName: String): Result<User?>
    suspend fun updateUser(userId: String, firstName: String, lastName: String)
    suspend fun insertUser(userId: String, firstName: String, lastName: String): Result<Unit>
}