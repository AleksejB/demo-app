package com.example.data.datasource.counterdatasource

import com.example.demoappv1.UserDatabase
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToOne
import com.squareup.sqldelight.runtime.coroutines.mapToOneOrNull
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CounterDataSourceImpl @Inject constructor(
    db: UserDatabase
): CounterDataSource {
    private val queries = db.counterQueries

    override fun getCount(userId: String): Flow<Int?> {
        return queries.getUserCount(userId).asFlow().mapToOne()
    }

    override suspend fun insetNewCount(userId: String, count: Int) {
        return queries.insertNewCount(userId = userId, count = count)
    }

    override suspend fun updateCount(newCount: Int, userId: String) {
        return queries.updateUserCountByUserId(
            newCount = newCount,
            userId = userId
        )
    }
}