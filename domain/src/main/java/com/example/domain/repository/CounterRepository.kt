package com.example.domain.repository

import kotlinx.coroutines.flow.Flow

interface CounterRepository {
    suspend fun getCount(email: String): Flow<Int?>
    suspend fun insertNewCount(email: String, count: Int)
    suspend fun updateCount(email: String, newCount: Int)
}