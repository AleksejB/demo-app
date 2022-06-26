package com.example.data.datasource.userdatasource

import com.example.demoappv1.User
import kotlinx.coroutines.flow.Flow

interface UserDataSource {
//    suspend fun getUserById(userId: String): User?
    suspend fun getUserByFirstAndLastName(firstName: String, lastName: String): User?
    suspend fun updateUser(userId: String, firstName: String, lastName: String)
    suspend fun insertNewUser(userId: String, firstName: String, lastName: String)
}