package com.example.data.repository.counterrepository

import kotlinx.coroutines.flow.Flow

interface CounterRepository {
    fun getCount(userId: String): Flow<Int?>
    suspend fun insertNewCount(userId: String, count: Int)
    suspend fun updateCount(userId: String, newCount: Int)
}