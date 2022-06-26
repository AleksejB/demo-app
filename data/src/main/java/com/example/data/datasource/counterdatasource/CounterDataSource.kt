package com.example.data.datasource.counterdatasource

import kotlinx.coroutines.flow.Flow

interface CounterDataSource {
    fun getCount(userId: String): Flow<Int?>
    suspend fun insetNewCount(userId: String, count: Int)
    suspend fun updateCount(newCount: Int, userId: String)
}