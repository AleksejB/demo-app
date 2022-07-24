package com.example.data.repository

import android.util.Log
import com.example.domain.repository.CounterRepository
import com.example.domain.datasource.CounterDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CounterRepositoryImpl @Inject constructor(
    private val counterDataSource: CounterDataSource
): CounterRepository {

    companion object {
        private const val TAG = "CounterRepositoryImpl"
    }

    override suspend fun insertNewCount(email: String, count: Int) {
        return counterDataSource.insertNewCount(email, count)
    }

    override suspend fun getCount(email: String): Flow<Int> {
        return counterDataSource.getCount(email)
    }

    override suspend fun updateCount(email: String, newCount: Int) {
        return counterDataSource.updateCount(email, newCount)
    }
}