package com.example.data.datasource

import android.util.Log
import com.example.data.daos.CounterDao
import com.example.data.dto.CounterDto
import com.example.domain.datasource.CounterDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class CounterDataSourceImpl @Inject constructor(
    private val counterDao: CounterDao
): CounterDataSource {

    companion object {
        private const val TAG = "CounterDataSourceImpl"
    }

    override suspend fun insertNewCount(email: String, count: Int) {

        return counterDao.insertNewCount(
            CounterDto(
                count = count,
                email = email
            )
        )
    }

    override suspend fun getCount(email: String): Flow<Int> {
        return counterDao.getUserCount(email)
    }

    override suspend fun updateCount(email: String, newCount: Int) {
        return counterDao.updateCount(
            CounterDto(email = email, count = newCount)
        )
    }
}