package com.example.data.repository

import com.example.data.daos.CounterLocalDataSource
import com.example.data.dto.CounterDto
import com.example.domain.repository.CounterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CounterRepositoryImpl @Inject constructor(
    private val counterLocalDataSource: CounterLocalDataSource
): CounterRepository {

    companion object {
        private const val TAG = "CounterRepositoryImpl"
    }

    override suspend fun insertNewCount(email: String, count: Int) {
        return counterLocalDataSource.insertNewCount(
            CounterDto(
                email = email,
                count = count
            )
        )
    }

    override suspend fun getCount(email: String): Flow<Int?> {
        return counterLocalDataSource.getUserCount(email)
    }

    override suspend fun updateCount(email: String, newCount: Int) {
        return counterLocalDataSource.updateCount(
            CounterDto(
                email = email,
                count = newCount
            )
        )
    }
}