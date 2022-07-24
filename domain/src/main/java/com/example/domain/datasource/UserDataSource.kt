package com.example.domain.datasource

import com.example.domain.model.User

interface UserDataSource {
    suspend fun getUserByEmail(email: String): Result<Unit>
    suspend fun insertNewUser(email: String, firstName: String)
}