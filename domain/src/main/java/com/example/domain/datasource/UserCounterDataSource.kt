package com.example.domain.datasource

import com.example.domain.model.UserCounter
import kotlinx.coroutines.flow.Flow

interface UserCounterDataSource {
    suspend fun getUserAndCount(email: String): UserCounter
}