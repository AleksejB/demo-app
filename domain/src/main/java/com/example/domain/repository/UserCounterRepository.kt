package com.example.domain.repository

import com.example.domain.model.UserCounter
import kotlinx.coroutines.flow.Flow

interface UserCounterRepository {
    suspend fun getUserNameAndCount(email: String): UserCounter?
}