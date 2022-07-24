package com.example.domain.repository

import com.example.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun doesUserExist(email: String): Result<Unit>
    suspend fun insertUser(email: String, firstName: String)
}