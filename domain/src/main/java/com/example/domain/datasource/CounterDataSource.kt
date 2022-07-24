package com.example.domain.datasource

import kotlinx.coroutines.flow.Flow

interface CounterDataSource {
    suspend fun getCount(email: String): Flow<Int>
    suspend fun insertNewCount(email: String, count: Int)
    suspend fun updateCount(email: String, newCount: Int)
}