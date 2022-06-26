package com.example.data.repository.counterrepository

import com.example.data.datasource.counterdatasource.CounterDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CounterRepositoryImpl @Inject constructor(
    private val counterDataSource: CounterDataSource
): CounterRepository {

    override fun getCount(userId: String): Flow<Int?> {
        return counterDataSource.getCount(userId)
    }

    override suspend fun insertNewCount(userId: String, count: Int) {
        return counterDataSource.insetNewCount(userId, count)
    }

    override suspend fun updateCount(userId: String, newCount: Int) {
        return counterDataSource.updateCount(
            userId = userId,
            newCount = newCount
        )
    }
}